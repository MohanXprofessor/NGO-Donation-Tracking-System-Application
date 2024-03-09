import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddngoComponent } from './addngo.component';

describe('AddngoComponent', () => {
  let component: AddngoComponent;
  let fixture: ComponentFixture<AddngoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AddngoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AddngoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
