import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
// import Swal from 'sweetalert2';
import { Train } from './train';
import { User } from './User';


@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  url="http://localhost:8083/user";

  header = new HttpHeaders().set("Authorization","Bearer "+this.getToken());
  
  constructor(private http:HttpClient,private route:Router) { }

  

  getAuth(credential:any)
  {
    return this.http.post(`${this.url}/authenticates`,credential);
  }
  
 //for login user
 loginuser(token:any)
 {
     localStorage.setItem("token",token);
     return true;
 }

 // check user is login or not 
 isLoggedIn()
 {
   let token = localStorage.getItem("token");
   if(token==undefined || token==null || token=='')
   {
     return false;
   }else{
     return true;
   }
 }

 
// logout user
logout(){
  localStorage.removeItem("token");
  localStorage.removeItem("role");
  localStorage.removeItem("username");
  return true;
}

// for get token 
getToken()
{
 return localStorage.getItem("token");
}



// for user 
public createUser(user:User)
  {
      return this.http.post("http://localhost:8083/user/create",user,{responseType:'text' as 'json'});
  }


  public getByuserName(username:any)
  {
    return this.http.get(`${this.url}/user/${username}`,{headers:this.header})
  }



  // for train
  public getTrains()
  {
     let str="Bearer "+this.getToken();

    return this.http.get(`${this.url}/allTrain`,{headers:this.header});
  }

  public getByName(name1:String)
  {
   return this.http.get(`${this.url}/find-train/${name1}`,{headers:this.header});
  }

  public getById(id:Number):Observable<Train>
  {
   return this.http.get<Train>(`${this.url}/find/${id}`,{headers:this.header});
  }

  public getByLoc(st:String,en:String)
  {
     return this.http.get(`${this.url}/findLoc/${st}/${en}`,{headers:this.header});
  }
 
 payment(order:any)
 {
  
 
   return this.http.post("http://localhost:9090/book/makebook",order,{headers:this.header});
  
 }

 
 

  }




