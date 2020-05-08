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

	  @PostMapping("/add")
	  public ResponseEntity<Seat> addSeat(@RequestBody SeatDetailsDto dto) 
	      {
		    Seat seat = convert(dto);
		    seat = service.addSeat(seat);
	        ResponseEntity<Seat> response = new ResponseEntity<>(seat, HttpStatus.OK);
	        return response;
          }

	        Seat convert(SeatDetailsDto dto)
	      {
	        Seat seat= new Seat();
	        seat.setSeatId(dto.getSeatId());
	        seat.setSeatPrice(dto.getSeatPrice());
	        seat.setSeatStatus(SeatStatus.AVAILABLE);
	        return seat;
	      }


       
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
       
       @PutMapping("/blockseat/{id}")
       public ResponseEntity<Seat> blockSeat(@PathVariable("id") int seatId) {
           Seat seat = service.blockSeat(seatId);
           ResponseEntity<Seat> response = new ResponseEntity<Seat>(seat, HttpStatus.OK);
           return response;
       }

       @PutMapping("/bookseat/{id}")
       public ResponseEntity<Seat> bookSeat(@PathVariable("id") int id) {
           Seat seat = service.bookSeat(id);
           ResponseEntity<Seat> response = new ResponseEntity<Seat>(seat, HttpStatus.OK);
           return response;
       }

       @PutMapping("/cancelseat/{id}")
       public ResponseEntity<Seat> cancelSeat(@PathVariable("id") int id) {
           Seat seat = service.cancelSeat(id);
           ResponseEntity<Seat> response = new ResponseEntity<Seat>(seat, HttpStatus.OK);
           return response;
       }

    
}
