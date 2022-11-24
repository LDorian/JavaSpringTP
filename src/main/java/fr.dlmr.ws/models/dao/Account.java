package fr.dlmr.ws.models.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table (name = "accounts")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Account implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ACCOUNT_ID", unique = true, nullable = false)
	private int accountId;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ADDRESS_ID")
	private Address address;

	public Account (int accountId, String firstName, String lastName, Address address, List<BankDetail> bankDetails)
	{
		this.accountId = accountId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getAccountId ()
	{
		return accountId;
	}

	public void setAccountId (int accountId)
	{
		this.accountId = accountId;
	}

	public String getFirstName ()
	{
		return firstName;
	}

	public void setFirstName (String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName ()
	{
		return lastName;
	}

	public void setLastName (String lastName)
	{
		this.lastName = lastName;
	}

	public Account () {
		// TODO Auto-generated constructor stub
	}

}

