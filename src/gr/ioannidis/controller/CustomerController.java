package gr.ioannidis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import gr.ioannidis.db.controller.ICustomerDbService;
import gr.ioannidis.db.model.Customer;
import gr.ioannidis.service.ICustomerService;


@Controller
@RequestMapping("/customer")
public class CustomerController  {
	
	@Autowired
	private ICustomerService customerService;
	@Autowired
	private ICustomerDbService customerDbService;
	
	
	@GetMapping("/list")
	public String customerList(Model model) {
		List<Customer> customers = customerService.getCustomers();
		model.addAttribute("customers", customers);
		return "list-customers";
	}
	
	@GetMapping("/getFormForAddingCustomer")
	public String getForm(Model model) {
		//create model attribute to bind the form data 
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "addCustomerForm";
	}
	
	@PostMapping("/addCustomer")
	public String addCustomer(@ModelAttribute("customer") Customer customer) {
		customerService.addCustomer(customer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdatingCustomer")
	public String showFormForUpdatingCustomer(@RequestParam("customerId") int id, Model model) {
		Customer customer = customerService.getCustomer(id);
		model.addAttribute("customerForUpdate", customer);
		return "showFormForUpdatingCustomer";
	}
	
	@PostMapping("/updateCustomer")
	public String updateCustomer(@ModelAttribute("customerForUpdate") Customer customer) {
		customerService.updateCustomer(customer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int id) {
		customerService.deleteCustomer(id);
		return "redirect:/customer/list";
	} 
	
	
	@RequestMapping("/{id}")
	public String getCustomer(Model model, @PathVariable("id") int id) {
		Customer customer = customerDbService.find(id);
		model.addAttribute("customer", customer);
		return "getCustomer";
	}

	
}
