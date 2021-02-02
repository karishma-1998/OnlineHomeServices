import { Component, OnInit } from '@angular/core';
import { EmailValidator } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

import { LoginService } from 'src/app/login.service';
@Component({
  selector: 'app-userlogin',
  templateUrl: './userlogin.component.html',
  styleUrls: ['./userlogin.component.css']
})
export class UserloginComponent implements OnInit {
   email='';
   password='';
  
  constructor(private router:Router,
    private lservice:LoginService,private toastr:ToastrService) { }
  

  ngOnInit(): void {
  }

  onLogin()
  {
    if(this.email==null || this.password==null)
    {
      this.toastr.warning('invalid email id or password')
    }
    console.log("in login");
    this.lservice.login(this.email,this.password)
    .subscribe(response=>{
      console.log(response);
      if(response==null)
      {
        this.toastr.warning('invalid email id or password')
      }
      
      if(response['status']=='success'){
        console.log(response);
        const msg=response['message']
        const data=response['data']
        if(data['role']=='ADMIN'){
          sessionStorage['firstName']=data['firstName'];
          sessionStorage['lastname']=data['lastname'];
          sessionStorage['customerId']=data['customerId'];
           // this.isAuthenticated=true;
         
           this.toastr.success(msg);
          this.router.navigate(['adminHome']);
        }else{
        //  this.isAuthenticated=true;
        sessionStorage['firstName']=data['firstName'];
        sessionStorage['lastname']=data['lastname'];
        sessionStorage['customerId']=data['customerId'];
        this.toastr.success(msg);
          this.router.navigate(['services']);
        }
      }
      // }else{
      //   this.toastr.warning('invalid email id or password')
      //   //alert('invalid email or password');
      // }
     
    });
  }
  btnClick=function()
  {
    this.router.navigateByUrl('/registeruser');
  }

}
