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
@Table(name = "responsibles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Responsibles.findAll", query = "SELECT r FROM Responsibles r")
    , @NamedQuery(name = "Responsibles.findByResponsiblesId", query = "SELECT r FROM Responsibles r WHERE r.responsiblesId = :responsiblesId")
    , @NamedQuery(name = "Responsibles.findByLastName", query = "SELECT r FROM Responsibles r WHERE r.lastName = :lastName")
    , @NamedQuery(name = "Responsibles.findByFirstName", query = "SELECT r FROM Responsibles r WHERE r.firstName = :firstName")
    , @NamedQuery(name = "Responsibles.findByMiddleName", query = "SELECT r FROM Responsibles r WHERE r.middleName = :middleName")
    , @NamedQuery(name = "Responsibles.findByDepartmentRespons", query = "SELECT r FROM Responsibles r WHERE r.departmentRespons = :departmentRespons")
    , @NamedQuery(name = "Responsibles.findByPost", query = "SELECT r FROM Responsibles r WHERE r.post = :post")
    , @NamedQuery(name = "Responsibles.findByCountryRespons", query = "SELECT r FROM Responsibles r WHERE r.countryRespons = :countryRespons")
    , @NamedQuery(name = "Responsibles.findByCityRespons", query = "SELECT r FROM Responsibles r WHERE r.cityRespons = :cityRespons")})
public class Responsibles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "responsibles_id")
    private Integer responsiblesId;
    @Basic(optional = false)
    @Column(name = "last_name")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @Basic(optional = false)
    @Column(name = "department_respons")
    private String departmentRespons;
    @Basic(optional = false)
    @Column(name = "post")
    private String post;
    @Basic(optional = false)
    @Column(name = "country_respons")
    private String countryRespons;
    @Basic(optional = false)
    @Column(name = "city_respons")
    private String cityRespons;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "responsible")
    private List<Equipment> equipmentList;

    public Responsibles() {
    }

    public Responsibles(Integer responsiblesId) {
        this.responsiblesId = responsiblesId;
    }

    public Responsibles(Integer responsiblesId, String lastName, String firstName, String departmentRespons, String post, String countryRespons, String cityRespons) {
        this.responsiblesId = responsiblesId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.departmentRespons = departmentRespons;
        this.post = post;
        this.countryRespons = countryRespons;
        this.cityRespons = cityRespons;
    }

    public Integer getResponsiblesId() {
        return responsiblesId;
    }

    public void setResponsiblesId(Integer responsiblesId) {
        this.responsiblesId = responsiblesId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getDepartmentRespons() {
        return departmentRespons;
    }

    public void setDepartmentRespons(String departmentRespons) {
        this.departmentRespons = departmentRespons;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getCountryRespons() {
        return countryRespons;
    }

    public void setCountryRespons(String countryRespons) {
        this.countryRespons = countryRespons;
    }

    public String getCityRespons() {
        return cityRespons;
    }

    public void setCityRespons(String cityRespons) {
        this.cityRespons = cityRespons;
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
        hash += (responsiblesId != null ? responsiblesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Responsibles)) {
            return false;
        }
        Responsibles other = (Responsibles) object;
        if ((this.responsiblesId == null && other.responsiblesId != null) || (this.responsiblesId != null && !this.responsiblesId.equals(other.responsiblesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return post + " " + departmentRespons + " " +  lastName + " " + firstName;
    }
    
}
