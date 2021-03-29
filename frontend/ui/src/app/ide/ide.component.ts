import { SourcefileCreationOverviewComponent } from './../sourcefile-creation-overview/sourcefile-creation-overview.component';
import { SourceCode } from './../source-code';
import { Component, OnInit } from '@angular/core';
import {IdeService} from "./ide.service";
import {Project} from "../project";
import {Sourcefile} from "../sourcefile";
import { Router } from '@angular/router';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { MatMenuModule}  from '@angular/material/menu';
import {AuthService} from "../auth.service";


@Component({
  selector: 'app-ide',
  templateUrl: './ide.component.html',
  styleUrls: ['./ide.component.css']
})
export class IdeComponent implements OnInit {

  editorOptions = {
    theme: "vs-dark",
    language: "javascript"
  };

  project: Project;
  sourcefiles: Sourcefile[];
  newSourcefileName: string;
  selectedSourcefile: Sourcefile;
  code: string;
  errorString: string;
  compilerOutput: SourceCode;
  compilerResult: string;
  loading= false;
  saved: boolean;


  constructor(private ideService: IdeService,
              private router: Router,
              public dialog: MatDialog,
              public authService: AuthService
  ) { }


  ngOnInit() {
    this.modeChecker();
    setInterval(() => { this.modeChecker(); }, 5000);
    this.ideService.getProject().subscribe(data => {
      if(data != null)
      {
        this.project = data;
        this.ideService.getProjectFiles(data).subscribe(data => {
          this.sourcefiles = data;
          this.selectedSourcefile = data[0];
          this.code = data[0].code;
          this.changeEditorLanguage(data[0]);
        });
      }
    });
  }

  modeChecker(){
    this.ideService.getDarkMode().subscribe(data=> {
      if((this.editorOptions.theme == 'vs-dark' && !data) || (this.editorOptions.theme == 'vs-light' && data)){
        this.editorOptions = { ...this.editorOptions, theme: data ? 'vs-dark' : 'vs-light' };
      }
    });
  }

  fetchFiles() {
    this.ideService.getProjectFiles(this.project).subscribe(data => {
      this.sourcefiles = data;
    });
  }

  createSourcefile(newSourcefile : string) {
    this.loading = true;
    const sourcefile = new Sourcefile();
    sourcefile.filename = newSourcefile;
    sourcefile.project = this.project;
    sourcefile.code = '';
    this.ideService.save(sourcefile).subscribe(sourcefile => {
      this.sourcefiles.push(sourcefile)
      this.loading = false;
    });
    this.newSourcefileName='';
  }

  renameFile(sourcefile: Sourcefile) {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.autoFocus = true;
    dialogConfig.width = '250px';
    dialogConfig.data = sourcefile.filename;
    //this.dialog.open(ProjectCreationOverviewComponent, dialogConfig);

    const dialogRef = this.dialog.open(SourcefileCreationOverviewComponent, dialogConfig);
    //Actions to perform when the dialog is closed
    dialogRef.afterClosed().subscribe(
      data => {
        if (data != null) {
          sourcefile.filename = data;
        }
        this.ideService.rename(sourcefile).subscribe(sourcefileRenamed => {
          if(sourcefileRenamed.id == this.selectedSourcefile.id){
            this.changeEditorLanguage(sourcefile);
          }
        });
      });
  }


  deleteFile(sourcefile: Sourcefile) {
    this.ideService.delete(sourcefile).subscribe(sourcefile => {
      this.loading = false;
    });
    this.ngOnInit();
  }

  openDialog(): void{
    const dialogConfig = new MatDialogConfig();
    dialogConfig.autoFocus = true;
    dialogConfig.width = '250px';
    dialogConfig.data = this.newSourcefileName;
    //this.dialog.open(ProjectCreationOverviewComponent, dialogConfig);

    const dialogRef = this.dialog.open(SourcefileCreationOverviewComponent, dialogConfig);
    //Actions to perform when the dialog is closed
    dialogRef.afterClosed().subscribe(
    data => {
      this.createSourcefile(data);
    });
  }

  //open project in IDE
  backHomepage() {
    this.router.navigate(['/projects']);
  }
  openSourcefile(sourcefile: Sourcefile) {
    this.selectedSourcefile = sourcefile;
    this.code = sourcefile.code;
    this.changeEditorLanguage(sourcefile);
  }

  changeEditorLanguage(sourcefile: Sourcefile){
    var filename = sourcefile.filename.split(".");
    if(filename.length != 1){
      this.editorOptions.language = filename[filename.length-1] == "c" ? "c" : "java";
    }
  }

  saveCode(){
    this.loading = true;
    const sourcefile = new Sourcefile();
    sourcefile.filename = this.selectedSourcefile.filename;
    sourcefile.project = this.selectedSourcefile.project;
    sourcefile.code = this.code;
    sourcefile.id = this.selectedSourcefile.id;
    const index = this.sourcefiles.indexOf(this.selectedSourcefile);
    this.ideService.saveCode(sourcefile).subscribe(newSelected => {
      this.sourcefiles[index] = newSelected;
      this.openSourcefile(newSelected);
      this.loading = false;
    });
  }

  canCompile() {
    if (this.selectedSourcefile != null) {
        return this.code == this.selectedSourcefile.code;
    }
  }

  compileSourceCode(){
    this.loading = true;
    this.compilerOutput = new SourceCode();
    const sourcefile = new Sourcefile();
    sourcefile.filename = this.selectedSourcefile.filename;
    sourcefile.project = this.selectedSourcefile.project;
    sourcefile.code = this.code;
    sourcefile.id = this.selectedSourcefile.id;
    this.ideService.compileSourceCode(sourcefile).subscribe(data => {
      this.compilerOutput = data;
      this.loading = false;
    });
  }

}
