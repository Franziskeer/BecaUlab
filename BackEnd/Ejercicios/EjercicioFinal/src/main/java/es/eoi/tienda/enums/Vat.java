package es.eoi.tienda.enums;

public enum Vat {
	
	TWENTYONE(21), 
	TEN(10), 
	FOUR(4); 

	private Integer vatValue;

	private Vat(Integer text) {
		this.vatValue = text;
	}

	public Integer getVatValue() {
		return this.vatValue;
	}

}
