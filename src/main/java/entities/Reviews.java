/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "reviews")
@NamedQueries({
    @NamedQuery(name = "Reviews.findAll", query = "SELECT r FROM Reviews r"),
    @NamedQuery(name = "Reviews.findByUsuario", query = "SELECT r FROM Reviews r WHERE r.usuario = :usuario"),
    @NamedQuery(name = "Reviews.findByMensaje", query = "SELECT r FROM Reviews r WHERE r.mensaje = :mensaje"),
    @NamedQuery(name = "Reviews.findByPuntaje", query = "SELECT r FROM Reviews r WHERE r.puntaje = :puntaje"),
    @NamedQuery(name = "Reviews.findByFecha", query = "SELECT r FROM Reviews r WHERE r.fecha = :fecha")})
public class Reviews implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "id")
    private Object id;
    @Size(max = 100)
    @Column(name = "usuario")
    private String usuario;
    @Size(max = 2147483647)
    @Column(name = "mensaje")
    private String mensaje;
    @Column(name = "puntaje")
    private BigInteger puntaje;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIME)
    private Date fecha;
    @JoinColumn(name = "parqueadero_id", referencedColumnName = "id_parqueadero")
    @ManyToOne
    private Parqueadero parqueaderoId;

    public Reviews() {
    }

    public Reviews(Object id) {
        this.id = id;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public BigInteger getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(BigInteger puntaje) {
        this.puntaje = puntaje;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Parqueadero getParqueaderoId() {
        return parqueaderoId;
    }

    public void setParqueaderoId(Parqueadero parqueaderoId) {
        this.parqueaderoId = parqueaderoId;
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
        if (!(object instanceof Reviews)) {
            return false;
        }
        Reviews other = (Reviews) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.servlets.Reviews[ id=" + id + " ]";
    }
    
}
