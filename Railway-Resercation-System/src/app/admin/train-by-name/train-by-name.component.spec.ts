import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TrainByNameComponent } from './train-by-name.component';

describe('TrainByNameComponent', () => {
  let component: TrainByNameComponent;
  let fixture: ComponentFixture<TrainByNameComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TrainByNameComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TrainByNameComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
