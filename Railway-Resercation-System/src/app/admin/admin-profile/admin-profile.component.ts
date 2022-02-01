import { Component, OnInit } from '@angular/core';
import { Admin } from '../admin';
import { AdminServiceService } from '../admin-service.service';

@Component({
  selector: 'app-admin-profile',
  templateUrl: './admin-profile.component.html',
  styleUrls: ['./admin-profile.component.css']
})
export class AdminProfileComponent implements OnInit {

  constructor(private service:AdminServiceService) { }

  admin:any = new Admin("","","","","",[{"role":""}],"");

  ngOnInit(): void {
    let u = localStorage.getItem("username");
    this.service.getByuserName(u).subscribe((data)=>{this.admin=data});
  }



}
