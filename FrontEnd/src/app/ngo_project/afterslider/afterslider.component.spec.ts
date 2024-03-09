import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AftersliderComponent } from './afterslider.component';

describe('AftersliderComponent', () => {
  let component: AftersliderComponent;
  let fixture: ComponentFixture<AftersliderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AftersliderComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AftersliderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
