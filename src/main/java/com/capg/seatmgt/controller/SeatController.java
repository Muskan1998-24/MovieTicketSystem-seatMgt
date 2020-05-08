package com.capg.seatmgt.controller;


import com.capg.seatmgt.dto.SeatDetailsDto;
import com.capg.seatmgt.entities.Seat;
import com.capg.seatmgt.entities.SeatStatus;
import com.capg.seatmgt.service.ISeatService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/seats")
public class SeatController
{

      @Autowired
      private ISeatService service;

	  @PostMapping("add")
	  public ResponseEntity<Seat> addSeat(@RequestBody SeatDetailsDto dto) 
	      {
		    Seat seat = convert(dto);
		    seat = service.save(seat);
	        ResponseEntity<Seat> response = new ResponseEntity<>(seat, HttpStatus.OK);
	        return response;
          }

	        Seat convert(SeatDetailsDto dto)
	      {
	        Seat seat= new Seat();
	        seat.setSeatStatus(dto.getSeatStatus());
	        seat.setSeatPrice(dto.getSeatPrice());
	        return seat;
	      }


       @GetMapping("/")
       public ResponseEntity<List<Seat>> fetchAll() 
          {
            List<Seat> seats = service.fetchAllSeats();
            ResponseEntity<List<Seat>> response = new ResponseEntity<>(seats, HttpStatus.OK);
            return response;
          }

       @GetMapping("find/{id}")
	   public ResponseEntity<Seat> findById(@PathVariable("id") int seatId)
	      {
	        Seat seat = service.findById(seatId);
	        if(seat==null)
	          {
	             ResponseEntity<Seat> response= new ResponseEntity<>(HttpStatus.NOT_FOUND);
	             return response;
	          }
	        ResponseEntity<Seat> response = new ResponseEntity<>(seat, HttpStatus.OK);
	        return response;
	      }
       
       
       @PutMapping("/book")
       public ResponseEntity bookSeat(@RequestBody Integer[]seatId) 
          {
             List<Integer>seatIdList=Arrays.asList(seatId);
             service.bookSeat(seatIdList);
             ResponseEntity responseEntity = new ResponseEntity(HttpStatus.OK);
             return responseEntity;
          }

       
       @DeleteMapping("/cancel/{id}")
   	   public ResponseEntity<String> cancelSeat(@PathVariable("id") int seatId)
          {
   		     String msg = service.cancelSeat(seatId);
   		     ResponseEntity<String> response = new ResponseEntity<String>(msg,HttpStatus.OK);
   		     return response;
   	      }
   	 
    
}
