import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserTrainListComponent } from './user-train-list.component';

describe('UserTrainListComponent', () => {
  let component: UserTrainListComponent;
  let fixture: ComponentFixture<UserTrainListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserTrainListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UserTrainListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
