export class Booking{
    bookingId:number;
    jobId:number;
    customerId:number;
    bookingStatus:string;
    paymentStatus:string;
    bookingDate:Date;
    serviceBookDate:Date;

    constructor(
        bookingId:number,
    jobId:number,
    customerId:number,
    bookingStatus:string,
    paymentStatus:string,
    bookingDate:Date,
    serviceBookDate:Date
    ){
        this.bookingId=bookingId;
        this.jobId=jobId;
        this.customerId=customerId;
        this.bookingStatus=bookingStatus;
        this.paymentStatus=paymentStatus;
        this.bookingDate=bookingDate;
        this.serviceBookDate=serviceBookDate;
    }
}