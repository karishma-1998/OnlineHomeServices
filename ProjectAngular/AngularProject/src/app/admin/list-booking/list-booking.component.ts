import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Booking } from 'src/app/booking/booking.model';
import { Workers } from 'src/app/workers.model';
import { AdminServiceService } from '../admin-service.service';
import { assignBooking } from '../assignBooking.model';

@Component({
  selector: 'app-list-booking',
  templateUrl: './list-booking.component.html',
  styleUrls: ['./list-booking.component.css']
})
export class ListBookingComponent implements OnInit {
  book:Booking;
  bookingArr:Booking[];
  workerArr:Workers[];
  worker:Workers;
  id:number;
  jobId:number;
  customerId:number;
  bookingId:number;
  workerId:number;
  bookingStatus:string;
  assBook:assignBooking[];
  bookarr:Booking[];
  flag=false;
  count=0;
  constructor(private aService:AdminServiceService,private router :Router,private toastr:ToastrService) { }

  ngOnInit(): void {
    this.aService.getAllBookingDone().subscribe(r=>{
      console.log(r);
      this.bookarr=r;
    });
    this.aService.getAllBooking().subscribe(result=>{
      console.log(result);
      this.bookingArr=result;
    });
  }

  assignWorker(booking:Booking)
  {
    this.book=booking;
    console.log(this.book);
    console.log(this.book.bookingId);
    this.aService.getAllWorkersById(booking.jobId).subscribe(result=>{
      console.log(result);
      this.workerArr=result;
    });
    this.flag=true;
  }

  assignBooking(worker:Workers)
  {
    this.worker=worker;
    let b=new assignBooking(this.id,this.book.jobId,this.book.customerId,
      this.book.bookingId,this.worker.workerId,this.book.bookingStatus);
      console.log(b);
      this.aService.addNewBooking(b)
      .subscribe(r=>{console.log(r);   /// r is array from service
        this.id=this.count++;
        this.jobId=0;
        this.customerId=0;
        this.workerId=0;
        this.bookingId=0;
        this.bookingStatus="";
     });
     this.toastr.success("Worker assigned successfully");
     this.router.navigate(['listBooking']);
  }


}
