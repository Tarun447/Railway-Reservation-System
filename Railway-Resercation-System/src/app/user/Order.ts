export class Order{
    constructor(
        public  userName:String,
	    public  trainNumber:Number,
        public trainName:String,
        public  ticketType:String,
        public amnt:Number,
        public stratpoint:String,
        public endpoint:String,
        public time:String,
        public email:String
    ){}
}