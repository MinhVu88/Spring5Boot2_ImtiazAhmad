package spring5.sec_1.demo.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/layers_0")
public class DemoController_0 {
	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	public String test1() {
		return "<h1 style=\"color:crimson; text-align:center; margin-top: 80px\">Hi there</h1>";
	}
	
//	@RequestMapping(value = "/2", method = RequestMethod.GET)
	@RequestMapping("/test2")
	public String test2() {
		return "<h1 style=\"color:green; text-align:center; margin-top: 80px\">How are you?</h1>";
	}

	@RequestMapping("form")
	public String displayForm() {
		return "<form action=\"/layers/form_data\" method=\"POST\">\r\n"
		+ "  <label for=\"firstName\">First name:</label><br>\r\n"
		+ "  <input type=\"text\" id=\"fname\" name=\"firstName\"><br>\r\n"
		+ "  <label for=\"lastName\">Last name:</label><br>\r\n"
		+ "  <input type=\"text\" id=\"lname\" name=\"lastName\"><br><br>\r\n"
		+ "  <input type=\"submit\" value=\"Submit\">\r\n"
		+ "</form>";
	}
	
	@RequestMapping(value = "form_data", method = RequestMethod.POST)
	public String submitFormData(@RequestParam String firstName, @RequestParam String lastName) {
		return "<h1 style=\"color:green; text-align:center; margin-top: 80px\">"
				+ "Form Submitted! Welcome " + firstName + " " + lastName
				+ "</h1>";
	}
	
	@RequestMapping(value = "/orders/{id}", method = RequestMethod.GET)
	public String getOrders(@PathVariable String id) {
		return "<h1 style=\"color:crimson; text-align:center; margin-top: 80px\">Order id: " + id + "</h1>";
	}
}
