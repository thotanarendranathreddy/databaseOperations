﻿﻿import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
﻿﻿﻿﻿﻿﻿﻿import { ValidationService } from './_services/Validation.Service';
@Component({
    moduleId: module.id,
    selector: 'app',
    templateUrl: 'app.component.html'
})

export class AppComponent { 
error='';
loginform:any;
user:string="user";
pasword:string="user";
  show:boolean=false;
  constructor(private formBuilder: FormBuilder){
    this.loginform = this.formBuilder.group({
        'username': ['', Validators.required],
        'pwd':['',Validators.required]
      });
    
  }
  clickfunction(us:string,pw:string){
    if(this.loginform.dirty&&this.loginform.valid){
      if((us==this.user)&&(pw==this.pasword)){
          this.show=!this.show;
          console.log(status);
        }
        else{
          this.error = 'Username or password is incorrect';
          console.log(status);
        }
    }
 
}
  
}