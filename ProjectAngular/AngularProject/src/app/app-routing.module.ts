import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { RegisteruserComponent } from './login/registeruser/registeruser.component';
import { RegisterworkerComponent } from './worker/registerworker/registerworker.component';
import { UserloginComponent } from './login/userlogin/userlogin.component';
import { WorkerloginComponent } from './worker/workerlogin/workerlogin.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { ServicesComponent } from './services/services.component';
import { ListServicesComponent } from './admin/list-services/list-services.component';
import { ListCustomerComponent } from './admin/list-customer/list-customer.component';
import { ListWorkerComponent } from './admin/list-worker/list-worker.component';
import { ListBookingComponent } from './admin/list-booking/list-booking.component';
import { AdminHomeComponent } from './admin/admin-home/admin-home.component';
import { FormBookingComponent } from './booking/form-booking/form-booking.component';
import { UpdateListComponent } from './admin/update-list/update-list.component';
import { AddNewJobComponent } from './admin/add-new-job/add-new-job.component';
import { ThankyouComponent } from './booking/thankyou/thankyou.component';
import { WorkerHomeComponent } from './worker/worker-home/worker-home.component';


const routes: Routes = [
  {path:'',redirectTo:'/home',pathMatch:'full'},
  {path:'home',component:HomeComponent},
  {path:'workerlogin',component:WorkerloginComponent},
  {path:'userlogin',component:UserloginComponent},
  {path:'registeruser',component:RegisteruserComponent},
  {path:'registerworker',component:RegisterworkerComponent},
  {path:'services',component:ServicesComponent},
  {path:'adminHome',component:AdminHomeComponent},
  {path:'listServices',component:ListServicesComponent},
  {path:'listCustomer',component:ListCustomerComponent},
  {path:'listWorker/:jobId',component:ListWorkerComponent},
  {path:'listBooking',component:ListBookingComponent},
  {path:'book',component:FormBookingComponent},
  {path:'update/:jobid',component:UpdateListComponent},
  {path:'addNewJob',component:AddNewJobComponent},
  {path:'thankyou',component:ThankyouComponent},
  {path:'workerHome',component:WorkerHomeComponent},
  {path:'**',component:PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
