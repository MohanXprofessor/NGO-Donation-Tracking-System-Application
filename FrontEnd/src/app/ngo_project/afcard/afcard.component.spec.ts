import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AfcardComponent } from './afcard.component';

describe('AfcardComponent', () => {
  let component: AfcardComponent;
  let fixture: ComponentFixture<AfcardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AfcardComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AfcardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
