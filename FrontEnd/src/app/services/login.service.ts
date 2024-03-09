import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private readonly validEmail = 'admin@admin.com';
  private readonly validPassword = 'admin';

  isAuthenticated = false;

  login(email: string, password: string): boolean {
    if (email === this.validEmail && password === this.validPassword) {
      this.isAuthenticated = true;
      return true;
    }
    return false;
  }

  logout(): void {
    this.isAuthenticated = false;
  }

  constructor() { }
}
