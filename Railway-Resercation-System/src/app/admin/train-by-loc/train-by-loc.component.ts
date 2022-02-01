import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminServiceService } from '../admin-service.service';

@Component({
  selector: 'app-train-by-loc',
  templateUrl: './train-by-loc.component.html',
  styleUrls: ['./train-by-loc.component.css']
})
export class TrainByLocComponent implements OnInit {
trainlist:any;
  constructor(private service:AdminServiceService,private rout:Router) { }

  ngOnInit(): void {
  }



  byloc(st:any,en:any)
  {
    this.service.getByLoc(st,en).subscribe((data)=>{this.trainlist=data});
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
