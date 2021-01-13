import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/model/User';
import { FoodService } from 'src/app/services/food.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  @Input() user: User = new User();
  submitted = false;
  accType:string;

  cities = ["Abuja", "Lagos", "Ibadan", "Uyo", "Port Harcourt", "Enugu",
    "Asaba", "Kano", "Umuahia", "Onitsha", "Aba", "Owerri"
    ];

    accountType = [
      "Service Provider", "Customer", "Transporter"
    ];
  constructor(private foodService: FoodService,
    private router: Router) { 
      this.submitted = false;
    }

  ngOnInit() {
  }

  save() {
    this.accType = this.user.accountType;
    this.submitted = true;
    this.foodService
    .createVendor(this.user).subscribe(data => {
      console.log(data)
      this.user = new User();
      if(this.accType == "Service Provider"){
        this.router.navigate(['/provider/dashboard']);
      }else if(this.accType == "Transporter"){
        this.router.navigate(['/transporter/dashboard']);
      }else{
        this.router.navigate(['/dashboard']);
      }
      this.gotoList();
    }, 
    error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }
  gotoList() {
    this.router.navigate(['/dashboard']);
  }
}
