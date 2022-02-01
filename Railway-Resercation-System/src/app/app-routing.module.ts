import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminAuthGuard } from './admin/admin-auth.guard';
import { AdminLoginComponent } from './admin/admin-login/admin-login.component';
import { AdminProfileComponent } from './admin/admin-profile/admin-profile.component';
import { AdminSignupComponent } from './admin/admin-signup/admin-signup.component';
import { AdminComponent } from './admin/admin.component';
import { TrainListComponent } from './admin/train-list/train-list.component';
import { UpdateTrainComponent } from './admin/update-train/update-train.component';
import { HomeComponent } from './home/home.component';
import { UserAuthGuard } from './user/user-auth.guard';
import { UserLoginComponent } from './user/user-login/user-login.component';
import { UserProfileComponent } from './user/user-profile/user-profile.component';
import { UserSignupComponent } from './user/user-signup/user-signup.component';
import { UserTrainListComponent } from './user/user-train-list/user-train-list.component';
import { UserComponent } from './user/user.component';

const routes: Routes = [
  {path:"",component:HomeComponent},
  // {path:"admin-dash",component:AdminDashboardComponent},
 
  
  
  // for Admin path
  {path:"admin",component:AdminComponent,
        children:[ {path:"admin-login",component:AdminLoginComponent},
                    {path:"admin-signup",component:AdminSignupComponent},
                     {path:"train-list",component:TrainListComponent,canActivate:[AdminAuthGuard]},
                     {path:"update-train/:id",component:UpdateTrainComponent,canActivate:[AdminAuthGuard]},
                     {path:"profile",component:AdminProfileComponent,canActivate:[AdminAuthGuard]},
                  ],
                   },

    // for user  Path
    {path:"user" ,component:UserComponent,
            children:[
              {path:"user-login",component:UserLoginComponent,pathMatch:'full'},
              {path:"user-signup",component:UserSignupComponent,pathMatch:'full'},
              {path:"tarinlist",component:UserTrainListComponent,canActivate:[UserAuthGuard]},
              {path:"profile",component:UserProfileComponent,canActivate:[UserAuthGuard]},
            ],
          },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
