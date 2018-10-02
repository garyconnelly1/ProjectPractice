import { Component, OnInit } from '@angular/core';
import { User } from '../Models/user.model';
import { Worker } from '../Models/worker.model';
import { ListUsersService } from '../Services/list-users.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

// instances of required objects
  users: User[];
  workers: Worker[];

  constructor(private _userService: ListUsersService) {
   }

  ngOnInit() {
   // this.users = this._userService.getUsers();
   this._userService.httpGetUsers().subscribe(data => this.users = data);

    this._userService.httpGetWorkers().subscribe(data => this.workers = data);

}//end oninit



//method to post users
postUser(){
  
   this._userService.httpPostUser().subscribe((data: User) => {
      console.log(data);
    });
    
    console.log("post user");
}//

//method to post worker
postWorker(){
  
   this._userService.httpPostWorker().subscribe((data: Worker) =>
       {
         console.log(data);
       });
       
      console.log("post worker");
}


//delete method
deleteUser(){
  
  this._userService.httpDeleteUser(2).subscribe(
    () => console.log("user deleted")
  );
  
  //console.log("inside delete");
}




/////////////////////////////////////////////
sayHello(){
 //httpPutUser
  this._userService.httpPutUser().subscribe(
    () => {
      console.log("test put");
    }
  );
  
}
///////////////////////////////////////////////


}
