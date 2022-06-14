import { NgToastService } from "ng-angular-popup";
import { Router } from "@angular/router";
import { Activity } from "../../dashboard/dashboard-components/activity/activity";
import { DashboardService } from "../../services/dashboard.service";

import { HttpErrorResponse } from "@angular/common/http";
import { NgbNavChangeEvent } from "@ng-bootstrap/ng-bootstrap";
import { Component, OnInit, TrackByFunction } from "@angular/core";

@Component({
  selector: "app-buttons",
  templateUrl: "./allActivity.component.html",
  styleUrls: ["./allActivity.scss"],
})
export class AllActivityComponent implements OnInit {
  // ====================================================================
  placements = ["top", "left", "right", "bottom"];
  popoverTitle = "Voullez vous supprimer?";
  popoverMessage = "Êtes vous <b>sûr</b> de vouloir supprimer?";
  confirmText = 'Oui <i class="fas fa-check"></i>';
  cancelText = 'Non <i class="fas fa-times"></i>';
  confirmClicked = false;

  cancelClicked = false;
  trackByValue: TrackByFunction<string> = (index, value) => value;

  // -----------------------------------------------------
  ActivityJanv: Activity[] = [];
  ActivityFev: Activity[] = [];
  ActivityMars: Activity[] = [];
  ActivityAvril: Activity[] = [];
  ActivityMai: Activity[] = [];
  ActivityJuin: Activity[] = [];
  ActivityJuillet: Activity[] = [];
  ActivityAout: Activity[] = [];
  ActivitySept: Activity[] = [];
  ActivityOctb: Activity[] = [];
  ActivityNov: Activity[] = [];
  ActivityDec: Activity[] = [];
  activitys: Activity[] = [];
  searchText: string = "";

  constructor(
    private dashboardService: DashboardService,
    private router: Router,
    private toast: NgToastService
  ) {}

  ngOnInit(): void {
    // this.getChildActivityJav();
    // this.getChildActivityFev();
    // this.getChildActivityMars();
    // this.getChildActivityAvril();
    // this.getChildActivityMai();
    // this.getChildActivityJuin();
    // this.getChildActivityJuillet();
    // this.getChildActivityAout();
    // this.getChildActivitySept();
    // this.getChildActivityOctb();
    // this.getChildActivityNov();
    // this.getChildActivityDec();
    this.getActivity();
  }

  exportActivityPdf() {
    this.dashboardService.exportActivityPdf().subscribe((response) => {});
  }

  updateActivity(idActivity: any) {
    this.router.navigate(["/component/updateActivity", idActivity]);
  }

  removeActivity(idActivity: number) {
    this.dashboardService.deleteActivity(idActivity).subscribe(
      (data) => {
        this.ngOnInit();
        this.showSuccess();
      },
      (error) => {
        this.showError();
      }
    );
  }

  showSuccess() {
    this.toast.success({
      detail: "SUPPRESSION",
      summary: "Suppression éffectuer",
      duration: 6500,
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
      detail: "ANNULATION",
      summary: "Action Annuler",
      duration: 3000,
    });
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

  public getChildActivityJav(): void {
    this.dashboardService.getChildActivityJav().subscribe(
      (data: Activity[]) => {
        this.ActivityJanv = data;
        // console.log(this.activity);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
  public getChildActivityFev(): void {
    this.dashboardService.getChildActivityFev().subscribe(
      (data: Activity[]) => {
        this.ActivityFev = data;
        // console.log(this.activity);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
  public getChildActivityMars(): void {
    this.dashboardService.getChildActivityMars().subscribe(
      (data: Activity[]) => {
        this.ActivityMars = data;
        // console.log(this.activity);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
  public getChildActivityAvril(): void {
    this.dashboardService.getChildActivityAvril().subscribe(
      (data: Activity[]) => {
        this.ActivityAvril = data;
        // console.log(this.activity);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
  public getChildActivityMai(): void {
    this.dashboardService.getChildActivityMai().subscribe(
      (data: Activity[]) => {
        this.ActivityMai = data;
        // console.log(this.activity);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
  public getChildActivityJuin(): void {
    this.dashboardService.getChildActivityJuin().subscribe(
      (data: Activity[]) => {
        this.ActivityJuin = data;
        // console.log(this.activity);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
  public getChildActivityJuillet(): void {
    this.dashboardService.getChildActivityJuillet().subscribe(
      (data: Activity[]) => {
        this.ActivityJuillet = data;
        // console.log(this.activity);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
  public getChildActivityAout(): void {
    this.dashboardService.getChildActivityAout().subscribe(
      (data: Activity[]) => {
        this.ActivityAout = data;
        // console.log(this.activity);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
  public getChildActivitySept(): void {
    this.dashboardService.getChildActivitySept().subscribe(
      (data: Activity[]) => {
        this.ActivitySept = data;
        // console.log(this.activity);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
  public getChildActivityOctb(): void {
    this.dashboardService.getChildActivityOctb().subscribe(
      (data: Activity[]) => {
        this.ActivityOctb = data;
        // console.log(this.activity);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
  public getChildActivityNov(): void {
    this.dashboardService.getChildActivityNov().subscribe(
      (data: Activity[]) => {
        this.ActivityNov = data;
        // console.log(this.activity);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
  public getChildActivityDec(): void {
    this.dashboardService.getChildActivityDec().subscribe(
      (data: Activity[]) => {
        this.ActivityDec = data;
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
