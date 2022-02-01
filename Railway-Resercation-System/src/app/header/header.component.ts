import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import Swal from 'sweetalert2';
import { AdminProfileComponent } from '../admin/admin-profile/admin-profile.component';
import { AdminServiceService } from '../admin/admin-service.service';
import { TrainByIdComponent } from '../admin/train-by-id/train-by-id.component';
import { TrainByLocComponent } from '../admin/train-by-loc/train-by-loc.component';
import { TrainByNameComponent } from '../admin/train-by-name/train-by-name.component';
import { LoginModalComponent } from '../login-modal/login-modal.component';
import { SignupModalComponent } from '../signup-modal/signup-modal.component';
import { TrainIdComponent } from '../user/train-id/train-id.component';
import { TrainLocComponent } from '../user/train-loc/train-loc.component';
import { TrainNameComponent } from '../user/train-name/train-name.component';
import { UserProfileComponent } from '../user/user-profile/user-profile.component';
import { UserServiceService } from '../user/user-service.service';
import { HeaderServiceService } from './header-service.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  public  role:any='';
  

  constructor(private dialog:MatDialog,private service:AdminServiceService,private service1:UserServiceService
    )
   {
       
   }
  

  ngOnInit(): void {
    
    // console.log(this.d.getrole());
    this.role=localStorage.getItem('role');
    // alert(this.role);
  }
 
  
  
  openlogin(){
    
    
    this.dialog.open(LoginModalComponent);
  }
  opensignup(){
    this.dialog.open(SignupModalComponent);
  }

  logout()
  {
    const swalWithBootstrapButtons = Swal.mixin({
      customClass: {
        confirmButton: 'btn btn-success',
        cancelButton: 'btn btn-danger'
      },
      buttonsStyling: false
    })
    
    swalWithBootstrapButtons.fire({
      title: 'Are you sure?',
      text: "Do You Want To LogOut",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText:  '   Yes Log Out',
      cancelButtonText:  'No, cancel!  ',
      reverseButtons: true
    }).then((result) => {
      if (result.isConfirmed) {
        if(localStorage.getItem("role")=="Admin")
    {
      this.service.logout();
      window.location.href="admin/admin-login"
    }
    else if(localStorage.getItem("role")=="User"){
        this.service1.logout();
        window.location.href="user/user-login"
    }

        swalWithBootstrapButtons.fire(
          'Logout',
          'You  have been LoggedOut.',
          'success'
        )
      } else if (
        /* Read more about handling dismissals below */
        result.dismiss === Swal.DismissReason.cancel
      ) {
        swalWithBootstrapButtons.fire(
          'Cancelled',
        
          'error'
        )
      }
    }) 
  }

  profile(){
    const matconfig = new MatDialogConfig();
   matconfig.width = "60%";
    if(localStorage.getItem("role")=="Admin")
    {
      this.dialog.open(AdminProfileComponent,matconfig);
    }
    else if(localStorage.getItem("role")=="User")
    {
      this.dialog.open(UserProfileComponent,matconfig);
    }
    }
      


    // for searching
    searchById(){
      const matconfig = new MatDialogConfig();
   matconfig.width = "60%";
      if(localStorage.getItem("role")=='Admin')
      {
        this.dialog.open(TrainByIdComponent,matconfig);
      }
      else if(localStorage.getItem("role")=='User'){
          this.dialog.open(TrainIdComponent,matconfig);
      }
    }
  
    searchByName()
    {
      const matconfig = new MatDialogConfig();
   matconfig.width = "60%";
      if(localStorage.getItem("role")=='Admin')
      {
        this.dialog.open(TrainByNameComponent,matconfig);
      }
      else if(localStorage.getItem("role")=='User'){
        this.dialog.open(TrainNameComponent,matconfig);
      }
    }

    searchByLoc()
    {
      const matconfig = new MatDialogConfig();
   matconfig.width = "60%";
      if(localStorage.getItem("role")=='Admin')
      {
          this.dialog.open(TrainByLocComponent)
      }
      else if(localStorage.getItem("role")=='User'){
          this.dialog.open(TrainLocComponent,matconfig)
      }
    }
  
    getUsername()
    {
      return localStorage.getItem("username");
    }
  }

 






