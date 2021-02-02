

export class Customer {
    customerId:number;
    firstName:string;
    lastname:string;
    email:string;
    mobileNo:string;
    address:string;
    city:string;
    state:string;
    country:string;
    password:string;
    role:string;
    pincode:number;
    constructor(
        customerId:number,
         firstName:string,
         lastname:string,
         email:string,
         mobileNo:string,
         address:string,
         city:string,
         state:string,
         country:string,
         password:string,
         role:string,
         pincode:number
    ) {
        this.customerId=customerId;
        this.firstName=firstName;
        this.lastname=lastname;
        this.email=email;
        this.address=address;
        this.mobileNo=mobileNo;
        this.city=city;
        this.state=state;
        this.country=country;
        this.password=password;
        this.role=role;
        this.pincode=pincode;
    }
}