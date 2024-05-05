package com.aua.flightreservationsystem.api.country;

import com.aua.flightreservationsystem.core.aircraftFactory.exceptions.AircraftFactoryNotFoundException;
import com.aua.flightreservationsystem.core.country.Country;
import com.aua.flightreservationsystem.core.country.CountryService;
import com.aua.flightreservationsystem.core.country.exceptions.CountryNotFoundException;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/allow/country")
public class CountryController {
    private final CountryApiMapper countryApiMapper;
    private final CountryService countryService;

    @GetMapping("/")
    public ResponseEntity<List<CountryResponse>> getAllAircraftFactories() {
        return ResponseEntity.ok(
                countryService.getAll().stream().map(countryApiMapper::map).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CountryResponse> getAircraftFactoryById(@PathVariable UUID id)
            throws CountryNotFoundException {
        Country country = countryService.getById(id).orElseThrow(() -> new CountryNotFoundException(id));

        return ResponseEntity.ok(countryApiMapper.map(country));
    }

    @PostMapping("/")
    public ResponseEntity<CountryResponse> createAircraftFactory(@RequestBody CountryRequest countryRequest) {
        Country savedCountry = countryService.save(countryRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(countryApiMapper.map(savedCountry));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CountryResponse> updateAircraftFactory(
            @PathVariable UUID id, @RequestBody CountryRequest countryRequest) {
        HttpStatus httpStatus;
        if (countryService.getById(id).isPresent()) {
            httpStatus = HttpStatus.OK;
        } else {
            httpStatus = HttpStatus.CREATED;
        }

        Country updateCountry = countryService.update(id, countryRequest);
        return ResponseEntity.status(httpStatus).body(countryApiMapper.map(updateCountry));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAircraftFactory(@PathVariable UUID id) throws AircraftFactoryNotFoundException {
        countryService.getById(id).orElseThrow(() -> new AircraftFactoryNotFoundException(id));

        countryService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @ExceptionHandler(CountryNotFoundException.class)
    ResponseEntity<String> handleCountryNotFoundExceptions(
            CountryNotFoundException countryNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(countryNotFoundException.getMessage());
    }

    @ExceptionHandler(AircraftFactoryNotFoundException.class)
    ResponseEntity<String> handleAircraftFactoryNotFoundExceptions(
            AircraftFactoryNotFoundException aircraftFactoryNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(aircraftFactoryNotFoundException.getMessage());
    }


}
