package spring5.sec_1.demo.web;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring5.sec_1.demo.domains.Products;

@RestController
@RequestMapping("/layers_1")
public class DemoController_1 {
	@RequestMapping("/{id}")
	public String showUserId(@PathVariable int id) {
		return "<h1 style=\"color:crimson; text-align:center; margin-top: 80px\">user id: " + id + "</h1>";
	}
	
	@RequestMapping("/{id}/invoices")
	public String showInvoices(@PathVariable("id") int id, @RequestParam(value = "date", required = false) Date optionalDate) {
		return "<h1 style=\"color:crimson; text-align:center; margin-top: 80px\">"
				+ "user id: " + id + " | Date: " + optionalDate +
				"</h1>";
	}

	@RequestMapping("/{id}/items")
	public List<String> showItems() {
		return Arrays.asList("laptop", "cellphone", "coffee");
	}
	
	@RequestMapping("/{id}/products")
	public List<Products> showProducts() {
		return Arrays.asList(new Products(1, "laptop", 88.99),
							 new Products(2, "mouse", 51.99),
							 new Products(3, "cooling pad", 47.99));
	}
}
