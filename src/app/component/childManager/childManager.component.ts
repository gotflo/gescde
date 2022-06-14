import { DashboardService } from "./../../services/dashboard.service";
import { Child } from "./../../dashboard/dashboard-components/child/child-data";
import { DatePipe } from "@angular/common";
import { Component, OnInit } from "@angular/core";
import { NgForm } from "@angular/forms";
import { NgToastService } from "ng-angular-popup";

import * as $ from "jquery";
declare function isEmpty(): void;

@Component({
  selector: "app-ngbd-alert",
  templateUrl: "childManager.component.html",
  styleUrls: ["./childManager.scss"],
})
export class ChildManagerComponent implements OnInit {
  child: Child = new Child();
  // this is for the Closeable Alert
  year: any;
  myDate = new Date(Date.now());
  selectedValueDays: any;
  selectedValueMonth: any;
  selectedValueYear: any;
  selectedValueYearEnter: any;
  selectedValueStatus: any;
  selectedValueGender: any;

  constructor(
    private datePipe: DatePipe,
    private dashboardService: DashboardService,
    private toast: NgToastService
  ) {
    // isEmpty();
    this.year = this.datePipe.transform(this.myDate, "YYYY");
  }

  ngOnInit(): void {}

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

  addChild(addchildform: NgForm) {
    console.log(addchildform.form);
    this.dashboardService.addChilds(addchildform.value).subscribe(
      (data: Child) => {
        // console.log("Enfant enregistrer avec succès");
        // alert("tâche enregistrer avec succès");
        addchildform.reset();
        this.showSuccess();
        isEmpty();
        this.ngOnInit();
        // this.router.navigate(["taskList"]);
      },
      (err) => {
        this.showWarn();
      }
    );
  }
}
