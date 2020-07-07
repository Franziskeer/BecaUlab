package es.eoi.tienda.repositories;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import es.eoi.tienda.entities.Product;

public class ProductRepositoryImpl implements ProductRepository {

	private List<Product> dataBase;

	static Gson gson = new GsonBuilder().setPrettyPrinting().create();
	static String path = "productos.json";

	public ProductRepositoryImpl() {

		if (new File(path).exists()) {
			this.dataBase = readAll();
		} else {
			this.dataBase = new ArrayList<Product>();
			BufferedWriter writer;
			
			try {
				writer = new BufferedWriter(new FileWriter(path, false));
				writer.write(gson.toJson(dataBase));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public Boolean create(Product newProduct) {

		BufferedWriter writer = null;

		try {
			this.dataBase = readAll();
			writer = new BufferedWriter(new FileWriter(path, false));
			dataBase.add(newProduct);
			writer.write(gson.toJson(dataBase));
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return false;
	}

	public List<Product> readAll() {

		List<Product> productosResul = new ArrayList<Product>();
		Product[] myProducts = null;

		try {
			myProducts = gson.fromJson(new FileReader(path), Product[].class);

			if (myProducts != null) {
				productosResul = new ArrayList<Product>(Arrays.asList(myProducts));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return productosResul;

	}

	public List<Product> read(Object filter) {

		List<Product> foundProducts = readAll();
		
		
		
		
		return foundProducts;
	}

	public Boolean update(Product myProd) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean delete(Product myProd) {
		// TODO Auto-generated method stub
		return null;
	}

}
