import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AdminComponent } from './admin/admin.component';
import { UserComponent } from './user/user.component';
import { TrainListComponent } from './admin/train-list/train-list.component';
import { NgbModule,NgbPaginationModule } from '@ng-bootstrap/ng-bootstrap';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LoginModalComponent } from './login-modal/login-modal.component';
import {MatDialogModule} from '@angular/material/dialog';
import {MatButtonModule} from '@angular/material/button';
import {MatMenuModule} from '@angular/material/menu';
import { AdminLoginComponent } from './admin/admin-login/admin-login.component';
import { SignupModalComponent } from './signup-modal/signup-modal.component';
import { AdminSignupComponent } from './admin/admin-signup/admin-signup.component';
import { UserSignupComponent } from './user/user-signup/user-signup.component';
import { UserLoginComponent } from './user/user-login/user-login.component';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';
import { AdminTrainComponent } from './admin/admin-train/admin-train.component';
import {MatIconModule} from '@angular/material/icon';
import { UpdateTrainComponent } from './admin/update-train/update-train.component';
import { AdminProfileComponent } from './admin/admin-profile/admin-profile.component';
import { TrainByIdComponent } from './admin/train-by-id/train-by-id.component';
import { TrainByNameComponent } from './admin/train-by-name/train-by-name.component';
import { TrainByLocComponent } from './admin/train-by-loc/train-by-loc.component';
import { UserProfileComponent } from './user/user-profile/user-profile.component';
import { TrainIdComponent } from './user/train-id/train-id.component';
import { TrainNameComponent } from './user/train-name/train-name.component';
import { TrainLocComponent } from './user/train-loc/train-loc.component';
import { UserTrainListComponent } from './user/user-train-list/user-train-list.component';
import { FooterComponent } from './footer/footer.component';
import { BookComponent } from './user/book/book.component';
import {MatSelectModule} from '@angular/material/select';

const material = [
  MatDialogModule,MatButtonModule,MatMenuModule,MatFormFieldModule,MatInputModule,FormsModule,
  MatIconModule,MatSelectModule
]

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    AdminComponent,
    UserComponent,
    TrainListComponent,
    LoginModalComponent,
    AdminLoginComponent,
    SignupModalComponent,
    AdminSignupComponent,
    UserSignupComponent,
    UserLoginComponent,
    HomeComponent,
    AdminTrainComponent,
    UpdateTrainComponent,
    AdminProfileComponent,
    TrainByIdComponent,
    TrainByNameComponent,
    TrainByLocComponent,
    UserProfileComponent,
    TrainIdComponent,
    TrainNameComponent,
    TrainLocComponent,
    UserTrainListComponent,
    FooterComponent,
    BookComponent,
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    NgbPaginationModule,
    BrowserAnimationsModule,
    material, HttpClientModule
    
    
  ],
   entryComponents:[AdminTrainComponent],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
