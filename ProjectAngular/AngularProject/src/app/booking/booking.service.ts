import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { Jobs } from '../jobs.model';
import { Booking } from './booking.model';

@Injectable({
  providedIn: 'root'
})
export class BookingService {
  baseURL='http://localhost:8080/booking';
  job:Jobs;
  constructor(private httpC:HttpClient) { }

  getJobId(id:number):Observable<Jobs>
  {
    var subject=new Subject<Jobs>();
    this.httpC.get<Jobs>(this.baseURL+"/"+id).subscribe(
     r=> {
        console.log("in booking service");
        subject.next(r);
      });
      return subject.asObservable();
  }
    /* var subject=new Subject<Jobs[]>();
     this.httpClient.delete(this.baseURL+"/"+p.jobId).subscribe(r=>{
          console.log("deleted");
          console.log(r);
          this.httpClient.get<Jobs[]>(this.baseURL+"/jobs").subscribe(result=>{
          subject.next(result);

          });
     });
     return subject.asObservable(); */
     createBooking(b:Booking):Observable<Booking[]>
     {
       var subject=new Subject<Booking[]>();
       console.log(b);
       this.httpC.post<Booking>(this.baseURL+"/createbooking",b).subscribe(r=>{
        console.log("booking done");
        console.log(r);

       });
       return subject.asObservable();
     }
  
}
