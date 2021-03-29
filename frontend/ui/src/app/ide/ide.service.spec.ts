import { TestBed } from '@angular/core/testing';

import { IdeService } from './ide.service';

describe('IdeService', () => {
  let service: IdeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(IdeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
