import { TestBed } from '@angular/core/testing';

import { HttpRequestAirService } from './http-request-air.service';

describe('HttpRequestAirService', () => {
  let service: HttpRequestAirService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HttpRequestAirService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
