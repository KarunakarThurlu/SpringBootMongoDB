package com.app.daoimpl;



import java.util.List;
import java.util.Set;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.app.idao.ICountryDao;
import com.app.model.Country;

@Repository
public class CountryDaoImpl implements ICountryDao{

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public String saveCountryInfo(Country c) {
		try {
			mongoTemplate.insert(c);
			return "saved successfully";
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage().toString();
		}
	}

	@Override
	public String updateCountryInfo(JSONObject obj) {
		String id=(String)obj.get("_id");
		Set<String> keys=obj.keySet();
		Query query=new Query(Criteria.where("_id").is(id));
		Update update=new Update();
		keys.forEach(k->{
			if(!k.equals("_id"))
				update.set(k,obj.get(k));
		});
		try {
			mongoTemplate.updateMulti(query, update, Country.class);
			return "Updated successfully";
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage().toString();
		}
	}

	@Override
	public String deleteCountryInfo(String info) {
		try {
			mongoTemplate.remove(new Query(Criteria.where("_id").is(info)), Country.class);
			return "record "+info+" removed succcesfully";
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage().toString();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getCountryByName(String name) {
		try {
			String countryName=name;
			Country c=mongoTemplate.findOne(new Query(Criteria.where("countryName").is(countryName)), Country.class);
			JSONObject object=new JSONObject();
			object.put("countryName", c.getCountryName());
			object.put("countryCapital", c.getCountryCapital());
			object.put("countryLanguage",c.getCountryLanguage());
			object.put("GDP", c.getGDP());
			object.put("population",c.getPopulation());
			return object.toJSONString();
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage().toString();
		}
	}

	@Override
	public List<Country> getAllCountrysInfo() {
		try {
			List<Country> list=mongoTemplate.findAll(Country.class);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
