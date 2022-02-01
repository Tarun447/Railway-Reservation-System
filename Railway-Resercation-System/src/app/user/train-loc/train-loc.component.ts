import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { BookComponent } from '../book/book.component';
import { UserServiceService } from '../user-service.service';

@Component({
  selector: 'app-train-loc',
  templateUrl: './train-loc.component.html',
  styleUrls: ['./train-loc.component.css']
})
export class TrainLocComponent implements OnInit {

  trainlist:any;
  constructor(private service:UserServiceService,private rout:Router,private dialog:MatDialog) { }

  ngOnInit(): void {
  }

  byloc(st:any,en:any)
  {
    this.service.getByLoc(st,en).subscribe((data)=>{this.trainlist=data});
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
