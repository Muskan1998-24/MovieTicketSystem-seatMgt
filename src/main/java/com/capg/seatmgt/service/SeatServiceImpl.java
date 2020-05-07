package com.capg.seatmgt.service;

import com.capg.seatmgt.dao.SeatDao;
import com.capg.seatmgt.entities.Seat;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SeatServiceImpl implements ISeatService
{

    @Autowired
    private SeatDao seatDao;
   
    @Override
    public Seat save(Seat seat){
       seat=seatDao.save(seat);
       return seat;
    }
    
    @Override
    public List<Seat>fetchAllSeats(){
        List<Seat>seat=seatDao.findAll();
        return seat;
    }

}
