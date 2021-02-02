import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { Customer } from '../customer.model';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  custArr:Customer[];
  baseURL='http://localhost:8080/customer';
  constructor(private httpClient:HttpClient) { }

  //add new Worker
  addNewCustomer(p:Customer):Observable<Customer[]>{
    var subject = new Subject<Customer[]>();
    this.httpClient.post<Customer>(this.baseURL+"/registercustomer",p).subscribe(r=>{
      
       console.log("customer Added");
       console.log(r);
      // this.getAllProduct().subscribe(r=>{console.log(r);
       //this will send the get request
      // this.httpClient.get<Customer[]>(this.baseURL+"/registercustomer").subscribe((r)=>{
      //     console.log("in service add customer");
      //     console.log(r);
      //     //this will notify subject that data is populated 
      //     subject.next(r);
 
      //  });
    });
    
    // it will wrap associated array into observable
    return subject.asObservable();   
  }
}
