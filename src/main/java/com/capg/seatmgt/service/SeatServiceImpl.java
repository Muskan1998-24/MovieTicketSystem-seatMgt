package com.capg.seatmgt.service;


import com.capg.seatmgt.dao.SeatDao;
import com.capg.seatmgt.entities.Seat;
import com.capg.seatmgt.exceptions.SeatAlreadyExistException;
import com.capg.seatmgt.exceptions.SeatNotFoundException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

@Service
@Transactional
public class SeatServiceImpl implements ISeatService{

    @Autowired
    private SeatDao seatDao;

    @Override
	public Seat addSeat(Seat seat)
    {
	 if(seatDao.existsById(seat.getSeatId()))	
	 {
		 throw new SeatAlreadyExistException("seat already exists");
	 }
	 seat=seatDao.save(seat);
	return seat;
	}

	@Override
	public Seat save(Seat seat)
	{
		seat=seatDao.save(seat);
		return seat;
	}

	@Override
	public List<Seat> viewAllSeat() 
	{
		List<Seat>seats=seatDao.findAll();
		return seats;
	}

	 @Override
	 public void bookSeat(int seatId)
	 {
	        

	    }


	@Override
	public List<Seat> getAvailableSeats() {
		// TODO Auto-generated method stub
		return null;
	}
	
/*
	@Override
	public boolean cancelSeat(int seatId)
	{
		Seat seat=dao.getOne(seatId);
		if(seat!=null) 
		{
		dao.deleteById(seatId);
		seat=save(seat);
		return true;
		}
		return false;
	}
	*/
}