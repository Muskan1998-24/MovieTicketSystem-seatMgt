package com.capg.seatmgt.service;



import com.capg.seatmgt.dao.SeatDao;
import com.capg.seatmgt.entities.Seat;
import com.capg.seatmgt.entities.SeatStatus;
import com.capg.seatmgt.exceptions.IncorrectSeatIdException;
import com.capg.seatmgt.exceptions.SeatAlreadyExistException;
import com.capg.seatmgt.exceptions.SeatNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SeatServiceImpl implements ISeatService
{

    @Autowired
    private SeatDao seatDao;
   
    /*.....................................SAVE SEAT................................*/
    
    @Override
    public Seat save(Seat seat)
    {
       seat=seatDao.save(seat);
       return seat;
    }
    
    
    /*.....................................FETCH ALL SEATS................................*/
    
    @Override
    public List<Seat>fetchAllSeats()
    {
        List<Seat>seat=seatDao.findAll();
        return seat;
    }
    
    

    /*.....................................ADD SEAT................................*/
    
	@Override
	public Seat addSeat(Seat seat)
	{
		if (seatDao.existsById(seat.getSeatId())) 
		{
			throw new SeatAlreadyExistException("Seat already exists");
		}
		seat=seatDao.save(seat);
		return seat;
		
	}
	
	
	
	
	
	 /*.....................................FIND BY ID................................*/
	@Override
    public Seat findById(int seatId) {
        Optional<Seat> optional = seatDao.findById(seatId);
        if (optional.isPresent()) {
            Seat seat = optional.get();
            return seat;
        }
        throw new SeatNotFoundException("seat not found for id=" + seatId);
    }
	  
	
	  /*.....................................BOOK SEAT................................*/
    
	
	@Override
	public List<Seat> bookSeat(List<Integer> seatId)
	{
		 List<Seat> seatList=new ArrayList<>();
		 for(int id:seatId) 
		 {
		    if(seatDao.existsById(id)) 
		     {
			 Seat bookseat= seatDao.getOne(id);
			    if(bookseat.getSeatStatus()==SeatStatus.AVAILABLE)
			    {
				bookseat.setSeatStatus(SeatStatus.BOOKED);
				seatList.add(bookseat);
			    }
		     }
		 }
		 seatList=seatDao.saveAll(seatList);
		return seatList;
	}

	
	  /*.....................................BLOCK SEAT................................*/
    
	
	@Override
	public List<Seat> blockSeat(List<Integer> seatId)
	{
		 List<Seat> seatList=new ArrayList<>();
		 for(int id:seatId) 
		 {
		    if(seatDao.existsById(id)) 
		     {
			 Seat blockseat= seatDao.getOne(id);
			    if(blockseat.getSeatStatus()==SeatStatus.AVAILABLE)
			    {
				blockseat.setSeatStatus(SeatStatus.BLOCKED);
				seatList.add(blockseat);
			    }
		     }
		 }
		 seatList=seatDao.saveAll(seatList);
		return seatList;
	}

	
	  /*.....................................CANCEL SEAT................................*/
    
	
	@Override
	public String cancelSeat(int seatId) {
		Seat seat = findById(seatId);
		seat.getSeatId();
		if(seat==null) throw new SeatNotFoundException("Seat Not Booked");
		seat.setSeatStatus(SeatStatus.CANCELLED);
		return "Seat Cancelled";
	}
	
	
    
    

  
		
	
    
    

}
