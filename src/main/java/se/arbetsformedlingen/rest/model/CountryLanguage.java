package se.arbetsformedlingen.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity(name = "CountryLanguage")
@Table(name="countryLanguage")
public class CountryLanguage {

    @Id
    @Column(name="Language", length = 30)
    private String language;
    @Column(name = "IsOfficial")
    private Character isOfficial;
    @Column(name = "Percentage")
    private double percentage;

    @ManyToOne()
    @JsonIgnoreProperties("cities")
    @JoinColumn(name="CountryCode")
    private Country country;

    public Country getCountry() { return country; }

    public void setCountry(Country country) { this.country = country; }

    public String getLanguage() { return language; }

    public void setLanguage(String language) { this.language = language; }

    public Character getIsOfficial() { return isOfficial; }

    public void setIsOfficial(Character isOfficial) { this.isOfficial = isOfficial; }

    public double getPercentage() { return percentage; }

    public void setPercentage(double percentage) { this.percentage = percentage; }
}
