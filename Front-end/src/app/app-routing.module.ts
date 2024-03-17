import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import path from 'path';
import { FirstpageComponent } from './Component/loginComponent/firstpage/firstpage.component';
import { AdminloginComponent } from './Component/loginComponent/adminlogin/adminlogin.component';
import { HomeComponent } from './Component/userComponet/home/home.component';
import { UserloginComponent } from './Component/loginComponent/userlogin/userlogin.component';
import { UserSignUpComponent } from './Component/loginComponent/user-sign-up/user-sign-up.component';
import { DashboardComponent } from './Component/adminComponent/dashboard/dashboard.component';

const routes: Routes = [
{
  path:'',
  component:FirstpageComponent,
  pathMatch:'full'

},
{
  path:'adminlogin',
  component:AdminloginComponent,
  pathMatch:'full'
},
{
  path:'userlogin',
  component:UserloginComponent,
  pathMatch:'full'
},
{
  path:'home',
  component:HomeComponent,
  pathMatch:'full'
},
{
  path:'user-sign-up',
  component:UserSignUpComponent,
  pathMatch:'full'
},
{
  path:'dashboard',
  component:DashboardComponent,
  pathMatch:'full'
}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
