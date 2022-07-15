import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {LoginAccount} from '../login/model/login-account';
import {UserToken} from '../login/dto/user-token';
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class HomeService {

  private readonly token = localStorage.getItem('token');
  private readonly header = {
    'content-type': 'application/json',
    'Authorization': `Bearer${this.token}`
  };
  private readonly URL_BE = 'http://localhost:8080/api/user/';

  constructor(private  http: HttpClient) {
  }

  // checkLogin() {
  //   console.log('aaaaaaaaaaaaaaaaaa');
  //   console.log(this.header);
  //   return this.http.post<any>(`${this.URL_BE}delete`, null, {headers: this.header})
  //
  // }

  checkLogin() {
    console.log('aaaaaaaaaaaaaaaaaa');
    console.log(this.header);
    return this.http.get<any>(`${this.URL_BE}getListBook`, {headers: this.header})

  }

}
