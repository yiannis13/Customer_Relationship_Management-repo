package gr.ioannidis.db;

import java.util.List;

public interface IDbService<T> {

	void create(T entity);
	
	T find(Object id);
	
	void update(T entity);
	
	void delete(T entity);
	
	List<T> findAll();
}
