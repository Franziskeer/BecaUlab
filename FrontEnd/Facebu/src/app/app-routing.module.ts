import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EventsComponent } from './events/events.component';
import { FriendsComponent } from './friends/friends.component';


const routes: Routes = [
/*  
  { path: '', component: EventsComponent },
  { path: 'stories', component: StoriesComponent },
  { path: 'profile', component: ProfileComponent },
*/
  { path: 'friends', component: FriendsComponent },
  { path: 'events', component: EventsComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
