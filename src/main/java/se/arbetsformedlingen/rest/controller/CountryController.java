package se.arbetsformedlingen.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.arbetsformedlingen.rest.exception.CountryConflictException;
import se.arbetsformedlingen.rest.exception.CountryNotFoundException;
import se.arbetsformedlingen.rest.model.City;
import se.arbetsformedlingen.rest.model.Country;
import se.arbetsformedlingen.rest.service.CountryService;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping(value = "/country/find/{name}")
    @ResponseBody
    public ResponseEntity find(@PathVariable(value = "name", required = true) String name){
        return ResponseEntity.ok().body(countryService.findCountry(name));
    }

    //TODO: Controllers persists data via CountryJpaRepository



    @GetMapping(value = "/countries")
    @ResponseBody
    public ResponseEntity<List<Country>> countries(){
        if(countryService.listAllCountries().isEmpty()){

            throw new CountryNotFoundException("No countries found");
        }
        return ResponseEntity.ok().body(countryService.listAllCountries());

         }

    @GetMapping(value = "/country/{name}")
    @ResponseBody
    public ResponseEntity<Country> country(@PathVariable(value = "name", required = true) String name){
        if(countryService.findCountry(name) == null){

            throw new CountryNotFoundException("Unable to find. A country with name " +
                    name + " doesn't exist.");
        }
        Country country = countryService.findCountry(name);
        return ResponseEntity.ok().body(country);
    }

    @PostMapping(value = "/countries")
    public ResponseEntity<Country> add(@RequestBody Country country) {



        if(countryService.existsCountry(country.getCode())){
           throw new CountryConflictException("Unable to create. A country with country code " +
                   country.getCode() + " already exist.");
        }
        countryService.addCountry(country);
        return ResponseEntity.ok().body(country);

    }


    @PutMapping(value = "/countries")
    public ResponseEntity<Country> update(@RequestBody Country country) {

        if(countryService.existsCountry(country.getCode())){

            return ResponseEntity.ok().body(countryService.update(country));
        }
            throw new CountryNotFoundException("Unable to update. A country with country code " +
                    country.getCode() + " doesn't exist.");
    }


    @GetMapping(value = "/countries/population/greaterthan/{population}")
    @ResponseBody
    public ResponseEntity<List<Country>> findCountriesByPopulationIsGreaterThanXPopulation (@PathVariable(value = "population") Integer population){
        return new ResponseEntity(countryService.findCountriesByPopulationIsGreaterThanXPopulation(population), HttpStatus.FOUND);
    }

    @GetMapping(value = "/countries/governmentform/{govform}")
    public  ResponseEntity<List<Country>> findAllByGovernmentForm(@PathVariable(value = "govform") String govform){
        return new ResponseEntity(countryService.findAllByGovernmentForm(govform), HttpStatus.FOUND);
    }

    @GetMapping(value = "/countries/capitals")
    public  ResponseEntity<List<City>> findAllCapitals(){

        return new ResponseEntity(countryService.capitals(), HttpStatus.FOUND);
    }

    @GetMapping(value = "/countries/cities/{continent}/{population}")
    public  ResponseEntity<List<Country>> findAllCitiesInAContinentWithAPopulationEqualOrGreaterThanXPopulation(@PathVariable(value = "continent") String continent,
                                                                                     @PathVariable(value = "population") Integer population){
        return new ResponseEntity(countryService.findAllCitiesInAContinentWithAPopulationEqualOrGreaterThanX(continent, population),
                HttpStatus.FOUND);
    }

    @GetMapping(value = "/countries/{code}/cities")
    public ResponseEntity<List<City>> findAllCitiesByCountry(@PathVariable(value = "code") String code) {
        return new ResponseEntity(countryService.findAllCitiesByCountry(code), HttpStatus.FOUND);
    }


}
