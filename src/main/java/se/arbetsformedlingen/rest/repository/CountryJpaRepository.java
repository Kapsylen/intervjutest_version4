package se.arbetsformedlingen.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import se.arbetsformedlingen.rest.model.City;
import se.arbetsformedlingen.rest.model.Country;

import java.util.List;

@Repository
public interface CountryJpaRepository extends JpaRepository<Country, Integer> {

    Country findByCode(String code);

    boolean existsByCode(String code);

    @Query("SELECT c FROM Country c")
    List<Country> listAllCountries();

    Country findByName(String name);

    List<Country> findCountriesByPopulationIsGreaterThan(Integer population);

    List<Country> findAllByGovernmentForm(String name);

    @Query("SELECT c FROM City c, Country k WHERE c.id = k.capital")
    List<City> findAllCapitals();

    @Query("SELECT c.name, c.population FROM City c, Country k WHERE k.continent = :continent AND c.country = k.code AND c.population >= :population")
    List<Country> findAllCitiesInAContinentWithAPopulationEqualOrGreaterThanX(@Param("continent")String continent, @Param("population") Integer population);

}
