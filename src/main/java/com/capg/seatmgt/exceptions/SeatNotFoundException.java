package com.capg.seatmgt.exceptions;

public class SeatNotFoundException extends RuntimeException
{
    public SeatNotFoundException(String msg) 
   {
	super(msg);
   }
}
