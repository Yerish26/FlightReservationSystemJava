package com.aua.flightreservationsystem.api.airline;

import com.aua.flightreservationsystem.core.airline.Airline;
import com.aua.flightreservationsystem.core.airline.AirlineService;
import com.aua.flightreservationsystem.core.airline.exceptions.AirlineNotFoundException;
import com.aua.flightreservationsystem.core.flight.exceptions.OneOrMoreFlightsNotFoundException;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/allow/airline")
public class AirlineController {
    private final AirlineApiMapper airlineApiMapper;
    private final AirlineService airlineService;

    @GetMapping("/")
    public ResponseEntity<List<AirlineResponse>> getAllAirlines() {
        return ResponseEntity.ok(
                airlineService.getAll().stream().map(airlineApiMapper::map).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AirlineResponse> getAirlineById(@PathVariable UUID id) throws AirlineNotFoundException {
        Airline airline = airlineService.getById(id).orElseThrow(() -> new AirlineNotFoundException(id));

        return ResponseEntity.ok(airlineApiMapper.map(airline));
    }

    @PostMapping("/")
    public ResponseEntity<AirlineResponse> createAirline(@RequestBody AirlineRequest airlineRequest)
            throws OneOrMoreFlightsNotFoundException {
        Airline savedAirline = airlineService.save(airlineRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(airlineApiMapper.map(savedAirline));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AirlineResponse> updateAirline(
            @PathVariable UUID id, @RequestBody AirlineRequest airlineRequest)
            throws OneOrMoreFlightsNotFoundException {
        HttpStatus httpStatus;
        if (airlineService.getById(id).isPresent()) {
            httpStatus = HttpStatus.OK;
        } else {
            httpStatus = HttpStatus.CREATED;
        }

        Airline updateAirline = airlineService.update(id, airlineRequest);
        return ResponseEntity.status(httpStatus).body(airlineApiMapper.map(updateAirline));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirline(@PathVariable UUID id) throws AirlineNotFoundException {
        airlineService.getById(id).orElseThrow(() -> new AirlineNotFoundException(id));

        airlineService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
