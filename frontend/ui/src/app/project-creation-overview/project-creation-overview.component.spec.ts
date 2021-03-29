import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjectCreationOverviewComponent } from './project-creation-overview.component';

describe('ProjectCreationOverviewComponent', () => {
  let component: ProjectCreationOverviewComponent;
  let fixture: ComponentFixture<ProjectCreationOverviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProjectCreationOverviewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProjectCreationOverviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
