import { Injectable } from '@angular/core';
import {Observable, Subject} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServiceAppService {

  constructor() { }
  private subject = new Subject<any>();

  sendClickEvent() {
    this.subject.next();
  }
  getClickEvent(): Observable<any>{
    return this.subject.asObservable();
  }
}
