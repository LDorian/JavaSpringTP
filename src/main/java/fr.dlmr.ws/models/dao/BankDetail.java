package fr.dlmr.ws.models.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import fr.dlmr.ws.models.AttributeEncryptor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "bankdetail")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class BankDetail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BANK_DETAIL_ID", unique = true, nullable = false)
    private int bankDetailId;

    // Create columns for the IBAN
    @Column(name = "IBAN")
    @Convert(converter = AttributeEncryptor.class) // This is for the encryption
    private String iban;

    // Many to one relationship with Account
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ACCOUNT_ID")
    private Account account;

    // Create a constructor
    public BankDetail (int bankDetailId, String iban, Account account)
    {
        this.bankDetailId = bankDetailId;
        this.iban = iban;
        this.account = account;
    }

    public BankDetail() {

    }
    // Create getters and setters
    public String getIban ()
    {
        return iban;
    }

    public void setIban (String iban)
    {
        this.iban = iban;
    }

    public Account getAccount ()
    {
        return account;
    }

    public void setAccount (Account account)
    {
        this.account = account;
    }

    public void setBankDetailId (int bankDetailId)
    {
        this.bankDetailId = bankDetailId;
    }

    public int getBankDetailId ()
    {
        return bankDetailId;
    }
}
