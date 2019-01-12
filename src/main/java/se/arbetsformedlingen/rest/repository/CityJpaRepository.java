package se.arbetsformedlingen.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.arbetsformedlingen.rest.model.City;

import java.util.List;

@Repository
public interface CityJpaRepository extends JpaRepository<City, Integer> {


    boolean existsCityById(Integer id);

    Integer deleteCityById(Integer id);

    List<City> findCitiesByName(String name);

    List<City> findAllByCountryCode(String code);

    List<City> findAllByCountry_Region(String region);



}
