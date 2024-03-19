import { HttpHeaders } from "@angular/common/http";
import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { User } from "../../Entity/user";
import { Services } from "../../Services";

@Component({
  selector: "app-dashboard",
  templateUrl: "./dashboard.component.html",
  styleUrl: "./dashboard.component.css",
})
export class DashboardComponent implements OnInit {
  regUsers: User[] = [];
  vehicleType = localStorage.getItem('vehicleType');
  constructor(private service: Services, private router: Router) {}

  ngOnInit(): void {
    this.service.getRegisteredUsers().subscribe((response) => {
      this.regUsers = response;
      console.log(this.vehicleType);
      
      console.log(this.regUsers);
      
    });
  }

}
