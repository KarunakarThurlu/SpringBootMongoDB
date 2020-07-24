package com.app.serviceimpl;

import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.idao.ICountryDao;
import com.app.iservice.ICountryService;
import com.app.model.Country;

@Service
public class CountryServiceImpl  implements ICountryService{
	
	@Autowired
	private ICountryDao dao;

	 JSONParser parser=new JSONParser();
	@Override
	public String saveCountryInfo(String info) {
		try {
			JSONObject obj=(JSONObject)parser.parse(info);
			Country c=new Country((String)obj.get("countryName"),(String)obj.get("countryCapital"),(String)obj.get("countryCurrency"),(String)obj.get("countryLanguage"),Long.parseLong((String)obj.get("GDP")),Long.parseLong((String)obj.get("population")));
		   return  dao.saveCountryInfo(c);
		} catch (ParseException e) {
			e.printStackTrace();
			return e.getMessage().toString();
		}
	}
	@Override
	public String updateCountryInfo(String info) {
		try {
			JSONObject obj=(JSONObject)parser.parse(info);
			return dao.updateCountryInfo(obj);
		} catch (ParseException e) {
			e.printStackTrace();
			return e.getMessage().toString();
		}

	}
	@Override
	public String deleteCountryInfo(String info) {
		return dao.deleteCountryInfo(info);
	}
	@Override
	public String getCountryByName(String name) {
		return dao.getCountryByName(name);
	}
	@Override
	public List<Country> getAllCountrysInfo() {
		return dao.getAllCountrysInfo();
	}

}
