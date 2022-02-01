import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TrainByLocComponent } from './train-by-loc.component';

describe('TrainByLocComponent', () => {
  let component: TrainByLocComponent;
  let fixture: ComponentFixture<TrainByLocComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TrainByLocComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TrainByLocComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
