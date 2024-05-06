package com.aua.flightreservationsystem.api.aircraftFactory;

import com.aua.flightreservationsystem.core.aircraftFactory.AircraftFactory;
import com.aua.flightreservationsystem.core.aircraftFactory.AircraftFactoryService;
import com.aua.flightreservationsystem.core.aircraftFactory.exceptions.AircraftFactoryNotFoundException;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/aircraft-factory")
public class AircraftFactoryController {
    private final AircraftFactoryApiMapper aircraftApiMapper;
    private final AircraftFactoryService aircraftFactoryService;

    @GetMapping()
    public ResponseEntity<List<AircraftFactoryResponse>> getAllAircraftFactories() {
        return ResponseEntity.ok(aircraftFactoryService.getAll().stream()
                .map(aircraftApiMapper::map)
                .toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AircraftFactoryResponse> getAircraftFactoryById(@PathVariable UUID id)
            throws AircraftFactoryNotFoundException {
        AircraftFactory aircraftFactory =
                aircraftFactoryService.getById(id).orElseThrow(() -> new AircraftFactoryNotFoundException(id));

        return ResponseEntity.ok(aircraftApiMapper.map(aircraftFactory));
    }

    @PostMapping()
    public ResponseEntity<AircraftFactoryResponse> createAircraftFactory(
            @RequestBody AircraftFactoryRequest aircraftFactoryRequest) {
        AircraftFactory savedAircraftFactory = aircraftFactoryService.save(aircraftFactoryRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(aircraftApiMapper.map(savedAircraftFactory));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AircraftFactoryResponse> updateAircraftFactory(
            @PathVariable UUID id, @RequestBody AircraftFactoryRequest aircraftFactoryRequest) {
        HttpStatus httpStatus;
        if (aircraftFactoryService.getById(id).isPresent()) {
            httpStatus = HttpStatus.OK;
        } else {
            httpStatus = HttpStatus.CREATED;
        }

        AircraftFactory updateAircraftFactory = aircraftFactoryService.update(id, aircraftFactoryRequest);
        return ResponseEntity.status(httpStatus).body(aircraftApiMapper.map(updateAircraftFactory));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAircraftFactory(@PathVariable UUID id) throws AircraftFactoryNotFoundException {
        aircraftFactoryService.getById(id).orElseThrow(() -> new AircraftFactoryNotFoundException(id));

        aircraftFactoryService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @ExceptionHandler(AircraftFactoryNotFoundException.class)
    ResponseEntity<String> handleAircraftFactoryNotFoundExceptions(
            AircraftFactoryNotFoundException aircraftFactoryNotFoundException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(aircraftFactoryNotFoundException.getMessage());
    }
}
