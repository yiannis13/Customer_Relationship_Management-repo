package gr.ioannidis.service;

import java.util.List;
import gr.ioannidis.db.model.Customer;


public interface ICustomerService {
	
	List<Customer> getCustomers();
	
	void addCustomer(Customer customer);
	
	Customer getCustomer(int id);

	void updateCustomer(Customer customer);

	void deleteCustomer(int id);
}
