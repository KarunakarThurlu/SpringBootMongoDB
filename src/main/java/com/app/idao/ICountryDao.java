package com.app.idao;

import java.util.List;

import org.json.simple.JSONObject;

import com.app.model.Country;

public interface ICountryDao {
	public String saveCountryInfo(Country c);
	public String updateCountryInfo(JSONObject obj);
	public String deleteCountryInfo(String info);
	public String getCountryByName(String name);
	public List<Country> getAllCountrysInfo();

}
