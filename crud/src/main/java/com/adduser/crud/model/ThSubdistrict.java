/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.adduser.crud.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author manka
 */
@Entity
@Table(name = "TH_SUBDISTRICT", catalog = "GGEZ", schema = "PUBLIC")
@NamedQueries({
        @NamedQuery(name = "ThSubdistrict.findAll", query = "SELECT t FROM ThSubdistrict t"),
        @NamedQuery(name = "ThSubdistrict.findById", query = "SELECT t FROM ThSubdistrict t WHERE t.id = :id"),
        @NamedQuery(name = "ThSubdistrict.findByDistrictId", query = "SELECT t FROM ThSubdistrict t WHERE t.districtId = :districtId"),
        @NamedQuery(name = "ThSubdistrict.findByNameTh", query = "SELECT t FROM ThSubdistrict t WHERE t.nameTh = :nameTh"),
        @NamedQuery(name = "ThSubdistrict.findByNameEn", query = "SELECT t FROM ThSubdistrict t WHERE t.nameEn = :nameEn"),
        @NamedQuery(name = "ThSubdistrict.findByLat", query = "SELECT t FROM ThSubdistrict t WHERE t.lat = :lat"),
        @NamedQuery(name = "ThSubdistrict.findByLong1", query = "SELECT t FROM ThSubdistrict t WHERE t.long1 = :long1"),
        @NamedQuery(name = "ThSubdistrict.findByZipcode", query = "SELECT t FROM ThSubdistrict t WHERE t.zipcode = :zipcode") })
public class ThSubdistrict implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Long id;
    @Column(name = "DISTRICT_ID")
    private Long districtId;
    @Column(name = "NAME_TH", length = 120)
    private String nameTh;
    @Column(name = "NAME_EN", length = 120)
    private String nameEn;
    // @Max(value=?) @Min(value=?)//if you know range of your decimal fields
    // consider using these annotations to enforce field validation
    @Column(name = "LAT", precision = 5, scale = 3)
    private BigDecimal lat;
    @Column(name = "LONG", precision = 6, scale = 3)
    private BigDecimal long1;
    @Column(name = "ZIPCODE")
    private Long zipcode;
    // @OneToMany(cascade = CascadeType.ALL, mappedBy = "subDistrictId", fetch =
    // FetchType.EAGER)
    // private List<Address> addressList;

    public ThSubdistrict() {
    }

    public ThSubdistrict(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public String getNameTh() {
        return nameTh;
    }

    public void setNameTh(String nameTh) {
        this.nameTh = nameTh;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    public BigDecimal getLong1() {
        return long1;
    }

    public void setLong1(BigDecimal long1) {
        this.long1 = long1;
    }

    public Long getZipcode() {
        return zipcode;
    }

    public void setZipcode(Long zipcode) {
        this.zipcode = zipcode;
    }

    // public List<Address> getAddressList() {
    // return addressList;
    // }

    // public void setAddressList(List<Address> addressList) {
    // this.addressList = addressList;
    // }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ThSubdistrict)) {
            return false;
        }
        ThSubdistrict other = (ThSubdistrict) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.ThSubdistrict[ id=" + id + " ]";
    }

}
