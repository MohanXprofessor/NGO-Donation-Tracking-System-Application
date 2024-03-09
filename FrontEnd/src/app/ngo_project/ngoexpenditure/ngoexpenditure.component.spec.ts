import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NgoexpenditureComponent } from './ngoexpenditure.component';

describe('NgoexpenditureComponent', () => {
  let component: NgoexpenditureComponent;
  let fixture: ComponentFixture<NgoexpenditureComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [NgoexpenditureComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(NgoexpenditureComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
