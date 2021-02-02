import { Component, OnInit } from '@angular/core';
import { Customer } from 'src/app/customer.model';
import { HttpServiceService } from 'src/app/http-service.service';

@Component({
  selector: 'app-customerlist',
  templateUrl: './customerlist.component.html',
  styleUrls: ['./customerlist.component.css']
})
export class CustomerlistComponent implements OnInit {
 
  customerId:number;
    firstName:string;
    lastname:string;
    email:string;
    mobileNo:string;
    address:string;
    city:string;
    state:string;
    country:string;
    password:string;
    role:string;
    pincode:number;
  custArr:Customer[];
  cid=sessionStorage.getItem("customerId");
  constructor(private wservice:HttpServiceService) { }

  ngOnInit(): void {
    let id=parseInt(this.cid);
    this.wservice.getCustomerById(id).subscribe(r=>{
      console.log(r);
      this.custArr=r;
    });
  }

}
