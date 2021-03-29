import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import {ManageProjectsComponent} from './manage-projects/manage-projects.component';
import { IdeComponent } from './ide/ide.component';
import {Route, RouterModule} from "@angular/router";
import {FormsModule} from "@angular/forms";
import {MonacoEditorModule} from "ngx-monaco-editor";
import {HttpClientModule} from "@angular/common/http";
import {ManageProjectsService} from "./manage-projects/manage-projects.service";
import {IdeService} from "./ide/ide.service";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonModule} from "@angular/material/button";
import {MatTableModule} from "@angular/material/table";
import {MatPaginatorModule} from "@angular/material/paginator";
import {MatIconModule} from '@angular/material/icon';
import {MatSortModule} from "@angular/material/sort";
import {MatDialogModule} from "@angular/material/dialog";
import {MatFormFieldModule} from "@angular/material/form-field";
import { ProjectCreationOverviewComponent } from './project-creation-overview/project-creation-overview.component';
import {MatInputModule} from "@angular/material/input";
import {CdkColumnDef} from "@angular/cdk/table";
import { CompilerSidebarComponent } from './compiler-sidebar/compiler-sidebar.component';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatTabsModule} from '@angular/material/tabs';
import {MatDividerModule} from '@angular/material/divider';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import { SourcefileCreationOverviewComponent } from './sourcefile-creation-overview/sourcefile-creation-overview.component';
import {MatMenuModule} from '@angular/material/menu';
import { AuthGuard } from './auth.guard';
import { LoginComponent } from './login/login.component';

const routes: Route[] = [
  {path: '', component: LoginComponent},
  {path: 'home', component: HomeComponent, canActivate: [AuthGuard]},
  {path: 'projects', component: ManageProjectsComponent, canActivate: [AuthGuard]},
  //{path: 'create-project', component: ProjectCreationOverviewComponent},
  {
    path: 'ide',
    component: IdeComponent,
    children: [
      {path: ':name', component: IdeComponent}
    ], canActivate: [AuthGuard]},
  {path: '**', redirectTo: '/'}
];

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ManageProjectsComponent,
    IdeComponent,
    ProjectCreationOverviewComponent,
    CompilerSidebarComponent,
    SourcefileCreationOverviewComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(routes),
    MonacoEditorModule.forRoot(),
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatTableModule,
    MatPaginatorModule,
    MatIconModule,
    MatSortModule,
    MatDialogModule,
    MatFormFieldModule,
    MatInputModule,
    MatSidenavModule,
    MatTabsModule,
    MatDividerModule,
    MatProgressSpinnerModule,
    MatMenuModule
  ],
  exports: [
    RouterModule,
    MatSidenavModule,
    MatTabsModule,
    MatDividerModule,
    MatProgressSpinnerModule
  ],
  providers: [ManageProjectsService, CdkColumnDef],
  bootstrap: [AppComponent],
  entryComponents: [ProjectCreationOverviewComponent]
})
export class AppModule { }
