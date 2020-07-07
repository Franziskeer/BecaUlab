import { Component, OnInit, Input } from '@angular/core';
import { iUsers } from '../interfaces/iUsers';

@Component({
  selector: 'app-friends-list',
  templateUrl: './friends-list.component.html',
  styleUrls: ['./friends-list.component.css']
})
export class FriendsListComponent implements OnInit {
  @Input() mensaje: string;
  myFriends: iUsers[];
  constructor() { }

  ngOnInit() {
  }

}
