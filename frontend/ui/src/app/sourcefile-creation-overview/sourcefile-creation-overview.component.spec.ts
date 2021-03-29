import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SourcefileCreationOverviewComponent } from './sourcefile-creation-overview.component';

describe('SourcefileCreationOverviewComponent', () => {
  let component: SourcefileCreationOverviewComponent;
  let fixture: ComponentFixture<SourcefileCreationOverviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SourcefileCreationOverviewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SourcefileCreationOverviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
