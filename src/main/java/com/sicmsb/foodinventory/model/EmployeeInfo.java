package com.sicmsb.foodinventory.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE_INFO")
public class EmployeeInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "employee_no", nullable = false)
	private String employeeNo;

	@ManyToOne
	@JoinColumn(name = "role_id", nullable = false)
	private RoleInfo  roleId;

	@Column(name = "name", length = 200, nullable = false)
	private String name;

	@Column(name = "department", length = 100, nullable = false)
	private String department;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public RoleInfo getRoleInfo() {
		return roleId;
	}

	public void setRoleInfo(RoleInfo roleId) {
		this.roleId = roleId;
	}

}
