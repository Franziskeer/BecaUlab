import { Routes, RouterModule } from "@angular/router";
import { AppComponent } from './app.component';
import { ItemListComponent } from './item-list/item-list.component';
import { ComoQueraisComponent } from './como-querais/como-querais.component';

const routes: Routes = [
    { path: '', component: AppComponent },
    { path: 'item-list', component: ItemListComponent },
    { path: 'como-querais', component: ComoQueraisComponent }
];

export const routing = RouterModule.forRoot(routes);