package com.gk.swagger;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@GetMapping("/")
	public String autocomplete(Model model) {
		model.addAttribute("title", "autocomplete countries example");
		//model.

		return "autocomplete";
	}

	@RequestMapping(value = "/suggestion", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Suggestions autocompleteSuggestions(@RequestParam("searchstr") String searchstr) {
		System.out.println("searchstr: " + searchstr);

		ArrayList<Country> suggestions = new ArrayList<>();

		String[] locales = Locale.getISOCountries();

		for (String countryCode : locales) {

			Locale obj = new Locale("", countryCode);
			// add all countries to the arraylist
			// if on the query string
			if (obj.getDisplayCountry().toLowerCase().contains(searchstr.toLowerCase())) {
				suggestions.add(new Country(obj.getDisplayCountry()));
			}
		}

		// truncate the list to the first n, max 20 elements
		int n = suggestions.size() > 20 ? 20 : suggestions.size();
		List<Country> sulb = new ArrayList<>(suggestions.subList(0, n));

		Suggestions sw = new Suggestions();
		sw.setCountries(sulb);
		return sw;
	}
}
