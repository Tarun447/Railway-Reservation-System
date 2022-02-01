import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TrainListComponent } from './train-list.component';

describe('TrainListComponent', () => {
  let component: TrainListComponent;
  let fixture: ComponentFixture<TrainListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TrainListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TrainListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
