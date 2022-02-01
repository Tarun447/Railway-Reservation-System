import { compareSegments } from '@angular/compiler-cli/src/ngtsc/sourcemaps/src/segment_marker';
import { Component, OnInit } from '@angular/core';
import { Role } from 'src/app/role';
import { Admin } from '../admin';
import { AdminServiceService } from '../admin-service.service';

@Component({
  selector: 'app-admin-signup',
  templateUrl: './admin-signup.component.html',
  styleUrls: ['./admin-signup.component.css']
})
export class AdminSignupComponent implements OnInit {
 role:any = new Role([{role:"Admin"}]);
 admin :any = new Admin("","","","","",[{role:"Admin"}],"");

 data:any;
  constructor(private service:AdminServiceService) { }

  ngOnInit(): void {
  }

  signupAdmin()
  {
      this.service.createAdmin(this.admin).subscribe((data)=>{
        alert("New Admin Successfully Added");
        window.location.href="admin";
        
      },
      
      (error)=>{console.log(error)});
        // alert("Username Should Be unique");
  }

}
