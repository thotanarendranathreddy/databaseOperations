import { EmployeeService } from '../_services/employee.service';
import { Component } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import * as _ from 'underscore';
import 'rxjs/add/operator/map'
@Component({
  selector: 'getall-list',
    moduleId: module.id,
  templateUrl: 'getAll.component.html'
})
export class GetAllComponent {
  status: string;
  status1:  string;
  showstatus_search:boolean=false;
  showpage : boolean=false;
  resdel: string;
  rescrt: string;
  resup: string;
  tableEnable:boolean=false;
  delpopup: number;
  uppopup: number;

  var1 : number;
  content : any[];
  firstbl : boolean;
  lastbl : boolean;          
     page : number;
     currentpage : number;
     lastpage: number;    
 
 constructor(private http: Http,private _employeeService: EmployeeService) { }

    // array of all items to be paged
    private allItems: any[];

   

    // paged items
    employee: any[];
   
  ongetAll(no: number) {
                this.showpage=true;     
                this.var1=no;              
                this.tableEnable=true;  
                this.page=0; 
                this.currentpage=this.page;                 
                this._employeeService.getEmployees(no,this.page)
                .subscribe(res => {  this.employee = (res.content)              
                  this.lastpage=res.totalPages-1;
                  this.firstbl=res.first;
                  this.lastbl=res.last;
                      });   
                      }
 
  num(){
     this.currentpage=this.currentpage+1;
    this._employeeService.getEmployees(this.var1,this.currentpage)
                .subscribe(res => {  this.employee = (res.content)              
                  this.lastpage=res.totalPages-1;
                  this.firstbl=res.first;
                  this.lastbl=res.last;
                      });   
    
  }
  first(){
                
                this.page=0; 
                this.currentpage=this.page;               
                this._employeeService.getEmployees(this.var1,this.page)
                .subscribe(res => {this.employee = (res.content)
                      this.lastpage=res.totalPages-1;
                      this.firstbl=res.first;
                      this.lastbl=res.last;
                      });   
    
  }
  last(){
    
    
    this.currentpage=this.lastpage;
    this._employeeService.getEmployees(this.var1,this.lastpage)
                .subscribe(res => {this.employee = (res.content)
                      this.lastpage=res.totalPages-1;
                      this.firstbl=res.first;
                      this.lastbl=res.last;
                      });  
  }
   
   next(){       
   this.currentpage=this.currentpage+1;
   this._employeeService.getEmployees(this.var1,this.currentpage)
    .subscribe(res => {this.employee = (res.content)
                      this.lastpage=res.totalPages-1;
                      this.firstbl=res.first;
                      this.lastbl=res.last;
          });   
        }
  
                      previous(){
                                             
                        this.currentpage=this.currentpage-1;
                        this._employeeService.getEmployees(this.var1,this.currentpage)
                      .subscribe(res => {this.employee = (res.content)
                        this.lastpage=res.totalPages-1;
                        this.firstbl=res.first;
                        this.lastbl=res.last;
                            });   
                      }
  
  
  onSearch(temp:string){            
                  this.tableEnable=true;
                 this.showstatus_search=!this.showstatus_search;
                this._employeeService.getEmp(temp)
                  .subscribe(resEmployeeData => {this.employee = (resEmployeeData)
                    if(this.employee.length==0){                      
                     this.status1 = 'Record not found';
                    }else{ this.status1 = ''; }
                  });
              }  
  
  onDelete(temp1:string){
                               
                  this._employeeService.delete(temp1)
                    .subscribe(resEmployeeData => this.resdel =resEmployeeData).add(()=>{this.ongetAll(this.var1)
   
                    });
                  
                }
  
  
                                            deletepopup(id1 : number){
                                              this.delpopup=id1;
                                                           }
                                            
                                            updatepopup(id2 : number){
                                              this.uppopup=id2;
                                            }
                                            
                                                cleardelpopup(){
                                                    this.resdel="";
                                                    }
                                                
                                                clearuppopup(){
                                                  this.resup="";
                                                }
                                                  clearcrtpopup(){
                                                    this.rescrt="";
                                                  }
  
  onCreate(id:string,name:string,salary:string,dept:string){
    console.log('created record');
    this._employeeService.createRow(id,name,salary,dept)
      .subscribe(resEmployeeData => this.rescrt = (resEmployeeData));
    
  }
 onUpdate(id1:string,name1:string,salary1:string,dept1:string){
    console.log('created update');
    this._employeeService.update(id1,name1,salary1,dept1)
   .subscribe(resEmployeeData => this.resup=resEmployeeData).add(()=>{this.ongetAll(this.var1)
   });
    
  
  
  }
    
    
  }