/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "historial")
@NamedQueries({
    @NamedQuery(name = "Historial.findAll", query = "SELECT h FROM Historial h"),
    @NamedQuery(name = "Historial.findByTipoVehiculo", query = "SELECT h FROM Historial h WHERE h.tipoVehiculo = :tipoVehiculo"),
    @NamedQuery(name = "Historial.findByParqueaderoNombre", query = "SELECT h FROM Historial h WHERE h.parqueaderoNombre = :parqueaderoNombre"),
    @NamedQuery(name = "Historial.findByFecha", query = "SELECT h FROM Historial h WHERE h.fecha = :fecha"),
    @NamedQuery(name = "Historial.findByHoraInicio", query = "SELECT h FROM Historial h WHERE h.horaInicio = :horaInicio"),
    @NamedQuery(name = "Historial.findByHoraFin", query = "SELECT h FROM Historial h WHERE h.horaFin = :horaFin"),
    @NamedQuery(name = "Historial.findByEstadoFinal", query = "SELECT h FROM Historial h WHERE h.estadoFinal = :estadoFinal"),
    @NamedQuery(name = "Historial.findByValorTotal", query = "SELECT h FROM Historial h WHERE h.valorTotal = :valorTotal"),
    @NamedQuery(name = "Historial.findByFechaRegistro", query = "SELECT h FROM Historial h WHERE h.fechaRegistro = :fechaRegistro")})
public class Historial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "id_historial")
    private Object idHistorial;
    @Lob
    @Column(name = "id_reserva_fk")
    private Object idReservaFk;
    @Size(max = 2147483647)
    @Column(name = "tipo_vehiculo")
    private Types.tipo_vehiculos_aceptados tipoVehiculo;
    @Size(max = 100)
    @Column(name = "parqueadero_nombre")
    private String parqueaderoNombre;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "hora_inicio")
    @Temporal(TemporalType.TIME)
    private Date horaInicio;
    @Column(name = "hora_fin")
    @Temporal(TemporalType.TIME)
    private Date horaFin;
    @Size(max = 2147483647)
    @Column(name = "estado_final")
    private Types.estado_historial estadoFinal;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_total")
    private BigDecimal valorTotal;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @JoinColumn(name = "id_conductor_fk", referencedColumnName = "id_conductor")
    @ManyToOne
    private Conductor idConductorFk;

    public Historial() {
    }

    public Historial(Object idHistorial) {
        this.idHistorial = idHistorial;
    }

    public Object getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(Object idHistorial) {
        this.idHistorial = idHistorial;
    }

    public Object getIdReservaFk() {
        return idReservaFk;
    }

    public void setIdReservaFk(Object idReservaFk) {
        this.idReservaFk = idReservaFk;
    }

    public Types.tipo_vehiculos_aceptados getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(Types.tipo_vehiculos_aceptados tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getParqueaderoNombre() {
        return parqueaderoNombre;
    }

    public void setParqueaderoNombre(String parqueaderoNombre) {
        this.parqueaderoNombre = parqueaderoNombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    public Types.estado_historial getEstadoFinal() {
        return estadoFinal;
    }

    public void setEstadoFinal(Types.estado_historial estadoFinal) {
        this.estadoFinal = estadoFinal;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Conductor getIdConductorFk() {
        return idConductorFk;
    }

    public void setIdConductorFk(Conductor idConductorFk) {
        this.idConductorFk = idConductorFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHistorial != null ? idHistorial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Historial)) {
            return false;
        }
        Historial other = (Historial) object;
        if ((this.idHistorial == null && other.idHistorial != null) || (this.idHistorial != null && !this.idHistorial.equals(other.idHistorial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.servlets.Historial[ idHistorial=" + idHistorial + " ]";
    }
    
}
