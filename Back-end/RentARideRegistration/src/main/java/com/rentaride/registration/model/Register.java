package com.rentaride.registration.model;

import jakarta.validation.constraints.NotBlank;
//import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
@SequenceGenerator(name="registration_id_seq", initialValue=11)
public class Register {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="registration_id_seq")
	@Column(name = "registration_id", unique = true)
//	@ApiModelProperty(value = "User id")
	private Integer registrationId;
	
	@Column(name = "full_name")
//	@ApiModelProperty(value = "User full name")
	@NotBlank(message = "Full name cannot be blank")
	private String fullName;
	
	@Column(name = "contact_number")
//	@ApiModelProperty(value = "User contact number")
	@NotBlank(message = "Contact Number cannot be blank")
	private String contactNumber;
	
	@Column(name = "date_of_birth")
//	@ApiModelProperty(value = "User date of birth")
	@NotBlank(message = "Date of Birth cannot be blank")
	private String dateOfBirth;
	
	@Column(name = "user_role")
//	@ApiModelProperty(value = "User role")
	@NotBlank(message = "User role cannot be blank")
	private String userRole;
	
	@Column(name = "user_email")
//	@ApiModelProperty(value = "User full name")
	@NotBlank(message = "Email cannot be blank")
	private String email;
	
	@Column(name = "user_password")
//	@ApiModelProperty(value = "User password")
	@NotBlank(message = "Password cannot be blank")
	private String password;
}
