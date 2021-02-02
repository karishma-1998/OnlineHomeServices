import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from '@angular/router';
import { Observable, Subject } from 'rxjs';
import { Customer } from './customer.model';

@Injectable({
  providedIn: 'root'
})
export class LoginService implements CanActivate{
  baseUrl="http://localhost:8080/customer";
  constructor(private httpClient:HttpClient,private router:Router) { }

  login(email:string,password:string):Observable<any>
  {
    var subject=new Subject<any>();
    console.log("in login service");
    const body={
      email:email,
      password:password
    }
    this.httpClient.post(this.baseUrl+'/login',body).subscribe(r=>{
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
      this.router.navigate(['userlogin']);
      return false;
    }
  }

}

