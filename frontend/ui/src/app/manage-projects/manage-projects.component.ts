import {Component, Inject, OnInit, ViewChild} from '@angular/core';
import {Project} from "../project";
import {ManageProjectsService} from "./manage-projects.service";
import {ActivatedRoute, Router} from "@angular/router";
import {IdeComponent} from "../ide/ide.component";
import {IdeService} from "../ide/ide.service";
import {MatDialog, MatDialogConfig, MatDialogRef, MAT_DIALOG_DATA} from "@angular/material/dialog";
import {ProjectCreationOverviewComponent} from "../project-creation-overview/project-creation-overview.component";
import {AuthService} from "../auth.service";



@Component({
  selector: 'app-manage-projects',
  templateUrl: './manage-projects.component.html',
  styleUrls: ['./manage-projects.component.css']
})
export class ManageProjectsComponent implements OnInit {
  projects: Project[];
  ide: IdeComponent;
  ideService: IdeService;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private manageProjectsService: ManageProjectsService,
              public dialog: MatDialog,
              public authService: AuthService){}

  ngOnInit(): void {
    this.manageProjectsService.findAll().subscribe(data => {
      this.projects = data;
    });
  }

  refresh(): void {
    this.manageProjectsService.findAll().subscribe(data => {
      this.projects = data;
    });
  }

  //create a new project
  createProject(newProjectName: string): void {
    const project = new Project();
    project.name = newProjectName;
    this.manageProjectsService
      .save(project)
      .subscribe(project => {
        this.projects.push(project);
        this.refresh();
      });
  }

  rename(project: Project) {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.autoFocus = true;
    dialogConfig.width = '250px';
    dialogConfig.data = this.projects;
    const dialogRef = this.dialog.open(ProjectCreationOverviewComponent, dialogConfig);
    //Actions to perform when the dialog is closed
    dialogRef.afterClosed().subscribe(
      data => {
        project.name = data;
        this.manageProjectsService
          .rename(project)
          .subscribe(project => {
            this.refresh();
          });
        this.refresh();
      });
  }

  //delete a project
  deleteProject(project: Project): void {
    this.manageProjectsService
      .delete(project)
      .subscribe(project => {
        this.projects;
        this.refresh();
      });
  }

  //open project in IDE
  openProject(project: Project) {
    this.router.navigate(['/ide', { name: project.name }], { relativeTo: this.route });
  }

  //open dialog to create a new project
  createProjectDialog(): void{
    const dialogConfig = new MatDialogConfig();
    dialogConfig.autoFocus = true;
    dialogConfig.width = '250px';
    dialogConfig.data = this.projects;
    const dialogRef = this.dialog.open(ProjectCreationOverviewComponent, dialogConfig);
    //Actions to perform when the dialog is closed
    dialogRef.afterClosed().subscribe(
    data => {
      this.createProject(data);
      this.refresh();
    });
  }

  //List of columns in the projects table
  displayedColumns: string[] = ['id', 'name', 'actions'];

}
