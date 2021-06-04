import {Component, OnInit} from '@angular/core';
import {AppService} from '../app.service';
import {Router} from '@angular/router';
import {MatSnackBar} from '@angular/material';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  public name;
  public username;
  public password;
  public confirmPassword;
  private  profilePic = 'https://image.flaticon.com/icons/png/512/17/17797.png';


  constructor(
    private service: AppService, // services for BE calls
    private router: Router, // page routing system - navigation (after correct credentials for login -> home)
    public snackBar: MatSnackBar // pop-ups in current page ( login successful )
  ) {
  }

  ngOnInit() {
    this.name = '';
    this.username = ''; // init inputs - empty strings
    this.password = '';
    this.confirmPassword = '';
  }

  register() {
    //check if the username already exists
    this.password === this.confirmPassword ?
      this.openSnackBar('Register successful!', '') :
      this.openSnackBar('Register failed!', '');
    /*this.service.register(this.name, this.username, this.password) // register function inside service
      .subscribe(res => { // returns Observable 1.response  function(success, error)
        this.openSnackBar('Register successful!', '');
        this.router.navigate(['overview']);
      }, err => {
        this.openSnackBar('Wrong selected fields', '');
      });*/
  }

  openSnackBar(message: string, action: string) {
    this.snackBar.open(message, action, {
      duration: 2000,
      direction: 'ltr',
      horizontalPosition: 'end',
      verticalPosition: 'bottom'
    });
  }

}
