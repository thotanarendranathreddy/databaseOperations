import {Injectable} from '@angular/core';
import { Http,Response } from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class EmployeeService{
  
  private _url1:string='http://localhost:8081/spring_Rest_jdbc/create/';
  private _url2:string='http://localhost:8081/spring_Rest_jdbc/getEmployee/';
  private _url3:string='http://localhost:8081/spring_Rest_jdbc/delete/';
  private _url4:string='http://localhost:8081/spring_Rest_jdbc/update/';
  private _url5:string='http://localhost:8081/spring_Rest_jdbc/getAll/';
  constructor(private _http:Http){}

createRow(id:string,name:string,salary:string,dept:string) {
	var timestamp=new Date().getTime();
    var json ={"name":name,"salary":salary,"dept":dept};
    return this._http.post(this._url1+timestamp, json).map((res: Response) => res.json());
  }
 getEmp(temp:string)
  {
   var timestamp=new Date().getTime();
 console.log(temp);
    return this._http.get(this._url2+temp+"/"+timestamp)
      .map((response:Response) => response.json())

  }
  
 delete(temp1:string)
  {
	 var timestamp=new Date().getTime();
  return this._http.get(this._url3+temp1+"/"+timestamp)
      .map((response:Response) => response.json())

  }
 update(id1:string,name1:string,salary1:string,dept1:string) {
	 var timestamp=new Date().getTime();
    var json ={"id":id1,"name":name1,"salary":salary1,"dept":dept1};
    return this._http.post(this._url4+timestamp, json).map((res: Response) => res.json());
  }
  
  getEmployees(order:string)
  {
     console.log(order);
	  var timestamp=new Date().getTime();
    return this._http.get(this._url5+order+"/"+timestamp)
      .map((response:Response) => response.json());

  }

}
