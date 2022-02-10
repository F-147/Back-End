/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.adduser.crud.model;

import java.io.Serializable;
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
@Table(name = "TH_PROVINCE", catalog = "GGEZ", schema = "PUBLIC")
@NamedQueries({
        @NamedQuery(name = "ThProvince.findAll", query = "SELECT t FROM ThProvince t"),
        @NamedQuery(name = "ThProvince.findById", query = "SELECT t FROM ThProvince t WHERE t.id = :id"),
        @NamedQuery(name = "ThProvince.findByNameTh", query = "SELECT t FROM ThProvince t WHERE t.nameTh = :nameTh"),
        @NamedQuery(name = "ThProvince.findByNameEn", query = "SELECT t FROM ThProvince t WHERE t.nameEn = :nameEn") })
public class ThProvince implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Long id;
    @Column(name = "NAME_TH", length = 120)
    private String nameTh;
    @Column(name = "NAME_EN", length = 120)
    private String nameEn;
    
//    @JsonIgnore
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "provinceId", fetch = FetchType.LAZY)
//    private Address address;

    public ThProvince() {
    }

    public ThProvince(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ThProvince)) {
            return false;
        }
        ThProvince other = (ThProvince) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.ThProvince[ id=" + id + " ]";
    }

}
