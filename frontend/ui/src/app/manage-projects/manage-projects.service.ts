import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import {Project} from "../project";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ManageProjectsService {

  private projectsUrl: string;
  private deleted: Observable<Object>;

  constructor(private http: HttpClient) {
    this.projectsUrl = '/project';
  }

  public findAll(): Observable<Project[]> {
    return this.http.get<Project[]>(this.projectsUrl);
  }

  public save(project: Project) {
    return this.http.post<Project>(this.projectsUrl + "/create", project);
    // return this.http.post<Project>(this.projectsUrl + "/create", "{name: \""+ project + "\"}");
  }

  public delete(project: Project) {
    return this.deleted = this.http.request('delete', this.projectsUrl, { body: project });
  }

  public rename(project: Project) {
    return this.http.patch<Project>(this.projectsUrl, project);
  }
}
