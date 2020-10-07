import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ReCaptchaV3Service } from 'ng-recaptcha';
import {RestService} from '../../service/rest.service'

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {

  contactForm: FormGroup;

  constructor(private recaptchaV3Service: ReCaptchaV3Service, private formBuilder: FormBuilder, private rest: RestService, private _snackBar: MatSnackBar) {
    this.contactForm = this.formBuilder.group({
      email: ['', [Validators.email, Validators.required]],
      body: ['', [Validators.required]]
    })
  }

  ngOnInit(): void {
  }

  onSubmit(form, formDir) {
    this.recaptchaV3Service.execute('importantAction').subscribe((token) => {
      let emailDto = {
        email: form.email,
        body: form.body,
        recaptcha: token
      }
      this.rest.sendEmail(emailDto).subscribe((res: boolean) => {
        res ? this.onSuccess(formDir) : alert("error processing recaptcha");
      });
    });
  }

  onSuccess(formDir) {
    formDir.resetForm();
    this.contactForm.reset();
    this._snackBar.open("Email sent! We will get back to you shortly.", '', {duration: 5000})
  }



  getErrorMessage(field) {
    switch(field) {
      case 'email':
        if (this.contactForm.get(field).hasError('required')) return "required"
        if (this.contactForm.get(field).hasError('email')) return "must be email format"
        break;
      case 'body':
        if (this.contactForm.get(field).hasError('required')) return "required"
        break;
    }
  }

}
