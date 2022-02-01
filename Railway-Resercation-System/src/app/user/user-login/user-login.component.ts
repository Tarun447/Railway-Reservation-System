import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
// import { HeaderServiceService } from 'src/app/header/header-service.service';
// import { HeaderComponent } from 'src/app/header/header.component';
import { UserServiceService } from '../user-service.service';
// import { HomeServiceService } from 'src/app/home/home-service.service';


@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {
  
   credential={
    username:'',
    password:''

  }
  constructor(private route:Router,private service:UserServiceService) { }

  ngOnInit(): void {
  }
  

  onSubmit(){
    // console.log(this.credential);
    if((this.credential.username!='' && this.credential.password!='') && (this.credential.username!=null && this.credential.password!=null))
    {
             this.service.getAuth(this.credential).subscribe((response:any)=>{
              console.log(response.token);
              localStorage.setItem("role","User");
              localStorage.setItem("username",this.credential.username)
              this.service.loginuser(response.token);
              window.location.href=""
             },
             error=>{ alert("Invalid Crdential");
             })

    }
    else{
      alert("Login UnSuccessful")
    }
       
   }
}
