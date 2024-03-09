import { Component } from '@angular/core';
import { Donation } from '../../models/Donation';
import { NgoserviceService } from '../../services/ngoservice.service';
import { DonationService } from '../../services/donation.service';
import { User } from '../../models/User';
import { Ngo } from '../../models/Ngo';

@Component({
  selector: 'app-donate',
  templateUrl: './donate.component.html',
  styleUrl: './donate.component.css'
})
export class DonateComponent {

  donation: Donation = new Donation();
  ngos: Ngo[] = []; // Assuming you have an array of NGOs
  users: User[] = []; // Assuming you have an array of Users

  constructor(private donationService: DonationService,private service:NgoserviceService) { }

  ngOnInit() {
    // Fetch NGOs and Users from your service or API
    this.fetchNgos();
    this.fetchUsers();
  }

  fetchNgos() {
    // Call service method to fetch NGOs
    // Assuming you have a method called getNgos() in your service
    this.service.getAllNgo().subscribe(
      (ngos: Ngo[]) => {
        this.ngos = ngos;
      },
      (      error: any) => {
        console.error('Error fetching NGOs:', error);
      }
    );
  }
  // fetchUsers() {}
  fetchUsers() {
    // Call service method to fetch Users
    // Assuming you have a method called getUsers() in your service
    this.service.getAllUser().subscribe(
      (user: User[]) => {
        this.users = user;
      },
      (      error: any) => {
        console.error('Error fetching Users:', error);
      }
    );
  }

  onSubmit() {
    // Call the service method to add the donation
    this.donationService.addDonation(this.donation).subscribe(
      (      response: any) => {
        console.log('Donation added successfully:', response);
        // You may redirect the user or show a success message here
      },
      (      error: any) => {
        console.error('Error adding donation:', error);
        // Handle error, show error message, etc.
      }
    );
  }
}
