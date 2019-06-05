package com.disi.trainer.BusinessLogic;

import com.disi.trainer.DataAccess.Entry;
import com.disi.trainer.DataAccess.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EntryService {

    @Autowired
    private EntryRepository entryRepository;

    public List<Entry> findByCustomerId(Integer id) {
        List<Entry> entries = new ArrayList<>();
        entryRepository.findByCustomerId(id).forEach(entries::add);
        return entries;
    }

    public Optional<Entry> findByIdAndCustomerId(Integer entryId, Integer customerId) {
        return entryRepository.findByIdAndCustomerId(entryId, customerId);
    }

    public Optional<Entry> getEntryById (Integer id){
        return entryRepository.findById(id);
    }

    public void addEntry(Entry entry){

        Double bfp = calculateBfp(entry.getWeight(), entry.getBiceps(), entry.getWaist(), entry.getThigh());

        entry.setBfp(bfp);

        entryRepository.save(entry);
    }

    public void deleteEntry(Entry entry){
        entryRepository.delete(entry);
    }

    public void updateEntry(Entry entry){
        entryRepository.save(entry);
    }

    public Double calculateBfp (Integer weigth, Integer biceps, Integer waist, Integer thigh) {
        Double bfp;
        Double bfw;
        Double lbm;

        lbm = (weigth * 0.732) + 8.987 + biceps / 3.140 + waist * 0.157 + thigh * 0.249 - 20;
        bfw = weigth - lbm;
        bfp = (bfw * 100) / weigth;

        return bfp;
    }

}
