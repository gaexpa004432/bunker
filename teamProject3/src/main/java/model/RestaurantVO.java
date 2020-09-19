package model;

import java.util.List;

public class RestaurantVO {
	private int res_no; 
	private String res_name;
	private String res_content;
	private String res_date;
	private String res_tel;
	private String res_si;
	private String res_gu;
	private String res_dong;
	private List<String> res_picture;
	private Integer first;
	private Integer last;
	
	public Integer getFirst() {
		return first;
	}
	public void setFirst(Integer first) {
		this.first = first;
	}
	public Integer getLast() {
		return last;
	}
	public void setLast(Integer last) {
		this.last = last;
	}
	public int getRes_no() {
		return res_no;
	}
	public void setRes_no(int res_no) {
		this.res_no = res_no;
	}
	public String getRes_name() {
		return res_name;
	}
	public void setRes_name(String res_name) {
		this.res_name = res_name;
	}
	public String getRes_content() {
		return res_content;
	}
	public void setRes_content(String res_content) {
		this.res_content = res_content;
	}
	public String getRes_date() {
		return res_date;
	}
	public void setRes_date(String res_date) {
		this.res_date = res_date;
	}
	public String getRes_tel() {
		return res_tel;
	}
	public void setRes_tel(String res_tel) {
		this.res_tel = res_tel;
	}
	public String getRes_si() {
		return res_si;
	}
	public void setRes_si(String res_si) {
		this.res_si = res_si;
	}
	public String getRes_gu() {
		return res_gu;
	}
	public void setRes_gu(String res_gu) {
		this.res_gu = res_gu;
	}
	public String getRes_dong() {
		return res_dong;
	}
	public void setRes_dong(String res_dong) {
		this.res_dong = res_dong;
	}
	public List<String> getRes_picture() {
		return res_picture;
	}
	public void setRes_picture(List<String> res_picture) {
		this.res_picture = res_picture;
	}
	
}
