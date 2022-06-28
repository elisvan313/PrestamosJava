/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prestamos.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Elisvan
 */
@Entity
@Table(name = "tbprestamo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbprestamo.findAll", query = "SELECT t FROM Tbprestamo t")
    , @NamedQuery(name = "Tbprestamo.findByCodigo", query = "SELECT t FROM Tbprestamo t WHERE t.codigo = :codigo")
    , @NamedQuery(name = "Tbprestamo.findByNombrec", query = "SELECT t FROM Tbprestamo t WHERE t.nombrec = :nombrec")
    , @NamedQuery(name = "Tbprestamo.findByValorprestamo", query = "SELECT t FROM Tbprestamo t WHERE t.valorprestamo = :valorprestamo")
    , @NamedQuery(name = "Tbprestamo.findByNcuotas", query = "SELECT t FROM Tbprestamo t WHERE t.ncuotas = :ncuotas")
    , @NamedQuery(name = "Tbprestamo.findByInteres", query = "SELECT t FROM Tbprestamo t WHERE t.interes = :interes")
    , @NamedQuery(name = "Tbprestamo.findByTipoprestamo", query = "SELECT t FROM Tbprestamo t WHERE t.tipoprestamo = :tipoprestamo")
    , @NamedQuery(name = "Tbprestamo.findByValorcuota", query = "SELECT t FROM Tbprestamo t WHERE t.valorcuota = :valorcuota")
    , @NamedQuery(name = "Tbprestamo.findByFechaprestamo", query = "SELECT t FROM Tbprestamo t WHERE t.fechaprestamo = :fechaprestamo")
    , @NamedQuery(name = "Tbprestamo.findByFechavencer", query = "SELECT t FROM Tbprestamo t WHERE t.fechavencer = :fechavencer")})
public class Tbprestamo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Codigo")
    private Integer codigo;
    @Basic(optional = false)
    @Column(name = "nombrec")
    private String nombrec;
    @Basic(optional = false)
    @Column(name = "valorprestamo")
    private int valorprestamo;
    @Basic(optional = false)
    @Column(name = "ncuotas")
    private int ncuotas;
    @Basic(optional = false)
    @Column(name = "interes")
    private int interes;
    @Basic(optional = false)
    @Column(name = "tipoprestamo")
    private String tipoprestamo;
    @Basic(optional = false)
    @Column(name = "valorcuota")
    private int valorcuota;
    @Basic(optional = false)
    @Column(name = "fechaprestamo")
    @Temporal(TemporalType.DATE)
    private Date fechaprestamo;
    @Basic(optional = false)
    @Column(name = "fechavencer")
    @Temporal(TemporalType.DATE)
    private Date fechavencer;

    public Tbprestamo() {
    }

    public Tbprestamo(Integer codigo) {
        this.codigo = codigo;
    }

    public Tbprestamo(Integer codigo, String nombrec, int valorprestamo, int ncuotas, int interes, String tipoprestamo, int valorcuota, Date fechaprestamo, Date fechavencer) {
        this.codigo = codigo;
        this.nombrec = nombrec;
        this.valorprestamo = valorprestamo;
        this.ncuotas = ncuotas;
        this.interes = interes;
        this.tipoprestamo = tipoprestamo;
        this.valorcuota = valorcuota;
        this.fechaprestamo = fechaprestamo;
        this.fechavencer = fechavencer;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombrec() {
        return nombrec;
    }

    public void setNombrec(String nombrec) {
        this.nombrec = nombrec;
    }

    public int getValorprestamo() {
        return valorprestamo;
    }

    public void setValorprestamo(int valorprestamo) {
        this.valorprestamo = valorprestamo;
    }

    public int getNcuotas() {
        return ncuotas;
    }

    public void setNcuotas(int ncuotas) {
        this.ncuotas = ncuotas;
    }

    public int getInteres() {
        return interes;
    }

    public void setInteres(int interes) {
        this.interes = interes;
    }

    public String getTipoprestamo() {
        return tipoprestamo;
    }

    public void setTipoprestamo(String tipoprestamo) {
        this.tipoprestamo = tipoprestamo;
    }

    public int getValorcuota() {
        return valorcuota;
    }

    public void setValorcuota(int valorcuota) {
        this.valorcuota = valorcuota;
    }

    public Date getFechaprestamo() {
        return fechaprestamo;
    }

    public void setFechaprestamo(Date fechaprestamo) {
        this.fechaprestamo = fechaprestamo;
    }

    public Date getFechavencer() {
        return fechavencer;
    }

    public void setFechavencer(Date fechavencer) {
        this.fechavencer = fechavencer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbprestamo)) {
            return false;
        }
        Tbprestamo other = (Tbprestamo) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prestamos.entity.Tbprestamo[ codigo=" + codigo + " ]";
    }
    
}
