import { Component, OnInit } from '@angular/core';
import { HeaderServiceService } from 'src/app/header/header-service.service';
// import { AdminServiceService } from '../admin-service.service';
// import { AdminServiceService } from '../admin-signup/admin-signup.component';
import { AdminServiceService } from '../admin-service.service';


@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit {
  credential={
    username:'',
    password:''

  }

  constructor(private service:AdminServiceService,private head:HeaderServiceService) { }

  ngOnInit(): void {
   
  }

  onSubmit(){
    // console.log(this.credential);

    if((this.credential.username!='' && this.credential.password!='') && (this.credential.username!=null && this.credential.password!=null))
    {
             this.service.getAuth(this.credential).subscribe((response:any)=>{
              console.log(response.token);
              localStorage.setItem('role','Admin');
              localStorage.setItem("username",this.credential.username);
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
