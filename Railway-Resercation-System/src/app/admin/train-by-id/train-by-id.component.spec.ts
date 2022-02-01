import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TrainByIdComponent } from './train-by-id.component';

describe('TrainByIdComponent', () => {
  let component: TrainByIdComponent;
  let fixture: ComponentFixture<TrainByIdComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TrainByIdComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TrainByIdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
