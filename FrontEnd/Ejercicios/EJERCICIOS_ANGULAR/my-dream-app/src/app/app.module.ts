import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { ItemListComponent } from './item-list/item-list.component';
import { ItemListService } from './item-list/item-list.service';
import { HttpClientModule } from '@angular/common/http';
import { ComoQueraisComponent } from './como-querais/como-querais.component';
import { routing } from './app.routes';



@NgModule({
  declarations: [
    AppComponent,
    ItemListComponent,
    ComoQueraisComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    routing
  ],
  providers: [ItemListService],
  bootstrap: [AppComponent]
})

export class AppModule { }
