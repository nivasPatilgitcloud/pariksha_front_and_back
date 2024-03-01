import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CommonnavbarComponent } from './commonnavbar.component';

describe('CommonnavbarComponent', () => {
  let component: CommonnavbarComponent;
  let fixture: ComponentFixture<CommonnavbarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CommonnavbarComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CommonnavbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
