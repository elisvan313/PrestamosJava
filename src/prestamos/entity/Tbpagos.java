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
@Table(name = "tbpagos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbpagos.findAll", query = "SELECT t FROM Tbpagos t")
    , @NamedQuery(name = "Tbpagos.findByCodigoprestamo", query = "SELECT t FROM Tbpagos t WHERE t.codigoprestamo = :codigoprestamo")
    , @NamedQuery(name = "Tbpagos.findByNombrec", query = "SELECT t FROM Tbpagos t WHERE t.nombrec = :nombrec")
    , @NamedQuery(name = "Tbpagos.findBySaldoactual", query = "SELECT t FROM Tbpagos t WHERE t.saldoactual = :saldoactual")
    , @NamedQuery(name = "Tbpagos.findByCuotaspagadas", query = "SELECT t FROM Tbpagos t WHERE t.cuotaspagadas = :cuotaspagadas")
    , @NamedQuery(name = "Tbpagos.findByCuotaspendientes", query = "SELECT t FROM Tbpagos t WHERE t.cuotaspendientes = :cuotaspendientes")
    , @NamedQuery(name = "Tbpagos.findByFechapago", query = "SELECT t FROM Tbpagos t WHERE t.fechapago = :fechapago")
    , @NamedQuery(name = "Tbpagos.findByIdpago", query = "SELECT t FROM Tbpagos t WHERE t.idpago = :idpago")})
public class Tbpagos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "Codigoprestamo")
    private int codigoprestamo;
    @Basic(optional = false)
    @Column(name = "Nombrec")
    private String nombrec;
    @Basic(optional = false)
    @Column(name = "Saldoactual")
    private int saldoactual;
    @Basic(optional = false)
    @Column(name = "Cuotaspagadas")
    private int cuotaspagadas;
    @Basic(optional = false)
    @Column(name = "Cuotaspendientes")
    private int cuotaspendientes;
    @Basic(optional = false)
    @Column(name = "Fechapago")
    @Temporal(TemporalType.DATE)
    private Date fechapago;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpago")
    private Integer idpago;

    public Tbpagos() {
    }

    public Tbpagos(Integer idpago) {
        this.idpago = idpago;
    }

    public Tbpagos(Integer idpago, int codigoprestamo, String nombrec, int saldoactual, int cuotaspagadas, int cuotaspendientes, Date fechapago) {
        this.idpago = idpago;
        this.codigoprestamo = codigoprestamo;
        this.nombrec = nombrec;
        this.saldoactual = saldoactual;
        this.cuotaspagadas = cuotaspagadas;
        this.cuotaspendientes = cuotaspendientes;
        this.fechapago = fechapago;
    }

    public int getCodigoprestamo() {
        return codigoprestamo;
    }

    public void setCodigoprestamo(int codigoprestamo) {
        this.codigoprestamo = codigoprestamo;
    }

    public String getNombrec() {
        return nombrec;
    }

    public void setNombrec(String nombrec) {
        this.nombrec = nombrec;
    }

    public int getSaldoactual() {
        return saldoactual;
    }

    public void setSaldoactual(int saldoactual) {
        this.saldoactual = saldoactual;
    }

    public int getCuotaspagadas() {
        return cuotaspagadas;
    }

    public void setCuotaspagadas(int cuotaspagadas) {
        this.cuotaspagadas = cuotaspagadas;
    }

    public int getCuotaspendientes() {
        return cuotaspendientes;
    }

    public void setCuotaspendientes(int cuotaspendientes) {
        this.cuotaspendientes = cuotaspendientes;
    }

    public Date getFechapago() {
        return fechapago;
    }

    public void setFechapago(Date fechapago) {
        this.fechapago = fechapago;
    }

    public Integer getIdpago() {
        return idpago;
    }

    public void setIdpago(Integer idpago) {
        this.idpago = idpago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpago != null ? idpago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbpagos)) {
            return false;
        }
        Tbpagos other = (Tbpagos) object;
        if ((this.idpago == null && other.idpago != null) || (this.idpago != null && !this.idpago.equals(other.idpago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prestamos.entity.Tbpagos[ idpago=" + idpago + " ]";
    }
    
}
