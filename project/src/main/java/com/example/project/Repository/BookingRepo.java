package com.example.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import com.example.project.model.Booking;

@Repository
public interface BookingRepo extends JpaRepository<Booking,String> {

    //SELECT QUERY USING METHOD 
    List<Booking> findByEmailOrName(String email,String name);

    //DELETE QUERY
    @Modifying
	@Transactional
	@Query(value="delete from booking where email=:s",nativeQuery=true)
	public Integer deleteBookingInfo(@Param("s") String email);

    //UPDATE QUERY
    @Modifying
	@Transactional
	@Query(value="update booking b set b.email =?1 where b.email=?2",nativeQuery=true)
	public Integer updateempInfo(String newemail,String email);

}