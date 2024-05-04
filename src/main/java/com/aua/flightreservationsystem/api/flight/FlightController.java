package com.aua.flightreservationsystem.api.flight;

import com.aua.flightreservationsystem.core.flight.Flight;
import com.aua.flightreservationsystem.core.flight.FlightService;
import com.aua.flightreservationsystem.core.flight.exceptions.FlightAlreadyExistsException;
import com.aua.flightreservationsystem.core.flight.exceptions.FlightNotFoundException;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class FlightController {

    private final FlightService flightService;
    private final FlightApiMapper flightApiMapper;

    @GetMapping("/flights")
    public ResponseEntity<List<FlightResponse>> getAllFlights() {
        return ResponseEntity.ok(
                flightService.getAll().stream().map(flightApiMapper::map).toList());
    }

    @GetMapping("/flights/{id}")
    public ResponseEntity<FlightResponse> getFlightById(@PathVariable UUID id) throws FlightNotFoundException {
        Flight flight = flightService.getById(id).orElseThrow(() -> new FlightNotFoundException(id));

        return ResponseEntity.ok(flightApiMapper.map(flight));
    }

    @PostMapping("/flights")
    public ResponseEntity<Flight> createFlight(@RequestBody FlightRequest flightRequest)
            throws FlightAlreadyExistsException {
        Flight flight = flightApiMapper.map(flightRequest);
        Flight savedFlight = flightService.save(flight);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedFlight);
    }

    @PutMapping("/flights/{id}")
    public ResponseEntity<Flight> updateFlight(@PathVariable UUID id, @RequestBody FlightRequest flightRequest) {
        HttpStatus httpStatus;
        if (flightService.getById(id).isPresent()) {
            httpStatus = HttpStatus.OK;
        } else {
            httpStatus = HttpStatus.CREATED;
        }

        Flight flight = flightApiMapper.map(id, flightRequest);
        Flight updateFlight = flightService.update(flight);
        return ResponseEntity.status(httpStatus).body(updateFlight);
    }

    @DeleteMapping("/flights/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable UUID id) throws FlightNotFoundException {
        flightService.getById(id).orElseThrow(() -> new FlightNotFoundException(id));

        flightService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @ExceptionHandler(FlightAlreadyExistsException.class)
    ResponseEntity<String> handleFlightAlreadyExistsExceptions(
            FlightAlreadyExistsException flightAlreadyExistsException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(flightAlreadyExistsException.getMessage());
    }

    @ExceptionHandler(FlightNotFoundException.class)
    ResponseEntity<String> handleFlightNotFoundExceptions(FlightNotFoundException flightNotFoundException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(flightNotFoundException.getMessage());
    }
}
