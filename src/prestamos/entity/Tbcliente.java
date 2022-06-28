/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prestamos.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Elisvan
 */
@Entity
@Table(name = "tbcliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbcliente.findAll", query = "SELECT t FROM Tbcliente t")
    , @NamedQuery(name = "Tbcliente.findByIdtbcliente", query = "SELECT t FROM Tbcliente t WHERE t.idtbcliente = :idtbcliente")
    , @NamedQuery(name = "Tbcliente.findByNombres", query = "SELECT t FROM Tbcliente t WHERE t.nombres = :nombres")
    , @NamedQuery(name = "Tbcliente.findByApellidos", query = "SELECT t FROM Tbcliente t WHERE t.apellidos = :apellidos")
    , @NamedQuery(name = "Tbcliente.findByDireccion", query = "SELECT t FROM Tbcliente t WHERE t.direccion = :direccion")
    , @NamedQuery(name = "Tbcliente.findByTelefono", query = "SELECT t FROM Tbcliente t WHERE t.telefono = :telefono")
    , @NamedQuery(name = "Tbcliente.findByCedula", query = "SELECT t FROM Tbcliente t WHERE t.cedula = :cedula")})
public class Tbcliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "idtbcliente")
    private int idtbcliente;
    @Basic(optional = false)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @Column(name = "telefono")
    private String telefono;
    @Id
    @Basic(optional = false)
    @Column(name = "cedula")
    private Integer cedula;

    public Tbcliente() {
    }

    public Tbcliente(Integer cedula) {
        this.cedula = cedula;
    }

    public Tbcliente(Integer cedula, int idtbcliente, String nombres, String apellidos, String direccion, String telefono) {
        this.cedula = cedula;
        this.idtbcliente = idtbcliente;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public int getIdtbcliente() {
        return idtbcliente;
    }

    public void setIdtbcliente(int idtbcliente) {
        this.idtbcliente = idtbcliente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedula != null ? cedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbcliente)) {
            return false;
        }
        Tbcliente other = (Tbcliente) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prestamos.entity.Tbcliente[ cedula=" + cedula + " ]";
    }
    
}
