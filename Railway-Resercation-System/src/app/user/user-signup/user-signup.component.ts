import { Component, OnInit } from '@angular/core';
import { Role } from 'src/app/role';
import { User } from '../User';
import { UserServiceService } from '../user-service.service';  

@Component({
  selector: 'app-user-signup',
  templateUrl: './user-signup.component.html',
  styleUrls: ['./user-signup.component.css']
})
export class UserSignupComponent implements OnInit {
  role:any = new Role([{role:"Admin"}]);
  user :any = new User("","","","","",[{role:"Admin"}],"");



  constructor(private service:UserServiceService) { }

  ngOnInit(): void {
  }

  signupUser()
  {
    this.service.createUser(this.user).subscribe((data)=>{
      console.log(data)
    },
    
    (error)=>{console.log(error)});
      console.log(this.role);
      console.log(this.user)
  }
}
