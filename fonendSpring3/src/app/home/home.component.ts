import {Component, OnInit} from '@angular/core';
import {LoginService} from '../login/login.service';
import {Router} from '@angular/router';
import {MatSnackBar} from '@angular/material/snack-bar';
import {ServiceAppService} from '../service-app.service';
import {HomeService} from './home.service';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private homeService: HomeService,
              private router: Router,
              private snackBar: MatSnackBar,
              private appService: ServiceAppService) {
  }

  ngOnInit(): void {

  }

  checkLogin() {
    this.homeService.checkLogin().subscribe((data) => {
      console.log(data);
    }, (error) => {
      console.log(error);
    });
  }
}
