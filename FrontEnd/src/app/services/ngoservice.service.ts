import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Ngo } from '../models/Ngo';
import { User } from '../models/User';

@Injectable({
  providedIn: 'root'
})
export class NgoserviceService {
 

  baseUrl='http://localhost:8080';

  constructor(private http: HttpClient) { 

  }
//user
createUser(users:Object):Observable<Object>{
  return this.http.post(`${this.baseUrl}/users`, users);
}
getAllUser():any{
  return this.http.get(`${this.baseUrl}/users/getAll`);
}
deleteUser(id:number): Observable<any>
{
  return this.http.delete(`${this.baseUrl}/users/${id}`, { responseType: 'text'});
}

getOneUser(id:number): Observable<any>
{
  return this.http.get( `${this.baseUrl}/users/getUser/${id}` );
}

updateUser(user:User): Observable<any>
{
  return this.http.put( `${this.baseUrl}/users/${user.user_id}`, user );
}

///ngo
createNgo(ngo:Object):Observable<Object>{
  return this.http.post(`${this.baseUrl}/ngos`, ngo);
}
getAllNgo():any{
  return this.http.get(`${this.baseUrl}/ngos/getAllNgos`);
}

deleteNgo(id:number): Observable<any>
{
  return this.http.delete(`${this.baseUrl}/ngos/${id}`, { responseType: 'text'});
}

getOneNgo(id:number): Observable<any>
{
  return this.http.get(`${this.baseUrl}/ngos/getNgo/${id}` );
}



updateNgo(ngo: Ngo): Observable<Ngo> {
  return this.http.put<Ngo>(`${this.baseUrl}/ngos/${ngo.ngo_id}`, ngo);
}

//expenditure
addExpenditure(expenditure: Object): Observable<any> {
  return this.http.post(`${this.baseUrl}/expenditures`, expenditure);
}

}
  
