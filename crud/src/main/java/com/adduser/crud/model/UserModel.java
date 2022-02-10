package com.adduser.crud.model;

import java.util.ArrayList;
import java.util.List;

public class UserModel {
	private Long id;
    private String title;
    private String fname;
    private String lname;
	private Long telphone;
    private List<AddressModel> addressModelList = new ArrayList<AddressModel>();
    
    public UserModel() {
    	
    }

	public UserModel(Long id, String title, String fname, String lname, Long telphone ,List<AddressModel> addressModelList) {
		super();
		this.id = id;
		this.title = title;
		this.fname = fname;
		this.lname = lname;
		this.telphone = telphone;
		this.addressModelList = addressModelList;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public Long getTelphone() {
        return telphone;
    }

    public void setTelphone(Long telphone) {
        this.telphone = telphone;
    }

	public List<AddressModel> getAddressModelList() {
		return addressModelList;
	}

	public void setAddressModelList(List<AddressModel> addressModelList) {
		this.addressModelList = addressModelList;
	}
    
	

}
