import { Component, HostListener, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  @ViewChild('headercontainer')
  headerContainer;
  sticky

  @HostListener('window:scroll', ['$event'])
  doSomething(event) {
    window.pageYOffset > this.sticky ? this.headerContainer.nativeElement.classList.add('onscroll') : this.headerContainer.nativeElement.classList.remove('onscroll')
  }

  constructor(private router: Router) { }

  ngOnInit(): void { }

  setSticky() {
    this.sticky = this.headerContainer.nativeElement.offsetTop;
  }

  navigate(location) {
    this.router.navigateByUrl('').then(res => this.router.navigateByUrl(location));
  }

}
