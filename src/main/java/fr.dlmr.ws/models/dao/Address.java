package fr.dlmr.ws.models.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "address")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ADDRESS_ID", unique = true, nullable = false)
    private int accountId;

    @Column(name = "STREET")
    private String street;

    @Column(name = "CITY")
    private String city;

    @Column(name = "ZIP_CODE")
    private String zipCode;

    // Create a constructor
    public Address (int accountId, String street, String city, String zipCode, String country)
    {
        this.accountId = accountId;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }

    public Address() {

    }

    public String getStreet ()
    {
        return street;
    }

    public void setStreet (String street)
    {
        this.street = street;
    }

    public String getCity ()
    {
        return city;
    }

    public void setCity (String city)
    {
        this.city = city;
    }

    public String getZipCode ()
    {
        return zipCode;
    }

    public void setZipCode (String zipCode)
    {
        this.zipCode = zipCode;
    }

}
