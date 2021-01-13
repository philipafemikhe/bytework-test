import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { FoodVendor } from '../model/FoodVendor';


@Injectable({
  providedIn: 'root'
})
export class FoodService {

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

  getVendors(): Observable<FoodVendor[]> {
    return this.http.get<FoodVendor[]>(`${this.baseUrl}/vendor/all`);
  }

  createVendor(foodVendor: FoodVendor) : Observable<any> {
    console.log(foodVendor);
    return this.http.post<FoodVendor>(`${this.baseUrl}vendor/create`, foodVendor);
    // return null;
  }
}
