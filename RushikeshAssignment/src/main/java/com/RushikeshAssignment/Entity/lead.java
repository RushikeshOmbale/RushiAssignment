package com.RushikeshAssignment.Entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "leads")
public class lead {
	@Id
	private int id;

	@NotBlank
	@Pattern(regexp = "^[a-zA-Z]+$")
	private String firstName;

	@Pattern(regexp = "^[a-zA-Z]+$")
	private String middleName;

	@NotBlank
	@Pattern(regexp = "^[a-zA-Z]+$")
	private String lastName;

	@NotBlank
	@Pattern(regexp = "^[6-9]\\d{9}$")
	private String mobileNumber;

	@NotBlank
	@Pattern(regexp = "^(Male|Female|Others)$")
	private String gender;

	@NotNull
	@JsonFormat(pattern = "MM/dd/yyyy", shape = JsonFormat.Shape.STRING)
	@Temporal(TemporalType.DATE)
	private Date dob;

	@NotBlank
	@Email
	private String email;

	public lead() {
		super();
	}

	public lead(int id, @NotBlank @Pattern(regexp = "^[a-zA-Z]+$") String firstName,
			@Pattern(regexp = "^[a-zA-Z]+$") String middleName,
			@NotBlank @Pattern(regexp = "^[a-zA-Z]+$") String lastName,
			@NotBlank @Pattern(regexp = "^[6-9]\\d{9}$") String mobileNumber,
			@NotBlank @Pattern(regexp = "^(Male|Female|Others)$") String gender, @NotNull Date dob,
			@NotBlank @Email String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.gender = gender;
		this.dob = dob;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
