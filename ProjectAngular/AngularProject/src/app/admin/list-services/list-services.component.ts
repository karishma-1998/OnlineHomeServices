import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Jobs } from 'src/app/jobs.model';
import { AdminServiceService } from '../admin-service.service';

@Component({
  selector: 'app-list-services',
  templateUrl: './list-services.component.html',
  styleUrls: ['./list-services.component.css']
})
export class ListServicesComponent implements OnInit {
  jobsArr:Jobs[];
  ob:Jobs;
  flag=false;
  pflag=false;
  constructor(private aservice:AdminServiceService,private router:Router,private toastr:ToastrService) { }

  ngOnInit(): void {
    this.aservice.getAllJobs().subscribe(result=>{
      console.log(result);
      this.jobsArr=result;
    });
  }
    
  displayform()
  {
    this.router.navigate(['addNewJob']);
  }

  deleteJob(p:Jobs){
    this.aservice.deleteJob(p)
    .subscribe(result=>this.jobsArr=result);
    //route to some page;
    this.toastr.success('Services Deleted');
    this.router.navigate(['listServices']);

}
updateJob(p:Jobs){
    this.flag=true;
    console.log("in product update");
    this.ob=p;
}
}
