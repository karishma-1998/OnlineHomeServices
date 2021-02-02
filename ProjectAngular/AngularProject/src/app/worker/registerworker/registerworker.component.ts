import { Component, Input, OnInit, Output, SimpleChanges } from '@angular/core';
import { Router } from '@angular/router';
import { EventEmitter } from 'events';
import { ToastrService } from 'ngx-toastr';
import { HttpServiceService } from '../../http-service.service';
import { Workers } from '../../workers.model';

@Component({
  selector: 'app-registerworker',
  templateUrl: './registerworker.component.html',
  styleUrls: ['./registerworker.component.css']
})
export class RegisterworkerComponent {
  
  workerId:number;
  firstName:string;
  lastname:string;
  email:string;
  mobileNo:string;
  address:string;
  city:string;
  state:string;
  country:string;
  password:string;
  onLeave:string;
  pincode:string;
  jobId:number;
  
  workerArr:Workers[];

  @Input("uob") wob:Workers;
  @Output() myevent=new EventEmitter();
  count:number=0;

  constructor(private httpClient: HttpServiceService, private router: Router,private toastr:ToastrService) { }

  ngOnChanges(simple:SimpleChanges){
    console.log("in ngOnChange");
    if(simple["wob"].currentValue!=simple["wob"].previousValue){
        console.log(simple);
        this.workerId=simple["wob"].currentValue.workerId;
        this.firstName=simple["wob"].currentValue.firstName;
        this.lastname=simple["wob"].currentValue.lastname;
        this.email=simple["wob"].currentValue.email;
        this.mobileNo=simple["wob"].currentValue.mobileNo;
        this.address=simple["wob"].currentValue.address;
        this.city=simple["wob"].currentValue.city;
        this.state=simple["wob"].currentValue.state;
        this.country=simple["wob"].currentValue.country;
        this.password=simple["wob"].currentValue.password;
        this.onLeave=simple["wob"].currentValue.onLeave;
        this.pincode=simple["wob"].currentValue.pincode;
        this.jobId=simple["wob"].currentValue.jobId;
       
    }


}

  addNewWorker()
  {
    if( this.firstName==null || this.lastname==null || this.address==null || this.city==null || this.state==null || this.country==null || this.email==null || this.password==null || this.jobId==null || this.pincode ==null)
    {
      this.toastr.warning('All Fields are Mandatory');
    }else{
    let w=new Workers(this.workerId,this.firstName,this.lastname,this.email,this.mobileNo,
      this.address,this.city,this.state,this.country,this.password,"AVAILABLE",this.pincode,
      this.jobId);
    console.log("in  add new worker");
    console.log(w);
   this.httpClient.addNewWorker(w)
    .subscribe(r=>{console.log(r);   /// r is array from service
        //this.myevent.emit();   // we are passing to table component to upadte the table
        this.workerId=this.count;
        this.firstName="";
        this.lastname="";
        this.email="";
        this.mobileNo=""; 
        this.address="";
        this.city="";
        this.state="";
        this.country="";
        this.password="";
        this.onLeave="AVAILABLE";
        this.pincode="";
        this.jobId=0;
   });
   this.toastr.success('Registration Successfull');
   this.router.navigate(['workerlogin']);
  }
  }
  // register()
  // {
  //   this.router.navigate(['/workerlogin',-1]);
  // }
}
