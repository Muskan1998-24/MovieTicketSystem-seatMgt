package com.capg.seatmgt.controller;

import com.capg.seatmgt.service.ISeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/seats")
public class SeatController {

    @Autowired
    private ISeatService service;

   

}
