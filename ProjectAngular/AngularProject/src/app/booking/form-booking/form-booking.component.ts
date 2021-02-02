import { DatePipe, ɵDomAdapter } from '@angular/common';
import { Component, EventEmitter, Input, OnInit, Output, SimpleChanges } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Jobs } from 'src/app/jobs.model';
import { Booking } from '../booking.model';
import { BookingService } from '../booking.service';

@Component({
  selector: 'app-form-booking',
  templateUrl: './form-booking.component.html',
  styleUrls: ['./form-booking.component.css']
})
export class FormBookingComponent implements OnInit {
    bookingId:number;
    jobId:number;
    customerId:number;
    bookingStatus:string;
    paymentStatus:string;
    bookingDate:Date;
    serviceBookDate:Date;
    
    booking:Booking[];

  jobs:Jobs;
  Id=sessionStorage.getItem("id");
  cid=sessionStorage.getItem("customerId");
  @Input("bob") ob:Booking;
  @Output() myevent=new EventEmitter();
  count:number=0;

  constructor(private router:Router,private toastr:ToastrService,private bService:BookingService,private datepipe:DatePipe) { }

  ngOnInit() {
    let i=parseInt(this.Id);
    this.bService.getJobId(i).subscribe(
      r=>{
        console.log(r);
        this.jobs=r;
        const data=r;
        sessionStorage['jobId']=r['jobId'];
        sessionStorage['jobName']=r['jobName'];
        sessionStorage['jobDescription']=r['jobDescription'];
        sessionStorage['price']=r['price'];
        sessionStorage['discount']=r['discount'];
      });
  }

  ngOnChanges(simple:SimpleChanges){
    if(simple["ob"].currentValue!=simple['ob'].previousValue){
      console.log(simple);
      this.bookingId=simple["ob"].currentValue.bookingId;
      this.jobId=simple["ob"].currentValue.jobId;
      this.customerId=simple["ob"].currentValue.customerId;
      this.paymentStatus=simple["ob"].currentValue.paymentStatus;
      this.bookingStatus=simple["ob"].currentValue.bookingStatus;
      this.bookingDate=simple["ob"].currentValue.bookingDate;
      this.serviceBookDate=simple["ob"].currentValue.serviceBookDate;
    }
  }

  saveBooking()
  {
   
   let sDate=new Date();
    const bDate=new Date();
    //var sDate = this.datepipe.transform(new Date(),"yyyy-MM-dd");
   sDate=this.serviceBookDate;
   this.bookingStatus="WORKPENDING";
   if(this.paymentStatus==null || sDate==null)
   {
    this.toastr.warning('All Fields are Mandatory');
   }
   else{
     //const sDate=new Date(this.serviceBookingDate.getDay(),this.serviceBookingDate.getMonth(),this.serviceBookingDate.getFullYear());
    let b=new Booking(this.bookingId,parseInt(this.Id),parseInt(this.cid),
    this.bookingStatus,this.paymentStatus,bDate,sDate);
    console.log("in booking");
    console.log(b);
    this.bService.createBooking(b).
    subscribe(
      r=>{
        console.log(r);
        this.bookingId=this.count;
        this.jobId=0;
        this.customerId=0;
        this.bookingStatus="";
        this.paymentStatus="DONE";
        this.bookingDate;
        this.serviceBookDate;

      });
      this.toastr.success("Booking Done")
      this.router.navigate(['thankyou']);
  }
}

}
