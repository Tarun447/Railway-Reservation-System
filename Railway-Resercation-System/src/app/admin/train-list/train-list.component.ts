import { Component, OnInit } from '@angular/core';
import { MatDialog,MatDialogConfig } from '@angular/material/dialog';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { AdminServiceService } from '../admin-service.service';
import { AdminTrainComponent } from '../admin-train/admin-train.component';
// import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-train-list',
  templateUrl: './train-list.component.html',
  styleUrls: ['./train-list.component.css']
})
export class TrainListComponent implements OnInit {

  trainlist:any;

  constructor(private service:AdminServiceService,private dialog:MatDialog,private rout:Router) { }

  ngOnInit(): void {
    let res=this.service.getTrains();
    res.subscribe((data)=>{this.trainlist=data});
  }


  deltrain(id:number)
  {
     
    Swal.fire({
      title: 'Are you sure?',
      text: "You won't be able to revert this!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
      if (result.isConfirmed) {
        Swal.fire(
          'Deleted!',
          'Your file has been deleted.',
          'success'
        )
        this.service.deleteTrain(id).subscribe((data)=>{ console.log(data);
          this.ngOnInit();});
      }
    })
    
  }


  // Open Add New Modal
  addnew(){

   const matconfig = new MatDialogConfig();
   matconfig.width = "60%";
    this.ngOnInit();
     this.dialog.open(AdminTrainComponent,matconfig)
  //  alert("Hello")
  }

  // onclose()
  // {
  //    this.ref.close();
  // }



  // Update Train
  updateTrain(id:number)
  {
    this.rout.navigate(["admin/update-train",id]);
  }
}
