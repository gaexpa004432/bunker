package model;

import lombok.Data;

@Data
public class MemberVO {
	private String member_id;
	private	String member_name;
	private String member_tel;
	private String member_address;
	private String member_pass;
	private String member_gender;
	private String member_birth;
	private String member_type;
	private int member_mileage;
	private String seller_code;
	
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getMember_tel() {
		return member_tel;
	}
	public void setMember_tel(String member_tel) {
		this.member_tel = member_tel;
	}
	public String getMember_address() {
		return member_address;
	}
	public void setMember_address(String member_address) {
		this.member_address = member_address;
	}
	public String getMember_pass() {
		return member_pass;
	}
	public void setMember_pass(String member_pass) {
		this.member_pass = member_pass;
	}
	public String getMember_gender() {
		return member_gender;
	}
	public void setMember_gender(String member_gender) {
		this.member_gender = member_gender;
	}
	public String getMember_birth() {
		return member_birth;
	}
	public void setMember_birth(String member_birth) {
		this.member_birth = member_birth;
	}
	public String getMember_type() {
		return member_type;
	}
	public void setMember_type(String member_type) {
		this.member_type = member_type;
	}
	public int getMember_mileage() {
		return member_mileage;
	}
	public void setMember_mileage(int member_mileage) {
		this.member_mileage = member_mileage;
	}
	public String getSeller_code() {
		return seller_code;
	}
	public void setSeller_code(String seller_code) {
		this.seller_code = seller_code;
	}
	
	
}
