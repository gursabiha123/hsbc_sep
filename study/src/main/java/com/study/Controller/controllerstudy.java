package com.study.Controller;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.study.DAO.StudydaoInterface;
import com.study.entity.Instausers;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
//@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin",origins = "*")
public class controllerstudy {

		//to run google->advanced rest client->frst link->add to chrome->url http://localhost:8080/listEmployee.htm, try with get,post,put..
		//@RequestMapping("listemployee.htm")//anything can have/not have extension ,localhost:8080/.. this name.. should be what u write here
		//@RequestMapping(value="listEmployee.htm",method=RequestMethod.GET)
	
	@Autowired
	private StudydaoInterface daointerface;
	
		@GetMapping("/listviews.htm")
		public List<Instausers> ll(){
		
			System.out.println("views");
			//return 
			return daointerface.viewAllprofiledao();
		}
		
		   @PostMapping("/listcreate.h")
		    public Instausers createTodo(@Validated @RequestBody Instausers todo) {
			   System.out.println("\t name is" +todo.getName()+"\t email is"+todo.getEmail()+"\t passwrd is"+todo.getPassword());
		        return daointerface.createProfileDAO(todo);
		    }
		   
		   @CrossOrigin(origins = "*", allowedHeaders = "*")
		   @PutMapping(value="/listupdat.ht/{email}")
		   
		    public ResponseEntity<Instausers>  updateTodo(@PathVariable("email") String email,
		                                           @Validated @RequestBody Instausers todo) {
			   System.out.println("viewsput");
			   Instausers u=null;
				u=new Instausers();
			    u= daointerface.updateProfileDAO(todo);
			    return new ResponseEntity<>(u, HttpStatus.OK);
		    }
		   @DeleteMapping(value="/listdel.h/{email}")
		    public void deleteTodo(@PathVariable("email") String email) {
			   daointerface.deleteProfileDAO(email); 
		    }
		   
	
}
