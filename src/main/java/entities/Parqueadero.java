/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
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
@Table(name = "parqueadero")
@NamedQueries({
    @NamedQuery(name = "Parqueadero.findAll", query = "SELECT p FROM Parqueadero p"),
    @NamedQuery(name = "Parqueadero.findByNombre", query = "SELECT p FROM Parqueadero p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Parqueadero.findByDireccion", query = "SELECT p FROM Parqueadero p WHERE p.direccion = :direccion"),
    @NamedQuery(name = "Parqueadero.findByCiudad", query = "SELECT p FROM Parqueadero p WHERE p.ciudad = :ciudad"),
    @NamedQuery(name = "Parqueadero.findByNumeroCeldas", query = "SELECT p FROM Parqueadero p WHERE p.numeroCeldas = :numeroCeldas"),
    @NamedQuery(name = "Parqueadero.findByTipoCeldas", query = "SELECT p FROM Parqueadero p WHERE p.tipoCeldas = :tipoCeldas"),
    @NamedQuery(name = "Parqueadero.findByTarifaHora", query = "SELECT p FROM Parqueadero p WHERE p.tarifaHora = :tarifaHora"),
    @NamedQuery(name = "Parqueadero.findByEstado", query = "SELECT p FROM Parqueadero p WHERE p.estado = :estado"),
    @NamedQuery(name = "Parqueadero.findByCalificacion", query = "SELECT p FROM Parqueadero p WHERE p.calificacion = :calificacion"),
    @NamedQuery(name = "Parqueadero.findByDepartamento", query = "SELECT p FROM Parqueadero p WHERE p.departamento = :departamento"),
    @NamedQuery(name = "Parqueadero.findByTiposVehiculosAceptados", query = "SELECT p FROM Parqueadero p WHERE p.tiposVehiculosAceptados = :tiposVehiculosAceptados"),
    @NamedQuery(name = "Parqueadero.findByCreatedAt", query = "SELECT p FROM Parqueadero p WHERE p.createdAt = :createdAt")})
public class Parqueadero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "id_parqueadero")
    private Object idParqueadero;
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 200)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 100)
    @Column(name = "ciudad")
    private String ciudad;
    @Column(name = "numero_celdas")
    private Integer numeroCeldas;
    @Column(name = "tipo_celdas")
    private Serializable tipoCeldas;
    @Column(name = "tarifa_hora")
    private BigInteger tarifaHora;
    @Lob
    @Column(name = "horario_atencion")
    private Object horarioAtencion;
    @Column(name = "estado")
    private Boolean estado;
    @Column(name = "calificacion")
    private BigInteger calificacion;
    @Size(max = 100)
    @Column(name = "departamento")
    private String departamento;
    @Column(name = "tipos_vehiculos_aceptados")
    private Serializable tiposVehiculosAceptados;
    @Column(name = "created_at")
    @Temporal(TemporalType.DATE)
    private Date createdAt;
    @OneToMany(mappedBy = "parqueaderoId")
    private Collection<Reviews> reviewsCollection;
    @JoinColumn(name = "id_propietario_fk", referencedColumnName = "id_propietario")
    @ManyToOne
    private Propietario idPropietarioFk;
    @OneToMany(mappedBy = "idParqueaderoFk")
    private Collection<Reserva> reservaCollection;

    public Parqueadero() {
    }

    public Parqueadero(Object idParqueadero) {
        this.idParqueadero = idParqueadero;
    }

    public Object getIdParqueadero() {
        return idParqueadero;
    }

    public void setIdParqueadero(Object idParqueadero) {
        this.idParqueadero = idParqueadero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Integer getNumeroCeldas() {
        return numeroCeldas;
    }

    public void setNumeroCeldas(Integer numeroCeldas) {
        this.numeroCeldas = numeroCeldas;
    }

    public Serializable getTipoCeldas() {
        return tipoCeldas;
    }

    public void setTipoCeldas(Serializable tipoCeldas) {
        this.tipoCeldas = tipoCeldas;
    }

    public BigInteger getTarifaHora() {
        return tarifaHora;
    }

    public void setTarifaHora(BigInteger tarifaHora) {
        this.tarifaHora = tarifaHora;
    }

    public Object getHorarioAtencion() {
        return horarioAtencion;
    }

    public void setHorarioAtencion(Object horarioAtencion) {
        this.horarioAtencion = horarioAtencion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public BigInteger getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(BigInteger calificacion) {
        this.calificacion = calificacion;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Serializable getTiposVehiculosAceptados() {
        return tiposVehiculosAceptados;
    }

    public void setTiposVehiculosAceptados(Serializable tiposVehiculosAceptados) {
        this.tiposVehiculosAceptados = tiposVehiculosAceptados;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Collection<Reviews> getReviewsCollection() {
        return reviewsCollection;
    }

    public void setReviewsCollection(Collection<Reviews> reviewsCollection) {
        this.reviewsCollection = reviewsCollection;
    }

    public Propietario getIdPropietarioFk() {
        return idPropietarioFk;
    }

    public void setIdPropietarioFk(Propietario idPropietarioFk) {
        this.idPropietarioFk = idPropietarioFk;
    }

    public Collection<Reserva> getReservaCollection() {
        return reservaCollection;
    }

    public void setReservaCollection(Collection<Reserva> reservaCollection) {
        this.reservaCollection = reservaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idParqueadero != null ? idParqueadero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parqueadero)) {
            return false;
        }
        Parqueadero other = (Parqueadero) object;
        if ((this.idParqueadero == null && other.idParqueadero != null) || (this.idParqueadero != null && !this.idParqueadero.equals(other.idParqueadero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.servlets.Parqueadero[ idParqueadero=" + idParqueadero + " ]";
    }
    
}
