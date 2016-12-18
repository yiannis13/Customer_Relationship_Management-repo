package gr.ioannidis.db.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import gr.ioannidis.db.model.Customer;


@Repository
public class CustomerDbService implements ICustomerDbService {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<Customer> findAll() {
		CriteriaBuilder cb = getSession().getCriteriaBuilder();
		CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
		Root<Customer> rootEntry = cq.from(Customer.class);
		CriteriaQuery<Customer> all = cq.select(rootEntry);
		TypedQuery<Customer> allQuery = getSession().createQuery(all);
		return allQuery.getResultList().stream().sorted().collect(Collectors.toList());
	}

	@Override
	public void create(Customer entity) {
		getSession().persist(entity);
	}

	@Override
	public Customer find(Object id) {
		return getSession().find(Customer.class, id);
	}

	@Override
	public void update(Customer entity) {
		 getSession().merge(entity);
	}

	@Override
	public void delete(Customer entity) {
		getSession().remove(getSession().merge(entity));
	}

}
