package com.aua.flightreservationsystem.api.city;

import com.aua.flightreservationsystem.core.airport.exceptions.AirportNotFoundException;
import com.aua.flightreservationsystem.core.city.City;
import com.aua.flightreservationsystem.core.city.CityService;
import com.aua.flightreservationsystem.core.city.exceptions.CityNotFoundException;
import com.aua.flightreservationsystem.core.country.exceptions.CountryNotFoundException;
import com.aua.flightreservationsystem.core.flight.exceptions.OneOrMoreFlightsNotFoundException;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/city")
public class CityController {
    private final CityApiMapper cityApiMapper;
    private final CityService cityService;

    @GetMapping("")
    public ResponseEntity<List<CityResponse>> getAllCities() {
        return ResponseEntity.ok(
                cityService.getAll().stream().map(cityApiMapper::map).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CityResponse> getCityById(@PathVariable UUID id) throws CityNotFoundException {
        City city = cityService.getById(id).orElseThrow(() -> new CityNotFoundException(id));

        return ResponseEntity.ok(cityApiMapper.map(city));
    }

    @PostMapping("")
    public ResponseEntity<CityResponse> createCity(@RequestBody CityRequest cityRequest)
            throws OneOrMoreFlightsNotFoundException, AirportNotFoundException, CountryNotFoundException {
        City savedAirline = cityService.save(cityRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(cityApiMapper.map(savedAirline));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CityResponse> updateCity(@PathVariable UUID id, @RequestBody CityRequest cityRequest)
            throws OneOrMoreFlightsNotFoundException, AirportNotFoundException, CountryNotFoundException {
        HttpStatus httpStatus;
        if (cityService.getById(id).isPresent()) {
            httpStatus = HttpStatus.OK;
        } else {
            httpStatus = HttpStatus.CREATED;
        }

        City updateCity = cityService.update(id, cityRequest);
        return ResponseEntity.status(httpStatus).body(cityApiMapper.map(updateCity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable UUID id) throws CityNotFoundException {
        cityService.getById(id).orElseThrow(() -> new CityNotFoundException(id));

        cityService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @ExceptionHandler(CityNotFoundException.class)
    ResponseEntity<String> handleCityNotFoundExceptions(CityNotFoundException cityNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(cityNotFoundException.getMessage());
    }

    @ExceptionHandler(AirportNotFoundException.class)
    ResponseEntity<String> handleAirportNotFoundExceptions(AirportNotFoundException airportNotFoundException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(airportNotFoundException.getMessage());
    }

    @ExceptionHandler(CountryNotFoundException.class)
    ResponseEntity<String> handleCountryNotFoundExceptions(CountryNotFoundException countryNotFoundException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(countryNotFoundException.getMessage());
    }

    @ExceptionHandler(OneOrMoreFlightsNotFoundException.class)
    ResponseEntity<String> handleOneOrMoreFlightsNotFoundExceptions(
            OneOrMoreFlightsNotFoundException oneOrMoreFlightsNotFoundException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(oneOrMoreFlightsNotFoundException.getMessage());
    }
}
