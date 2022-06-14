import { BrowserModule } from "@angular/platform-browser";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import {
  CommonModule,
  LocationStrategy,
  PathLocationStrategy,
} from "@angular/common";
import { NgToastModule } from "ng-angular-popup";
import { NgModule } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { HttpClientModule, HttpClient } from "@angular/common/http";
import { Routes, RouterModule } from "@angular/router";
import { DatePipe } from "@angular/common";
import { NgbModule } from "@ng-bootstrap/ng-bootstrap";
import { ConfirmationPopoverModule } from "angular-confirmation-popover";

import { FullComponent } from "./layouts/full/full.component";

import { NavigationComponent } from "./shared/header/navigation.component";
import { SidebarComponent } from "./shared/sidebar/sidebar.component";

import { Approutes } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { SpinnerComponent } from "./shared/spinner.component";

import { PerfectScrollbarModule } from "ngx-perfect-scrollbar";
import { PERFECT_SCROLLBAR_CONFIG } from "ngx-perfect-scrollbar";
import { PerfectScrollbarConfigInterface } from "ngx-perfect-scrollbar";
import { MatSliderModule } from "@angular/material/slider";
import { MDBBootstrapModule } from "angular-bootstrap-md";
import { Ng2SearchPipeModule } from "ng2-search-filter";
import { NgxPrintModule } from "ngx-print";

const DEFAULT_PERFECT_SCROLLBAR_CONFIG: PerfectScrollbarConfigInterface = {
  suppressScrollX: true,
  wheelSpeed: 1,
  wheelPropagation: true,
  minScrollbarLength: 20,
};

@NgModule({
  declarations: [
    AppComponent,
    SpinnerComponent,
    FullComponent,
    NavigationComponent,
    SidebarComponent,
  ],
  imports: [
    CommonModule,
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    NgToastModule,
    HttpClientModule,
    MatSliderModule,
    Ng2SearchPipeModule,
    NgxPrintModule,
    NgbModule,
    ConfirmationPopoverModule.forRoot({
      confirmButtonType: "danger", // set defaults here
    }),
    MDBBootstrapModule.forRoot(),
    RouterModule.forRoot(Approutes, {
      useHash: false,
      relativeLinkResolution: "legacy",
    }),
    PerfectScrollbarModule,
  ],
  providers: [
    {
      provide: LocationStrategy,
      useClass: PathLocationStrategy,
    },
    {
      provide: PERFECT_SCROLLBAR_CONFIG,
      useValue: DEFAULT_PERFECT_SCROLLBAR_CONFIG,
    },
    DatePipe,
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
