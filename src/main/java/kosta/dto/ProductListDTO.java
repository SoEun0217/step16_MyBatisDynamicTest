package kosta.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductListDTO {
	private String code;
	private String name;
	private int qty;
	private int price;
	private String detail;
	
	public ProductListDTO() {}

	public ProductListDTO(String code, String name, int qty, int price, String detail) {
		super();
		this.code = code;
		this.name = name;
		this.qty = qty;
		this.price = price;
		this.detail = detail;
	}
	
	@Override
	public String toString() {
		return code+" | "+name+" | "+qty+" | "+price+" | "+detail+"\n";
	}
}
