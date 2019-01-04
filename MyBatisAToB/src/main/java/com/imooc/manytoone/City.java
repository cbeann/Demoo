package com.imooc.manytoone;

public class City {

	private Integer cid;

	private String cname;

	//添加一个一方的属性
	private Country country;

	public Integer getCid() {
		return cid;
	}

	public City() {
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "City [cid=" + cid + ", cname=" + cname + ", country=" + country + "]";
	}

}
