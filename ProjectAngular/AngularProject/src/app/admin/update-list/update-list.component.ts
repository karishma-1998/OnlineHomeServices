import { Component, EventEmitter,Input, Output, SimpleChanges } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

import { Jobs } from 'src/app/jobs.model';
import { AdminServiceService } from '../admin-service.service';

@Component({
  selector: 'app-update-list',
  templateUrl: './update-list.component.html',
  styleUrls: ['./update-list.component.css']
})
export class UpdateListComponent {
  jobId:number;
  jobName:string;
  jobDescription:String;
  price:number;
  discount:number;
  jobsArr:Jobs[];
  @Input("uob") pob:Jobs;
  @Output() myevent=new EventEmitter();
  constructor(private aservice:AdminServiceService,private toastr:ToastrService,private router:Router) { }

  ngOnChanges(simple:SimpleChanges){
    console.log("in ngOnChange");
    if(simple["pob"].currentValue!=simple["pob"].previousValue){
        console.log(simple);
        this.jobId=simple["pob"].currentValue.jobId;
        this.jobName=simple["pob"].currentValue.jobName;
        this.jobDescription=simple["pob"].currentValue.jobDescription;
        this.price=simple["pob"].currentValue.price;
        this.discount=simple["pob"].currentValue.discount;
    }


}


  updateJob(){
    let p=new Jobs(this.jobId,this.jobName,this.jobDescription,this.price,this.discount);
    console.log("in update of update List");
    console.log(p);
    this.aservice.updateJobs(p).subscribe(result=>{
        console.log("updated");
        this.myevent.emit(result);
    });
    this.toastr.success("Service Updated Successfully");
    this.router.navigate(['listServices']);
  }

}
