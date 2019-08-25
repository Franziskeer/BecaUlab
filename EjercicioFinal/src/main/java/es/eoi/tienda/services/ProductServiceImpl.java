package es.eoi.tienda.services;

import java.util.ArrayList;
import java.util.List;

import es.eoi.tienda.entities.Product;
import es.eoi.tienda.enums.Category;
import es.eoi.tienda.repositories.ProductRepository;
import es.eoi.tienda.repositories.ProductRepositoryImpl;

public class ProductServiceImpl implements ProductService {

	private ProductRepository myRepository;
	
	public ProductServiceImpl() {
		this.myRepository = new ProductRepositoryImpl();
	}
	
	public Boolean create(Product newProduct) {
		List<Product> myProds = readAll();
		int cod = 1;
		
		if (!myProds.isEmpty()) {
			cod = myProds.get(myProds.size()-1).getCod()+1;
		}
		
		newProduct.setCod(cod);
		
		return myRepository.create(newProduct);
	}

	public List<Product> readAll() {
		return myRepository.readAll();
	}

	public List<Product> read(Object filter) {
		
		if ((filter instanceof Integer) || (filter instanceof String) || (filter instanceof Category)) {
			return myRepository.read(filter);
		} 
		
		return (new ArrayList<Product>());
	}

	public Boolean update(Product myProd) {
		return myRepository.update(myProd);
	}

	public Boolean delete(Product myProd) {
		return myRepository.delete(myProd);
	}

}
