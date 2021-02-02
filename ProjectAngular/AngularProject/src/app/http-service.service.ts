import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Workers } from './workers.model';
import { Observable, Subject } from 'rxjs';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from '@angular/router';
import { assignBooking } from './admin/assignBooking.model';
import { Customer } from './customer.model';


@Injectable({
  providedIn: 'root'
})
export class HttpServiceService  implements CanActivate{
  workerArr:Workers[];
  baseURL='http://localhost:8080/worker';//yaha worker aayega
  constructor(private httpClient : HttpClient,
    private router:Router) { }

  login(email:string,password:string):Observable<any>
  {
    var subject=new Subject<any>();
    console.log("in worker service");
    const body={
      email:email,
      password:password
    }
     this.httpClient.post(this.baseURL+'/login',body).subscribe(r=>{
        console.log(r); 
      if(r=="null")
      {
        return r;
      }
      subject.next(r);
     });
     return subject.asObservable();
  }

  canActivate(route:ActivatedRouteSnapshot,state:RouterStateSnapshot)
  {
    if(sessionStorage['firstName'])
    {
      return true;
    }
    else{
      this.router.navigate(['workerlogin']);
      return false;
    }
  }

  //add new Worker
  addNewWorker(p:Workers):Observable<Workers[]>{
    var subject = new Subject<Workers[]>();
    this.httpClient.post<Workers>(this.baseURL+"/registerworker",p).subscribe(r=>{
      
       console.log("workerAdded");
       console.log(r);
      // this.getAllProduct().subscribe(r=>{console.log(r);
       //this will send the get request
      // this.httpClient.get<Workers[]>(this.baseURL+"/registerworker").subscribe((r)=>{
      //     console.log("in service add function");
      //     console.log(r);
      //     //this will notify subject that data is populated 
      //     subject.next(r);
 
      //  });
    });
    
    // it will wrap associated array into observable
    return subject.asObservable();   
  }
  getBookingByWorkerId(workerId:number):Observable<assignBooking[]>
  {
    var subject=new Subject<assignBooking[]>();
    return this.httpClient.get<assignBooking[]>(this.baseURL+"/"+workerId);
  }

  getCustomerById(custId:number):Observable<Customer[]>{
    var subject=new Subject<Customer[]>();
    return this.httpClient.get<Customer[]>(this.baseURL+"/customer/"+custId);
  }

  updateStatus(a:assignBooking):Observable<assignBooking[]>{
    var subject=new Subject<assignBooking[]>();
    this.httpClient.put(this.baseURL+"/"+a.id,a).subscribe(result=>
      {
        this.httpClient.get<assignBooking[]>(this.baseURL+"/"+a.workerId).subscribe(r=>{
          subject.next(r);
        });
        
      });
      return subject.asObservable();
  }
 
}
