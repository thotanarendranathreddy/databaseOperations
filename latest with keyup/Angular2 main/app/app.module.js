"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
Object.defineProperty(exports, "__esModule", { value: true });
var Validation_Service_1 = require("./_services/Validation.Service");
var employee_service_1 = require("./_services/employee.service");
var core_1 = require("@angular/core");
var platform_browser_1 = require("@angular/platform-browser");
var http_1 = require("@angular/http");
var router_1 = require("@angular/router");
var app_component_1 = require("./app.component");
var controlmessages_component_1 = require("./component/controlmessages.component");
var getAll_component_1 = require("./component/getAll.component");
var home_component_1 = require("./component/home.component");
var routes_1 = require("./route/routes");
var forms_1 = require("@angular/forms");
var ng2_pagination_1 = require("ng2-pagination");
var AppModule = (function () {
    function AppModule() {
    }
    return AppModule;
}());
AppModule = __decorate([
    core_1.NgModule({
        imports: [
            ng2_pagination_1.Ng2PaginationModule,
            platform_browser_1.BrowserModule,
            http_1.HttpModule,
            router_1.RouterModule.forRoot(routes_1.rotes), forms_1.ReactiveFormsModule
        ],
        declarations: [
            app_component_1.AppComponent,
            home_component_1.HomeComponent,
            controlmessages_component_1.ControlMessagesComponent,
            getAll_component_1.GetAllComponent,
        ],
        providers: [
            employee_service_1.EmployeeService, Validation_Service_1.ValidationService
        ],
        bootstrap: [app_component_1.AppComponent]
    })
], AppModule);
exports.AppModule = AppModule;
//# sourceMappingURL=app.module.js.map