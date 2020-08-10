import { TestBed } from '@angular/core/testing';

import { GetLocApiService } from './get-loc-api.service';

describe('GetLocApiService', () => {
  let service: GetLocApiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GetLocApiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
