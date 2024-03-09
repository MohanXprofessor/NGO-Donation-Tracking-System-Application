import { Component } from '@angular/core';
import { DonationserviceService } from '../../services/donationservice.service';


declare var Razorpay:any;
@Component({
  selector: 'app-donations',
  templateUrl: './donations.component.html',
  styleUrl: './donations.component.css'
})
export class DonationsComponent {


  amount: any;
  userDetails: any = {};

  constructor(private service: DonationserviceService) {}

  paymentStart() {
    console.log(this.amount);
    if (this.amount == 0 || this.amount == null) {
      alert("Please enter a valid amount");
      return null;
    } else {
      return this.service.createOrder(this.amount, this.userDetails).subscribe(
        (response: any) => {
          console.log(response);

          if (response.status === 'created') {

            let options = {
              key: 'rzp_test_M1sggR7jCFARkD',
              amount: this.amount,
              currency: 'INR',
              name: 'Project testPayment',
              description: 'Donation',
              image: 'https://upload.wikimedia.org/wikipedia/commons/thumb/3/3a/Cat03.jpg/1200px-Cat03.jpg',
              order_id: response.id,
              handler: (response: any) => {
                console.log(response.razorpay_payment_id);
                console.log(response.razorpay_order_id);
                console.log(response.razorpay_signature);
                console.log('payment successful!'); 
              },
              prefill: {
                name: this.userDetails.name,
                email: this.userDetails.email,
                contact: this.userDetails.contact,
              },
              theme: {
                color: '#3399cc',
              }
            };

            let rzp1 = new Razorpay(options);
            rzp1.open();
          } else {
            alert('Unexpected response status');
          }
        },
        (error) => {
          alert('Error creating Razorpay order: ' + error.message);
          console.error('Error creating Razorpay order:', error);
        }
      );
    }
  }

}
