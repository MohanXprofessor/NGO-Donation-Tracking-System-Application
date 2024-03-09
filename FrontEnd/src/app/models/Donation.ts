import { Ngo } from "./Ngo";
import { User } from "./User";

export class Donation{
    donation_id:number;
    amount:number;
    donationDate!: Date;
    ngo: Ngo = new Ngo();
    user:User=new User();

    constructor(){
        this.donation_id=0;
        this.amount=0;
        
    }
}
