import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { VendorComponent } from './vendor/vendor.component';
import { MealComponent } from './meal/meal.component';
import { TransporterComponent } from './transporter/transporter.component';
import { FoodService } from './services/food.service';
import { HttpClientModule } from '@angular/common/http';
import { SignupComponent } from './signup/signup.component';
import { LoginComponent } from './login/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ProviderDashboardComponent } from './dashboard/provider-dashboard/provider-dashboard.component';
import { TransporterDashboardComponent } from './dashboard/transporter-dashboard/transporter-dashboard.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    VendorComponent,
    MealComponent,
    TransporterComponent,
    SignupComponent,
    LoginComponent,
    DashboardComponent,
    ProviderDashboardComponent,
    TransporterDashboardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [FoodService],
  bootstrap: [AppComponent]
})
export class AppModule { }
