import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import {FoodVendor } from '../model/FoodVendor';
import {FoodService } from '../services/food.service';


@Component({
  selector: 'app-vendor',
  templateUrl: './vendor.component.html',
  styleUrls: ['./vendor.component.css']
})
export class VendorComponent implements OnInit {
  foodVendors:FoodVendor[];

  constructor(private foodService: FoodService, private router: Router) { }

  ngOnInit() {
    this.loadVendors();
  }

  // loadVendors(){
  //   this.foodVendors = this.foodService.getVendors();
  //   console.log("Food vendor list");
  //   console.log(this.foodVendors);
  // }

  loadVendors():any{
    this.foodService.getVendors().subscribe((res) => {
      console.log(res);
      this.foodVendors = res;
      console.log(res);

    });
    return null;
  }


}
