import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { assignBooking } from 'src/app/admin/assignBooking.model';
import { Customer } from 'src/app/customer.model';
import { HttpServiceService } from 'src/app/http-service.service';

@Component({
  selector: 'app-worker-home',
  templateUrl: './worker-home.component.html',
  styleUrls: ['./worker-home.component.css']
})
export class WorkerHomeComponent implements OnInit {
  name=sessionStorage.getItem("firstName");
  wId=sessionStorage.getItem("workerId");
  assBooking:assignBooking[];
  ob:assignBooking;
  customer:Customer[];
  c:Customer[];
  flag=false;
  pflag=false;
  constructor(private wservice:HttpServiceService,private router:Router,private toastr:ToastrService) { }

  ngOnInit(): void {
    let id=parseInt(this.wId);
    this.wservice.getBookingByWorkerId(id).subscribe(
      result=>{
        console.log(result);
        this.assBooking=result;
      }
    );
    for(var i=0;i<this.assBooking.length;i++)
      this.wservice.getCustomerById(this.assBooking[i].customerId).subscribe(r=>{
        this.c=r;
      });
  }

  updateStatus(book:assignBooking)
  {
    
    this.flag=true;
    console.log("in update status");
    this.ob=book;
    this.pflag=false;
  }

  getCustomer(custId:number){
    this.pflag=true;
    sessionStorage.setItem("customerId",custId.toString());
    // this.wservice.getCustomerById(custId).subscribe(r=>{
    //   console.log(r);
    //   this.customer=r;
    // });
   this.flag=false;
  }
  // getCustomer(){
  //   this.pflag=true;
  //   //this.ob=customer;
  //   this.flag=false;
  // }
  onLogout()
  {
    console.log("in logout");
    sessionStorage.removeItem('firstName');
    sessionStorage.removeItem('lastname');
    sessionStorage.removeItem('workerId');
    sessionStorage.removeItem('customerId');
    this.toastr.success("Logout Successfull");
    this.router.navigate(['']);
  }

}
