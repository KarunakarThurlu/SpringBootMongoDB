package com.app.iservice;

import java.util.List;

import com.app.model.Country;

public interface ICountryService {
	public String saveCountryInfo(String info);
	public String updateCountryInfo(String info);
	public String deleteCountryInfo(String info);
	public String getCountryByName(String name);
	public List<Country> getAllCountrysInfo();
}
