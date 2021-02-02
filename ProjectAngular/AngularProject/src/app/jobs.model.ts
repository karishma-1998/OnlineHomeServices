export class Jobs{
    jobId:number;
    jobName:string;
    jobDescription:String;
    price:number;
    discount:number;

    constructor(
        jobId:number,
        jobName:string,
        jobDescription:String,
        price:number,
        discount:number,
    ){
        this.jobId=jobId;
        this.jobName=jobName;
        this.jobDescription=jobDescription;
        this.price=price;
        this.discount=discount;
        
    }
    
}