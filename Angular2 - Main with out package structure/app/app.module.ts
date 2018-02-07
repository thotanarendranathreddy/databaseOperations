﻿﻿﻿﻿﻿﻿﻿import { ValidationService } from './_services/Validation.Service';
import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpModule } from '@angular/http';
import { rotes } from './routes';
import { RouterModule } from '@angular/router';
import { AppComponent }  from './app.component';
import { PagerService } from './_services/index';
import { ControlMessagesComponent } from './controlmessages.component';
import { EmployeeService } from './employee.service';
import {HomeComponent} from'./home.component';
import { GetAllComponent } from './getAll.component';
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