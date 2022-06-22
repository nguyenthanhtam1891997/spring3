import {Component, OnInit} from '@angular/core';
import {ServiceAppService} from '../service-app.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  userName: string;

  constructor(private appService: ServiceAppService) {
    this.appService.getClickEvent().subscribe(() => {
      this.loadUserName();
    });
  }

  ngOnInit(): void {
    this.loadUserName();

  }

  loadUserName() {
    this.userName = localStorage.getItem('user');
    console.log(this.userName);
  }

}
