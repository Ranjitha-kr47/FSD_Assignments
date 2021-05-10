import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';
import {Employee} from'../employee';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {

  employee: Employee = new Employee();
  submitted = false;

  title = 'Angular Form Validation Tutorial';
   angForm: FormGroup;
   
    
   

  constructor(private employeeService: EmployeeService,
    private router: Router) {
      
    }
    
    
     

    ngOnInit():void{}
    // ngOnInit(): void {
    //   this.employee.firstName = new FormGroup({
    //     name: new FormControl(this.employee.firstName, [
    //       Validators.required,
    //        // <-- Here's how you pass in the custom validator.
    //     ]),
    //     // alterEgo: new FormControl(this.employee.alterEgo),
    //     // power: new FormControl(this.employee.power, Validators.required)
    //   });
    
    // }
    
    // get name() { return this.employee.firstName.get('firstName'); }
    
    // get power() { return this.employee.firstName.get('power'); }

  newEmployee(): void {
    this.submitted = false;
    this.employee = new Employee();
  }

  save() {
    this.employeeService
    .createEmployee(this.employee).subscribe(data => {
      console.log(data)
      this.employee = new Employee();
      this.gotoList();
    }, 
    error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/employees']);
  }

}
