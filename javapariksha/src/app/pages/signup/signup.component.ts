import { Component } from '@angular/core';
import { UserService } from '../../services/user.service';
import { catchError, of } from 'rxjs';
import { MatSnackBar } from '@angular/material/snack-bar';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.css'
})
export class SignupComponent {


  public user={
    firstname:"",
    lastname:"",
    email:"",
    mobilenumber:"",
    password:""
  }

  constructor(private userService:UserService, private snackbar:MatSnackBar){}

  ngOnInit():void{}

  userRegFormSubmit() {
    if (this.user.firstname === '' || this.user.firstname === null) {
      this.snackbar.open("First name is required","",{
        duration:3000,
        verticalPosition:'top',
        horizontalPosition:'right'
      })
      return;
    } else if (this.user.lastname === '' || this.user.lastname === null) {
      this.snackbar.open("Last name is required","",{
        duration:3000,
        verticalPosition:'top',
        horizontalPosition:'right'
      })
      return;
    } else if (this.user.email === '' || this.user.email === null) {
      this.snackbar.open("Email is required","",{
        duration:3000,
        verticalPosition:'top',
        horizontalPosition:'right'
      })
      return;
    }
    else if (this.user.mobilenumber === '' || this.user.mobilenumber === null) {
      this.snackbar.open("Mobile number is required","",{
        duration:3000,
        verticalPosition:'top',
        horizontalPosition:'right'
      })
      return;
    }
    else if (this.user.password === '' || this.user.password === null) {
      this.snackbar.open("Password is required","",{
        duration:3000,
        verticalPosition:'top',
        horizontalPosition:'right'
      })
      return;
    }
  
    this.userService.addUser(this.user).pipe(
      catchError((error) => {
        alert("Oops something went wrong");
        // Use 'of' to return a new Observable after catching an error
        return of(null); // You might want to return an empty observable or some error indicator
      })
    ).subscribe(
      (data) => {
        if (data) {
          Swal.fire("success","User Created successfully, please login","success");
          console.log(data);          
        }
      }
    );
  }
}

