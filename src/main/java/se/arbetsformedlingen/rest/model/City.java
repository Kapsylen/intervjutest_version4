package se.arbetsformedlingen.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity(name="City")
@Table(name="city")
public class City {

    @Id
    @Column(name="ID")
    Integer id;
    @Column(name="Name", length = 35)
    String name;
    @Column(name="District", length = 20)
    String district;
    @Column(name="Population")
    Integer population;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("cities")
    @JoinColumn(name="CountryCode")
    private Country country;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Integer getPopulation() { return population; }

    public void setPopulation(Integer population) { this.population = population; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(id, city.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
