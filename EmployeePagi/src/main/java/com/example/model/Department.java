package com.example.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class Department implements Serializable {

	private int eid;
	private String name;

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(int eid, String name) {
		super();
		this.eid = eid;
		this.name = name;
	}
//
//	public int geteId() {
//		return e_id;
//	}
//
//	public void seteId(int eId) {
//		this.e_id = eId;
//	}

	public String getName() {
		return name;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(eid, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		return eid == other.eid && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Department [eId=" + eid + ", name=" + name + "]";
	}

}