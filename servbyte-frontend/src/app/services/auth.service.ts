import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LoginDetails } from '../model/LoginDetails';
import { Observable } from 'rxjs';
import { User } from '../model/User';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  headers: HttpHeaders = new HttpHeaders();
  options: any;

  private baseUrl = 'http://localhost:8070/api/';

  constructor(private http: HttpClient) { 
    this.headers.append('enctype', 'multipart/form-date');
    this.headers.append('Content-Type', 'application/json');
    this.headers.append('X-Requested-With', 'XMLHttpRequest');

     this.options = {
      'headers' : this.headers
    };
  }

  createAccount(user: User) : Observable<any> {
    console.log(user);
    return this.http.post<User>(`${this.baseUrl}/signup`, user);
    // return null;
  }

  login(loginDetails : LoginDetails) : Observable<any> {    
    return this.http.post<LoginDetails>(`${this.baseUrl}login`, loginDetails);
  }
}
