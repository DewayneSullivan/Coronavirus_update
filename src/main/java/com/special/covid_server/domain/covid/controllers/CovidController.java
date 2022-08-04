package com.special.covid_server.domain.covid.controllers;

import com.special.covid_server.domain.covid.models.Covid;
import com.special.covid_server.domain.covid.services.CovidService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/cough")
public class CovidController {

    private CovidService covidService;

    public CovidController (CovidService covidService){
        this.covidService =covidService;
    }
    @GetMapping
    public ResponseEntity<List<Covid>> getAll(){
        List<Covid> requests = covidService.getAll();
        return new ResponseEntity<>(requests, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Covid> create (@RequestBody Covid covid){
        covid = covidService.create(covid);
        return new ResponseEntity<>(covid, HttpStatus.CREATED);
    }
    @GetMapping ("{id}")
    public ResponseEntity<Covid> getById(@PathVariable("id")Long id){
        Covid covid = covidService.getById(id);
        return new ResponseEntity<>(covid, HttpStatus.OK);
    }
    @GetMapping("lookup")
    public ResponseEntity<Covid>getByEmail(@RequestParam String email){
        Covid covid = covidService.getByEmail(email);
        return new ResponseEntity<>(covid, HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<Covid> update (@PathVariable("id") Long id, @RequestBody Covid covidDetails){
        covidDetails = covidService.update(id,covidDetails);
        return  new ResponseEntity<>(covidDetails, HttpStatus.ACCEPTED);
    }
    @DeleteMapping("{id}")
    public ResponseEntity delete (@PathVariable("id")Long id){
        covidService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
