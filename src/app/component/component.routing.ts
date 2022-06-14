import { InfoChildComponent } from "./infoChild/infoChild.component";
import { UpdateActivityComponent } from "./updateActivity/updateActivity.component";
import { ChildUpdateComponent } from "./childUpdate/childUpdate.component";
import { InfoChildLogComponent } from "./infoChildLog/infoChildLog.component";
import { ActivityManagerComponent } from "./activityManager/activityManager.component";
import { Routes } from "@angular/router";
import { AllMonthAnnivComponent } from "./allMonthAnniv/allMonthAnniv.component";
import { ChildManagerComponent } from "./childManager/childManager.component";

import { ChildProjectManagerComponent } from "./childProjectManager/childProjectManager.component";
import { ChildProjctsComponent } from "./childProjects/childProjcts.component";
import { ListChildsComponent } from "./listChilds/listChilds.component";
import { AllActivityComponent } from "./allActivity/allActivity.component";
import { ChildLogComponent } from "./childLog/childLog.component";
import { ChildLogManagerComponent } from "./childLogManager/childLogManager.component";

export const ComponentsRoutes: Routes = [
  {
    path: "",
    children: [
      {
        path: "infoChildLog/:numeroBeneficiaireLog",
        component: InfoChildLogComponent,
      },
      {
        path: "infoChild/:numeroBeneficiaire",
        component: InfoChildComponent,
      },
      {
        path: "activityManager",
        component: ActivityManagerComponent,
      },
      {
        path: "updateActivity/:idActivity",
        component: UpdateActivityComponent,
      },
      {
        path: "childLog",
        component: ChildLogComponent,
      },
      {
        path: "allMonthAnniv",
        component: AllMonthAnnivComponent,
      },
      {
        path: "listChilds",
        component: ListChildsComponent,
      },
      {
        path: "childManager",
        component: ChildManagerComponent,
      },
      {
        path: "childUpdate/:numeroBeneficiaire",
        component: ChildUpdateComponent,
      },
      {
        path: "childLogManager/:numeroBeneficiaire",
        component: ChildLogManagerComponent,
      },
      {
        path: "childProjectManager/:numeroBeneficiaire",
        component: ChildProjectManagerComponent,
      },
      {
        path: "childProjcts",
        component: ChildProjctsComponent,
      },
      {
        path: "allActivity",
        component: AllActivityComponent,
      },
    ],
  },
];
