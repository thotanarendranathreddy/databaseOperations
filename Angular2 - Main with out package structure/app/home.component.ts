import {Component} from '@angular/core';
import { EmployeeService } from './employee.service';
@Component({
moduleId: module.id,
selector:'home',
templateUrl: 'home.component.html',
providers: [EmployeeService]
})

export class HomeComponent{
	
}