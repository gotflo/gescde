import { DashboardService } from "./../../services/dashboard.service";
import { NgToastService } from "ng-angular-popup";
import { ActivatedRoute } from "@angular/router";
import { Router } from "@angular/router";
import { Activity } from "./../../dashboard/dashboard-components/activity/activity";
import { DatePipe } from "@angular/common";
import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-updateActivity",
  templateUrl: "./updateActivity.component.html",
  styleUrls: ["./updateActivity.component.scss"],
})
export class UpdateActivityComponent implements OnInit {
  activity!: Activity;
  idActivity!: any;
  submitted = false;
  year: any;
  myDate = new Date(Date.now());

  constructor(
    private datePipe: DatePipe,
    private router: Router,
    private route: ActivatedRoute,
    private toast: NgToastService,
    private dashboardService: DashboardService
  ) {
    // isEmpty();
    this.year = this.datePipe.transform(this.myDate, "YYYY");
  }

  ngOnInit(): void {
    this.activity = new Activity();
    this.idActivity = this.route.snapshot.params["idActivity"];

    this.dashboardService.getAllActivityById(this.idActivity).subscribe(
      (data) => {
        this.activity = data;
      },
      (error) => alert("error")
    );
  }

  updateActivity() {
    this.dashboardService
      .updateActivity(this.idActivity, this.activity)
      .subscribe(
        (data) => {
          this.router.navigate(["/component/allActivity"]);
          this.showSuccess();
        },
        (err) => {
          this.router.navigate(["/component/allActivity"]);
          this.showWarn();
        }
      );
    this.activity = new Activity();
  }

  showSuccess() {
    this.toast.success({
      detail: "MODIFICATION",
      summary: "Modification éffectuer",
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
      detail: "Modification non éffectuer",
      summary: "Veillez renseignez correctement les champ",
      duration: 7000,
    });
  }

  onSubmit() {
    this.submitted = true;
    this.updateActivity();
  }
}
