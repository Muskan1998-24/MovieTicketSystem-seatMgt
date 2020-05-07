package com.capg.seatmgt.controller;
import com.capg.seatmgt.dto.*;
import com.capg.seatmgt.entities.Seat;
import com.capg.seatmgt.service.ISeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

import javax.validation.Valid;

@RestController
@RequestMapping("/seat")
public class SeatController
{
	
	@Autowired
	private ISeatService service;
	@PostMapping("/add")
	public ResponseEntity<Seat> addSeat(@RequestBody Seat seat) {
	service.addSeat(seat);
    ResponseEntity<Seat>response = new ResponseEntity<>(seat, HttpStatus.OK);	
	return response;
	}
}
