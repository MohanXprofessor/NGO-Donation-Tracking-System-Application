import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AdminComponent } from './ngo_project/admin/admin.component';
import { HomeComponent } from './ngo_project/home/home.component';
import { NavbarComponent } from './ngo_project/navbar/navbar.component';
import { FooterComponent } from './ngo_project/footer/footer.component';
import { SliderComponent } from './ngo_project/slider/slider.component';
import { AboutComponent } from './ngo_project/about/about.component';
import { LoginComponent } from './ngo_project/login/login.component';
import { AdminPanelComponent } from './ngo_project/admin-panel/admin-panel.component';
import { AddngoComponent } from './ngo_project/addngo/addngo.component';
import { NgolistComponent } from './ngo_project/ngolist/ngolist.component';
import { NgoexpenditureComponent } from './ngo_project/ngoexpenditure/ngoexpenditure.component';
import { DonateComponent } from './ngo_project/donate/donate.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { SignupComponent } from './ngo_project/signup/signup.component';
import { AdminngolistComponent } from './ngo_project/adminngolist/adminngolist.component';
import { AfterloginComponent } from './ngo_project/afterlogin/afterlogin.component';
import { AftersliderComponent } from './ngo_project/afterslider/afterslider.component';
import { AfcardComponent } from './ngo_project/afcard/afcard.component';
import { DonationsComponent } from './ngo_project/donations/donations.component';
import { NgoeditComponent } from './ngo_project/ngoedit/ngoedit.component';

@NgModule({
  declarations: [
    AppComponent,
    AdminComponent,
    HomeComponent,
    NavbarComponent,
    FooterComponent,
    SliderComponent,
    AboutComponent,
    LoginComponent,
    AdminPanelComponent,
    AddngoComponent,
    NgolistComponent,
    NgoexpenditureComponent,
    DonateComponent,
    SignupComponent,
    AdminngolistComponent,
    AfterloginComponent,
    AftersliderComponent,
    AfcardComponent,
    DonationsComponent,
    NgoeditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
