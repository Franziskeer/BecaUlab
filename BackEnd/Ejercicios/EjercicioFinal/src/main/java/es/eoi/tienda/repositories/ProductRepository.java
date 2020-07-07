package es.eoi.tienda.repositories;

import java.util.List;

import es.eoi.tienda.entities.Product;

public interface ProductRepository {
	
	public Boolean create(Product newProduct);
	
	public List<Product> readAll();
	
	public List<Product> read(Object filter);
	
	public Boolean update(Product myProd);
	
	public Boolean delete(Product myProd);
	
}
