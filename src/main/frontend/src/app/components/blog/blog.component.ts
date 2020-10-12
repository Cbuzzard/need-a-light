import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { RestService } from 'src/app/service/rest.service';

@Component({
  selector: 'app-blog',
  templateUrl: './blog.component.html',
  styleUrls: ['./blog.component.css']
})
export class BlogComponent implements OnInit {

  blog;

  constructor(private rest: RestService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.params.subscribe(param => {
      console.log(param)
      this.rest.getBlog(param.slug).subscribe(res =>{
        this.blog = res;
        console.log(this.blog.content)
      })
    })
  }

  getDateString(timestamp) {
    let d = new Date(timestamp)
    return d.toLocaleString()
  }

}
