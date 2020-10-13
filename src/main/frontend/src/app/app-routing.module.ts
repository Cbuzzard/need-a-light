import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './components/about/about.component';
import { AdminComponent } from './components/admin/admin.component';
import { BlogListComponent } from './components/blog-list/blog-list.component';
import { BlogComponent } from './components/blog/blog.component';
import { ContactComponent } from './components/contact/contact.component';
import { GalleryComponent } from './components/gallery/gallery.component';
import { HomeComponent } from './components/home/home.component';
import { PricingComponent } from './components/pricing/pricing.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'admin', component: AdminComponent },
  { path: 'blog', component: BlogListComponent},
  { path: 'pricing', component: PricingComponent},
  { path: 'contact', component: ContactComponent},
  { path: 'about', component: AboutComponent},
  { path: 'gallery', component: GalleryComponent},
  { path: ':slug', component: BlogComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(
    routes,
    { scrollPositionRestoration: 'enabled',
    })],
  exports: [RouterModule]
})
export class AppRoutingModule { }