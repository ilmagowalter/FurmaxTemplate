import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GearbestComponent } from './gearbest.component';

describe('GearbestComponent', () => {
  let component: GearbestComponent;
  let fixture: ComponentFixture<GearbestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GearbestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GearbestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
