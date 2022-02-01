import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Admin } from './admin';
import { Train } from './train';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminServiceService {
  url="http://localhost:8081/admin";
  
   header = new HttpHeaders().set("Authorization","Bearer "+this.getToken());
  constructor(private http:HttpClient) { 
    
  }



  public createAdmin(admin:Admin)
   {
       return this.http.post("http://localhost:8081/admin/addAdmin",admin,{responseType:'text' as 'json'});
   }


   getAuth(credential:any)
   {
     return this.http.post(`${this.url}/authenticates`,credential);
   }
   
  //for login user
  loginuser(token:any)
  {
      localStorage.setItem("token",token);
      // localStorage.setItem("role","Admin");
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
   localStorage.removeItem("username");
   localStorage.removeItem("role");
   return true;
}

// for get token 
getToken()
{
  return localStorage.getItem("token");
}


// update Admin
public updateAdmin(id:any,admin:Admin)
  {
    return this.http.put(`${this.url}/updateAdmin/${id}`,admin,{headers:this.header});
  }

public getByuserName(username:any)
{
  return this.http.get(`${this.url}/user/${username}`,{headers:this.header})
}


// For train
public addTrain(train:Train)
   {

       return this.http.post(`${this.url}/addTrain`,train,{headers:this.header,responseType:'text' as 'json'});
   }

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

   public deleteTrain(id:number)
   {
    return this.http.delete(`${this.url}/delete/${id}`,{headers:this.header,responseType: 'text'});
   }

   public updateTrain(id:Number,train:Train)
   {
     return this.http.put(`${this.url}/update/${id}`,train,{headers:this.header,responseType:'text' as 'json' });
   }






}
