import { HttpEventType, HttpErrorResponse } from '@angular/common/http';
import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { of } from 'rxjs';
import { map, catchError } from 'rxjs/operators';
import { RestService } from 'src/app/service/rest.service';

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

  constructor(private rest: RestService, private formBuilder: FormBuilder) {
    this.blogForm = this.formBuilder.group({
      slug: ['', [Validators.required]],
      content: ['', [Validators.required]]
    })
  }

  ngOnInit(): void {
  }

  onClick() {
    const fileUpload = this.fileUpload.nativeElement;
    fileUpload.onchange = () => { 
      this.file = fileUpload.files[0]; 
      this.uploadFile(this.file);  
    };
    fileUpload.click();
  }

  uploadFile(file) {  
    const image = new FormData();  
    image.append('file', file);  
    file.inProgress = true;  
    this.rest.uploadImage(image).pipe(  
      map((event: any) => {
        switch (event.type) {  
          case HttpEventType.UploadProgress:  
            file.progress = Math.round(event.loaded * 100 / event.total);  
            this.fileProgress = file.progress;
            console.log(file.progress)
            break;  
          case HttpEventType.Response:  
            return event;  
        }  
      }),  
      catchError((error: HttpErrorResponse) => {  
        file.inProgress = false;  
        return of(`${file.data.name} upload failed.`);  
      })).subscribe((event: any) => {  
      });  
  }

  onSubmit(form) {
    console.log(`${form.slug} : ${form.content}`)
  }

  getErrorMessage(field) {

  }

}
