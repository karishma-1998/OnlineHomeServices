import { Component,EventEmitter, Input, OnInit, Output, SimpleChanges } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Customer } from 'src/app/customer.model';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-registeruser',
  templateUrl: './registeruser.component.html',
  styleUrls: ['./registeruser.component.css']
})
export class RegisteruserComponent implements OnInit {
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
    @Input("uob") wob:Customer;
    @Output() myevent=new EventEmitter();
    count:number=0;
  
    constructor(private customer: CustomerService, private router: Router,private toastr:ToastrService) { }
  
    ngOnChanges(simple:SimpleChanges){
      console.log("in ngOnChange");
      if(simple["wob"].currentValue!=simple["wob"].previousValue){
          console.log(simple);
          this.customerId=simple["wob"].currentValue.workerId;
          this.firstName=simple["wob"].currentValue.firstName;
          this.lastname=simple["wob"].currentValue.lastname;
          this.email=simple["wob"].currentValue.email;
          this.mobileNo=simple["wob"].currentValue.mobileNo;
          this.address=simple["wob"].currentValue.address;
          this.city=simple["wob"].currentValue.city;
          this.state=simple["wob"].currentValue.state;
          this.country=simple["wob"].currentValue.country;
          this.password=simple["wob"].currentValue.password;
          this.pincode=simple["wob"].currentValue.pincode;
          this.role=simple["wob"].currentValue.role;
         
      }
  
  
  }
  ngOnInit(): void {
  }
  addNewCustomer()
  {
    if( this.pincode==null || this.firstName==null || this.lastname==null || 
      this.email==null || this.mobileNo==null || this.address==null || 
      this.city==null || this.state==null || this.password==null)
    {
      this.toastr.warning('All Fields are Required');
    }else{
    let w=new Customer(this.customerId,this.firstName,this.lastname,this.email,this.mobileNo,
      this.address,this.city,this.state,this.country,this.password,"CUSTOMER",this.pincode);
    console.log("in  add new customer");
    console.log(w);
   this.customer.addNewCustomer(w)
    .subscribe(r=>{console.log(r);   /// r is array from service
        this.myevent.emit();   // we are passing to table component to upadte the table
        this.customerId=this.count++;
        this.firstName="";
        this.lastname="";
        this.email="";
        this.mobileNo=""; 
        this.address="";
        this.city="";
        this.state="";
        this.country="";
        this.password="";
        this.pincode=0;
        this.role="CUSTOMER";
   });
   this.toastr.success('Registration Successfull');
   this.router.navigate(['userlogin']);
  }
}
}
