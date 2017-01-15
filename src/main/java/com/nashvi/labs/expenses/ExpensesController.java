package com.nashvi.labs.expenses;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class ExpensesController {

	@RequestMapping(value = "/expenses", method = RequestMethod.GET)
	public List<String> allExpenses() {
		List<String> expenses = Arrays.asList("Direct", "Indirect");
		return expenses;
	}
}
