import { NgModule } from '@angular/core';
import { CommonModule, DatePipe } from '@angular/common';
import { FormBookingComponent } from './form-booking/form-booking.component';
import { PaymentComponent } from './payment/payment.component';
import { FormsModule } from '@angular/forms';
import { ThankyouComponent } from './thankyou/thankyou.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';



@NgModule({
  declarations: [FormBookingComponent, PaymentComponent, ThankyouComponent],
  imports: [
    FormsModule,
    CommonModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot()
  ],
  exports:[
    ThankyouComponent
  ],
  providers:[
    DatePipe
  ]
})
export class BookingModule { }
