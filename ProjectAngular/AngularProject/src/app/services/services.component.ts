import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { AdminServiceService } from '../admin/admin-service.service';
import { Jobs } from '../jobs.model';
import { JobService } from './job.service';

@Component({
  selector: 'app-services',
  templateUrl: './services.component.html',
  styleUrls: ['./services.component.css']
})
export class ServicesComponent implements OnInit {
  flag=false;
  name=sessionStorage['firstName'];
  selectedFile: File = null;
  message: string = null;
  retrievedImage: any;
  jobId:number;
  jobsArr:Jobs[];
  //id:number;
  constructor(private router:Router,private toastr:ToastrService,private service:JobService,private aservice:AdminServiceService) { }

  ngOnInit(): void {
  
   this.aservice.getAllJobs().subscribe(
     r=>{
      console.log(r);
      console.log("in get all jobs");
      this.jobsArr=r;
     // sessionStorage.setItem("array",JSON.stringify(this.jobsArr));
      
     });
   // this.jobsArr['jobId']=sessionStorage.getItem('array');
    //  var a=JSON.parse(sessionStorage.getItem("array"));
    //  console.log(a);
    // this.service.retrieveImage(this.jobId).subscribe(
    //   resp => {
    //     console.log(resp);//resp is of type ImageEntity
    //     this.retrievedImage = `data:${resp.type};base64,${resp.data}`;
    //   },
    //   error => {
    //     console.log(error);
    //     if (error.status === 404)
    //       this.message = "Image Not Found!!!!";
    //     else
    //       this.message = `Server Error :${error.message}`;
    //       this.retrievedImage=null;
    //   });
    
      if(this.name!=null)
      {
        console.log(this.name);
       this.flag=true;
      }
    }
    bookNow(id:number)
    {
     if(this.name==null)
     {
       this.router.navigate(['userlogin']);
     }
     else
     {
       console.log(id);
      if(id==1)
      {
        sessionStorage.setItem("id","1");
        this.router.navigate(['book']);
      }
      else
      {
        if(id==2)
        {
          sessionStorage.setItem("id","2");
          this.router.navigate(['book']);
        }
        else
        {
          if(id==3)
          {
            sessionStorage.setItem("id","3");
            this.router.navigate(['book']);
          }
          else
          {
            sessionStorage.setItem("id","4");
            this.router.navigate(['book']);
          }
        }
      }
     }
    }
  onLogout()
  {
    console.log("in logout");
    sessionStorage.removeItem('firstName');
    sessionStorage.removeItem('lastname');
    this.toastr.success("Logout Successfully");
    this.router.navigate(['']);
  }

}
