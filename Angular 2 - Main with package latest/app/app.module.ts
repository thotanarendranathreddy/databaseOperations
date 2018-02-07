﻿﻿﻿﻿﻿﻿﻿import { ValidationService } from './_services/Validation.Service';
import { EmployeeService } from './_services/employee.service';
import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpModule } from '@angular/http';
import { RouterModule } from '@angular/router';
import { AppComponent }  from './app.component';
import { PagerService } from './_services/index';
import { ControlMessagesComponent } from './component/controlmessages.component';
import { GetAllComponent } from './component/getAll.component';
import { HomeComponent } from './component/home.component';
import { rotes } from './route/routes';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
@NgModule({
    imports: [
        BrowserModule,
        HttpModule,
		RouterModule.forRoot(rotes),ReactiveFormsModule
    ],
    declarations: [
    AppComponent,
		HomeComponent,
    ControlMessagesComponent,
		GetAllComponent,
       
    ],
    providers: [
        PagerService,EmployeeService,ValidationService
    ],
    bootstrap: [AppComponent]
})

export class AppModule { }