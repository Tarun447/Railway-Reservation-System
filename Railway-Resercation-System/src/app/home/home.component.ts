import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
// import { HeaderServiceService } from '../header/header-service.service';
import { HomeServiceService } from './home-service.service';
import { LoginModalComponent } from '../login-modal/login-modal.component';
import { SignupModalComponent } from '../signup-modal/signup-modal.component';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private dialog:MatDialog,private service:HomeServiceService) { }

  ngOnInit(): void {
  }

  openlogin(){
    // alert("Hello")
    
    this.dialog.open(LoginModalComponent);
  }
  opensignup(){
    // alert("Hello")
    this.dialog.open(SignupModalComponent);
  }
}
