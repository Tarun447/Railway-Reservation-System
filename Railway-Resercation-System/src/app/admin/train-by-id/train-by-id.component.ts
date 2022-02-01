import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminServiceService } from '../admin-service.service';

@Component({
  selector: 'app-train-by-id',
  templateUrl: './train-by-id.component.html',
  styleUrls: ['./train-by-id.component.css']
})
export class TrainByIdComponent implements OnInit {

  trainlist:any;

  constructor(private service:AdminServiceService,private rout:Router) { }

  ngOnInit(): void {
  }

  byId(id:number)
  { 
     this.service.getById(id).subscribe((data)=>{
       this.trainlist = data;
     })
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
