import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DonationService {

  baseUrl='http://localhost:8080/donations';

  constructor(private http:HttpClient) 
  { }

  addDonation(donation:Object):Observable<Object>{
    return this.http.post(`${this.baseUrl}`, donation);
  }
}
