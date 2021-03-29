import { SourceCode } from './../source-code';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import {Project} from "../project";
import {Observable} from "rxjs";
import {Sourcefile} from "../sourcefile";
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class IdeService {
  private projectsUrl: string;
  private sourceFileUrl: string;
  private compilerUrl: string;
  private darkModeUrl: string;

  constructor(private http: HttpClient, private router: Router) {
    this.projectsUrl = '/project';
    this.sourceFileUrl = '/project/sourcefile';
    this.compilerUrl = '/compiler';
    this.darkModeUrl = '/dark-mode';
  }
  public getProjectFiles(project: Project): Observable<Sourcefile[]> {
    console.log(project);
    return this.http.post<Sourcefile[]>(this.projectsUrl + "/sourcefiles", project);
  }

  getProject(): Observable<Project> {
    console.log(this.router.url);
    let projectName = this.router.url.slice(10);
    projectName= projectName.replace(/%20/g, " ");
    console.log(projectName);
    return this.http.post<Project>(this.projectsUrl + "/find", projectName);
  }

  save(sourcefile: Sourcefile) : Observable<Sourcefile> {
    return this.http.post<Sourcefile>(this.sourceFileUrl + "/create", sourcefile);
  }

  saveCode(sourcefile: Sourcefile): Observable<Sourcefile> {
    return this.http.patch<Sourcefile>(this.sourceFileUrl , sourcefile);
  }

  compileSourceCode(sourcefile: Sourcefile) : Observable<SourceCode>{
    return this.http.post<SourceCode>(this.compilerUrl + "/compile" , sourcefile);
  }

  rename(sourcefile: Sourcefile) {
    return this.http.patch<Sourcefile>(this.sourceFileUrl , sourcefile);
  }

  delete(sourcefile: Sourcefile) {
    return this.http.request('delete', this.sourceFileUrl, { body: sourcefile });
  }

  getDarkMode(): Observable<boolean> {
    return this.http.get<boolean>(this.darkModeUrl);
  }
}
