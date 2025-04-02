/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Laura
 */
@Entity
@Table(name = "propietarios")
@NamedQueries({
    @NamedQuery(name = "Propietarios.findAll", query = "SELECT p FROM Propietarios p"),
    @NamedQuery(name = "Propietarios.findById", query = "SELECT p FROM Propietarios p WHERE p.id = :id"),
    @NamedQuery(name = "Propietarios.findByFullname", query = "SELECT p FROM Propietarios p WHERE p.fullname = :fullname"),
    @NamedQuery(name = "Propietarios.findByPropid", query = "SELECT p FROM Propietarios p WHERE p.propid = :propid"),
    @NamedQuery(name = "Propietarios.findByCreatedat", query = "SELECT p FROM Propietarios p WHERE p.createdat = :createdat"),
    @NamedQuery(name = "Propietarios.findByIsactive", query = "SELECT p FROM Propietarios p WHERE p.isactive = :isactive")})
public class Propietarios implements Serializable {

    @Size(max = 255)
    @Column(name = "fullname")
    private String fullname;
    @Size(max = 255)
    @Column(name = "propid")
    private String propid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "createdat")
    @Temporal(TemporalType.DATE)
    private Date createdat;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "id")
    private String id;
    @Column(name = "isactive")
    private Boolean isactive;
    @OneToMany(mappedBy = "propid")
    private Collection<Parqueaderos> parqueaderosCollection;

    public Propietarios() {
    }

    public Propietarios(String id) {
        this.id = id;
    }

    public Propietarios(String id, Date createdat) {
        this.id = id;
        this.createdat = createdat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public Boolean getIsactive() {
        return isactive;
    }

    public void setIsactive(Boolean isactive) {
        this.isactive = isactive;
    }

    public Collection<Parqueaderos> getParqueaderosCollection() {
        return parqueaderosCollection;
    }

    public void setParqueaderosCollection(Collection<Parqueaderos> parqueaderosCollection) {
        this.parqueaderosCollection = parqueaderosCollection;
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
        if (!(object instanceof Propietarios)) {
            return false;
        }
        Propietarios other = (Propietarios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Propietarios[ id=" + id + " ]";
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPropid() {
        return propid;
    }

    public void setPropid(String propid) {
        this.propid = propid;
    }

    public Date getCreatedat() {
        return createdat;
    }

    public void setCreatedat(Date createdat) {
        this.createdat = createdat;
    }
    
}
