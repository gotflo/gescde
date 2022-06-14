import { NgToastService } from "ng-angular-popup";
import { ActivatedRoute } from "@angular/router";
import { Router } from "@angular/router";
import { DashboardService } from "./../../services/dashboard.service";
import { Child } from "./../../dashboard/dashboard-components/child/child-data";
import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-dropdown-basic",
  templateUrl: "./childProjectManager.component.html",
  styleUrls: ["./childProjectManager.scss"],
})
export class ChildProjectManagerComponent implements OnInit {
  child!: Child;
  numeroBeneficiaire!: any;
  submitted = false;

  constructor(
    private dashboardService: DashboardService,
    private router: Router,
    private route: ActivatedRoute,
    private toast: NgToastService
  ) {}

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

  showSuccess() {
    this.toast.success({
      detail: "VALIDER ",
      summary: "Projet ajouté avec succè",
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
          this.router.navigate(["/component/childProjcts"]);
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
