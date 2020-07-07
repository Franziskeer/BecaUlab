import { Injectable } from '@angular/core';
import { Item } from '../item.model';
//import { ITEMS } from './mocks'
import { HttpClient, HttpHeaders } from '@angular/common/http'

@Injectable()
export class ItemListService {

  constructor(private http: HttpClient) { }
  
  getItemList() {
    return this.http.get('http://localhost:3000/item-list');
  }
  
}
