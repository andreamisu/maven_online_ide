import {Component, OnInit} from '@angular/core';
import {MatDialogRef} from "@angular/material/dialog";

@Component({
  selector: 'app-sourcefile-creation-overview',
  templateUrl: './sourcefile-creation-overview.component.html',
  styleUrls: ['./sourcefile-creation-overview.component.css']
})
export class SourcefileCreationOverviewComponent implements OnInit {

  newFilename: string;

  constructor(
    private dialogRef: MatDialogRef<SourcefileCreationOverviewComponent>){
  }

  ngOnInit(): void {
  }

  save(): void {
    this.dialogRef.close(this.newFilename);

  }
  close(): void{
    this.dialogRef.close();
  }

}
