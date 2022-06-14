import { NgForm } from "@angular/forms";
import { DashboardService } from "./../../services/dashboard.service";
import { NgToastService } from "ng-angular-popup";
import { ActivatedRoute } from "@angular/router";
import { Router } from "@angular/router";
import { Activity } from "./../../dashboard/dashboard-components/activity/activity";
import { DatePipe } from "@angular/common";
import { Component, OnInit } from "@angular/core";

import * as $ from "jquery";
declare function myFun(): void;
declare function isEmpty(): void;

@Component({
  selector: "app-activityManager",
  templateUrl: "./activityManager.component.html",
  styleUrls: ["./activityManager.component.scss"],
})
export class ActivityManagerComponent implements OnInit {
  activity: Activity = new Activity();

  year: any;
  myDate = new Date(Date.now());

  constructor(
    private datePipe: DatePipe,
    private router: Router,
    private route: ActivatedRoute,
    private toast: NgToastService,
    private dashboardService: DashboardService
  ) {
    this.year = this.datePipe.transform(this.myDate, "YYYY");
  }

  ngOnInit(): void {}

  addActivity(addactivityform: NgForm) {
    this.dashboardService.addActivity(addactivityform.value).subscribe(
      (data: Activity) => {
        addactivityform.reset();
        this.showSuccess();
        this.ngOnInit();
        // this.router.navigate(["taskList"]);
      },
      (err) => {
        this.showWarn();
      }
    );
  }

  showSuccess() {
    this.toast.success({
      detail: "ENREGISTREMENT",
      summary: "Enrégistrement éffectuer",
      duration: 5000,
    });
  }

  showError() {
    this.toast.error({
      detail: "ERROR",
      summary: "Your Error Message",
      sticky: true,
    });
  }

  showWarn() {
    this.toast.warning({
      detail: "Enrégistrement non éffectuer",
      summary: "Veillez renseignez correctement les champ",
      duration: 7000,
    });
  }
}
