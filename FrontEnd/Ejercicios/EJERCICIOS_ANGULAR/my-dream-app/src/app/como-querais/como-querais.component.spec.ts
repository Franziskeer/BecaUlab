import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ComoQueraisComponent } from './como-querais.component';

describe('ComoQueraisComponent', () => {
  let component: ComoQueraisComponent;
  let fixture: ComponentFixture<ComoQueraisComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ComoQueraisComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ComoQueraisComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
