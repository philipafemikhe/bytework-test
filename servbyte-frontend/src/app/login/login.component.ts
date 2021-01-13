import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginDetails } from '../model/LoginDetails';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  @Input() loginDetails : LoginDetails = new LoginDetails();


  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit() {
  }

  onSubmit(){
    console.log(this.loginDetails.username);
    this.authService.login(this.loginDetails).subscribe(res=>{
      if(res.status == true){
        this.router.navigate(['/dashboard']);
      }
    })
  }


}
