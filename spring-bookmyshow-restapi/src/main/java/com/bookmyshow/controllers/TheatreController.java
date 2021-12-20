package com.bookmyshow.controllers;

import com.bookmyshow.model.Theatre;
import com.bookmyshow.service.ITheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("theatre-api")
public class TheatreController {
    ITheatreService theatreService;

    @Autowired
    public void setTheatreService(ITheatreService theatreService) {
        this.theatreService = theatreService;
    }

    @PostMapping("/theatres")
    public ResponseEntity<Theatre> addTheatre(@RequestBody Theatre theatre) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "adding new theatre");
        Theatre ntheatre = theatreService.addTheatre(theatre);
        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(ntheatre);
    }


    @PutMapping("/theatres")
    public ResponseEntity<Void> updateTheatre(@RequestBody Theatre theatre) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "updating a theatre");
        theatreService.updateTheatre(theatre);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
    }


    @DeleteMapping("/theatres/{theatreid}")
    public ResponseEntity<String> deleteTheatre(@PathVariable("theatreId") int theatreId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "deleting a  theatre");
        theatreService.deleteTheatre(theatreId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).body("deleted");
    }

    @GetMapping("/theatres")
    public ResponseEntity<List<Theatre>>  getAll() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting movie by Id");
        List<Theatre> theatres = theatreService.getAll();
        return ResponseEntity.ok().headers(headers).body(theatres);
    }


    @GetMapping("/theatres/id/{theatreid}")
    public ResponseEntity<Theatre> getById(@PathVariable("theatreid") int theatreId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting movie by Id");
        Theatre theatre = theatreService.getById(theatreId);
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(theatre);
    }



    @GetMapping("/theatres/theatrename/{theatrename}")
    public ResponseEntity<List<Theatre>> getByTheatre(@PathVariable("theatrename") String theatreName) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting  movie by name");
        List<Theatre> theatres = theatreService.getByTheatreName(theatreName);
        return ResponseEntity.ok().headers(headers).body(theatres);
    }

    @GetMapping("/theatres/location/{location}")
    public ResponseEntity<List<Theatre>> getByLocation(@PathVariable("location") String location) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting  theatre by location");
        List<Theatre> theatres = theatreService.getByLocation(location);
        return ResponseEntity.ok().headers(headers).body(theatres);
    }

    @GetMapping("/theatres/city/{city}")
    public ResponseEntity<List<Theatre>> getByCity(@PathVariable("city") String city) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting  theatre by city");
        List<Theatre> theatres = theatreService.getByCity(city);
        return ResponseEntity.ok().headers(headers).body(theatres);
    }

    @GetMapping("theatres/startprice/{startprice}/endprice/{endprice}")
    public ResponseEntity<List<Theatre>> getByPriceBetween(@PathVariable("startprice") String startPrice,@PathVariable("endprice") String endPrice) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting  theatre between two price range");
        List<Theatre> theatres = theatreService.getByPriceBetween(startPrice, endPrice);
        return ResponseEntity.ok().headers(headers).body(theatres);
    }
    @GetMapping("theatres/rating/{rating}")
    public ResponseEntity<List<Theatre>> getByRating(double rating) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting  theatre by rating");
        List<Theatre> theatres = theatreService.getByRating(rating);
        return ResponseEntity.ok().headers(headers).body(theatres);
    }
}
