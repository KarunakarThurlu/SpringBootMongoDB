package com.app.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("Countrys")
public class Country {

	private String countryName;
	private String countryCapital;
	private String countryCurrency;
	private String countryLanguage;
	private Long GDP;
	private Long population;
	
	
	
	public Country(String countryName, String countryCapital, String countryCurrency, String countryLanguage,
			Long gDP, Long population) {
		super();
		this.countryName = countryName;
		this.countryCapital = countryCapital;
		this.countryCurrency = countryCurrency;
		this.countryLanguage = countryLanguage;
		this.GDP = gDP;
		this.population = population;
	}
	public Country() {
		super();
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getCountryCapital() {
		return countryCapital;
	}
	public void setCountryCapital(String countryCapital) {
		this.countryCapital = countryCapital;
	}
	public String getCountryCurrency() {
		return countryCurrency;
	}
	public void setCountryCurrency(String countryCurrency) {
		this.countryCurrency = countryCurrency;
	}
	public String getCountryLanguage() {
		return countryLanguage;
	}
	public void setCountryLanguage(String countryLanguage) {
		this.countryLanguage = countryLanguage;
	}
	public Long getGDP() {
		return GDP;
	}
	public void setGDP(Long gDP) {
		GDP = gDP;
	}
	public Long getPopulation() {
		return population;
	}
	public void setPopulation(Long population) {
		this.population = population;
	}
	
}
