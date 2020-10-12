import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UrlService } from './url.service';

@Injectable({
  providedIn: 'root'
})
export class RestService {

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  constructor(private url: UrlService, private http: HttpClient) {}

  sendEmail(emailDto) {
    return this.http.post(`${this.url.backend}/email`, emailDto, this.httpOptions)
  }

  uploadImage(image) {
    return this.http.post(`${this.url.backend}/rest/upload`, image, {
      reportProgress: true,
      observe: 'events'
    })
  }

  postBlog(blogPostDto) {
    return this.http.post(`${this.url.backend}/rest/blog`, blogPostDto, {
      reportProgress: true,
      observe: 'events',
    })
  }

  getBlog(slug) {
    return this.http.get(`${this.url.backend}/rest/blog/${slug}`)
  }

  getBlogList() {
    return this.http.get(`${this.url.backend}/rest/blog`)
  }

}
