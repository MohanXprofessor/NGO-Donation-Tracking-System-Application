import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NgolistComponent } from './ngolist.component';

describe('NgolistComponent', () => {
  let component: NgolistComponent;
  let fixture: ComponentFixture<NgolistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [NgolistComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(NgolistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
