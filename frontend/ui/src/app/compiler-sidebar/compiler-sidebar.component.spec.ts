import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CompilerSidebarComponent } from './compiler-sidebar.component';

describe('CompilerSidebarComponent', () => {
  let component: CompilerSidebarComponent;
  let fixture: ComponentFixture<CompilerSidebarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CompilerSidebarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CompilerSidebarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
