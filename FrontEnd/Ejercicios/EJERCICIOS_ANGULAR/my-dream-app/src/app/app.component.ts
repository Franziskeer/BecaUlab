import { Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit {
  title: String = 'Tienda online';
  total: String = 'Esperando a que se pulse el botón...';

  ngOnInit() {
    setInterval( () => this.title += "e", 10000);
  }

  updateTotal(total: String) {
    this.total = total;
  }
}


