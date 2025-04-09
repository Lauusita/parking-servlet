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
import javax.persistence.Lob;
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
@Table(name = "propietario")
@NamedQueries({
    @NamedQuery(name = "Propietario.findAll", query = "SELECT p FROM Propietario p"),
    @NamedQuery(name = "Propietario.findByNombre", query = "SELECT p FROM Propietario p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Propietario.findByApellido", query = "SELECT p FROM Propietario p WHERE p.apellido = :apellido"),
    @NamedQuery(name = "Propietario.findByTipoDocumento", query = "SELECT p FROM Propietario p WHERE p.tipoDocumento = :tipoDocumento"),
    @NamedQuery(name = "Propietario.findByNumeroDocumento", query = "SELECT p FROM Propietario p WHERE p.numeroDocumento = :numeroDocumento"),
    @NamedQuery(name = "Propietario.findByTelefono", query = "SELECT p FROM Propietario p WHERE p.telefono = :telefono"),
    @NamedQuery(name = "Propietario.findByCorreo", query = "SELECT p FROM Propietario p WHERE p.correo = :correo"),
    @NamedQuery(name = "Propietario.findByContrasena", query = "SELECT p FROM Propietario p WHERE p.contrasena = :contrasena"),
    @NamedQuery(name = "Propietario.findByCreatedat", query = "SELECT p FROM Propietario p WHERE p.createdat = :createdat")})
public class Propietario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "id_propietario")
    private Object idPropietario;
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 100)
    @Column(name = "apellido")
    private String apellido;
    @Size(max = 50)
    @Column(name = "tipo_documento")
    private Types.tipo_documento tipoDocumento;
    @Size(max = 50)
    @Column(name = "numero_documento")
    private String numeroDocumento;
    @Size(max = 20)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 100)
    @Column(name = "correo")
    private String correo;
    @Size(max = 50)
    @Column(name = "contrasena")
    private String contrasena;
    @Column(name = "createdat")
    @Temporal(TemporalType.DATE)
    private Date createdat;
    @OneToMany(mappedBy = "idPropietarioFk")
    private Collection<Parqueadero> parqueaderoCollection;

    public Propietario() {
    }

    public Propietario(String nombre, String apellido, Types.tipo_documento tipoDocumento, String numeroDocumento, String telefono, String correo, String contrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.telefono = telefono;
        this.correo = correo;
        this.contrasena = contrasena;
    }
    
    

    public Propietario(Object idPropietario) {
        this.idPropietario = idPropietario;
    }

    public Object getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(Object idPropietario) {
        this.idPropietario = idPropietario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Types.tipo_documento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(Types.tipo_documento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Date getCreatedat() {
        return createdat;
    }

    public void setCreatedat(Date createdat) {
        this.createdat = createdat;
    }

    public Collection<Parqueadero> getParqueaderoCollection() {
        return parqueaderoCollection;
    }

    public void setParqueaderoCollection(Collection<Parqueadero> parqueaderoCollection) {
        this.parqueaderoCollection = parqueaderoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPropietario != null ? idPropietario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Propietario)) {
            return false;
        }
        Propietario other = (Propietario) object;
        if ((this.idPropietario == null && other.idPropietario != null) || (this.idPropietario != null && !this.idPropietario.equals(other.idPropietario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.servlets.Propietario[ idPropietario=" + idPropietario + " ]";
    }
    
}
