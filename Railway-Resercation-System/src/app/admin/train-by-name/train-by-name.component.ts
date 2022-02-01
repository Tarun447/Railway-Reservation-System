import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminServiceService } from '../admin-service.service';

@Component({
  selector: 'app-train-by-name',
  templateUrl: './train-by-name.component.html',
  styleUrls: ['./train-by-name.component.css']
})
export class TrainByNameComponent implements OnInit {

  trainlist:any;

  constructor(private service:AdminServiceService,private rout:Router) { }



  ngOnInit(): void {
  }


  byname(name:any)
  {
    this.service.getByName(name).subscribe((data)=>{this.trainlist=data});
    console.log(this.trainlist)
  }

  deltrain(id:number)
  {
    this.service.deleteTrain(id).subscribe((data)=>{ console.log(data)});
    this.ngOnInit();
  }

  updateTrain(id:number)
  {
    this.rout.navigate(["admin/update-train",id]);
  }

}
