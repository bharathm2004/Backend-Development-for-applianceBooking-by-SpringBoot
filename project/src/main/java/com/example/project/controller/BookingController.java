package com.example.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.example.project.model.Booking;
import com.example.project.services.BookingService;
@RestController
public class BookingController {
     @Autowired
    BookingService bs;

    //POST METHOD 
    @PostMapping("/Booking")
    public ResponseEntity<Booking> add(@RequestBody Booking b)
    {
        Booking obj = bs.addBooking(b);
        return new ResponseEntity<>(obj,HttpStatus.CREATED);
    }

    //GET METHOD
    @GetMapping("/getBooking")
    public ResponseEntity<List<Booking>> get()
    {
        return new ResponseEntity<>(bs.getBookingDetails(),HttpStatus.OK);
    }

    //GET BY SPECIFIC FIELD METHOD
    @GetMapping("/api/booking/{email}")
    public ResponseEntity<Booking> getemail(@PathVariable String email)
    {
        Booking obj = bs.getbyemail(email);
        if(obj!=null)
            return new ResponseEntity<>(obj,HttpStatus.OK);
        else    
            return new ResponseEntity<>(obj,HttpStatus.NOT_FOUND);
    }

    //UPDATE METHOD
    @PutMapping("api/booking/{email}")
    public ResponseEntity<Booking> put(@PathVariable("email") String email, @RequestBody Booking b)
    {
        if(bs.updateBooking(email, b)==true)
        {
            return new ResponseEntity<>(b,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    //DELETE METHOD
    @DeleteMapping("/api/deleteBooking/{email}")
    public ResponseEntity<Boolean> remove(@PathVariable("email") String email)
    {
        if(bs.deleteBooking(email)==true)
        {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }

    //SORT METHOD
    @GetMapping("/sortBy/{email}")
    public List<Booking> g(@PathVariable String email)
    {
        return bs.sort(email);
    }

    //PAGINATION METHOD
    @GetMapping("/booking/{offset}/{pagesize}")
    public List<Booking> get(@PathVariable int offset,@PathVariable int pagesize)
    {
        return bs.page(pagesize,offset);
    }

    //SORTING AND PAGINATION METHOD
    @GetMapping("/booking/{offset}/{pagesize}/{email}")
    public List<Booking> getsorting(@PathVariable int offset,@PathVariable int pagesize,@PathVariable String email)
    {
        return bs.getsort(offset,pagesize,email);
    }

    //SELECT QUERY METHOD
    @GetMapping("select/query/{email}/{name}")
	public List <Booking> displayAll(@PathVariable String email, @PathVariable String name){
		return bs.getDetails(email,name);
	}

    //DELETE QUERY METHOD
    @DeleteMapping("/delete/query/{email}")
	public String deleteeInfo(@PathVariable String email){
		return bs.deletebookingdetails(email)+" Deleted";
	}

    //UPDATE QUERY METHOD
    @PutMapping("/update/query/{newemail}/{email}")
	public String updateeInfo(@PathVariable("newemail") String newemail,@PathVariable("email") String email){
		return bs.updateempdetails(newemail,email)+"Updated";
	}
}
