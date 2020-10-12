import { HttpEventType } from '@angular/common/http';
import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { map } from 'rxjs/operators';
import { RestService } from 'src/app/service/rest.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  @ViewChild("fileUpload", {static: false}) 
  fileUpload: ElementRef;
  blogForm: FormGroup;
  fileProgress;
  file;
  adminStatus;

  constructor(private rest: RestService, private formBuilder: FormBuilder, private user: UserService) {
    this.blogForm = this.formBuilder.group({
      title: ['', [Validators.required]],
      slug: ['', [Validators.required]],
      content: ['', [Validators.required]]
    })
    this.user.adminStatus.subscribe(res => this.adminStatus = res);
  }

  ngOnInit(): void { }

  onSelectImage() {
    const fileUpload = this.fileUpload.nativeElement;
    fileUpload.onchange = () => { 
      this.file = fileUpload.files[0]; 
    };
    fileUpload.click();
  }

  onSubmit(form) {
    const blogPostDto = new FormData();  
    this.file ? blogPostDto.append('image', this.file) : blogPostDto.append('image', null);
    blogPostDto.append('title', form.title);
    blogPostDto.append('slug', form.slug);
    blogPostDto.append('content', form.content);
    this.rest.postBlog(blogPostDto).pipe(map((event => {
      switch (event.type) {  
        case HttpEventType.UploadProgress:  
          this.fileProgress = Math.round(event.loaded * 100 / event.total);
          break;  
        case HttpEventType.Response:  
          return event;  
      }
    }))).subscribe(res => console.log(res));
  }

}
