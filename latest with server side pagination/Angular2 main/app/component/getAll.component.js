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
var employee_service_1 = require("../_services/employee.service");
var core_1 = require("@angular/core");
var http_1 = require("@angular/http");
require("rxjs/add/operator/map");
var GetAllComponent = (function () {
    function GetAllComponent(http, _employeeService) {
        this.http = http;
        this._employeeService = _employeeService;
        this.showstatus_search = false;
        this.showpage = false;
        this.tableEnable = false;
    }
    GetAllComponent.prototype.ongetAll = function (no) {
        var _this = this;
        this.showpage = true;
        this.var1 = no;
        this.tableEnable = true;
        this.page = 0;
        this.currentpage = this.page;
        this._employeeService.getEmployees(no, this.page)
            .subscribe(function (res) {
            _this.employee = (res.content);
            _this.lastpage = res.totalPages - 1;
            _this.firstbl = res.first;
            _this.lastbl = res.last;
        });
    };
    GetAllComponent.prototype.num = function () {
        var _this = this;
        this.currentpage = this.currentpage + 1;
        this._employeeService.getEmployees(this.var1, this.currentpage)
            .subscribe(function (res) {
            _this.employee = (res.content);
            _this.lastpage = res.totalPages - 1;
            _this.firstbl = res.first;
            _this.lastbl = res.last;
        });
    };
    GetAllComponent.prototype.first = function () {
        var _this = this;
        this.page = 0;
        this.currentpage = this.page;
        this._employeeService.getEmployees(this.var1, this.page)
            .subscribe(function (res) {
            _this.employee = (res.content);
            _this.lastpage = res.totalPages - 1;
            _this.firstbl = res.first;
            _this.lastbl = res.last;
        });
    };
    GetAllComponent.prototype.last = function () {
        var _this = this;
        this.currentpage = this.lastpage;
        this._employeeService.getEmployees(this.var1, this.lastpage)
            .subscribe(function (res) {
            _this.employee = (res.content);
            _this.lastpage = res.totalPages - 1;
            _this.firstbl = res.first;
            _this.lastbl = res.last;
        });
    };
    GetAllComponent.prototype.next = function () {
        var _this = this;
        this.currentpage = this.currentpage + 1;
        this._employeeService.getEmployees(this.var1, this.currentpage)
            .subscribe(function (res) {
            _this.employee = (res.content);
            _this.lastpage = res.totalPages - 1;
            _this.firstbl = res.first;
            _this.lastbl = res.last;
        });
    };
    GetAllComponent.prototype.previous = function () {
        var _this = this;
        this.currentpage = this.currentpage - 1;
        this._employeeService.getEmployees(this.var1, this.currentpage)
            .subscribe(function (res) {
            _this.employee = (res.content);
            _this.lastpage = res.totalPages - 1;
            _this.firstbl = res.first;
            _this.lastbl = res.last;
        });
    };
    GetAllComponent.prototype.onSearch = function (temp) {
        var _this = this;
        this.tableEnable = true;
        this.showstatus_search = !this.showstatus_search;
        this._employeeService.getEmp(temp)
            .subscribe(function (resEmployeeData) {
            _this.employee = (resEmployeeData);
            if (_this.employee.length == 0) {
                _this.status1 = 'Record not found';
            }
            else {
                _this.status1 = '';
            }
        });
    };
    GetAllComponent.prototype.onDelete = function (temp1) {
        var _this = this;
        this._employeeService.delete(temp1)
            .subscribe(function (resEmployeeData) { return _this.resdel = resEmployeeData; }).add(function () {
            _this.ongetAll(_this.var1);
        });
    };
    GetAllComponent.prototype.deletepopup = function (id1) {
        this.delpopup = id1;
    };
    GetAllComponent.prototype.updatepopup = function (id2) {
        this.uppopup = id2;
    };
    GetAllComponent.prototype.cleardelpopup = function () {
        this.resdel = "";
    };
    GetAllComponent.prototype.clearuppopup = function () {
        this.resup = "";
    };
    GetAllComponent.prototype.clearcrtpopup = function () {
        this.rescrt = "";
    };
    GetAllComponent.prototype.onCreate = function (id, name, salary, dept) {
        var _this = this;
        console.log('created record');
        this._employeeService.createRow(id, name, salary, dept)
            .subscribe(function (resEmployeeData) { return _this.rescrt = (resEmployeeData); });
    };
    GetAllComponent.prototype.onUpdate = function (id1, name1, salary1, dept1) {
        var _this = this;
        console.log('created update');
        this._employeeService.update(id1, name1, salary1, dept1)
            .subscribe(function (resEmployeeData) { return _this.resup = resEmployeeData; }).add(function () {
            _this.ongetAll(_this.var1);
        });
    };
    return GetAllComponent;
}());
GetAllComponent = __decorate([
    core_1.Component({
        selector: 'getall-list',
        moduleId: module.id,
        templateUrl: 'getAll.component.html'
    }),
    __metadata("design:paramtypes", [http_1.Http, employee_service_1.EmployeeService])
], GetAllComponent);
exports.GetAllComponent = GetAllComponent;
//# sourceMappingURL=getAll.component.js.map