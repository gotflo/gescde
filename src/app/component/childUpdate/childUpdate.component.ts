import { ActivatedRoute } from "@angular/router";
import { Router } from "@angular/router";
import { NgForm } from "@angular/forms";
import { Child } from "./../../dashboard/dashboard-components/child/child-data";
import { DashboardService } from "./../../services/dashboard.service";
import { DatePipe } from "@angular/common";
import { Component, OnInit } from "@angular/core";
import { NgToastService } from "ng-angular-popup";

import * as $ from "jquery";
declare function isEmpty(): void;

@Component({
  selector: "app-childUpdate",
  templateUrl: "./childUpdate.component.html",
  styleUrls: ["./childUpdate.component.scss"],
})
export class ChildUpdateComponent implements OnInit {
  child!: Child;
  numeroBeneficiaire!: any;
  submitted = false;

  year: any;
  myDate = new Date(Date.now());

  selectedValueStatus: any;
  selectedValueGender: any;

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

  updateChild() {
    this.dashboardService
      .updateChilds(this.numeroBeneficiaire, this.child)
      .subscribe(
        (data) => {
          this.router.navigate(["/component/listChilds"]);
          this.showSuccess();
        },
        (err) => {
          this.router.navigate(["/component/listChilds"]);
          this.showWarn();
        }
      );
    this.child = new Child();
  }

  onSubmit() {
    this.submitted = true;
    this.updateChild();
  }
}
