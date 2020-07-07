import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-friends',
  templateUrl: './friends.component.html',
  styleUrls: ['./friends.component.css']
})
export class FriendsComponent implements OnInit {
  mensaje: string = "Mensaje enviado con inputs de Friends a Friends-List";

  constructor() { }

  ngOnInit() {
  }

}
