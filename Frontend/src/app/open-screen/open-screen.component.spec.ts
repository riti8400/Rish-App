import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OpenScreenComponent } from './open-screen.component';

describe('OpenScreenComponent', () => {
  let component: OpenScreenComponent;
  let fixture: ComponentFixture<OpenScreenComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OpenScreenComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OpenScreenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
