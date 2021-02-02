import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class JobService {
  baseURL: string = "http://localhost:8080/booking";

  constructor(private http: HttpClient) { }
  //constructor() { }

  retrieveImage(jobId:number) {
    console.log("sending " + `${this.baseURL}/services/${jobId}`);
    return this.http.get<any>(`${this.baseURL}/services/${jobId}`);
// return this.http.get<any>(`${this.baseURL}download/2`);
  }
}
