import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TrainNameComponent } from './train-name.component';

describe('TrainNameComponent', () => {
  let component: TrainNameComponent;
  let fixture: ComponentFixture<TrainNameComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TrainNameComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TrainNameComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
