import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { WorkerloginComponent } from '../worker/workerlogin/workerlogin.component';

import { RegisterworkerComponent } from '../worker/registerworker/registerworker.component';

import { FormsModule } from '@angular/forms';
import { WorkerHomeComponent } from './worker-home/worker-home.component';
import { UpdateStatusComponent } from './update-status/update-status.component';
import { CustomerlistComponent } from './customerlist/customerlist.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';



@NgModule({
  declarations: [WorkerloginComponent, 
    RegisterworkerComponent, 
    WorkerHomeComponent, 
    UpdateStatusComponent, 
    CustomerlistComponent],
  imports: [
    FormsModule,
    CommonModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot()
   
  ],
  exports:[
    WorkerloginComponent,
    RegisterworkerComponent,
    WorkerHomeComponent,
    CustomerlistComponent
  ]
})
export class WorkerModule { }
