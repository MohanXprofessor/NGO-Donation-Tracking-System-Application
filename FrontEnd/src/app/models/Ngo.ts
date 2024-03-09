import { Expenditure } from "./Expenditures";

export class Ngo{
    ngo_id: number;
     name:string;
   description:string;
   expenditures:Expenditure[];
    constructor(){
     this.ngo_id=0;
        this.name="";
        this.description="";
        this.expenditures=[];
    }

}