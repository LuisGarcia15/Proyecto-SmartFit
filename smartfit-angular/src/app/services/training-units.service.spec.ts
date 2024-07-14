import { TestBed } from '@angular/core/testing';

import { TrainingUnitsServiceService } from './training-units.service';

describe('TrainingUnitsServiceService', () => {
  let service: TrainingUnitsServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TrainingUnitsServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
