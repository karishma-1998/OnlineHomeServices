import { Component, OnInit } from '@angular/core';
import { Booking } from 'src/app/booking/booking.model';
import { Workers } from 'src/app/workers.model';
import { AdminServiceService } from '../admin-service.service';

@Component({
  selector: 'app-list-worker',
  templateUrl: './list-worker.component.html',
  styleUrls: ['./list-worker.component.css']
})
export class ListWorkerComponent implements OnInit {
 // jobId=sessionStorage.getItem('jobId');
  workerArr:Workers[];
  booking:Booking;
  constructor(private aservice:AdminServiceService) { }

  ngOnInit(): void {
    
    this.aservice.getAllWorkersById(5).subscribe(result=>
      {
        console.log(result);
        this.workerArr=result;
      });
  }

}
