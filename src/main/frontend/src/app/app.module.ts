import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AppComponent } from './app.component';
import { LoginButtonComponent } from './components/login-button/login-button.component';
import { HttpInterceptorService } from './service/http-interceptor.service';
import {MatMenuModule} from '@angular/material/menu';
import {MatIconModule} from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations'
import { AppRoutingModule } from './app-routing.module';
import { HomeComponent } from './components/home/home.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatListModule} from '@angular/material/list';
import {MatDividerModule} from '@angular/material/divider';
import {LayoutModule} from '@angular/cdk/layout';
import { PricingComponent } from './components/pricing/pricing.component';
import { LogoComponent } from './components/logo/logo.component';
import { SocialsComponent } from './components/socials/socials.component';
import { ContactComponent } from './components/contact/contact.component';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import { RECAPTCHA_V3_SITE_KEY, RecaptchaV3Module } from 'ng-recaptcha';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import { GalleryComponent } from './components/gallery/gallery.component';
import { AboutComponent } from './components/about/about.component';
import { MarkdownModule, MarkedOptions } from 'ngx-markdown';
import { AdminComponent } from './components/admin/admin.component';
import {MatProgressBarModule} from '@angular/material/progress-bar';
import {MatCardModule} from '@angular/material/card';
import { BlogComponent } from './components/blog/blog.component';
import { BlogListComponent } from './components/blog-list/blog-list.component';
import { SecurityContext } from '@angular/core';




@NgModule({
  declarations: [
    AppComponent,
    LoginButtonComponent,
    HomeComponent,
    NavBarComponent,
    PricingComponent,
    LogoComponent,
    SocialsComponent,
    ContactComponent,
    GalleryComponent,
    AboutComponent,
    AdminComponent,
    BlogComponent,
    BlogListComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    MatButtonModule,
    MatMenuModule,
    MatIconModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    MatSidenavModule,
    MatToolbarModule,
    MatListModule,
    MatDividerModule,
    LayoutModule,
    MatInputModule,
    MatFormFieldModule,
    RecaptchaV3Module,
    FormsModule,
    ReactiveFormsModule,
    MatSnackBarModule,
    MatProgressBarModule,
    MatCardModule,
    MarkdownModule.forRoot({
      sanitize: SecurityContext.NONE,
    }),

  ],
  providers: [
    {provide: HTTP_INTERCEPTORS, useClass: HttpInterceptorService, multi: true},
    { provide: RECAPTCHA_V3_SITE_KEY, useValue: '6LcFJdQZAAAAACr-6R34kCTXuYysHG7WUYLOEi8P' }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
