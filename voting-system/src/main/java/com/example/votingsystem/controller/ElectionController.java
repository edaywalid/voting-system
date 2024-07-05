package com.example.votingsystem.controller;

import com.example.votingsystem.dto.ElectionRequest;
import com.example.votingsystem.model.Election;
import com.example.votingsystem.service.ElectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/election/")
@RequiredArgsConstructor
/*
    ElectionController is used to handle the election related requests
    It is used to add an election, get all elections and get election by id

 */
public class ElectionController {
    private final ElectionService electionService;


    /*
        addElection is used to add an election to the database
        it takes an electionRequest object as a parameter
        and returns a response entity
     */
    @PostMapping("/add")
    ResponseEntity<?> addElection(
            @RequestBody ElectionRequest electionRequest
            ) {
        return electionService.addElection(electionRequest);
    }

    /*
        getElectionById is used to get an election by id
        it takes the election id as a parameter
        and returns a response entity
     */
    @GetMapping("{id}")
    ResponseEntity<?> getElectionById(
            @PathVariable String id
    ) {
        return electionService.getElectionById(id);
    }

    /*
        getAllElections is used to get all the elections in the database
        it returns a response entity
     */

    @GetMapping("/all")
    ResponseEntity<?> getAllElections() {
        return electionService.getAllElections();
    }
}
