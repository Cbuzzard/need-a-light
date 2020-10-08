import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements AfterViewInit {

  @ViewChild('pricing')
  pricing;

  @ViewChild('contact')
  contact;

  @ViewChild('gallery')
  gallery;

  @ViewChild('about')
  about;

  constructor() { }

  ngAfterViewInit(): void { }

}
