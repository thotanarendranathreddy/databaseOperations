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
var http_1 = require("@angular/http");
require("rxjs/add/operator/map");
var EmployeeService = (function () {
    function EmployeeService(_http) {
        this._http = _http;
        this._url1 = 'http://localhost:8081/spring_Rest_jdbc/create/';
        this._url2 = 'http://localhost:8081/spring_Rest_jdbc/getEmployee/';
        this._url3 = 'http://localhost:8081/spring_Rest_jdbc/delete/';
        this._url4 = 'http://localhost:8081/spring_Rest_jdbc/update/';
        this._url5 = 'http://localhost:8081/spring_Rest_jdbc/getAll/';
    }
    EmployeeService.prototype.createRow = function (id, name, salary, dept) {
        var timestamp = new Date().getTime();
        var json = { "name": name, "salary": salary, "dept": dept };
        return this._http.post(this._url1 + timestamp, json).map(function (res) { return res.json(); });
    };
    EmployeeService.prototype.getEmp = function (temp) {
        var timestamp = new Date().getTime();
        console.log(temp);
        return this._http.get(this._url2 + temp + "/" + timestamp)
            .map(function (response) { return response.json(); });
    };
    EmployeeService.prototype.delete = function (temp1) {
        var timestamp = new Date().getTime();
        return this._http.get(this._url3 + temp1 + "/" + timestamp)
            .map(function (response) { return response.json(); });
    };
    EmployeeService.prototype.update = function (id1, name1, salary1, dept1) {
        var timestamp = new Date().getTime();
        var json = { "id": id1, "name": name1, "salary": salary1, "dept": dept1 };
        return this._http.post(this._url4 + timestamp, json).map(function (res) { return res.json(); });
    };
    EmployeeService.prototype.getEmployees = function (order) {
        console.log(order);
        var timestamp = new Date().getTime();
        return this._http.get(this._url5 + order + "/" + timestamp)
            .map(function (response) { return response.json(); });
    };
    return EmployeeService;
}());
EmployeeService = __decorate([
    core_1.Injectable(),
    __metadata("design:paramtypes", [http_1.Http])
], EmployeeService);
exports.EmployeeService = EmployeeService;
//# sourceMappingURL=employee.service.js.map