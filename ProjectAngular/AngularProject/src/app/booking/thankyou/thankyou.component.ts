import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-thankyou',
  templateUrl: './thankyou.component.html',
  styleUrls: ['./thankyou.component.css']
})
export class ThankyouComponent implements OnInit {

  constructor(private router:Router,private toastr:ToastrService) { }

  ngOnInit(): void {
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
