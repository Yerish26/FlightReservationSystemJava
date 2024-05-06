package com.aua.flightreservationsystem.api.aircraft;

import com.aua.flightreservationsystem.core.aircraft.Aircraft;
import com.aua.flightreservationsystem.core.aircraft.AircraftService;
import com.aua.flightreservationsystem.core.aircraft.exceptions.AircraftAlreadyExistsException;
import com.aua.flightreservationsystem.core.aircraft.exceptions.AircraftNotFoundException;
import com.aua.flightreservationsystem.core.aircraftFactory.exceptions.AircraftFactoryNotFoundException;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/aircraft")
public class AircraftController {
    private final AircraftApiMapper aircraftApiMapper;
    private final AircraftService aircraftService;

    @GetMapping()
    public ResponseEntity<List<AircraftResponse>> getAllAircraftFactories() {
        return ResponseEntity.ok(
                aircraftService.getAll().stream().map(aircraftApiMapper::map).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AircraftResponse> getAircraftById(@PathVariable UUID id) throws AircraftNotFoundException {
        Aircraft aircraft = aircraftService.getById(id).orElseThrow(() -> new AircraftNotFoundException(id));

        return ResponseEntity.ok(aircraftApiMapper.map(aircraft));
    }

    @PostMapping()
    public ResponseEntity<AircraftResponse> createAircraft(@RequestBody AircraftRequest aircraftRequest)
            throws AircraftFactoryNotFoundException {
        Aircraft savedAircraft = aircraftService.save(aircraftRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(aircraftApiMapper.map(savedAircraft));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AircraftResponse> updateAircraft(
            @PathVariable UUID id, @RequestBody AircraftRequest aircraftRequest)
            throws AircraftFactoryNotFoundException, AircraftAlreadyExistsException {
        HttpStatus httpStatus;
        if (aircraftService.getById(id).isPresent()) {
            httpStatus = HttpStatus.OK;
        } else {
            httpStatus = HttpStatus.CREATED;
        }

        Aircraft updateAircraft = aircraftService.update(id, aircraftRequest);
        return ResponseEntity.status(httpStatus).body(aircraftApiMapper.map(updateAircraft));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAircraft(@PathVariable UUID id) throws AircraftNotFoundException {
        aircraftService.getById(id).orElseThrow(() -> new AircraftNotFoundException(id));

        aircraftService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @ExceptionHandler(AircraftAlreadyExistsException.class)
    ResponseEntity<String> handleAircraftAlreadyExistsExceptions(
            AircraftAlreadyExistsException aircraftAlreadyExistsException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(aircraftAlreadyExistsException.getMessage());
    }

    @ExceptionHandler(AircraftNotFoundException.class)
    ResponseEntity<String> handleAircraftNotFoundExceptions(AircraftNotFoundException aircraftNotFoundException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(aircraftNotFoundException.getMessage());
    }

    @ExceptionHandler(AircraftFactoryNotFoundException.class)
    ResponseEntity<String> handleAircraftFactoryNotFoundExceptions(
            AircraftFactoryNotFoundException aircraftFactoryNotFoundException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(aircraftFactoryNotFoundException.getMessage());
    }
}
