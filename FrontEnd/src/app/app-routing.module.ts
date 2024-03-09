import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './ngo_project/home/home.component';
import { AdminComponent } from './ngo_project/admin/admin.component';
import { AboutComponent } from './ngo_project/about/about.component';
import { LoginComponent } from './ngo_project/login/login.component';
import { AdminPanelComponent } from './ngo_project/admin-panel/admin-panel.component';
import { NgolistComponent } from './ngo_project/ngolist/ngolist.component';
import { AddngoComponent } from './ngo_project/addngo/addngo.component';
import { DonateComponent } from './ngo_project/donate/donate.component';
import { SignupComponent } from './ngo_project/signup/signup.component';
import { AfterloginComponent } from './ngo_project/afterlogin/afterlogin.component';
import { AdminngolistComponent } from './ngo_project/adminngolist/adminngolist.component';
import { NgoexpenditureComponent } from './ngo_project/ngoexpenditure/ngoexpenditure.component';
import { AftersliderComponent } from './ngo_project/afterslider/afterslider.component';
import { DonationsComponent } from './ngo_project/donations/donations.component';
import { NgoeditComponent } from './ngo_project/ngoedit/ngoedit.component';

const routes: Routes = [
  { path:"" ,component:HomeComponent},
  { path:"home",component:HomeComponent},
  { path:"admin",component:AdminComponent},
  { path:"about",component:AboutComponent},
  { path:"login",component:LoginComponent},
  { path:"admin-panel",component:AdminPanelComponent},
  { path:"ngolist",component:NgolistComponent},
  { path:"addngo",component:AddngoComponent},
  { path:"donate",component:DonateComponent},
  { path:"signup",component:SignupComponent},
  { path:"adminngolist",component:AdminngolistComponent},
  { path:"afterlogin",component:AfterloginComponent},
  { path:"afterslide",component:AftersliderComponent},
  { path:"ngoexpenditure",component:NgoexpenditureComponent},
  { path:"donations",component:DonationsComponent},
  { path:"ngoedit/:ngo_id",component:NgoeditComponent}










];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

  
 }
