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
@RequestMapping("/flight")
public class FlightController {

    private final FlightService flightService;
    private final FlightApiMapper flightApiMapper;

    @GetMapping()
    public ResponseEntity<List<FlightResponse>> getAllFlights() {
        return ResponseEntity.ok(
                flightService.getAll().stream().map(flightApiMapper::map).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlightResponse> getFlightById(@PathVariable UUID id) throws FlightNotFoundException {
        Flight flight = flightService.getById(id).orElseThrow(() -> new FlightNotFoundException(id));

        return ResponseEntity.ok(flightApiMapper.map(flight));
    }

    @PostMapping()
    public ResponseEntity<Flight> createFlight(@RequestBody FlightRequest flightRequest)
            throws FlightAlreadyExistsException {
        Flight flight = flightService.save(flightRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(flight);
    }

    @PutMapping("/{id}")
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

    @DeleteMapping("/{id}")
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
