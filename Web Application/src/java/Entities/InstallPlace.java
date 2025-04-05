/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author miste
 */
@Entity
@Table(name = "install_place")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InstallPlace.findAll", query = "SELECT i FROM InstallPlace i")
    , @NamedQuery(name = "InstallPlace.findByPlaceId", query = "SELECT i FROM InstallPlace i WHERE i.placeId = :placeId")
    , @NamedQuery(name = "InstallPlace.findByDepartmentPlace", query = "SELECT i FROM InstallPlace i WHERE i.departmentPlace = :departmentPlace")
    , @NamedQuery(name = "InstallPlace.findByCabinetNumber", query = "SELECT i FROM InstallPlace i WHERE i.cabinetNumber = :cabinetNumber")
    , @NamedQuery(name = "InstallPlace.findByPeopleNumber", query = "SELECT i FROM InstallPlace i WHERE i.peopleNumber = :peopleNumber")})
public class InstallPlace implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "place_id")
    private Integer placeId;
    @Basic(optional = false)
    @Column(name = "department_place")
    private String departmentPlace;
    @Basic(optional = false)
    @Column(name = "cabinet_number")
    private String cabinetNumber;
    @Basic(optional = false)
    @Column(name = "people_number")
    private short peopleNumber;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "installPlace")
    private List<Equipment> equipmentList;

    public InstallPlace() {
    }

    public InstallPlace(Integer placeId) {
        this.placeId = placeId;
    }

    public InstallPlace(Integer placeId, String departmentPlace, String cabinetNumber, short peopleNumber) {
        this.placeId = placeId;
        this.departmentPlace = departmentPlace;
        this.cabinetNumber = cabinetNumber;
        this.peopleNumber = peopleNumber;
    }

    public Integer getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
    }

    public String getDepartmentPlace() {
        return departmentPlace;
    }

    public void setDepartmentPlace(String departmentPlace) {
        this.departmentPlace = departmentPlace;
    }

    public String getCabinetNumber() {
        return cabinetNumber;
    }

    public void setCabinetNumber(String cabinetNumber) {
        this.cabinetNumber = cabinetNumber;
    }

    public short getPeopleNumber() {
        return peopleNumber;
    }

    public void setPeopleNumber(short peopleNumber) {
        this.peopleNumber = peopleNumber;
    }

    @XmlTransient
    public List<Equipment> getEquipmentList() {
        return equipmentList;
    }

    public void setEquipmentList(List<Equipment> equipmentList) {
        this.equipmentList = equipmentList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (placeId != null ? placeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InstallPlace)) {
            return false;
        }
        InstallPlace other = (InstallPlace) object;
        if ((this.placeId == null && other.placeId != null) || (this.placeId != null && !this.placeId.equals(other.placeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return departmentPlace + ", Кабинет №" + cabinetNumber;
    }
    
}
