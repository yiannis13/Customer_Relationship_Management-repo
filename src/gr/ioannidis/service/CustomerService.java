package gr.ioannidis.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import gr.ioannidis.db.controller.ICustomerDbService;
import gr.ioannidis.db.model.Customer;


@Service
public class CustomerService implements ICustomerService {
	
	@Autowired
	private ICustomerDbService customerDbService;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDbService.findAll();
	}

	@Override
	@Transactional
	public void addCustomer(Customer customer) {
		customerDbService.create(customer);		
	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {
		return customerDbService.find(id);
	}

	@Override
	@Transactional
	public void updateCustomer(Customer customer) {
		customerDbService.update(customer);
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {
		customerDbService.delete(getCustomer(id));
	}

	
}
