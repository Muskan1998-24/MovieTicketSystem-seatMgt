package com.capg.seatmgt.service;

import java.util.Collection;
import java.util.List;



import com.capg.seatmgt.entities.Seat;


public interface ISeatService 
{
 
Seat addSeat (Seat seat);

List<Seat> getAvailableSeats();

Seat save(Seat seat);

List<Seat> viewAllSeat();
 
 void bookSeat(int seatId);
 //blockSeat
 //public boolean cancelSeat(int seatId);
}
