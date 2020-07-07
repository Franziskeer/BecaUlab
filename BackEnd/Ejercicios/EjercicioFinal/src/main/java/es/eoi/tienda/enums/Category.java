package es.eoi.tienda.enums;

public enum Category {
	
	FOOD("Food"), 
	MATERIAL("Material"), 
	MECANIC("Mecanic"), 
	LUXURY("Luxury");

	private String description;

	private Category(String text) {
		this.description = text;
	}

	public String getDescripcion() {
		return this.description;
	}

}
