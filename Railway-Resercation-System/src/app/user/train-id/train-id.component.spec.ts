import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TrainIdComponent } from './train-id.component';

describe('TrainIdComponent', () => {
  let component: TrainIdComponent;
  let fixture: ComponentFixture<TrainIdComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TrainIdComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TrainIdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
