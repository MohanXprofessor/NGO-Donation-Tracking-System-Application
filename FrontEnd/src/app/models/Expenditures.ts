import { Ngo } from "./Ngo";

export class Expenditure {
    expenditure_id: number;
    ngo: Ngo = new Ngo();
    exp_amount: number;
    description: string;
    expenditureDate!: Date;

    constructor(){
        this.expenditure_id=0;
        this.exp_amount=0;
        this.description="";
       

    }
  }