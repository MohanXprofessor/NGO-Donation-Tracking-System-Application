import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgoserviceService } from '../../services/ngoservice.service';
import { Ngo } from '../../models/Ngo';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-addngo',
  templateUrl: './addngo.component.html',
  styleUrl: './addngo.component.css'
})
export class AddngoComponent {
  constructor(private service: NgoserviceService, private router:Router){
   
  }
  // submitted=false;
  ngo = new Ngo();

  
  onSubmit(){
    this.save();
    // this.submitted=true;
   
  }
  gotoHome(){
    this.router.navigate(['/admin-panel']);
   }
  save() {
   this.service.createNgo(this.ngo).subscribe();

   Swal.fire({
    position: "center",
    icon: "success",
    title: " NGO Added Successfully..!",
    showConfirmButton: false,
    timer: 1500
  });

   this.gotoHome()
   
  }
}
