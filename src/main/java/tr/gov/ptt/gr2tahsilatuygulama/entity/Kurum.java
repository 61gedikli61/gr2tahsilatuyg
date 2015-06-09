/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.gr2tahsilatuygulama.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "THS_KURUM")
@NamedQueries({
    @NamedQuery(name = "Kurum.findAll", query = "SELECT k FROM Kurum k"),
    @NamedQuery(name = "Kurum.findById", query = "SELECT k FROM Kurum k WHERE k.id = :id"),
    @NamedQuery(name = "Kurum.findByAd", query = "SELECT k FROM Kurum k WHERE k.ad = :ad")})
public class Kurum implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    @SequenceGenerator(name="kurumseq",sequenceName = "SEQ_THS_KURUM",initialValue = 1,allocationSize=1)
     @GeneratedValue(generator="kurumseq",strategy = GenerationType.SEQUENCE)
    private BigDecimal id;
    @Size(max = 250)
    @Column(name = "AD")
    private String ad;
    @OneToMany(mappedBy = "kurum",cascade = CascadeType.ALL)
    private List<Borc> borcList;

    public Kurum() {
    }

    public Kurum(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public List<Borc> getBorcList() {
        return borcList;
    }

    public void setBorcList(List<Borc> borcList) {
        this.borcList = borcList;
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
        if (!(object instanceof Kurum)) {
            return false;
        }
        Kurum other = (Kurum) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tr.gov.ptt.gr2tahsilatuygulama.entity.Kurum[ id=" + id + " ]";
    }
    
}
