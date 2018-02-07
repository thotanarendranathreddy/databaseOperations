import { EmployeeService } from '../_services/employee.service';
import { PagerService } from '../_services/pager.service';
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
 constructor(private http: Http, private pagerService: PagerService,private _employeeService: EmployeeService) { }

    // array of all items to be paged
    private allItems: any[];

    // pager object
    pager: any = {};

    // paged items
    pagedItems: any[];
var1:string;
  onOrder(order:string) {
                       this.var1=order;
                        this.tableEnable=true;
                      this._employeeService.getEmployees(order)
                          .subscribe(data => {
                              // set items to json response
                              this.allItems = data;              
                              // initialize to page 1
                              this.setPage(1);
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
                    .subscribe(resEmployeeData => this.resdel =resEmployeeData).add(()=>{this.onOrder(this.var1)
   
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
   .subscribe(resEmployeeData => this.resup=resEmployeeData).add(()=>{this.onOrder(this.var1)
   });
    
  
  
  }
  setPage(page: number) {
        if (page < 1 || page > this.pager.totalPages) {
            return;
        }

        // get pager object from service
        this.pager = this.pagerService.getPager(this.allItems.length, page);

        // get current page of items
        this.pagedItems = this.allItems.slice(this.pager.startIndex, this.pager.endIndex + 1);
    }
    
    
  }