import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";


@Component({
  selector: 'app-project-creation-overview',
  templateUrl: './project-creation-overview.component.html',
  styleUrls: ['./project-creation-overview.component.css']
})
export class ProjectCreationOverviewComponent implements OnInit {
  private _newProjectname: string;

  constructor(
    private dialogRef: MatDialogRef<ProjectCreationOverviewComponent>,
    @Inject(MAT_DIALOG_DATA) data){

      this._newProjectname = data.name;
  }

  ngOnInit(): void {
  }

  save(): void {
    this.dialogRef.close(this._newProjectname);

  }
  close(): void{
    this.dialogRef.close();
  }

  public get newProjectname(): string {
    return this._newProjectname;
  }

  public set newProjectname(value: string) {
    this._newProjectname = value;
  }
}
