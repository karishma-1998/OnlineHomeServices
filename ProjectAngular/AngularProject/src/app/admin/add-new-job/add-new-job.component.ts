import { Component,EventEmitter, Input, OnInit, Output, SimpleChanges } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Jobs } from 'src/app/jobs.model';
import { AdminServiceService } from '../admin-service.service';

@Component({
  selector: 'app-add-new-job',
  templateUrl: './add-new-job.component.html',
  styleUrls: ['./add-new-job.component.css']
})
export class AddNewJobComponent implements OnInit {
  count=1;
  jobId:number;
  jobName:string;
  jobDescription:String;
  price:number;
  discount:number;
  selectedFile: File = null;
  message: string = null;
  retrievedImage: any;

  jobsArr:Jobs[];
  
  @Input("uob") pob:Jobs;
  @Output() myevent=new EventEmitter();
  constructor(private aservice:AdminServiceService,private router:Router,private toastr:ToastrService) { }

  ngOnInit() {
  }
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

  public onFileChanged(event) {
    console.log(event);
    this.selectedFile = event.target.files[0];
  }
  //a member function to create new emp on btn click
  // createNewJob() {
  //     let p=new Jobs(this.jobId,this.jobName,this.jobDescription,this.price,this.discount);
  //     console.log("in pform add");
  //     console.log(p);
  //    this.aservice.addNewJob(p)
  //     .subscribe(r=>{console.log(r);   /// r is array from service
  //         this.myevent.emit(r);   // we are passing to table component to upadte the table
  //         this.jobId=this.count++;
  //         this.jobName="";
  //         this.jobDescription="";
  //         this.price=0;
  //         this.discount=0; 
  //    });
  //    //console.log(this.parr);
  //     this.router.navigate(['listServices']);
  // }
  createNewJob(){
    let p=new Jobs(this.jobId,this.jobName,this.jobDescription,this.price,this.discount);
    this.aservice.addNewJob(this.selectedFile,p).subscribe(
      resp=>{
        console.log(resp);
        this.message=resp;
      }
    );
    this.toastr.success("New Service Added");
    this.router.navigate(['adminHome']);
  }
}
