import { Component, OnInit } from '@angular/core';
import { Users } from './model/users';
import { FriendsService } from './services/friends.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit {
  user: Users = new Users();
  
  constructor(private friendsService: FriendsService) { }
  
  ngOnInit() {
  //  this.user = this.friendsService.getUserId();
  }
}
