import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../../services/login.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrl: './admin.component.css'
})
export class AdminComponent {
  email: string = 'admin@admin.com';
  password: string = 'admin';

  constructor(private authService: LoginService, private router: Router) {}

  onSubmit(): void {
    if (this.authService.login(this.email, this.password)) {
      this.router.navigate(['/admin-panel']);
    } else {
      alert('Invalid credentials. Please try again.');
    }
  }
  

}
