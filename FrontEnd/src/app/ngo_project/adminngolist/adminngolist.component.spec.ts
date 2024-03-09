import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminngolistComponent } from './adminngolist.component';

describe('AdminngolistComponent', () => {
  let component: AdminngolistComponent;
  let fixture: ComponentFixture<AdminngolistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AdminngolistComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AdminngolistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
