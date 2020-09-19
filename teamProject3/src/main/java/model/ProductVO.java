package model;

import lombok.Data;

@Data
public class ProductVO {
	private int product_number;
	private String product_name;
	private int product_price;
	private String product_unit;
	private String product_status;
	private int seller_code;
}
