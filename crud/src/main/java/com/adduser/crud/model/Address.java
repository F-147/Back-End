/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.adduser.crud.model;

import java.io.Serializable;

import javax.persistence.Basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author manka
 */
@Entity
@Table(name = "ADDRESS", catalog = "GGEZ", schema = "PUBLIC")
@NamedQueries({
        @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a"),
        @NamedQuery(name = "Address.findById", query = "SELECT a FROM Address a WHERE a.id = :id"),
        @NamedQuery(name = "Address.findByprovinceId", query = "SELECT a FROM Address a WHERE a.provinceId = :provinceId"),
        @NamedQuery(name = "Address.findByAddressNo", query = "SELECT a FROM Address a WHERE a.addressNo = :addressNo") })
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "ADDRESS_NO", nullable = false, length = 512)
    private String addressNo;
    @JoinColumn(name = "ADDRESS_TYPE", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private AddressType addressType;
    @JoinColumn(name = "DISTRICT_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ThDistrict districtId;
    //*****
    @JoinColumn(name = "PROVINCE_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ThProvince provinceId;
    
    @JoinColumn(name = "SUB_DISTRICT_ID", referencedColumnName = "ID", nullable = false)
    @JsonIgnore
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ThSubdistrict subDistrictId;
    
    // ***
    //@JsonIgnore
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User userId;
    
    
    
    public Address() {
    }

    public Address(Long id) {
        this.id = id;
    }

    
    public Address(Long id, String addressNo, AddressType addressType, ThDistrict districtId, ThProvince provinceId,
			ThSubdistrict subDistrictId) {
		super();
		this.id = id;
		this.addressNo = addressNo;
		this.addressType = addressType;
		this.districtId = districtId;
		this.provinceId = provinceId;
		this.subDistrictId = subDistrictId;
	}
	public String getFullAddress() {
        return this.addressNo + ", " + this.subDistrictId.getNameTh() + ", " + this.districtId.getNameTh()
                + ", " + this.provinceId.getNameTh();
    }

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public ThProvince getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(ThProvince provinceId) {
		this.provinceId = provinceId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    

    public String getAddressNo() {
        return addressNo;
    }

    public void setAddressNo(String addressNo) {
        this.addressNo = addressNo;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }

    public ThDistrict getDistrictId() {
        return districtId;
    }

    public void setDistrictId(ThDistrict districtId) {
        this.districtId = districtId;
    }

   

    public ThSubdistrict getSubDistrictId() {
        return subDistrictId;
    }

    public void setSubDistrictId(ThSubdistrict subDistrictId) {
        this.subDistrictId = subDistrictId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.Address[ id=" + id + " ]";
    }

}
