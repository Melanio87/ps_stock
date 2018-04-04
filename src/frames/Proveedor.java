/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Melanio
 */
@Entity
@Table(name = "proveedor", catalog = "p_s_stock", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Proveedor.findAll", query = "SELECT p FROM Proveedor p"),
    @NamedQuery(name = "Proveedor.findByPveeCodigo", query = "SELECT p FROM Proveedor p WHERE p.pveeCodigo = :pveeCodigo"),
    @NamedQuery(name = "Proveedor.findByPveeDescri", query = "SELECT p FROM Proveedor p WHERE p.pveeDescri = :pveeDescri")})
public class Proveedor implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pvee_codigo")
    private Integer pveeCodigo;
    @Column(name = "pvee_descri")
    private String pveeDescri;

    public Proveedor() {
    }

    public Proveedor(Integer pveeCodigo) {
        this.pveeCodigo = pveeCodigo;
    }

    public Integer getPveeCodigo() {
        return pveeCodigo;
    }

    public void setPveeCodigo(Integer pveeCodigo) {
        Integer oldPveeCodigo = this.pveeCodigo;
        this.pveeCodigo = pveeCodigo;
        changeSupport.firePropertyChange("pveeCodigo", oldPveeCodigo, pveeCodigo);
    }

    public String getPveeDescri() {
        return pveeDescri;
    }

    public void setPveeDescri(String pveeDescri) {
        String oldPveeDescri = this.pveeDescri;
        this.pveeDescri = pveeDescri;
        changeSupport.firePropertyChange("pveeDescri", oldPveeDescri, pveeDescri);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pveeCodigo != null ? pveeCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
        if ((this.pveeCodigo == null && other.pveeCodigo != null) || (this.pveeCodigo != null && !this.pveeCodigo.equals(other.pveeCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "frames.Proveedor[ pveeCodigo=" + pveeCodigo + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
