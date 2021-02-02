import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-admin-home',
  templateUrl: './admin-home.component.html',
  styleUrls: ['./admin-home.component.css']
})
export class AdminHomeComponent implements OnInit {

  FName=sessionStorage.getItem('firstName');
  LName=sessionStorage.getItem('lastname');
  constructor(private router:Router,private toastr:ToastrService) { }

  ngOnInit(): void {
   // this.toastr.success("welcome"+sessionStorage['firstName']);
  }
  showServices(){
    this.router.navigate(['listServices']);
  }
  showCustomers()
  {
    this.router.navigate(['listCustomer']);
  }
  showWorkers()
  {
    this.router.navigate(['listWorker']);
  }

  showBookings()
  {
    this.router.navigate(['listBooking']);
  }

  onLogout()
  {
    console.log("in logout");
    sessionStorage.removeItem('firstName');
    sessionStorage.removeItem('lastname');
    this.toastr.success('Logout Successfully');
    this.router.navigate(['']);
  }
}
