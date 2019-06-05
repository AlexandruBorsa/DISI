package com.disi.trainer.DataAccess;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface EntryRepository extends CrudRepository<Entry, Integer> {

    List<Entry> findByCustomerId(Integer customerId);
    Optional<Entry> findByIdAndCustomerId(Integer entryId, Integer customerId);
}
