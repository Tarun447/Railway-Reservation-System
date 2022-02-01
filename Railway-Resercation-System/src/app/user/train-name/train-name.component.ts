import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { BookComponent } from '../book/book.component';
import { UserServiceService } from '../user-service.service';

@Component({
  selector: 'app-train-name',
  templateUrl: './train-name.component.html',
  styleUrls: ['./train-name.component.css']
})
export class TrainNameComponent implements OnInit {
  trainlist:any;
  constructor(private service:UserServiceService,private rout:Router,private dialog:MatDialog){}

  ngOnInit(): void {
  }

  byname(name:any)
  {
    this.service.getByName(name).subscribe((data)=>{this.trainlist=data});
    console.log(this.trainlist)
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
