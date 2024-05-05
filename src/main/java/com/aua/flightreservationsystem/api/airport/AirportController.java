package com.aua.flightreservationsystem.api.airport;

import com.aua.flightreservationsystem.core.airport.Airport;
import com.aua.flightreservationsystem.core.airport.AirportService;
import com.aua.flightreservationsystem.core.airport.exceptions.AirportNotFoundException;
import com.aua.flightreservationsystem.core.city.exceptions.CityNotFoundException;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/allow/airport")
public class AirportController {
    private final AirportApiMapper aircraftApiMapper;
    private final AirportService airportService;

    @GetMapping("/")
    public ResponseEntity<List<AirportResponse>> getAllAircraftFactories() {
        return ResponseEntity.ok(
                airportService.getAll().stream().map(aircraftApiMapper::map).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AirportResponse> getAircraftFactoryById(@PathVariable UUID id)
            throws AirportNotFoundException {
        Airport airport = airportService.getById(id).orElseThrow(() -> new AirportNotFoundException(id));

        return ResponseEntity.ok(aircraftApiMapper.map(airport));
    }

    @PostMapping("/")
    public ResponseEntity<AirportResponse> createAircraftFactory(@RequestBody AirportRequest airportRequest)
            throws CityNotFoundException {
        Airport savedAircraftFactory = airportService.save(airportRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(aircraftApiMapper.map(savedAircraftFactory));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AirportResponse> updateAircraftFactory(
            @PathVariable UUID id, @RequestBody AirportRequest airportRequest) throws CityNotFoundException {
        HttpStatus httpStatus;
        if (airportService.getById(id).isPresent()) {
            httpStatus = HttpStatus.OK;
        } else {
            httpStatus = HttpStatus.CREATED;
        }

        Airport updateAircraftFactory = airportService.update(id, airportRequest);
        return ResponseEntity.status(httpStatus).body(aircraftApiMapper.map(updateAircraftFactory));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAircraftFactory(@PathVariable UUID id) throws AirportNotFoundException {
        airportService.getById(id).orElseThrow(() -> new AirportNotFoundException(id));

        airportService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
