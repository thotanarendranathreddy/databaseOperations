import { EmployeeService } from '../_services/employee.service';
import {Component} from '@angular/core';

@Component({
moduleId: module.id,
selector:'home',
templateUrl: 'home.component.html',
providers: [EmployeeService]
})

export class HomeComponent{
	
}