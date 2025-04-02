/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Laura
 */
@Entity
@Table(name = "parqueaderos")
@NamedQueries({
    @NamedQuery(name = "Parqueaderos.findAll", query = "SELECT p FROM Parqueaderos p"),
    @NamedQuery(name = "Parqueaderos.findById", query = "SELECT p FROM Parqueaderos p WHERE p.id = :id"),
    @NamedQuery(name = "Parqueaderos.findByParkingname", query = "SELECT p FROM Parqueaderos p WHERE p.parkingname = :parkingname"),
    @NamedQuery(name = "Parqueaderos.findByAddress", query = "SELECT p FROM Parqueaderos p WHERE p.address = :address"),
    @NamedQuery(name = "Parqueaderos.findByContact", query = "SELECT p FROM Parqueaderos p WHERE p.contact = :contact"),
    @NamedQuery(name = "Parqueaderos.findByActiveparkspaces", query = "SELECT p FROM Parqueaderos p WHERE p.activeparkspaces = :activeparkspaces"),
    @NamedQuery(name = "Parqueaderos.findByTotalparkspaces", query = "SELECT p FROM Parqueaderos p WHERE p.totalparkspaces = :totalparkspaces"),
    @NamedQuery(name = "Parqueaderos.findByPriceperhour", query = "SELECT p FROM Parqueaderos p WHERE p.priceperhour = :priceperhour")})
public class Parqueaderos implements Serializable {

    @Size(max = 255)
    @Column(name = "parkingname")
    private String parkingname;
    @Size(max = 255)
    @Column(name = "address")
    private String address;
    @Size(max = 255)
    @Column(name = "contact")
    private String contact;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "id")
    private String id;
    @Column(name = "activeparkspaces")
    private Integer activeparkspaces;
    @Column(name = "totalparkspaces")
    private Integer totalparkspaces;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "priceperhour")
    private Double priceperhour;
    @JoinColumn(name = "propid", referencedColumnName = "id")
    @ManyToOne
    private Propietarios propid;

    public Parqueaderos() {
    }

    public Parqueaderos(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public Integer getActiveparkspaces() {
        return activeparkspaces;
    }

    public void setActiveparkspaces(Integer activeparkspaces) {
        this.activeparkspaces = activeparkspaces;
    }

    public Integer getTotalparkspaces() {
        return totalparkspaces;
    }

    public void setTotalparkspaces(Integer totalparkspaces) {
        this.totalparkspaces = totalparkspaces;
    }

    public Double getPriceperhour() {
        return priceperhour;
    }

    public void setPriceperhour(Double priceperhour) {
        this.priceperhour = priceperhour;
    }

    public Propietarios getPropid() {
        return propid;
    }

    public void setPropid(Propietarios propid) {
        this.propid = propid;
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
        if (!(object instanceof Parqueaderos)) {
            return false;
        }
        Parqueaderos other = (Parqueaderos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Parqueaderos[ id=" + id + " ]";
    }

    public String getParkingname() {
        return parkingname;
    }

    public void setParkingname(String parkingname) {
        this.parkingname = parkingname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    
}
