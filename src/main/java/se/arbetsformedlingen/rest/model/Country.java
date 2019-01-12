package se.arbetsformedlingen.rest.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "Country")
@Table(name="country")
public class Country {

    @Id
    @NotNull
    @Column(name = "Code")
    @Size(min = 3, max = 3, message = "Country code have to be precise three character long")
    private String code;
    @Column(name="Name", length = 52)
    private String name;
    @Column(name = "Continent")
    private String continent;
    @Column(name="Region", length = 26)
    private String region;
    @Column(name="SurfaceArea")
    private Integer surfaceArea;
    @Column(name="IndepYear", nullable=true)
    private Integer indepYear;
    @Column(name="Population")
    private Integer population;
    @Column(name="LifeExpectancy", nullable=true)
    private Double lifeExpectancy;
    @Column(name="GNP")
    private Integer gnp;
    @Column(name="GNPOld", nullable=true)
    private Integer gnpOld;
    @Column(name="LocalName", length = 45)
    private String localName;
    @Column(name="GovernmentForm", length = 45)
    private String governmentForm;
    @Column(name="HeadOfState", length = 60)
    private String headOfState;
    @Column(name = "Capital")
    private Integer capital;
    @Column(name = "Code2")
    private String code2;

    public Country() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(Integer surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public Integer getIndepYear() {
        return indepYear;
    }

    public void setIndepYear(Integer indepYear) {
        this.indepYear = indepYear;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Double getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(Double lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public Integer getGnp() {
        return gnp;
    }

    public void setGnp(Integer gnp) {
        this.gnp = gnp;
    }

    public Integer getGnpOld() {
        return gnpOld;
    }

    public void setGnpOld(Integer gnpOld) {
        this.gnpOld = gnpOld;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getGovernmentForm() {
        return governmentForm;
    }

    public void setGovernmentForm(String governmentForm) {
        this.governmentForm = governmentForm;
    }

    public String getHeadOfState() {
        return headOfState;
    }

    public void setHeadOfState(String headOfState) {
        this.headOfState = headOfState;
    }

    public Integer getCapital() {
        return capital;
    }

    public void setCapital(Integer capital) {
        this.capital = capital;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }
}
