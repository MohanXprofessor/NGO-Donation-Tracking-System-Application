import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NgoeditComponent } from './ngoedit.component';

describe('NgoeditComponent', () => {
  let component: NgoeditComponent;
  let fixture: ComponentFixture<NgoeditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [NgoeditComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(NgoeditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
