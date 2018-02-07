"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = require("@angular/core");
var forms_1 = require("@angular/forms");
var AppComponent = (function () {
    function AppComponent(formBuilder) {
        this.formBuilder = formBuilder;
        this.error = '';
        this.user = "user";
        this.pasword = "user";
        this.show = false;
        this.loginform = this.formBuilder.group({
            'username': ['', forms_1.Validators.required],
            'pwd': ['', forms_1.Validators.required]
        });
    }
    AppComponent.prototype.clickfunction = function (us, pw) {
        if (this.loginform.dirty && this.loginform.valid) {
            if ((us == this.user) && (pw == this.pasword)) {
                this.show = !this.show;
                console.log(status);
            }
            else {
                this.error = 'Username or password is incorrect';
                console.log(status);
            }
        }
    };
    return AppComponent;
}());
AppComponent = __decorate([
    core_1.Component({
        moduleId: module.id,
        selector: 'app',
        templateUrl: 'app.component.html'
    }),
    __metadata("design:paramtypes", [forms_1.FormBuilder])
], AppComponent);
exports.AppComponent = AppComponent;
//# sourceMappingURL=app.component.js.map