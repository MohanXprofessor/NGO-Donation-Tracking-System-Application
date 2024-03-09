import { TestBed } from '@angular/core/testing';

import { NgoserviceService } from './ngoservice.service';

describe('NgoserviceService', () => {
  let service: NgoserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NgoserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
