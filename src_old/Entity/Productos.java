/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.Transient;

/**
 *
 * @author Melanio
 */
@Entity
@Table(name = "productos", catalog = "p_s_stock", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Productos.findAll", query = "SELECT p FROM Productos p"),
    @NamedQuery(name = "Productos.findByProCodigo", query = "SELECT p FROM Productos p WHERE p.proCodigo = :proCodigo"),
    @NamedQuery(name = "Productos.findByProDescri", query = "SELECT p FROM Productos p WHERE p.proDescri = :proDescri"),
    @NamedQuery(name = "Productos.findByProPre1", query = "SELECT p FROM Productos p WHERE p.proPre1 = :proPre1"),
    @NamedQuery(name = "Productos.findByProPre2", query = "SELECT p FROM Productos p WHERE p.proPre2 = :proPre2"),
    @NamedQuery(name = "Productos.findByProPre3", query = "SELECT p FROM Productos p WHERE p.proPre3 = :proPre3"),
    @NamedQuery(name = "Productos.findByProCant", query = "SELECT p FROM Productos p WHERE p.proCant = :proCant"),
    @NamedQuery(name = "Productos.findByProProvee", query = "SELECT p FROM Productos p WHERE p.proProvee = :proProvee"),
    @NamedQuery(name = "Productos.findByProCate", query = "SELECT p FROM Productos p WHERE p.proCate = :proCate"),
    @NamedQuery(name = "Productos.findByProSect", query = "SELECT p FROM Productos p WHERE p.proSect = :proSect"),
    @NamedQuery(name = "Productos.findByProFoto", query = "SELECT p FROM Productos p WHERE p.proFoto = :proFoto"),
    @NamedQuery(name = "Productos.findByProVenci", query = "SELECT p FROM Productos p WHERE p.proVenci = :proVenci"),
    @NamedQuery(name = "Productos.findByProCanmin", query = "SELECT p FROM Productos p WHERE p.proCanmin = :proCanmin")})
public class Productos implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pro_codigo")
    private Integer proCodigo;
    @Column(name = "pro_descri")
    private String proDescri;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pro_pre1")
    private BigDecimal proPre1;
    @Column(name = "pro_pre2")
    private BigDecimal proPre2;
    @Column(name = "pro_pre3")
    private BigDecimal proPre3;
    @Column(name = "pro_cant")
    private BigDecimal proCant;
    @Column(name = "pro_provee")
    private Integer proProvee;
    @Column(name = "pro_cate")
    private Integer proCate;
    @Column(name = "pro_sect")
    private Integer proSect;
    @Column(name = "pro_foto")
    private String proFoto;
    @Column(name = "pro_venci")
    @Temporal(TemporalType.DATE)
    private Date proVenci;
    @Column(name = "pro_canmin")
    private BigDecimal proCanmin;
    private BigDecimal proIva;
    private String proCbarra;
    private String proTiva;

    public Productos() {
    }

    public Productos(Integer proCodigo) {
        this.proCodigo = proCodigo;
    }

    public Integer getProCodigo() {
        return proCodigo;
    }

    public void setProCodigo(Integer proCodigo) {
        Integer oldProCodigo = this.proCodigo;
        this.proCodigo = proCodigo;
        changeSupport.firePropertyChange("proCodigo", oldProCodigo, proCodigo);
    }

    public String getProDescri() {
        return proDescri;
    }

    public void setProDescri(String proDescri) {
        String oldProDescri = this.proDescri;
        this.proDescri = proDescri;
        changeSupport.firePropertyChange("proDescri", oldProDescri, proDescri);
    }

    public BigDecimal getProPre1() {
        return proPre1;
    }

    public void setProPre1(BigDecimal proPre1) {
        BigDecimal oldProPre1 = this.proPre1;
        this.proPre1 = proPre1;
        changeSupport.firePropertyChange("proPre1", oldProPre1, proPre1);
    }

    public BigDecimal getProPre2() {
        return proPre2;
    }

    public void setProPre2(BigDecimal proPre2) {
        BigDecimal oldProPre2 = this.proPre2;
        this.proPre2 = proPre2;
        changeSupport.firePropertyChange("proPre2", oldProPre2, proPre2);
    }

    public BigDecimal getProPre3() {
        return proPre3;
    }

    public void setProPre3(BigDecimal proPre3) {
        BigDecimal oldProPre3 = this.proPre3;
        this.proPre3 = proPre3;
        changeSupport.firePropertyChange("proPre3", oldProPre3, proPre3);
    }

    public BigDecimal getProCant() {
        return proCant;
    }

    public void setProCant(BigDecimal proCant) {
        BigDecimal oldProCant = this.proCant;
        this.proCant = proCant;
        changeSupport.firePropertyChange("proCant", oldProCant, proCant);
    }

    public Integer getProProvee() {
        return proProvee;
    }

    public void setProProvee(Integer proProvee) {
        Integer oldProProvee = this.proProvee;
        this.proProvee = proProvee;
        changeSupport.firePropertyChange("proProvee", oldProProvee, proProvee);
    }

    public Integer getProCate() {
        return proCate;
    }

    public void setProCate(Integer proCate) {
        Integer oldProCate = this.proCate;
        this.proCate = proCate;
        changeSupport.firePropertyChange("proCate", oldProCate, proCate);
    }

    public Integer getProSect() {
        return proSect;
    }

    public void setProSect(Integer proSect) {
        Integer oldProSect = this.proSect;
        this.proSect = proSect;
        changeSupport.firePropertyChange("proSect", oldProSect, proSect);
    }

    public String getProFoto() {
        return proFoto;
    }

    public void setProFoto(String proFoto) {
        String oldProFoto = this.proFoto;
        this.proFoto = proFoto;
        changeSupport.firePropertyChange("proFoto", oldProFoto, proFoto);
    }

    public Date getProVenci() {
        return proVenci;
    }

    public void setProVenci(Date proVenci) {
        Date oldProVenci = this.proVenci;
        this.proVenci = proVenci;
        changeSupport.firePropertyChange("proVenci", oldProVenci, proVenci);
    }

    public BigDecimal getProCanmin() {
        return proCanmin;
    }

    public void setProCanmin(BigDecimal proCanmin) {
        BigDecimal oldProCanmin = this.proCanmin;
        this.proCanmin = proCanmin;
        changeSupport.firePropertyChange("proCanmin", oldProCanmin, proCanmin);
    }

    public BigDecimal getProIva() {
        return proIva;
    }

    public void setProIva(BigDecimal proIva) {
        this.proIva = proIva;
    }

    public String getProCbarra() {
        return proCbarra;
    }

    public void setProCbarra(String proCbarra) {
        this.proCbarra = proCbarra;
    }

    public String getProTiva() {
        return proTiva;
    }

    public void setProTiva(String proTiva) {
        this.proTiva = proTiva;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proCodigo != null ? proCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productos)) {
            return false;
        }
        Productos other = (Productos) object;
        if ((this.proCodigo == null && other.proCodigo != null) || (this.proCodigo != null && !this.proCodigo.equals(other.proCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "frames.Productos[ proCodigo=" + proCodigo + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
