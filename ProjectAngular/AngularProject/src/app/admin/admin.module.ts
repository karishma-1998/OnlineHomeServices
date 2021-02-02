import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
//import { BrowserModule } from '@angular/platform-browser';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { ListServicesComponent } from './list-services/list-services.component';
import { ListCustomerComponent } from './list-customer/list-customer.component';
import { ListWorkerComponent } from './list-worker/list-worker.component';
import { ListBookingComponent } from './list-booking/list-booking.component';
import { RouterModule } from '@angular/router';
import { UpdateListComponent } from './update-list/update-list.component';
import { AddNewJobComponent } from './add-new-job/add-new-job.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';


@NgModule({
  declarations: [
    AdminHomeComponent, 
    ListServicesComponent, 
    ListCustomerComponent, 
    ListWorkerComponent, 
    ListBookingComponent, 
    UpdateListComponent, 
    AddNewJobComponent
  ],
  imports: [
   FormsModule,
   //BrowserModule,
    CommonModule,
    RouterModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot()
   
  ],
  exports:[
    AdminHomeComponent,
    ListBookingComponent,
    ListCustomerComponent,
    ListServicesComponent,
    ListWorkerComponent,
    ListBookingComponent, 
    UpdateListComponent, 
    AddNewJobComponent
  ]
})
export class AdminModule { }
