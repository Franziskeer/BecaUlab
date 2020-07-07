package es.eoi.tienda.entities;

import es.eoi.tienda.enums.Category;
import es.eoi.tienda.enums.Vat;

public class Product {

	// ATRIBUTOS
	private Integer cod;
	private String name;
	private String description;
	private Vat vat;
	private Double price;
	private Integer availableProducts;
	private Integer soldProducts;
	private Category category;

	// CONSTRUCTORES
	public Product(String name, String description, Vat vat, Double price, Integer availableProducts,
			Category category) {
		super();
		this.cod = 0;
		this.name = name;
		this.description = description;
		this.vat = vat;
		this.price = price;
		this.availableProducts = availableProducts;
		this.soldProducts = 0;
		this.category = category;
	}

	// GETTERS & SETTERS
	public Integer getCod() {
		return cod;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Vat getVat() {
		return vat;
	}

	public Double getPrice() {
		return price;
	}

	public Integer getAvailableProducts() {
		return availableProducts;
	}

	public Integer getSoldProducts() {
		return soldProducts;
	}

	public Category getCategory() {
		return category;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setVat(Vat vat) {
		this.vat = vat;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setAvailableProducts(Integer availableProducts) {
		this.availableProducts = availableProducts;
	}

	public void setSoldProducts(Integer soldProducts) {
		this.soldProducts = soldProducts;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	// SALIDA POR CONSOLA
	@Override
	public String toString() {
		return String.format(
				"Product [cod=%s, name=%s, description=%s, vat=%s, price=%s, availableProducts=%s, soldProducts=%s, category=%s]",
				cod, name, description, vat, price, availableProducts, soldProducts, category);
	}

}
