package com.capg.seatmgt.service;

import com.capg.seatmgt.entities.Seat;

import java.util.Collection;
import java.util.List;





public interface ISeatService 
{
	Seat save(Seat seat);  
	
	List<Seat> fetchAllSeats();
	
    Seat addSeat (Seat seat);
    
    Seat findById(int seatId);
    
    List<Seat> bookSeat(List<Integer> seatId);
	
    List<Seat> blockSeat(List<Integer> seatId);
	
    String cancelSeat(int seatId);

}
