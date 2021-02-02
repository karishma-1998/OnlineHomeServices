import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { Booking } from '../booking/booking.model';
import { Customer } from '../customer.model';
import { Jobs } from '../jobs.model';
import { Workers } from '../workers.model';
import { assignBooking } from './assignBooking.model';

@Injectable({
  providedIn: 'root'
})
export class AdminServiceService {
  assBook:assignBooking[];
  jobsArr:Jobs[];
  custArr:Customer[];
  workerArr:Workers[];
  baseURL='http://localhost:8080/admin';
  constructor(private httpClient : HttpClient) { }

  getAllJobs():Observable<Jobs[]>{
    console.log("in services");
    return this.httpClient.get<Jobs[]>(this.baseURL+"/jobs");
  }

  getAllCustomers():Observable<Customer[]>{
    console.log("in get all customers services");
    return this.httpClient.get<Customer[]>(this.baseURL+"/customer");
  }

  getAllWorkers():Observable<Workers[]>
  {
    console.log("in get all workers");
    return this.httpClient.get<Workers[]>(this.baseURL+"/workers")
  }

  getAllBooking():Observable<Booking[]>
  {
    console.log("in get all bookings");
    return this.httpClient.get<Booking[]>(this.baseURL+"/bookings")
  }

  getAllBookingDone():Observable<Booking[]>
  {
    console.log("in get all bookings");
    return this.httpClient.get<Booking[]>(this.baseURL+"/bookingsDone")
  }


  getAllWorkersById(jobId:number):Observable<Workers[]>
  {
    console.log("in get workers by jobID");
    return this.httpClient.get<Workers[]>(this.baseURL+"/workerByJobId"+"/"+jobId);
  }

  addNewBooking(book:assignBooking):Observable<assignBooking[]>
  {
    var subject=new Subject<assignBooking[]>();
    this.httpClient.post<assignBooking>(this.baseURL+"/addNewBooking",book).subscribe(r=>
      {
        console.log("booking saved");
        console.log(r);
        //subject.next(r);
      });
      return subject.asObservable();
  }
//  addNewJob(job)
//  {
//   return this.httpClient.post<Jobs>(this.baseURL+'/addjob',job);
//  }

// addNewJob(p:Jobs):Observable<Jobs[]>{
//   var subject = new Subject<Jobs[]>();
//   this.httpClient.post<Jobs>(this.baseURL+"/addjob",p).subscribe(r=>{
    
//      console.log("jobAdded");
//      console.log(r);
//     // this.getAllProduct().subscribe(r=>{console.log(r);
//      //this will send the get request
//     this.httpClient.get<Jobs[]>(this.baseURL+"/addjob").subscribe((r)=>{
//         console.log("in service add function");
//         console.log(r);
//         //this will notify subject that data is populated 
//         subject.next(r);

//      });
//   });
  
//   // it will wrap associated array into observable
//   return subject.asObservable();   
// }

addNewJob(selectedFile:File,p:Jobs){
  const uploadData = new FormData();
  uploadData.append("imageFile", selectedFile);
  console.log(`sending ${p}`);
//  const userDtls=new UserDetails("madhura@gmail",27);
 // uploadData.append("dtls", "{'email' : 'rama@gmail.com','age' : 27}");
 uploadData.append("dtls",JSON.stringify(p));
 return this.httpClient.post(this.baseURL.concat("/upload"), uploadData, { responseType: 'text' });  
}


  deleteJob(p:Jobs):Observable<Jobs[]>{
    var subject=new Subject<Jobs[]>();
     this.httpClient.delete(this.baseURL+"/"+p.jobId).subscribe(r=>{
          console.log("deleted");
          console.log(r);
          this.httpClient.get<Jobs[]>(this.baseURL+"/jobs").subscribe(result=>{
          subject.next(result);

          });
     });
     return subject.asObservable();


  }

  updateJobs(p:Jobs):Observable<Jobs[]>{
    var subject=new Subject<Jobs[]>();
     this.httpClient.put(this.baseURL+"/"+p.jobId,p).subscribe(r=>{
        console.log("admin service updated");
        console.log(p);
        this.httpClient.get<Jobs[]>(this.baseURL+"/jobs").subscribe(result=>{
        subject.next(result);
     });
    });
     return subject.asObservable();
  }
}
