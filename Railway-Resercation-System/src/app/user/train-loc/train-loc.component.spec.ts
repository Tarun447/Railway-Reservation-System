import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TrainLocComponent } from './train-loc.component';

describe('TrainLocComponent', () => {
  let component: TrainLocComponent;
  let fixture: ComponentFixture<TrainLocComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TrainLocComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TrainLocComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
