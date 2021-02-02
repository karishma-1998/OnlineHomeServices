import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { LoginModule } from './login/login.module';
import { WorkerModule } from './worker/worker.module';
import { ServicesComponent } from './services/services.component';
import { AdminModule } from './admin/admin.module';
import { BookingModule } from './booking/booking.module';
import { ToastrModule } from 'ngx-toastr';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    ServicesComponent,
    FooterComponent,
    HomeComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    LoginModule,
    WorkerModule,
    AdminModule,
    BookingModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot()
  ],exports:[],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
