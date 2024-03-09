export class User{
    user_id:number;
	username:string;
	email:string;
	password: string;

    constructor(){
        this.user_id=0;
        this.username="";
        this.email="";
        this.password="";
    }
}