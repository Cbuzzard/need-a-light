import { MediaMatcher } from '@angular/cdk/layout';
import { ChangeDetectorRef, Component, HostListener, OnInit, ViewChild } from '@angular/core';
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

  mobileQuery: MediaQueryList;
  private _mobileQueryListener: () => void;

  @HostListener('window:scroll', ['$event']) 
  doSomething(event) {
    window.pageYOffset > this.sticky ? this.headerContainer.nativeElement.classList.add('onscroll') : this.headerContainer.nativeElement.classList.remove('onscroll')
  }

  showBurger() {

  }

  constructor(changeDetectorRef: ChangeDetectorRef, media: MediaMatcher, private router: Router) {
    this.mobileQuery = media.matchMedia('(max-width: 600px)');
    this._mobileQueryListener = () => changeDetectorRef.detectChanges();
    this.mobileQuery.addListener(this._mobileQueryListener);
  }

  ngOnInit(): void {
  }

  setSticky() {
    this.sticky = this.headerContainer.nativeElement.offsetTop;
  }

  navigate(location) {
    this.router.navigateByUrl('').then(res => this.router.navigate([''], { queryParams: { scroll: location } }));
  }

}
