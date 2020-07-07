import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

//hola
@Injectable({
  providedIn: 'root'
})
export class FriendsService {

  constructor(private http: HttpClient) { }
  
  getAllFriends() {
    return this.http.get('http://localhost:8080/users/{id}/friendsRelationship');
  }
  getAllPending() {
    return this.http.get('http://localhost:8080/users/{id}/pendingRelationship');
  }
  updateRelationship() {
    return this.http.get('http://localhost:8080/users/Relationship/{id}');
  }
  getUserId(){
    return this.http.get('http://localhost:8080/users/{id}');
  }
  getFullUserId(){
    return this.http.get('http://localhost:8080/users/fullUser/{id}');
  }
  deleteUser(){
    return this.http.get('http://localhost:8080/users/Relationship/{id}');
  }
  postPending(){
    return this.http.get('http://localhost:8080/users/{id}/inviteFriend');
  }
  getUserPending(){
    return this.http.get('http://localhost:8080/users/{id}/pendingRelationship');
  }
}
