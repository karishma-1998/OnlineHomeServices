export class Workers{
    workerId:number;
    firstName:string;
    lastname:string;
    email:string;
    mobileNo:string;
    address:string;
    city:string;
    state:string;
    country:string;
    password:string;
    onLeave:string;
    pincode:string;
    jobId:number;
   
    constructor(
         workerId:number,
         firstName:string,
         lastname:string,
         email:string,
         mobileNo:string,
         address:string,
         city:string,
         state:string,
         country:string,
         password:string,
         onLeave:string,
         pincode:string,
         jobId:number
    ){
        this.workerId=workerId;
        this.firstName=firstName;
        this.lastname=lastname;
        this.email=email;
        this.mobileNo=mobileNo;
        this.city=city;
        this.address=address;
        this.state=state;
        this.country=country;
        this.password=password;
        this.onLeave=onLeave;
        this.pincode=pincode;
        this.jobId=jobId;

    }
    
}