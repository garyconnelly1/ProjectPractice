package com.example.demo.model;

import javax.persistence.*;

@Entity
@NamedQueries({ @NamedQuery(name = "Worker.findAll", query = "SELECT w FROM Worker w") })

public class Worker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "worker_id")
	private int workerId;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "age")
	private int age;
	@Column(name = "trade")
	private String trade;
	@Column(name = "rating")
	private int rating;

	@ManyToOne
	@JoinColumn(name = "address_id")
	private Address address;
	
	public Worker() {}

	public Worker(int workerId, String firstName, String lastName, int age, String trade, int rating, Address address) {
		super();
		this.workerId = workerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.trade = trade;
		this.rating = rating;
		this.address = address;
	}

	public int getWorkerId() {
		return workerId;
	}

	public void setWorkerId(int workerId) {
		this.workerId = workerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getTrade() {
		return trade;
	}

	public void setTrade(String trade) {
		this.trade = trade;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
}
