import { Component, OnInit, Input, Output, EventEmitter, OnChanges, SimpleChange, SimpleChanges } from '@angular/core';
import { Item } from '../item.model'
import { ItemListService } from './item-list.service';

@Component({
  selector: 'app-item-list',
  templateUrl: './item-list.component.html',
  styleUrls: ['./item-list.component.css']
})

export class ItemListComponent implements OnInit, OnChanges {
  myItems: Item[];
  @Input() mensaje: String;
  @Output() total: EventEmitter<String> = new EventEmitter<String>();

  constructor(private itemListService: ItemListService) { }

  ngOnChanges(changes: SimpleChanges): void {
    console.log(this.mensaje);
  }

  ngOnInit() {
    this.itemListService.getItemList()
      .subscribe( (data: Item[]) => 
                  this.myItems = data,
                  error => console.log(error), 
                  () => console.log("My item list is loaded"));
  }

  selectItem(item: Item, myItems: Item[]) {
    myItems.forEach(element => {
      if (item === element) {
        element.selected = true;
      } else {
        element.selected = false;
      }
    });
  }

  sendEventTotal() {
    this.total.emit("There are " + this.myItems.length + " diferent items.")
  }

  upQuantity(item: Item) {
    if (item.stock > 0) {
      item.quantity++;
      item.stock--;
    }
  }

  downQuantity(item: Item) {
    if (item.quantity > 0) {
      item.quantity--;
      item.stock++;
    }
  }
}
