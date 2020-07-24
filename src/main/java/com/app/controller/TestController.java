package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.iservice.ICountryService;
import com.app.model.Country;
import com.app.model.Product;

@RestController
public class TestController {

	@Autowired
	private ICountryService service;

	@RequestMapping("/save")
	public String saveCountryInfo(@RequestBody String  data) {
         String res= service.saveCountryInfo(data);
		return res;
	}
	
	@RequestMapping("/update")
	public String updateCountryInfo(@RequestBody String data) {
		String res=service.updateCountryInfo(data);
		return res;
	}
	
	@RequestMapping("/remove/{id}")
	public String removeCountry(@PathVariable("id") String data) {
		String res=service.deleteCountryInfo(data);
		return res;
	}
	
	@RequestMapping("/getcountry")
	public String getCountryInfoByName(@RequestParam("name") String name) {
		String res=service.getCountryByName(name);
		return res;
	}
	
	@RequestMapping("/getAll")
	public List<Country> getAllCountrysInfo() {
		return service.getAllCountrysInfo();
	}
}
