import {Component, OnInit} from '@angular/core';
import {LoginService} from '../login.service';
import {Router} from '@angular/router';
import {MatSnackBar} from '@angular/material/snack-bar';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Observable, Subject} from 'rxjs';
import {ServiceAppService} from '../../service-app.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  loginForm = new FormGroup({
    email: new FormControl('', [Validators.required]),
    password: new FormControl('', [Validators.required])
  });


  constructor(private loginService: LoginService,
              private router: Router,
              private snackBar: MatSnackBar,
              private appService: ServiceAppService) {
  }

  ngOnInit(): void {
  }


  signIn() {
    if (!this.loginForm.invalid) {
      this.loginService.loginAccount(this.loginForm.value).subscribe((data) => {
        console.log(data);
        localStorage.setItem('user', data.userName);
        localStorage.setItem('token', data.token);
        this.router.navigateByUrl('');
        this.appService.sendClickEvent();
      });
    }
  }
}
