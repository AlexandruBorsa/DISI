import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-overview',
  templateUrl: './overview.component.html',
  styleUrls: ['./overview.component.css']
})
export class OverviewComponent implements OnInit {
  newName: any;
  newEmail: any;
  newPhone: any;
  newAge: any;
  editable = false;
  customers = [
    {name: 'user1', email: 'user1@user1.com', phone: '0725669432', age: 22},
    {name: 'user2', email: 'user2@user2.com', phone: '0725098332', age: 30}
  ];

  constructor() {
  }

  ngOnInit() {
  }

  addUser() {
    this.customers.push({name: this.newName, email: this.newEmail, phone: this.newPhone, age: this.newAge});
  }

  remove(index) {
    this.customers.splice(index, 1);
  }

  save(customer) {
    console.log('customers', customer);
  }
}
