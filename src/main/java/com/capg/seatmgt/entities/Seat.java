package com.capg.seatmgt.entities;

import javax.persistence.*;

import com.capg.seatmgt.entities.Seat;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "seats")

public class Seat
{
    @Id
    @GeneratedValue
	
    private int seatId;
    public int getSeatId() 
    {
    	return seatId;
    }
    public void setSeatId() 
    {
    	this.seatId=seatId;
    }
    
    public enum seatStatus
    {
    	SEAT_AVAILABLE,
    	SEAT_UNAVAILABLE;
    }
    
    private double seatPrice;
    public double getSeatPrice() 
    {
    	return seatPrice;
    }
    public void setSeatPrice() 
    {
    	this.seatPrice=seatPrice;
    }
	
  

    @Override
    public boolean equals(Object o) 
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return seatId == seat.seatId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(seatId);
    }
}
