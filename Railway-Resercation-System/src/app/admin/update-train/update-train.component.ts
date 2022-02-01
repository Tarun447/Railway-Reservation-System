import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import Swal from 'sweetalert2';
import { AdminServiceService } from '../admin-service.service';
import { Train } from '../train';

@Component({
  selector: 'app-update-train',
  templateUrl: './update-train.component.html',
  styleUrls: ['./update-train.component.css']
})
export class UpdateTrainComponent implements OnInit {
 
  id:number=0;
  train =  new Train(0,"","","",0,"",0,0,0,0);
  constructor(private service:AdminServiceService,private route:ActivatedRoute,
    private router:Router) { }

  ngOnInit(): void {
    this.id= this.route.snapshot.params['id'];
    this.service.getById(this.id).subscribe((data)=>{
      
      this.train = data;
      
    });

    console.log(this.train);
    console.log(this.id);
  }


   changeTrain()
   {


    Swal.fire({
      title: 'Do you want to save the changes?',
      // showDenyButton: true,
      showCancelButton: true,
      confirmButtonText: 'Save',
      denyButtonText: `Don't save`,
    }).then((result) => {
      /* Read more about isConfirmed, isDenied below */
      if (result.isConfirmed) {
        this.service.updateTrain(this.id,this.train).subscribe((data)=>{
          this.router.navigate(["/admin/train-list"]);
         });
        Swal.fire('Saved!', '', 'success')
      } else if (result.isDenied) {
        Swal.fire('Changes are not saved', '', 'info')
      }
    })
    
     
     
    
     
   }

   
   
}
