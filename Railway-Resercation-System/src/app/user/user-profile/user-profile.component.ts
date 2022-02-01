import { Component, OnInit } from '@angular/core';
import { User } from '../User';
import { UserServiceService } from '../user-service.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  admin:any = new User("","","","","",[{"role":""}],"");

  constructor(private service:UserServiceService) { }

  ngOnInit(): void {
    let u = localStorage.getItem("username");
    this.service.getByuserName(u).subscribe((data)=>{this.admin=data});
  }

}
