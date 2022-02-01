import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { BookComponent } from '../book/book.component';
import { UserServiceService } from '../user-service.service';

@Component({
  selector: 'app-train-id',
  templateUrl: './train-id.component.html',
  styleUrls: ['./train-id.component.css']
})
export class TrainIdComponent implements OnInit {

  trainlist:any;
  constructor(private service:UserServiceService,private rout:Router,private dialog:MatDialog) { }

  ngOnInit(): void {
  }

  byId(id:number)
  { 
     this.service.getById(id).subscribe((data)=>{
       this.trainlist = data;
     })
}

book(obj:any)
{
  const matconfig = new MatDialogConfig();
  matconfig.width = "60%";
  matconfig.disableClose=true;
  localStorage.setItem("train",obj);    
  this.dialog.open(BookComponent,matconfig)
}
}
