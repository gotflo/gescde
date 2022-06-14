import { DashboardService } from "./../../../services/dashboard.service";
import { Component, OnInit } from "@angular/core";
import { Activity } from "./activity";
import { HttpErrorResponse } from "@angular/common/http";

@Component({
  selector: "app-activity",
  templateUrl: "./activity.component.html",
  styleUrls: ["./activity.scss"],
})
export class ActivityComponent implements OnInit {
  activitys: Activity[] = [];
  constructor(private dashboardService: DashboardService) {}

  ngOnInit(): void {
    this.getActivity();
  }

  public getActivity(): void {
    this.dashboardService.getAllActivity().subscribe(
      (data: Activity[]) => {
        this.activitys = data;
        // console.log(this.activity);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public getActivityOfMonth(): void {
    this.dashboardService.getAllActivityOfMonth().subscribe(
      (data: Activity[]) => {
        this.activitys = data;
        // console.log(this.activity);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
}
