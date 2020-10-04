import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-logo',
  templateUrl: './logo.component.html',
  styleUrls: ['./logo.component.css']
})
export class LogoComponent implements OnInit {

  @Output()
  loaded = new EventEmitter<boolean>()

  constructor() { }

  ngOnInit(): void {
  }

  onLoaded() {
    this.loaded.emit(true);
  }

}
