import { HttpErrorResponse } from "@angular/common/http";
import { DashboardService } from "./../../../services/dashboard.service";
import { Component, OnInit } from "@angular/core";
import { Child } from "./child-data";

@Component({
  selector: "app-child",
  templateUrl: "./child.component.html",
  styleUrls: ["./child.scss"],
})
export class ChildComponent implements OnInit {
  childs: Child[] = [];

  constructor(private dashboardService: DashboardService) {}

  ngOnInit(): void {
    this.getChildAnniv();
  }

  public getChildAnniv(): void {
    this.dashboardService.getAllChildAnniv().subscribe(
      (data: Child[]) => {
        this.childs = data;
        // console.log(this.activity);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
}
