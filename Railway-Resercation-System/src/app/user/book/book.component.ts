import { Component, OnInit } from '@angular/core';
import { Order } from '../Order';
import { Train } from '../train';
import { UserServiceService } from '../user-service.service';
// import { ViewChild, ElementRef} from '@angular/core';


@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {

  constructor(private service:UserServiceService) { }

 amt:Number=0;

 username:String='';
 tickettype:String='';
email:String ='';


  train = new Train(0,"","","",0,"",0,0,0,0);

  
  id = parseInt(localStorage['train']);


  ngOnInit(): void {

   

  this.service.getById(this.id).subscribe((data)=>{
    this.train = data;
    
  });
  }
  


close()
{
  
  localStorage.removeItem("train");
}


first()
{
  this.tickettype = "FirstAc";
  this.amt = this.train.firstAc
  console.log(this.amt);
}


second()
{
  this.tickettype = "SecondAc";
  this.amt = this.train.secondAc
  console.log(this.amt);
}
third()
{
  this.tickettype = "ThirdAc";
  this.amt = this.train.thirdAc
  console.log(this.amt);
}

sleep()
{
  this.tickettype = "Sleeper";
  this.amt = this.train.sleeper
  console.log(this.amt);
}





pay()
{
  const order = new Order(this.username,this.train.trainNum,this.train.trainName,this.tickettype,this.amt,
    this.train.startLoc,this.train.endLoc,this.train.time,this.email);
  // console.log(order);

  this.service.payment(order).subscribe((data)=>{
    window.location.href = "https://paytm.me/wbqY-ht";
  })
}
}


