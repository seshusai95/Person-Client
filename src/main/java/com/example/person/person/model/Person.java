package com.example.person.person.model;

public class Person {
	private int id;
	private String name;
	private int age;
	private String city;
	private long phone;
	
	
//	public Person() {
//		super();
//	}
//	public Person(String name, int age, String city, long phone) {
//		super();
//		this.name = name;
//		this.age = age;
//		this.city = city;
//		this.phone = phone;
//	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + ", city=" + city + ", phone=" + phone + "]";
	}
	
	
	
}
