import { Role } from "../role";

export class User{
    constructor(
        public  fname:String,
        public  mname:String,
        public  lname:String,
        public  email:String,
        public  password:String,
        public role:[{role:any}],
        public userName:String
    ){}
}