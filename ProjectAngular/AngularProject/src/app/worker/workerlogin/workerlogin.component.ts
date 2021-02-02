import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { HttpServiceService } from 'src/app/http-service.service';

@Component({
  selector: 'app-workerlogin',
  templateUrl: './workerlogin.component.html',
  styleUrls: ['./workerlogin.component.css']
})
export class WorkerloginComponent implements OnInit {
  email='';
  password='';
  isAuthenticated=true;
  constructor(private router:Router,private wservice:HttpServiceService,private toastr:ToastrService) { }

  ngOnInit(): void {
  }

  onLogin()
  {
    console.log("in login");
    this.wservice.login(this.email,this.password)
    .subscribe(response=>{
      console.log(response);
      if(response==null)
      {
        this.toastr.warning('Invalid email and password');
      }
      if(response['status']=='success'){
        console.log(response);
        const msg=response['message'];
        const data=response['data'];
        sessionStorage['firstName']=data['firstName'];
        sessionStorage['lastname']=data['lastname'];
        sessionStorage['workerId']=data['workerId'];
        this.toastr.success(msg);
        this.router.navigate(['workerHome']);
      }
    });
  }
  
  btnClick=function()
  {
    console.log("in register");
    this.router.navigateByUrl('/registerworker');
  }
}
