package com.Staff.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Staff")
public class Staff {

	@Id
	private Long empId;

	private String empName;

	private String email;
	private int empSalary;

	public Staff() {

	}

	public Staff(Long empId, Long empDeptId, String empName, String empDeptName, String email, int empSalary) {
		super();
		this.empId = empId;

		this.empName = empName;

		this.email = email;
		this.empSalary = empSalary;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}



	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(int empSalary) {
		this.empSalary = empSalary;
	}

	@Override
	public String toString() {
		return "Staff [empId=" + empId + ",  empName=" + empName + ", email=" + email + ", empSalary=" + empSalary + "]";
	}

}
