import { HttpClient } from "@angular/common/http";
import { Component, NgModule, OnInit } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { Form } from "../../Entity/form";
import { Services } from "../../Services";
import { ToastrService, provideToastr } from "ngx-toastr";
import { provideAnimations } from "@angular/platform-browser/animations";
import { bootstrapApplication } from "@angular/platform-browser";
import { AppComponent } from "../../../app.component";
import { User } from "../../Entity/user";


@Component({
  selector: "app-forms",
  templateUrl: "./forms.component.html",
  styleUrl: "./forms.component.css",
})
export class FormsComponent implements OnInit {
  fullname!: string;
  phonenumber!: string;
  address!: string;
  dlnumber!: string;
  totalDays!: string;
  vehicleType!: string;
  form : Form =  new Form();
  user : User = new User();
  
  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private http:HttpClient,
    private services:Services,
    private toastr: ToastrService
  ) {}

  ngOnInit(): void {
      
  }

  
  onSubmit(regUser: User) {
    this.services.registerUser(regUser).subscribe((response) => { console.log(response); });
    console.log(regUser);
    console.log(this.vehicleType);
    localStorage.setItem('vehicleType',this.vehicleType);
    
    alert('Thank You, your request has been submitted to us!');
    
  }
}
