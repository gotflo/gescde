import { Router } from "@angular/router";
import { NgToastService } from "ng-angular-popup";
import { HttpErrorResponse } from "@angular/common/http";
import { Child } from "./../../dashboard/dashboard-components/child/child-data";
import { NgbNavChangeEvent } from "@ng-bootstrap/ng-bootstrap";
import { ChildLog } from "./childLog-data";
import { DashboardService } from "./../../services/dashboard.service";
import { Component, OnInit, TrackByFunction } from "@angular/core";
@Component({
  templateUrl: "./childLog.component.html",
  styleUrls: ["./childLog.scss"],
})
export class ChildLogComponent implements OnInit {
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

  // ===================================================
  childLogs: ChildLog[] = [];

  childLogByNum: ChildLog[] = [];
  childLogByname: ChildLog[] = [];
  childLogGenderM: ChildLog[] = [];
  childLogGenderF: ChildLog[] = [];
  childLogSponsor: ChildLog[] = [];
  childLogNoSponsor: ChildLog[] = [];
  searchText: string = "";

  constructor(
    private dashboardService: DashboardService,
    private toast: NgToastService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.getAllChildLogByNumBeneef();
    this.getAllChildLogByName();
    this.getAllChildLogGenderM();
    this.getAllChildLogGenderF();
    this.getAllChildLogSponsor();
    this.getAllChildLogNoSponsor();
  }

  public getAllChildLogByNumBeneef(): void {
    this.dashboardService.getAllChildLogByNumBeneef().subscribe(
      (data: ChildLog[]) => {
        this.childLogByNum = data;
        // console.log(this.activity);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public getAllChildLogByName(): void {
    this.dashboardService.getAllChildLogByName().subscribe(
      (data: ChildLog[]) => {
        this.childLogByname = data;
        // console.log(this.activity);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public getAllChildLogGenderM(): void {
    this.dashboardService.getAllChildLogGenderM().subscribe(
      (data: ChildLog[]) => {
        this.childLogGenderM = data;
        // console.log(this.activity);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public getAllChildLogGenderF(): void {
    this.dashboardService.getAllChildLogGenderF().subscribe(
      (data: ChildLog[]) => {
        this.childLogGenderF = data;
        // console.log(this.activity);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public getAllChildLogSponsor(): void {
    this.dashboardService.getAllChildLogSponsor().subscribe(
      (data: ChildLog[]) => {
        this.childLogSponsor = data;
        // console.log(this.activity);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public getAllChildLogNoSponsor(): void {
    this.dashboardService.getAllChildLogNoSponsor().subscribe(
      (data: ChildLog[]) => {
        this.childLogNoSponsor = data;
        // console.log(this.activity);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  childLogInfo(numeroBeneficiaireLog: any) {
    this.router.navigate(["/component/infoChildLog", numeroBeneficiaireLog]);
  }

  removeChildLog(numeroBeneficiaireLog: any) {
    this.dashboardService.deleteChildLog(numeroBeneficiaireLog).subscribe(
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

  // -------Export Pdf-------

  exportChildLogByNumPdf() {
    this.dashboardService.exportChildLogByNumPdf().subscribe((response) => {});
  }

  exportChildLogByLastNamePdf() {
    this.dashboardService
      .exportChildLogByLastNamePdf()
      .subscribe((response) => {});
  }

  exportChildLogByGenderMPdf() {
    this.dashboardService
      .exportChildLogByGenderMPdf()
      .subscribe((response) => {});
  }

  exportChildLogByGenderFPdf() {
    this.dashboardService
      .exportChildLogByGenderFPdf()
      .subscribe((response) => {});
  }

  exportChildLogBySponsorPdf() {
    this.dashboardService
      .exportChildLogBySponsorPdf()
      .subscribe((response) => {});
  }

  exportChildLogByNoSponsorPdf() {
    this.dashboardService
      .exportChildLogByNoSponsorPdf()
      .subscribe((response) => {});
  }

  // ---------------------------

  updateTask() {}
  deleteTask() {}
}
