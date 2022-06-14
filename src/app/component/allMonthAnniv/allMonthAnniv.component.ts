import { Router } from "@angular/router";
import { HttpErrorResponse } from "@angular/common/http";
import { NgbNavChangeEvent } from "@ng-bootstrap/ng-bootstrap";
import { DashboardService } from "../../services/dashboard.service";
import { Child } from "../../dashboard/dashboard-components/child/child-data";
import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-ngbd-pagination",
  templateUrl: "./allMonthAnniv.component.html",
})
export class AllMonthAnnivComponent implements OnInit {
  childAnnivJanv: Child[] = [];
  childAnnivFev: Child[] = [];
  childAnnivMars: Child[] = [];
  childAnnivAvril: Child[] = [];
  childAnnivMai: Child[] = [];
  childAnnivJuin: Child[] = [];
  childAnnivJuillet: Child[] = [];
  childAnnivAout: Child[] = [];
  childAnnivSept: Child[] = [];
  childAnnivOctb: Child[] = [];
  childAnnivNov: Child[] = [];
  childAnnivDec: Child[] = [];
  searchText: string = "";

  constructor(
    private dashboardService: DashboardService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.getChildAnnivJav();
    this.getChildAnnivFev();
    this.getChildAnnivMars();
    this.getChildAnnivAvril();
    this.getChildAnnivMai();
    this.getChildAnnivJuin();
    this.getChildAnnivJuillet();
    this.getChildAnnivAout();
    this.getChildAnnivSept();
    this.getChildAnnivOctb();
    this.getChildAnnivNov();
    this.getChildAnnivDec();
  }

  updateChild(numeroBeneficiaire: any) {
    this.router.navigate(["/component/childUpdate", numeroBeneficiaire]);
  }
  childProject(numeroBeneficiaire: any) {
    this.router.navigate([
      "/component/childProjectManager",
      numeroBeneficiaire,
    ]);
  }

  public getChildAnnivJav(): void {
    this.dashboardService.getChildAnnivJav().subscribe(
      (data: Child[]) => {
        this.childAnnivJanv = data;
        // console.log(this.activity);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
  public getChildAnnivFev(): void {
    this.dashboardService.getChildAnnivFev().subscribe(
      (data: Child[]) => {
        this.childAnnivFev = data;
        // console.log(this.activity);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
  public getChildAnnivMars(): void {
    this.dashboardService.getChildAnnivMars().subscribe(
      (data: Child[]) => {
        this.childAnnivMars = data;
        // console.log(this.activity);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
  public getChildAnnivAvril(): void {
    this.dashboardService.getChildAnnivAvril().subscribe(
      (data: Child[]) => {
        this.childAnnivAvril = data;
        // console.log(this.activity);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
  public getChildAnnivMai(): void {
    this.dashboardService.getChildAnnivMai().subscribe(
      (data: Child[]) => {
        this.childAnnivMai = data;
        // console.log(this.activity);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
  public getChildAnnivJuin(): void {
    this.dashboardService.getChildAnnivJuin().subscribe(
      (data: Child[]) => {
        this.childAnnivJuin = data;
        // console.log(this.activity);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
  public getChildAnnivJuillet(): void {
    this.dashboardService.getChildAnnivJuillet().subscribe(
      (data: Child[]) => {
        this.childAnnivJuillet = data;
        // console.log(this.activity);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
  public getChildAnnivAout(): void {
    this.dashboardService.getChildAnnivAout().subscribe(
      (data: Child[]) => {
        this.childAnnivAout = data;
        // console.log(this.activity);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
  public getChildAnnivSept(): void {
    this.dashboardService.getChildAnnivSept().subscribe(
      (data: Child[]) => {
        this.childAnnivSept = data;
        // console.log(this.activity);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
  public getChildAnnivOctb(): void {
    this.dashboardService.getChildAnnivOctb().subscribe(
      (data: Child[]) => {
        this.childAnnivOctb = data;
        // console.log(this.activity);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
  public getChildAnnivNov(): void {
    this.dashboardService.getChildAnnivNov().subscribe(
      (data: Child[]) => {
        this.childAnnivNov = data;
        // console.log(this.activity);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
  public getChildAnnivDec(): void {
    this.dashboardService.getChildAnnivDec().subscribe(
      (data: Child[]) => {
        this.childAnnivDec = data;
        // console.log(this.activity);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  // ===================================================
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
  // ===================================================
}
