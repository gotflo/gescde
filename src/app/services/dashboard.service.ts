import { ChildLog } from "./../component/childLog/childLog-data";
import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { environment } from "../../environments/environment";
import { DatePipe } from "@angular/common";
import { Observable } from "rxjs";
import { Activity } from "../dashboard/dashboard-components/activity/activity";
import { Child } from "../dashboard/dashboard-components/child/child-data";

@Injectable({
  providedIn: "root",
})
export class DashboardService {
  month: any;
  myDate = new Date(Date.now());

  constructor(private httpClient: HttpClient, private datePipe: DatePipe) {
    this.month = this.datePipe.transform(this.myDate, "MM");
  }

  HostChild = environment.hostChild;
  HostActivity = environment.hostActivity;
  HostChildLog = environment.hostChildLog;

  // =======================Côté Child=============================

  // ---------------------ChildManager-------------------------
  addChilds(child: Child): Observable<Child> {
    return this.httpClient.post<Child>(
      `${this.HostChild + "/addChild"}`,
      child
    );
  }

  updateChilds(numeroBeneficiaire: any, value: any): Observable<Object> {
    return this.httpClient.put(
      `${this.HostChild + "/updateChild"}/${numeroBeneficiaire}`,
      value
    );
  }

  getChildByNumeroBeneficiaire(numeroBeneficiaire: any): Observable<any> {
    return this.httpClient.get(
      `${this.HostChild + "/getChild"}/${numeroBeneficiaire}`
    );
  }

  deleteChild(numeroBeneficiaire: any): Observable<any> {
    return this.httpClient.delete(
      `${this.HostChild + "/deleteChild"}/${numeroBeneficiaire}`,
      {
        responseType: "text",
      }
    );
  }
  //  --------------------------------------------------------------
  allChildSize() {
    return this.httpClient.get<any>(this.HostChild + "/allChildSize");
  }
  allChildMSize() {
    return this.httpClient.get<any>(this.HostChild + "/childMSize");
  }
  allChildFSize() {
    return this.httpClient.get<any>(this.HostChild + "/childFSize");
  }
  allChildSponsorSize() {
    return this.httpClient.get<any>(this.HostChild + "/childSponsorSize");
  }
  allChildNoSponsorSize() {
    return this.httpClient.get<any>(this.HostChild + "/childNoSponsorSize");
  }

  allChildAnivSize() {
    return this.httpClient.get<any>(
      this.HostChild + "/childAnnivSize/" + this.month
    );
  }

  getAllChildAnniv(): Observable<Child[]> {
    return this.httpClient.get<Child[]>(
      `${this.HostChild + "/childListByAnniv/" + this.month}`
    );
  }
  // ====================Anniv Mois======================
  getChildAnnivJav(): Observable<Child[]> {
    return this.httpClient.get<Child[]>(
      `${this.HostChild + "/childListByAnniv/01"}`
    );
  }
  getChildAnnivFev(): Observable<Child[]> {
    return this.httpClient.get<Child[]>(
      `${this.HostChild + "/childListByAnniv/02"}`
    );
  }
  getChildAnnivMars(): Observable<Child[]> {
    return this.httpClient.get<Child[]>(
      `${this.HostChild + "/childListByAnniv/03"}`
    );
  }
  getChildAnnivAvril(): Observable<Child[]> {
    return this.httpClient.get<Child[]>(
      `${this.HostChild + "/childListByAnniv/04"}`
    );
  }
  getChildAnnivMai(): Observable<Child[]> {
    return this.httpClient.get<Child[]>(
      `${this.HostChild + "/childListByAnniv/05"}`
    );
  }
  getChildAnnivJuin(): Observable<Child[]> {
    return this.httpClient.get<Child[]>(
      `${this.HostChild + "/childListByAnniv/06"}`
    );
  }
  getChildAnnivJuillet(): Observable<Child[]> {
    return this.httpClient.get<Child[]>(
      `${this.HostChild + "/childListByAnniv/07"}`
    );
  }
  getChildAnnivAout(): Observable<Child[]> {
    return this.httpClient.get<Child[]>(
      `${this.HostChild + "/childListByAnniv/08"}`
    );
  }
  getChildAnnivSept(): Observable<Child[]> {
    return this.httpClient.get<Child[]>(
      `${this.HostChild + "/childListByAnniv/09"}`
    );
  }
  getChildAnnivOctb(): Observable<Child[]> {
    return this.httpClient.get<Child[]>(
      `${this.HostChild + "/childListByAnniv/10"}`
    );
  }
  getChildAnnivNov(): Observable<Child[]> {
    return this.httpClient.get<Child[]>(
      `${this.HostChild + "/childListByAnniv/11"}`
    );
  }
  getChildAnnivDec(): Observable<Child[]> {
    return this.httpClient.get<Child[]>(
      `${this.HostChild + "/childListByAnniv/12"}`
    );
  }
  // =====================================================
  getAllChildByNumBeneef(): Observable<Child[]> {
    return this.httpClient.get<Child[]>(
      `${this.HostChild + "/childListByNum"}`
    );
  }

  getAllChildByName(): Observable<Child[]> {
    return this.httpClient.get<Child[]>(
      `${this.HostChild + "/childListByLastName"}`
    );
  }
  getAllChildGenderM(): Observable<Child[]> {
    return this.httpClient.get<Child[]>(
      `${this.HostChild + "/childListByGnderM"}`
    );
  }
  getAllChildGenderF(): Observable<Child[]> {
    return this.httpClient.get<Child[]>(
      `${this.HostChild + "/childListByGnderF"}`
    );
  }
  getAllChildSponsor(): Observable<Child[]> {
    return this.httpClient.get<Child[]>(
      `${this.HostChild + "/childListBySponsor"}`
    );
  }
  getAllChildNoSponsor(): Observable<Child[]> {
    return this.httpClient.get<Child[]>(
      `${this.HostChild + "/childListByNoSponsor"}`
    );
  }

  // /-------------Export PDF-------------
  exportChildByNumPdf() {
    return this.httpClient.get(`${this.HostChild + "/exportChildByNum"}`);
  }

  exportChildByLastNamePdf() {
    return this.httpClient.get(`${this.HostChild + "/exportChildByLastName"}`);
  }

  exportChildByGenderMPdf() {
    return this.httpClient.get(`${this.HostChild + "/exportChildByGenderM"}`);
  }

  exportChildByGenderFPdf() {
    return this.httpClient.get(`${this.HostChild + "/exportChildByGenderF"}`);
  }

  exportChildBySponsorPdf() {
    return this.httpClient.get(`${this.HostChild + "/exportChildBySponsor"}`);
  }

  exportChildByNoSponsorPdf() {
    return this.httpClient.get(`${this.HostChild + "/exportChildByNoSponsor"}`);
  }

  exportChildProjectByLastNamePdf() {
    return this.httpClient.get(
      `${this.HostChild + "/exportChildProjectByLastName"}`
    );
  }
  // -------------------------------------

  // ======================Côté activités====================
  allActivitySize() {
    return this.httpClient.get<any>(this.HostActivity + "/allActivitySize");
  }

  getAllActivity(): Observable<Activity[]> {
    return this.httpClient.get<Activity[]>(
      `${this.HostActivity + "/allActivityByMonth"}`
    );
  }

  getAllActivityById(idActivity: any): Observable<any> {
    return this.httpClient.get(
      `${this.HostActivity + "/activityById"}/${idActivity}`
    );
  }

  getAllActivityOfMonth(): Observable<Activity[]> {
    return this.httpClient.get<Activity[]>(
      `${this.HostActivity + "/activityByMonth/" + this.month}`
    );
  }

  updateActivity(idActivity: any, value: any): Observable<Object> {
    return this.httpClient.put(
      `${this.HostActivity + "/updateActivity"}/${idActivity}`,
      value
    );
  }

  addActivity(activity: Activity): Observable<Activity> {
    return this.httpClient.post<Activity>(
      `${this.HostActivity + "/addActivity"}`,
      activity
    );
  }

  deleteActivity(idActivity: any): Observable<any> {
    return this.httpClient.delete(
      `${this.HostActivity + "/deleteActivity"}/${idActivity}`,
      {
        responseType: "text",
      }
    );
  }

  // updateActivity;
  // ====================Activity Mois======================
  getChildActivityJav(): Observable<Activity[]> {
    return this.httpClient.get<Activity[]>(
      `${this.HostActivity + "/activityByMonth/01"}`
    );
  }
  getChildActivityFev(): Observable<Activity[]> {
    return this.httpClient.get<Activity[]>(
      `${this.HostActivity + "/activityByMonth/02"}`
    );
  }
  getChildActivityMars(): Observable<Activity[]> {
    return this.httpClient.get<Activity[]>(
      `${this.HostActivity + "/activityByMonth/" + this.month}`
    );
  }
  getChildActivityAvril(): Observable<Activity[]> {
    return this.httpClient.get<Activity[]>(
      `${this.HostActivity + "/activityByMonth/04"}`
    );
  }
  getChildActivityMai(): Observable<Activity[]> {
    return this.httpClient.get<Activity[]>(
      `${this.HostActivity + "/activityByMonth/05"}`
    );
  }
  getChildActivityJuin(): Observable<Activity[]> {
    return this.httpClient.get<Activity[]>(
      `${this.HostActivity + "/activityByMonth/06"}`
    );
  }
  getChildActivityJuillet(): Observable<Activity[]> {
    return this.httpClient.get<Activity[]>(
      `${this.HostActivity + "/activityByMonth/07"}`
    );
  }
  getChildActivityAout(): Observable<Activity[]> {
    return this.httpClient.get<Activity[]>(
      `${this.HostActivity + "/activityByMonth/08"}`
    );
  }
  getChildActivitySept(): Observable<Activity[]> {
    return this.httpClient.get<Activity[]>(
      `${this.HostActivity + "/activityByMonth/09"}`
    );
  }
  getChildActivityOctb(): Observable<Activity[]> {
    return this.httpClient.get<Activity[]>(
      `${this.HostActivity + "/activityByMonth/10"}`
    );
  }
  getChildActivityNov(): Observable<Activity[]> {
    return this.httpClient.get<Activity[]>(
      `${this.HostActivity + "/activityByMonth/11"}`
    );
  }
  getChildActivityDec(): Observable<Activity[]> {
    return this.httpClient.get<Activity[]>(
      `${this.HostActivity + "/activityByMonth/12"}`
    );
  }

  exportActivityPdf() {
    return this.httpClient.get(`${this.HostActivity + "/exportActivity"}`);
  }

  // =====================================================
  // ===========================================================

  // ======================Côté Enfants sorti====================
  allChildLogSize() {
    return this.httpClient.get<any>(this.HostChildLog + "/allChildLogSize");
  }

  getAllChildLogByNumBeneef(): Observable<ChildLog[]> {
    return this.httpClient.get<ChildLog[]>(
      `${this.HostChildLog + "/childLogListByNum"}`
    );
  }

  getAllChildLogByName(): Observable<ChildLog[]> {
    return this.httpClient.get<ChildLog[]>(
      `${this.HostChildLog + "/childLogListByLastName"}`
    );
  }
  getAllChildLogGenderM(): Observable<ChildLog[]> {
    return this.httpClient.get<ChildLog[]>(
      `${this.HostChildLog + "/childLogListByGnderM"}`
    );
  }
  getAllChildLogGenderF(): Observable<ChildLog[]> {
    return this.httpClient.get<ChildLog[]>(
      `${this.HostChildLog + "/childLogListByGnderF"}`
    );
  }
  getAllChildLogSponsor(): Observable<ChildLog[]> {
    return this.httpClient.get<ChildLog[]>(
      `${this.HostChildLog + "/childLogListBySponsor"}`
    );
  }
  getAllChildLogNoSponsor(): Observable<ChildLog[]> {
    return this.httpClient.get<ChildLog[]>(
      `${this.HostChildLog + "/childLogListByNoSponsor"}`
    );
  }

  deleteChildLog(numeroBeneficiaireLog: any): Observable<any> {
    return this.httpClient.delete(
      `${this.HostChildLog + "/deleteChildLog"}/${numeroBeneficiaireLog}`,
      {
        responseType: "text",
      }
    );
  }

  addChildsLog(childLog: Child): Observable<ChildLog> {
    return this.httpClient.post<ChildLog>(
      `${this.HostChildLog + "/addChildLog"}`,
      childLog
    );
  }

  getChildByNumeroBeneficiaireLog(numeroBeneficiaireLog: any): Observable<any> {
    return this.httpClient.get(
      `${this.HostChildLog + "/getChildLog"}/${numeroBeneficiaireLog}`
    );
  }

  // /-------------Export PDF-------------
  exportChildLogByNumPdf() {
    return this.httpClient.get(`${this.HostChildLog + "/exportChildLogByNum"}`);
  }

  exportChildLogByLastNamePdf() {
    return this.httpClient.get(
      `${this.HostChildLog + "/exportChildLogByLastName"}`
    );
  }

  exportChildLogByGenderMPdf() {
    return this.httpClient.get(
      `${this.HostChildLog + "/exportChildLogByGenderM"}`
    );
  }

  exportChildLogByGenderFPdf() {
    return this.httpClient.get(
      `${this.HostChildLog + "/exportChildLogByGenderF"}`
    );
  }

  exportChildLogBySponsorPdf() {
    return this.httpClient.get(
      `${this.HostChildLog + "/exportChildLogBySponsor"}`
    );
  }

  exportChildLogByNoSponsorPdf() {
    return this.httpClient.get(
      `${this.HostChildLog + "/exportChildLogByNoSponsor"}`
    );
  }

  // -------------------------------------
}
