import { Component, OnInit, Input } from '@angular/core';
import { EventsService } from '../services/events.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Events } from '../model/events';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Users } from '../model/users';

@Component({
  selector: 'app-events',
  templateUrl: './events.component.html',
  styleUrls: ['./events.component.css']
})
export class EventsComponent implements OnInit {

  constructor(private fb: FormBuilder, private eventsService: EventsService, private route: ActivatedRoute, private router: Router) { }

  @Input() user: Users;
  allEvents: Events[];
  newEvent: Events;
  // public formGroup: FormGroup;
  
  ngOnInit() {
    this.eventsService.getAllEvents()
      .subscribe( (data: Events[]) => 
                  this.allEvents = data,
                  error => console.log(error), 
                  () => console.log("My events list is loaded"));

    // this.formGroup = this.fb.group({
    //   "name": this.newEvent.name,
    //   "description": this.newEvent.description,
    //   "eventDate": this.newEvent.eventDate,
    //   "creator": this.user
    // }); 
  }

  onSubmit() {
    // console.log(this.formGroup.value);
    // this.eventsService.postEvent(this.newEvent)
    //   .subscribe();
  }

}
