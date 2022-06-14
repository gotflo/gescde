import { NgToastService } from "ng-angular-popup";
import { ActivatedRoute } from "@angular/router";
import { Router } from "@angular/router";
import { DashboardService } from "./../../services/dashboard.service";
import { ChildLog } from "./../childLog/childLog-data";
import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-InfoChild",
  templateUrl: "./infoChildLog.component.html",
  styleUrls: ["./infoChildLog.component.scss"],
})
export class InfoChildLogComponent implements OnInit {
  childLog!: ChildLog;
  numeroBeneficiaireLog!: any;

  constructor(
    private dashboardService: DashboardService,
    private router: Router,
    private route: ActivatedRoute,
    private toast: NgToastService
  ) {}

  ngOnInit(): void {
    this.childLog = new ChildLog();
    this.numeroBeneficiaireLog =
      this.route.snapshot.params["numeroBeneficiaireLog"];

    this.dashboardService
      .getChildByNumeroBeneficiaireLog(this.numeroBeneficiaireLog)
      .subscribe(
        (data) => {
          this.childLog = data;
        },
        (error) => alert("error")
      );
  }
}
