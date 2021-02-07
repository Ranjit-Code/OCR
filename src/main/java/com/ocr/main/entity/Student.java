package com.ocr.main.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Student {

	@Id
	private String student_id;
	
	@Column
	private String name;
	
	@Column
	private String email_id;
	
	@Column
	private String contact_no;
	
	@Column
	private String gender;
	
	@Column
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dob;
	
	@Column
	private String country;
	
	@Column
	private int qualification;
	
	@Column
	private int area_of_interest;

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getContact_no() {
		return contact_no;
	}

	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getQualification() {
		return qualification;
	}

	public void setQualification(int qualification) {
		this.qualification = qualification;
	}

	public int getArea_of_interest() {
		return area_of_interest;
	}

	public void setArea_of_interest(int area_of_interest) {
		this.area_of_interest = area_of_interest;
	}

	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", name=" + name + ", email_id=" + email_id + ", contact_no="
				+ contact_no + ", gender=" + gender + ", dob=" + dob + ", country=" + country + ", qualification="
				+ qualification + ", area_of_interest=" + area_of_interest + "]";
	}
}
