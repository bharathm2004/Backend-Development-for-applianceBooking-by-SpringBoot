package com.example.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.*;
import com.example.project.Repository.BookingRepo;
import com.example.project.model.Booking;

@Service
public class BookingService {
    @Autowired
    BookingRepo br;

    //POST FUNCTION 
    public Booking addBooking(Booking b)
    {
        if(b!=null)
        return br.save(b);
        else
        {
        throw new IllegalArgumentException();
        }
    }

    //GET FUNCTION 
    public List<Booking> getBookingDetails()
    {
        return br.findAll();
    }

    //GET BY SPECIFIC FIELD
    public Booking getbyemail(String email)
    {
        return br.findById(email).orElse(null);
    }

    //UPDATE FUNCTION 
    public Booking getemail(String email)
    {
        return br.findById(email).orElse(null);
    }
    public Boolean updateBooking(String email,Booking b)
    {
        if(this.getemail(email)==null)
        {
            return false;
        }
        try
        {
            br.save(b);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }

    //DELETE FUNCTION 
    public Boolean deleteBooking(String email)
    {
        if(this.getemail(email)== null)
        {
            return false;
        }
        br.deleteById(email);
        return true;
    }

    //SORTING FUNCTION 
    public List<Booking> sort(String email)
    {
        Sort sort=Sort.by(Sort.Direction.ASC,email);
        return br.findAll(sort);
    }

    //PAGINATION FUNCTION 
    public List<Booking> page(int pageSize,int pageNumber)
    {
        Pageable page=PageRequest.of(pageNumber, pageSize);
        return br.findAll(page).getContent();
    }

    //PAGINATION AND SORTING FUNCTION 
    public List<Booking> getsort(int pageNumber,int pageSize,String email)
    {         
         return br.findAll(PageRequest.of(pageNumber, pageSize).withSort(Sort.by(Sort.Direction.ASC,email))).getContent();
    }

    //SELECT QUERY FUNCTION 
    public List <Booking> getDetails(String email, String name){
        return br.findByEmailOrName(email,name);
    }

    //DELETE QUERY FUNCTION 
    public Integer deletebookingdetails(String email){
		return br.deleteBookingInfo(email);
	}

    //UPDATE QUERY FUNCTION
    public Integer updateempdetails(String newemail,String email){
		return br.updateempInfo(newemail,email);
	}
}
