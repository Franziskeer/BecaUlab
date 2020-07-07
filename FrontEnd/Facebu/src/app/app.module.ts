import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RouterModule } from '@angular/router';
import { EventsComponent } from './events/events.component';
import { HttpClientModule } from '@angular/common/http';
import { EventsService } from './services/events.service';
import { FriendsComponent } from './friends/friends.component';
import { FriendsListComponent } from './friends-list/friends-list.component';
import { EventsListComponent } from './events-list/events-list.component';
import { ReactiveFormsModule } from '@angular/forms';
import { FriendsService } from './services/friends.service';
@NgModule({
  declarations: [
    AppComponent,
    EventsComponent,
    EventsListComponent,
    FriendsComponent,
    FriendsListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    RouterModule,
    ReactiveFormsModule
  ],
  providers: [
    EventsService,
    FriendsService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
