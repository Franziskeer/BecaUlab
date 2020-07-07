import { Component, OnInit, Input, Output, EventEmitter, OnChanges, SimpleChange, SimpleChanges } from '@angular/core';
import { Events } from '../model/events'
import { ActivatedRoute, Router } from '@angular/router';
import { EventsService } from '../services/events.service';

@Component({
  selector: 'app-events-list',
  templateUrl: './events-list.component.html',
  styleUrls: ['./events-list.component.css']
})
export class EventsListComponent implements OnInit {
  @Input() allEvents: Events[];
//
  constructor(private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {

  }

}
