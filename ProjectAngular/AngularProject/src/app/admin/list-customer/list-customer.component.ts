import { Component, OnInit } from '@angular/core';
import { Customer } from 'src/app/customer.model';
import { AdminServiceService } from '../admin-service.service';

@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css']
})
export class ListCustomerComponent implements OnInit {
  custArr:Customer[];
  constructor(private aservice:AdminServiceService) { }

  ngOnInit(): void {
    this.aservice.getAllCustomers().subscribe(result=>{
      console.log(result);
      this.custArr=result;
    });
  }

}
