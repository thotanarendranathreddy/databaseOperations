import { EmployeeService } from '../_services/employee.service';
import { Component } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
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
  resdel: string;
  rescrt: string;
  resup: string;
  tableEnable:boolean=false;
  delpopup: number;
  uppopup: number;
 constructor(private http: Http,private _employeeService: EmployeeService) { }

    // array of all items to be paged
    private allItems: any[];

    // pager object
    pager: any = {};

    // paged items
    pagedItems: any[];
  var1:string;
  var2: number;
  onOrder(order:string,no: number) {
                       this.var1=order;
                       this.var2=no;                 
                        this.tableEnable=true;
                      this._employeeService.getEmployees(order)
                          .subscribe(resEmployeeData => {this.pagedItems = (resEmployeeData)
                              
                          });
                  }
  onSearch(temp:string){            
                  this.tableEnable=true;
                 this.showstatus_search=!this.showstatus_search;
                this._employeeService.getEmp(temp)
                  .subscribe(resEmployeeData => {this.pagedItems = (resEmployeeData)
                    if(this.pagedItems.length==0){
                      
                     this.status1 = 'Record not found';
                    }else{ this.status1 = ''; }
                  });
              }  
  
  onDelete(temp1:string){
                               
                  this._employeeService.delete(temp1)
                    .subscribe(resEmployeeData => this.resdel =resEmployeeData).add(()=>{this.onOrder(this.var1,this.var2)
   
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
   .subscribe(resEmployeeData => this.resup=resEmployeeData).add(()=>{this.onOrder(this.var1,this.var2)
   });
    
  
  
  }
    
    
  }