import { Child } from "./../../dashboard/dashboard-components/child/child-data";
import { ActivatedRoute } from "@angular/router";
import { DashboardService } from "./../../services/dashboard.service";
import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";

@Component({
  selector: "app-infoChild",
  templateUrl: "./infoChild.component.html",
  styleUrls: ["./infoChild.component.scss"],
})
export class InfoChildComponent implements OnInit {
  child!: Child;
  numeroBeneficiaire!: any;
  constructor(
    private dashboardService: DashboardService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.child = new Child();
    this.numeroBeneficiaire = this.route.snapshot.params["numeroBeneficiaire"];

    this.dashboardService
      .getChildByNumeroBeneficiaire(this.numeroBeneficiaire)
      .subscribe(
        (data) => {
          this.child = data;
        },
        (error) => alert("error")
      );
  }
}
