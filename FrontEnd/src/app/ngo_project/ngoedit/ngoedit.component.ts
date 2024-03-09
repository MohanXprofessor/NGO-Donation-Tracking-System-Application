import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NgoserviceService } from '../../services/ngoservice.service';
import { Ngo } from '../../models/Ngo';
import { Observable, switchMap } from 'rxjs';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-ngoedit',
  templateUrl: './ngoedit.component.html',
  styleUrl: './ngoedit.component.css'
})
export class NgoeditComponent {
  ngo_id: number = 0;
  ngo: Ngo = new Ngo();

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private service: NgoserviceService
  ) {}

  ngOnInit() {
    this.route.params.pipe(
      switchMap(params => {
        this.ngo_id = +params['ngo_id']; // Convert to number
        return this.service.getOneNgo(this.ngo_id);
      })
    ).subscribe(
      (data: Ngo) => {
        this.ngo = data;
      },
      error => {
        console.error('Error fetching NGO data:', error);
      }
    );
  }

  onSubmit() {
    this.updateNgo();
  }

  updateNgo() {
    this.service.updateNgo(this.ngo).subscribe(
      (updatedNgo: Ngo) => {
        console.log('NGO updated successfully:', updatedNgo);
        this.router.navigate(['/admin-panel']); // Navigate to NGO list after update
      },
      error => {
        console.error('Error updating NGO:', error);
        // Handle error: Display error message to user or handle accordingly
      }
    );
    Swal.fire({
      position: "center",
      icon: "success",
      title: "Record Updated Successfully..!",
      showConfirmButton: false,
      timer: 1500
    });
  }
}

