import { Router } from "@angular/router";
import { NgbNavChangeEvent } from "@ng-bootstrap/ng-bootstrap";
import { HttpErrorResponse } from "@angular/common/http";
import { DashboardService } from "./../../services/dashboard.service";
import { Child } from "./../../dashboard/dashboard-components/child/child-data";
import { Component, OnInit, TrackByFunction } from "@angular/core";

@Component({
  selector: "app-listChilds",
  templateUrl: "./listChilds.component.html",
  styleUrls: ["./listChilds.scss"],
})
export class ListChildsComponent implements OnInit {
  // ===================================================

  placements = ["top", "left", "right", "bottom"];
  popoverTitle = "Voullez vous supprimer?";
  popoverMessage = "Êtes vous <b>sûr</b> de vouloir supprimer?";
  confirmText = 'Oui <i class="fas fa-check"></i>';
  cancelText = 'Non <i class="fas fa-times"></i>';
  confirmClicked = false;

  cancelClicked = false;
  trackByValue: TrackByFunction<string> = (index, value) => value;

  // -----------------------------------------------
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
  childs: Child[] = [];
  childByname: Child[] = [];
  childGenderM: Child[] = [];
  childGenderF: Child[] = [];
  childSponsor: Child[] = [];
  childNoSponsor: Child[] = [];
  searchText: any;

  constructor(
    private dashboardService: DashboardService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.getAllChildByNumBenef();
    this.getAllChildByName();
    this.getAllChildGenderM();
    this.getAllChildGenderF();
    this.getAllChildSponsor();
    this.getAllChildNoSponsor();
  }

  public getAllChildByNumBenef(): void {
    this.dashboardService.getAllChildByNumBeneef().subscribe(
      (data: Child[]) => {
        this.childs = data;
        // console.log(this.activity);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public getAllChildByName(): void {
    this.dashboardService.getAllChildByName().subscribe(
      (data: Child[]) => {
        this.childByname = data;
        // console.log(this.activity);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public getAllChildGenderM(): void {
    this.dashboardService.getAllChildGenderM().subscribe(
      (data: Child[]) => {
        this.childGenderM = data;
        // console.log(this.activity);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public getAllChildGenderF(): void {
    this.dashboardService.getAllChildGenderF().subscribe(
      (data: Child[]) => {
        this.childGenderF = data;
        // console.log(this.activity);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public getAllChildSponsor(): void {
    this.dashboardService.getAllChildSponsor().subscribe(
      (data: Child[]) => {
        this.childSponsor = data;
        // console.log(this.activity);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public getAllChildNoSponsor(): void {
    this.dashboardService.getAllChildNoSponsor().subscribe(
      (data: Child[]) => {
        this.childNoSponsor = data;
        // console.log(this.activity);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  updateChild(numeroBeneficiaire: any) {
    this.router.navigate(["/component/childUpdate", numeroBeneficiaire]);
  }

  infoChild(numeroBeneficiaire: any) {
    this.router.navigate(["/component/infoChild", numeroBeneficiaire]);
  }

  childProject(numeroBeneficiaire: any) {
    this.router.navigate([
      "/component/childProjectManager",
      numeroBeneficiaire,
    ]);
  }

  removeChild(dashboardService: any) {
    this.dashboardService.deleteChild(dashboardService).subscribe(
      (data) => {
        this.ngOnInit();
      },
      (error) => alert("Enfant non supprimer")
    );
  }

  childLog(numeroBeneficiaire: any) {
    this.router.navigate(["/component/childLogManager", numeroBeneficiaire]);
  }

  // -------Export Pdf-------

  exportChildByNumPdf() {
    this.dashboardService.exportChildByNumPdf().subscribe((response) => {});
  }

  exportChildByLastNamePdf() {
    this.dashboardService
      .exportChildByLastNamePdf()
      .subscribe((response) => {});
  }

  exportChildByGenderMPdf() {
    this.dashboardService.exportChildByGenderMPdf().subscribe((response) => {});
  }

  exportChildByGenderFPdf() {
    this.dashboardService.exportChildByGenderFPdf().subscribe((response) => {});
  }

  exportChildBySponsorPdf() {
    this.dashboardService.exportChildBySponsorPdf().subscribe((response) => {});
  }

  exportChildByNoSponsorPdf() {
    this.dashboardService
      .exportChildByNoSponsorPdf()
      .subscribe((response) => {});
  }

  // ---------------------------

  updateTask() {}
  deleteTask() {}
}
