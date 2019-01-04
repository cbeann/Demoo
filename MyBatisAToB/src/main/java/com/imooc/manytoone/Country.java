package com.imooc.manytoone;

public class Country {

	private Integer id;
	private String name;

	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + "]";
	}

	public Country(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Country() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
