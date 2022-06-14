import { DashboardService } from "./../../../services/dashboard.service";
import { Component, OnInit } from "@angular/core";
import { topcard, topcards } from "./top-cards-data";
import { DatePipe } from "@angular/common";

@Component({
  selector: "app-top-cards",
  templateUrl: "./top-cards.component.html",
  styleUrls: ["./top-cards.scss"],
})
export class TopCardsComponent implements OnInit {
  allChild: any;
  allChildMSize: any;
  allChildFSize: any;
  allChildSponsorSize: any;
  allChildNoSponsorSize: any;
  allChildAnivSize: any;
  allActivitySize: any;
  allChildLogSize: any;
  date: any;
  myDate = new Date(Date.now());
  topcards: topcard[];

  constructor(
    private dashboardService: DashboardService,
    private datePipe: DatePipe
  ) {
    this.topcards = topcards;
  }
  // this.date = formatDate(new Date(), "dd/MM/yyyy", "fr");
  ngOnInit(): void {
    // ========Size total des enfants dans la base========
    this.dashboardService.allChildSize().subscribe((data) => {
      this.allChild = data;
    });
    // ========Size total des enfants au sexe masculin dans la base========
    this.dashboardService.allChildMSize().subscribe((data) => {
      this.allChildMSize = data;
    });
    // ========Size total des enfants au sexe Féminin dans la base========
    this.dashboardService.allChildFSize().subscribe((data) => {
      this.allChildFSize = data;
    });
    // ========Size total des enfants Sponsorisé dans la base========
    this.dashboardService.allChildSponsorSize().subscribe((data) => {
      this.allChildSponsorSize = data;
    });
    // ========Size total des enfants Non sponsorisé dans la base========
    this.dashboardService.allChildNoSponsorSize().subscribe((data) => {
      this.allChildNoSponsorSize = data;
    });
    // ========Size total des enfants Faitant leurs anniversaire dans le mois========
    this.dashboardService.allChildAnivSize().subscribe((data) => {
      this.allChildAnivSize = data;
    });

    // ======================Côté activités====================
    this.dashboardService.allActivitySize().subscribe((data) => {
      this.allActivitySize = data;
    });

    // ======================Côté Enfants sorti====================
    this.dashboardService.allChildLogSize().subscribe((data) => {
      this.allChildLogSize = data;
    });
    // =========================Date=========================
    this.date = this.datePipe.transform(this.myDate, "dd/MM/yyyy");
    // =========================================================
  }
}
