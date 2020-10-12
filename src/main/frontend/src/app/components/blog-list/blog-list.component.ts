import { Component, OnInit } from '@angular/core';
import { RestService } from 'src/app/service/rest.service';

@Component({
  selector: 'app-blog-list',
  templateUrl: './blog-list.component.html',
  styleUrls: ['./blog-list.component.css']
})
export class BlogListComponent implements OnInit {

  blogs;

  constructor(private rest: RestService) { }

  ngOnInit(): void {
    this.rest.getBlogList().subscribe(res => {
      this.blogs = res;
    })
  }

  getDateString(timestamp) {
    let d = new Date(timestamp)
    return d.toLocaleString()
  }

}
