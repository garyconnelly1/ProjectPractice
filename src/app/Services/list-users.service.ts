import { Injectable } from '@angular/core';
import { User } from '../Models/user.model';
import { Worker } from '../Models/worker.model';
import { IUser } from '../Models/user.interface';
import { HttpClient, HttpHeaders  } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ListUsersService {

  constructor(private httpClient: HttpClient) { }

  base1 = "http://localhost:8080/users";
   base2 = "http://localhost:8080/workers";


// manually posting a user
  private postUser: User = {
   
    firstName: "Mong",
    lastName: "Connelly",
    age: 22,
    address:{
      //id: 5,
      line1: "Cloonena",
      line2: "Kilconnell",
      line3: "Ballinasloe",
      city: "Galway"

    }
  };

  

  //manually posting a worker
  private postWorker: Worker = {
    firstName: "Mong",
    lastName: "Clarke",
    age: 23,
    trade: "Mechanic",
    rating: 86,
     address:{
      //id: 5,
      line1: "Maree",
      line2: "Oranmore",
      line3: "Oranmore",
      city: "Galway"

    }

  };

  // manually posting a user
  private putUser: User = {
    id: 2,
    firstName: "MongLad",
    lastName: "Connelly",
    age: 22,
    address:{
      //id: 5,
      line1: "Cloonena",
      line2: "Kilconnell",
      line3: "Ballinasloe",
      city: "Galway"

    }
  };


//request users
  httpGetUsers(): Observable<User[]>{
    return this.httpClient.get<User[]>(this.base1);
  }

//request workers
   httpGetWorkers(): Observable<Worker[]>{
    return this.httpClient.get<Worker[]>(this.base2);
  }

//post a user
  httpPostUser(): Observable<User> {
    //configure a return
    return this.httpClient.post<User>(this.base1,this.postUser,{
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    });
  }

//post a worker
   httpPostWorker(): Observable<Worker> {
    //configure a return
    return this.httpClient.post<Worker>("http://localhost:8080/workers",this.postWorker,{
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    });
  }


  //put a user
 ///////////////////////////////not working
  httpPutUser(): Observable<void> {
    //configure a return
    return this.httpClient.put<void>(`${this.base1}/${this.putUser.id}`,this.putUser,{
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    });
  }
///////////////////////////////////////////

httpDeleteUser(id: number): Observable<void>{
  return this.httpClient.delete<void>(`${this.base1}/${id}`)
}



  
}
