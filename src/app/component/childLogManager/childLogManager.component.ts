import { NgToastService } from "ng-angular-popup";
import { NgForm } from "@angular/forms";
import { Child } from "./../../dashboard/dashboard-components/child/child-data";
import { ActivatedRoute } from "@angular/router";
import { Router } from "@angular/router";
import { DashboardService } from "./../../services/dashboard.service";
import { ChildLog } from "./../childLog/childLog-data";
import { DatePipe } from "@angular/common";
import { Component, OnInit } from "@angular/core";

import * as $ from "jquery";
declare function myFun(): void;
declare function isEmpty(): void;

@Component({
  selector: "app-table",
  templateUrl: "childLogManager.component.html",
  styleUrls: ["./childLogManager.scss"],
})
export class ChildLogManagerComponent implements OnInit {
  child!: Child;
  numeroBeneficiaire!: any;

  childLog: ChildLog = new ChildLog();

  year: any;
  myDate = new Date(Date.now());

  // -------------------------------

  selectedValueDays: any;
  selectedValueMonth: any;
  selectedValueYear: any;
  selectedValueYearEnter: any;
  selectedValueStatus: any;
  selectedValueGender: any;

  // --------------------------------------
  constructor(
    private datePipe: DatePipe,
    private dashboardService: DashboardService,
    private router: Router,
    private route: ActivatedRoute,
    private toast: NgToastService
  ) {
    // isEmpty();
    this.year = this.datePipe.transform(this.myDate, "YYYY");
  }

  ngOnInit(): void {
    this.child = new Child();
    this.numeroBeneficiaire = this.route.snapshot.params["numeroBeneficiaire"];

    this.dashboardService
      .getChildByNumeroBeneficiaire(this.numeroBeneficiaire)
      .subscribe(
        (data) => {
          this.child = data;
        },
        (error) => alert("error")
      );
  }

  addChildLog(addchildLogform: NgForm) {
    console.log(addchildLogform.value);
    this.dashboardService.addChildsLog(addchildLogform.value).subscribe(
      (data: ChildLog) => {
        // console.log("Enfant enregistrer avec succès");
        // alert("tâche enregistrer avec succès");
        addchildLogform.reset();
        this.showSuccess();
        this.removeChild(this.child.numeroBeneficiaire);
        this.ngOnInit();
        this.router.navigate(["component/childLog"]);
      },
      (err) => {
        this.showError();
      }
    );
  }

  removeChild(dashboardService: any) {
    this.dashboardService.deleteChild(dashboardService).subscribe(
      (data) => {
        this.showWarn();
        this.ngOnInit();
      },
      (error) => alert("Enfant non supprimer")
    );
  }

  showSuccess() {
    this.toast.success({
      detail: "ENREGISTREMENT",
      summary: "Enrégistrement éffectuer dans journal",
      duration: 5000,
    });
  }

  showError() {
    this.toast.error({
      detail: "ERROR",
      summary: "Compléter les champ restant",
      sticky: true,
    });
  }

  showWarn() {
    this.toast.warning({
      detail: "SUPPRESSION",
      summary: "Suppression Valider",
      duration: 5000,
    });
  }

  // -----------------------------------------------

  ChangeDepartmentDays(e: any) {
    console.log(e.target.value);
    this.selectedValueDays = e.target.value;
  }

  ChangeDepartmentMonth(e: any) {
    console.log(e.target.value);
    this.selectedValueMonth = e.target.value;
  }
  ChangeDepartmentYear(e: any) {
    console.log(e.target.value);
    this.selectedValueYear = e.target.value;
  }
  ChangeDepartmentYearEnter(e: any) {
    console.log(e.target.value);
    this.selectedValueYearEnter = e.target.value;
  }
  ChangeDepartmentStatus(e: any) {
    console.log(e.target.value);
    this.selectedValueStatus = e.target.value;
  }
  ChangeDepartmentGender(e: any) {
    console.log(e.target.value);
    this.selectedValueGender = e.target.value;
  }

  // -------------------------------------------------
}
