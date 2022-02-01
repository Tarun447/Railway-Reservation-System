import { Component, OnInit } from '@angular/core';
import { MatDialog,MatDialogConfig } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { BookComponent } from '../book/book.component';
import { UserServiceService } from '../user-service.service';

@Component({
  selector: 'app-user-train-list',
  templateUrl: './user-train-list.component.html',
  styleUrls: ['./user-train-list.component.css']
})
export class UserTrainListComponent implements OnInit {
 
  trainlist:any;
  
  constructor(private service:UserServiceService,private dialog:MatDialog,private rout:Router) { }

  ngOnInit(): void {
    let res=this.service.getTrains();
    res.subscribe((data)=>{this.trainlist=data});
  }

  book(obj:any)
  {
    const matconfig = new MatDialogConfig();
    matconfig.width = "60%";
    matconfig.disableClose=true;
    localStorage.setItem("train",obj);    
    this.dialog.open(BookComponent,matconfig);
  }

  

}
