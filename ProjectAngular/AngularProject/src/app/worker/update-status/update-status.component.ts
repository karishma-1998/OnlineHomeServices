import { Component, EventEmitter, Input, OnInit, Output, SimpleChanges } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { assignBooking } from 'src/app/admin/assignBooking.model';
import { HttpServiceService } from 'src/app/http-service.service';

@Component({
  selector: 'app-update-status',
  templateUrl: './update-status.component.html',
  styleUrls: ['./update-status.component.css']
})
export class UpdateStatusComponent implements OnInit {
  id:number;
  jobId:number;
  customerId:number;
  bookingId:number;
  workerId:number;
  bookingStatus:string;
  assBooking:assignBooking[];
  @Input("uob") pob:assignBooking;
  @Output() myevent=new EventEmitter();
  constructor(private wservice:HttpServiceService,private toastr:ToastrService,private router:Router) { }

  ngOnInit(): void {
  }

  ngOnChanges(simple:SimpleChanges){
    console.log("in ngOnChnages");
    if(simple["pob"].currentValue!=simple["pob"].previousValue)
    {
      this.id=simple["pob"].currentValue.id;
      this.jobId=simple["pob"].currentValue.jobId;
      this.customerId=simple["pob"].currentValue.customerId;
      this.workerId=simple["pob"].currentValue.workerId;
      this.bookingId=simple["pob"].currentValue.bookingId;
      this.bookingStatus=simple["pob"].currentValue.bookingStatus;
    }
  }

  updateStatus(){
    let p=new assignBooking(this.id,this.jobId,this.customerId,this.bookingId,this.workerId,this.bookingStatus);
    console.log("in update status");
    console.log(p);
    this.wservice.updateStatus(p).subscribe(result=>{
      console.log("updated");
      this.myevent.emit(result);
    });
    this.toastr.success('Status Updated');
    this.router.navigateByUrl('workerHome');
  }

}
