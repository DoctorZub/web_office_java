/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author miste
 */
@Entity
@Table(name = "equipment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipment.findAll", query = "SELECT e FROM Equipment e")
    , @NamedQuery(name = "Equipment.findByEquipmentId", query = "SELECT e FROM Equipment e WHERE e.equipmentId = :equipmentId")
    , @NamedQuery(name = "Equipment.findByEquipName", query = "SELECT e FROM Equipment e WHERE e.equipName = :equipName")
    , @NamedQuery(name = "Equipment.findByInventoryNumber", query = "SELECT e FROM Equipment e WHERE e.inventoryNumber = :inventoryNumber")
    , @NamedQuery(name = "Equipment.findByCapacity", query = "SELECT e FROM Equipment e WHERE e.capacity = :capacity")
    , @NamedQuery(name = "Equipment.findByProductionYear", query = "SELECT e FROM Equipment e WHERE e.productionYear = :productionYear")
    , @NamedQuery(name = "Equipment.findByLaskCheck", query = "SELECT e FROM Equipment e WHERE e.laskCheck = :laskCheck")
    , @NamedQuery(name = "Equipment.findByNextCheck", query = "SELECT e FROM Equipment e WHERE e.nextCheck = :nextCheck")
    , @NamedQuery(name = "Equipment.findByPrice", query = "SELECT e FROM Equipment e WHERE e.price = :price")})
public class Equipment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "equipment_id")
    private Integer equipmentId;
    @Basic(optional = false)
    @Column(name = "equip_name")
    private String equipName;
    @Basic(optional = false)
    @Column(name = "inventory_number")
    private String inventoryNumber;
    @Column(name = "capacity")
    private String capacity;
    @Basic(optional = false)
    @Column(name = "production_year")
    private short productionYear;
    @Column(name = "lask_check")
    @Temporal(TemporalType.DATE)
    private Date laskCheck;
    @Column(name = "next_check")
    @Temporal(TemporalType.DATE)
    private Date nextCheck;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private Float price;
    @JoinColumn(name = "install_place", referencedColumnName = "place_id")
    @ManyToOne(optional = false)
    private InstallPlace installPlace;
    @JoinColumn(name = "responsible", referencedColumnName = "responsibles_id")
    @ManyToOne(optional = false)
    private Responsibles responsible;
    @JoinColumn(name = "supplier", referencedColumnName = "suppliers_id")
    @ManyToOne(optional = false)
    private Suppliers supplier;

    public Equipment() {
    }

    public Equipment(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    public Equipment(Integer equipmentId, String equipName, String inventoryNumber, short productionYear) {
        this.equipmentId = equipmentId;
        this.equipName = equipName;
        this.inventoryNumber = inventoryNumber;
        this.productionYear = productionYear;
    }

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getEquipName() {
        return equipName;
    }

    public void setEquipName(String equipName) {
        this.equipName = equipName;
    }

    public String getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(String inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public short getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(short productionYear) {
        this.productionYear = productionYear;
    }

    public Date getLaskCheck() {
        return laskCheck;
    }

    public void setLaskCheck(Date laskCheck) {
        this.laskCheck = laskCheck;
    }

    public Date getNextCheck() {
        return nextCheck;
    }

    public void setNextCheck(Date nextCheck) {
        this.nextCheck = nextCheck;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public InstallPlace getInstallPlace() {
        return installPlace;
    }

    public void setInstallPlace(InstallPlace installPlace) {
        this.installPlace = installPlace;
    }

    public Responsibles getResponsible() {
        return responsible;
    }

    public void setResponsible(Responsibles responsible) {
        this.responsible = responsible;
    }

    public Suppliers getSupplier() {
        return supplier;
    }

    public void setSupplier(Suppliers supplier) {
        this.supplier = supplier;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (equipmentId != null ? equipmentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipment)) {
            return false;
        }
        Equipment other = (Equipment) object;
        if ((this.equipmentId == null && other.equipmentId != null) || (this.equipmentId != null && !this.equipmentId.equals(other.equipmentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Equipment[ equipmentId=" + equipmentId + " ]";
    }
    
}
