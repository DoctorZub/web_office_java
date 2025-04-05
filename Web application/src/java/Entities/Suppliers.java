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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author miste
 */
@Entity
@Table(name = "suppliers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Suppliers.findAll", query = "SELECT s FROM Suppliers s")
    , @NamedQuery(name = "Suppliers.findBySuppliersId", query = "SELECT s FROM Suppliers s WHERE s.suppliersId = :suppliersId")
    , @NamedQuery(name = "Suppliers.findBySuppiersName", query = "SELECT s FROM Suppliers s WHERE s.suppiersName = :suppiersName")
    , @NamedQuery(name = "Suppliers.findByCountrySupplier", query = "SELECT s FROM Suppliers s WHERE s.countrySupplier = :countrySupplier")
    , @NamedQuery(name = "Suppliers.findByCitySuppliers", query = "SELECT s FROM Suppliers s WHERE s.citySuppliers = :citySuppliers")})
public class Suppliers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "suppliers_id")
    private Integer suppliersId;
    @Basic(optional = false)
    @Column(name = "suppiers_name")
    private String suppiersName;
    @Column(name = "country_supplier")
    private String countrySupplier;
    @Column(name = "city_suppliers")
    private String citySuppliers;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplier")
    private List<Equipment> equipmentList;

    public Suppliers() {
    }

    public Suppliers(Integer suppliersId) {
        this.suppliersId = suppliersId;
    }

    public Suppliers(Integer suppliersId, String suppiersName) {
        this.suppliersId = suppliersId;
        this.suppiersName = suppiersName;
    }

    public Integer getSuppliersId() {
        return suppliersId;
    }

    public void setSuppliersId(Integer suppliersId) {
        this.suppliersId = suppliersId;
    }

    public String getSuppiersName() {
        return suppiersName;
    }

    public void setSuppiersName(String suppiersName) {
        this.suppiersName = suppiersName;
    }

    public String getCountrySupplier() {
        return countrySupplier;
    }

    public void setCountrySupplier(String countrySupplier) {
        this.countrySupplier = countrySupplier;
    }

    public String getCitySuppliers() {
        return citySuppliers;
    }

    public void setCitySuppliers(String citySuppliers) {
        this.citySuppliers = citySuppliers;
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
        hash += (suppliersId != null ? suppliersId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Suppliers)) {
            return false;
        }
        Suppliers other = (Suppliers) object;
        if ((this.suppliersId == null && other.suppliersId != null) || (this.suppliersId != null && !this.suppliersId.equals(other.suppliersId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return suppiersName;
    }
    
}
