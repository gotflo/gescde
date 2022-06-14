import { Router } from "@angular/router";
import { HttpErrorResponse } from "@angular/common/http";
import { Child } from "../../dashboard/dashboard-components/child/child-data";
import { DashboardService } from "../../services/dashboard.service";
import { Component, OnInit } from "@angular/core";
import { NgbNavChangeEvent } from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: "app-ngbd-nav",
  templateUrl: "./childProjcts.component.html",
  styleUrls: ["./childProjcts.component.scss"],
})
export class ChildProjctsComponent implements OnInit {
  childs: Child[] = [];
  searchText: string = "";
  constructor(
    private dashboardService: DashboardService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.getAllChildByName();
  }

  public getAllChildByName(): void {
    this.dashboardService.getAllChildByName().subscribe(
      (data: Child[]) => {
        this.childs = data;
        // console.log(this.activity);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  childProject(numeroBeneficiaire: any) {
    this.router.navigate([
      "/component/childProjectManager",
      numeroBeneficiaire,
    ]);
  }

  exportChildProjectByLastNamePdf() {
    this.dashboardService
      .exportChildProjectByLastNamePdf()
      .subscribe((response) => {});
  }

  currentJustify = "start";

  active = 1;
  activev = "top";

  activeKeep = 1;

  activeSelected = 1;
  disabled = true;

  tabs = [1, 2, 3, 4, 5];
  counter = this.tabs.length + 1;
  activeDynamic = 1;

  onNavChange(changeEvent: NgbNavChangeEvent) {
    if (changeEvent.nextId === 3) {
      changeEvent.preventDefault();
    }
  }

  toggleDisabled() {
    this.disabled = !this.disabled;
    if (this.disabled) {
      this.activeSelected = 1;
    }
  }

  close(event: MouseEvent, toRemove: number) {
    this.tabs = this.tabs.filter((id) => id !== toRemove);
    event.preventDefault();
    event.stopImmediatePropagation();
  }

  add(event: MouseEvent) {
    this.tabs.push(this.counter++);
    event.preventDefault();
  }
}
