import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminServiceService } from '../admin-service.service';
import { Train } from '../train';

@Component({
  selector: 'app-admin-train',
  templateUrl: './admin-train.component.html',
  styleUrls: ['./admin-train.component.css']
})
export class AdminTrainComponent implements OnInit {

  train: Train = new Train(0,"","","",0,"",0,0,0,0);

  constructor(private service:AdminServiceService,private route:Router) { }

  ngOnInit(): void {
  }

  addTrain()
  {
    this.service.addTrain(this.train).subscribe((data)=>{})
    //  this.route.url("admin/train-list")
    this.route.navigate(["admin/train-list"]).then(() => {
      window.location.reload();
   });
  }
}
