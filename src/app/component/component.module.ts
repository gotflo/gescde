import { UpdateActivityComponent } from "./updateActivity/updateActivity.component";
import { ConfirmationPopoverModule } from "angular-confirmation-popover";
import { ChildUpdateComponent } from "./childUpdate/childUpdate.component";
import { InfoChildLogComponent } from "./infoChildLog/infoChildLog.component";
import { ActivityManagerComponent } from "./activityManager/activityManager.component";
import { NgModule } from "@angular/core";
import { RouterModule } from "@angular/router";
import { CommonModule } from "@angular/common";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { ListChildsComponent } from "./listChilds/listChilds.component";

import { NgbModule } from "@ng-bootstrap/ng-bootstrap";
import { ComponentsRoutes } from "./component.routing";
import { AllMonthAnnivComponent } from "./allMonthAnniv/allMonthAnniv.component";
import { ChildManagerComponent } from "./childManager/childManager.component";
import { ChildProjectManagerComponent } from "./childProjectManager/childProjectManager.component";
import { ChildProjctsComponent } from "./childProjects/childProjcts.component";
import { AllActivityComponent } from "./allActivity/allActivity.component";
import { ChildLogComponent } from "./childLog/childLog.component";
import { ChildLogManagerComponent } from "./childLogManager/childLogManager.component";
import { InfoChildComponent } from "./infoChild/infoChild.component";
import { Ng2SearchPipeModule } from "ng2-search-filter";
import { NgxPrintModule } from "ngx-print";

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(ComponentsRoutes),
    FormsModule,
    Ng2SearchPipeModule,
    NgxPrintModule,
    ReactiveFormsModule,
    NgbModule,
    ConfirmationPopoverModule.forRoot({
      focusButton: "confirm",
    }),
  ],
  declarations: [
    AllMonthAnnivComponent,
    ChildManagerComponent,
    ChildProjectManagerComponent,
    ChildProjctsComponent,
    AllActivityComponent,
    ChildLogComponent,
    ChildLogManagerComponent,
    ActivityManagerComponent,
    InfoChildLogComponent,
    InfoChildComponent,
    ChildUpdateComponent,
    ListChildsComponent,
    UpdateActivityComponent,
  ],
})
export class ComponentsModule {}
