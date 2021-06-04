import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  loginUrl = 'http://localhost:8080/login';

  constructor(private http: HttpClient) { }

  login(username, password): Observable<any> {
    return this.http.post(this.loginUrl, {username, password});
  }
}
