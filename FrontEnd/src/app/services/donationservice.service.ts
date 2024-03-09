import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DonationserviceService {
  baseUrl = 'http://localhost:8080/donations/donate';

  constructor(private http: HttpClient) {}

  createOrder(amount: number, userDetails: any): Observable<Object> {
    const data = {
      amount: amount,
      name: userDetails.name,
      email: userDetails.email,
      contact: userDetails.contact,
      info: 'order_request'
    };

    // Set the headers to specify the content type as JSON
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
    });

    // Corrected template literal syntax
    return this.http.post(`${this.baseUrl}`, data, { headers });
  }
}
