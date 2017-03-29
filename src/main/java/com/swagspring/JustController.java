package com.swagspring;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Prabhu kvn
 *
 */

@RestController
@RequestMapping("/api")
public class JustController {

	Map<String, String> data = new HashMap<>();

	@RequestMapping(value = "/postcall", method = RequestMethod.POST)
	public String postCall(@RequestBody Data input) {

		String key = input.getKey();
		String value = input.getValue();
		data.put(key, value);
		System.out.println(data.get(key));
		if (data.containsKey(key)) {
			return ("Added Or Updated Key " + key + " Value:" + value);
		} else {
			return "Not Added";
		}

	}

	@RequestMapping(value = "/getalldata", method = RequestMethod.GET)
	public Map<String, String> getAllCall() {
		return data;

	}

	@RequestMapping(value = "/getvalue", method = RequestMethod.POST)
	public Data getValue(@RequestBody final String key) {
		String value = data.get(key);
		if (null != value) {
			return new Data(key, value);
		} else {
			return new Data();
		}

	}
}

/**
 * A class to hold data
 * 
 * @author prabhu kvn
 *
 */
class Data {
	String key;
	String value;

	public Data() {
		// TODO Auto-generated constructor stub
	}

	public Data(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
