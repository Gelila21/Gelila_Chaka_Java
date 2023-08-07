package com.example.customerdataservice.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="customer")
public class Customer implements Serializable
{
    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private String company;
    private String phone;
    private String address_1;

    private String address_2;

    private String city;
    private String state;
    private String postal_code;

    private String country;

    public Customer(String john, String doe, String newYork)
    {
    }


    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getFirst_name()
    {
        return first_name;
    }

    public void setFirst_name(String first_name)
    {
        this.first_name = first_name;
    }

    public String getLast_name()
    {
        return last_name;
    }

    public void setLast_name(String last_name)
    {
        this.last_name = last_name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getCompany()
    {
        return company;
    }

    public void setCompany(String company)
    {
        this.company = company;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getAddress_1()
    {
        return address_1;
    }

    public void setAddress_1(String address_1)
    {
        this.address_1 = address_1;
    }

    public String getAddress_2()
    {
        return address_2;
    }

    public void setAddress_2(String address_2)
    {
        this.address_2 = address_2;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getPostal_code()
    {
        return postal_code;
    }

    public void setPostal_code(String postal_code)
    {
        this.postal_code = postal_code;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id && Objects.equals(first_name, customer.first_name) && Objects.equals(last_name, customer.last_name) && Objects.equals(email, customer.email) && Objects.equals(company, customer.company) && Objects.equals(phone, customer.phone) && Objects.equals(address_1, customer.address_1) && Objects.equals(address_2, customer.address_2) && Objects.equals(city, customer.city) && Objects.equals(state, customer.state) && Objects.equals(postal_code, customer.postal_code) && Objects.equals(country, customer.country);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, first_name, last_name, email, company, phone, address_1, address_2, city, state, postal_code, country);
    }

    @Override
    public String toString()
    {
        return "Customer{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", company='" + company + '\'' +
                ", phone='" + phone + '\'' +
                ", address_1='" + address_1 + '\'' +
                ", address_2='" + address_2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postal_code='" + postal_code + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
