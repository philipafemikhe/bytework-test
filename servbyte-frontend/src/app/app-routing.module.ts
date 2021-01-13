import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { MealComponent } from './meal/meal.component';
import { TransporterComponent } from './transporter/transporter.component';
import { SignupComponent } from './signup/signup.component';
import { VendorComponent } from './vendor/vendor.component';
import { ProviderDashboardComponent } from './dashboard/provider-dashboard/provider-dashboard.component';
import { TransporterDashboardComponent } from './dashboard/transporter-dashboard/transporter-dashboard.component';


const routes: Routes = [
  {
    path:'', 
    redirectTo: 'home', 
    pathMatch:'full'
  },
  {
    path: 'login', 
    component: LoginComponent
  },
  {
    path: 'dashboard', 
    component: DashboardComponent
  },
  {
    path: 'provider/dashboard', 
    component: ProviderDashboardComponent
  },
  {
    path: 'transporter/dashboard', 
    component: TransporterDashboardComponent
  },
  {
    path: 'home', 
    component: HomeComponent
  },
  {
    path: 'vendor',
    component : VendorComponent
  },
  {
    path : 'meal',
    component: MealComponent
  },
  {
    path : 'transporter',
    component : TransporterComponent
  },
  {
    path : 'vendor/signup',
    component : SignupComponent
  },
  {
    path : 'signup',
    component : SignupComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
