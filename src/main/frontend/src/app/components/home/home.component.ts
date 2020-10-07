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

  constructor(private route: ActivatedRoute) { }

  ngAfterViewInit(): void {
    console.log("other")
    this.route.queryParams.subscribe(params => {
      this.scroll(params.scroll);
    });
  }

  scroll(location) {
    switch(location) {
      case 'pricing':
        this.pricing.nativeElement.scrollIntoView({behavior: "smooth"});
        break;
      case 'contact':
        this.contact.nativeElement.scrollIntoView({behavior: "smooth"});
        break;
      case 'gallery':
        this.gallery.nativeElement.scrollIntoView({behavior: "smooth"});
        break;
      case 'about':
        this.about.nativeElement.scrollIntoView({behavior: "smooth"});
        break;
      default:
    }
  }

}
