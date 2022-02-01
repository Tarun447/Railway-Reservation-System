export class Train{
    constructor(
       public  trainNum:Number,
       public trainName:String,
       public startLoc:String,
       public endLoc:String,
       public  seat:Number,
       public time:String,
       public  firstAc:Number,
       public  secondAc:Number,
       public  thirdAc:Number,
       public sleeper:Number
    ){}
}