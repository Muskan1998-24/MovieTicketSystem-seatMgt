package com.capg.seatmgt.dto;

import com.capg.seatmgt.entities.SeatStatus;

public class SeatDetailsDto
{
	 private int seatId;
	 private double seatPrice;
	 private SeatStatus seatStatus;
	    
	 public int getSeatId() 
	    {
	    	return seatId;
	    }
	    
	 public void setSeatId() 
	    {
	    	this.seatId=seatId;
	    }
	    
	  
	 public double getSeatPrice() 
	    {
	    	return seatPrice;
	    }
	 
     public void setSeatPrice(double Price) 
	    {
	    	this.seatPrice=seatPrice;
	    }

        
     public SeatStatus getSeatStatus() {
	    	return seatStatus;
	    }

     public void setSeatStatus(SeatStatus seatStatus) {
	    	this.seatStatus = seatStatus;
	    }



}
