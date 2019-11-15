package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.springframework.lang.NonNull;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Account {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name = "email")
	@NonNull
	private String email;
	
	@Column(name = "password")
	@NonNull
	private String password;
	
	@Column(name = "firstName")
	@NonNull
	private String firstName;
	
	@Column(name = "lastName")
	@NonNull
	private String lastName;
	
	@Column(name = "address")
	@NonNull
	private String address;
	
	@Column(name = "city")
	@NonNull
	private String city;
	
	@Column(name = "country")
	@NonNull
	private Country country;
	
	@Column(name = "phoneNumber")
	@NonNull
	private String phoneNumber;

	public Account(){
		super();
	}

	public Account(String password, String firstName, String lastName, String address, String city, Country country,
			String phoneNumber, String email) {
		super();
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.country = country;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



}
