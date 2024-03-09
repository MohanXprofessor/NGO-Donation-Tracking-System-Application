import { Component } from '@angular/core';
import { User } from '../../models/User';

import { Router } from '@angular/router';
import { NgoserviceService } from '../../services/ngoservice.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.css'
})
export class SignupComponent {
  constructor(private service: NgoserviceService, private router:Router){
   
  }
  submitted=false;
  user = new User();

  
  onSubmit(){
    this.save();
    this.submitted=true;
  
  }
  gotoHome(){
    this.router.navigate(['/']);
   }
  save() {
   this.service.createUser(this.user).subscribe();
 
  }
}
