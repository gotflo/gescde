/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { InfoChildComponent } from './infoChild.component';

describe('InfoChildComponent', () => {
  let component: InfoChildComponent;
  let fixture: ComponentFixture<InfoChildComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InfoChildComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InfoChildComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
