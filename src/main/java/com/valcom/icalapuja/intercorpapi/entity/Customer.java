package com.valcom.icalapuja.intercorpapi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Tbl_Customer")
public @Data class Customer implements Cloneable {
	@Id
	@GeneratedValue
	private Long code;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String lastName;
	
	@NotNull
    @Past
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date birthDate;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date deathDate;
	private int age;
}
