/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.gr2tahsilatuygulama.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "THS_BORC")
@NamedQueries({
    @NamedQuery(name = "Borc.findAll", query = "SELECT b FROM Borc b"),
    @NamedQuery(name = "Borc.findById", query = "SELECT b FROM Borc b WHERE b.id = :id"),
    @NamedQuery(name = "Borc.findByKurumIdAboneNo", 
    query = "SELECT b FROM Borc b WHERE b.kurum.id=:kurumId and "
    +"b.aboneNo=:aboneNo and b.faturaDurum=0"),
    @NamedQuery(name = "Borc.findByAboneNo", query = "SELECT b FROM Borc b WHERE b.aboneNo = :aboneNo"),
    @NamedQuery(name = "Borc.findByAboneAd", query = "SELECT b FROM Borc b WHERE b.aboneAd = :aboneAd"),
    @NamedQuery(name = "Borc.findByAboneSoyad", query = "SELECT b FROM Borc b WHERE b.aboneSoyad = :aboneSoyad"),
    @NamedQuery(name = "Borc.findByFaturaNo", query = "SELECT b FROM Borc b WHERE b.faturaNo = :faturaNo"),
    @NamedQuery(name = "Borc.findByFaturaSonOdemeTrh", query = "SELECT b FROM Borc b WHERE b.faturaSonOdemeTrh = :faturaSonOdemeTrh"),
    @NamedQuery(name = "Borc.findByFaturaTutar", query = "SELECT b FROM Borc b WHERE b.faturaTutar = :faturaTutar"),
    @NamedQuery(name = "Borc.findByFaturaDurum", query = "SELECT b FROM Borc b WHERE b.faturaDurum = :faturaDurum")})
public class Borc implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    @SequenceGenerator(name="borcseq",sequenceName = "SEQ_THS_BORC",initialValue = 1,allocationSize=1)
     @GeneratedValue(generator="borcseq",strategy = GenerationType.SEQUENCE)
    private BigDecimal id;
    @Size(max = 100)
    @Column(name = "ABONE_NO")
    private String aboneNo;
    @Size(max = 30)
    @Column(name = "ABONE_AD")
    private String aboneAd;
    @Size(max = 30)
    @Column(name = "ABONE_SOYAD")
    private String aboneSoyad;
    @Size(max = 100)
    @Column(name = "FATURA_NO")
    private String faturaNo;
    @Column(name = "FATURA_SON_ODEME_TRH")
    @Temporal(TemporalType.TIMESTAMP)
    private Date faturaSonOdemeTrh;
    @Column(name = "FATURA_TUTAR")
    private BigDecimal faturaTutar;
    @Column(name = "FATURA_DURUM")
    private Short faturaDurum;
    @JoinColumn(name = "KURUM_ID", referencedColumnName = "ID")
    @ManyToOne(cascade = CascadeType.ALL)
    private Kurum kurum;

    public Borc() {
        kurum=new Kurum();
    }

    public Borc(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getAboneNo() {
        return aboneNo;
    }

    public void setAboneNo(String aboneNo) {
        this.aboneNo = aboneNo;
    }

    public String getAboneAd() {
        return aboneAd;
    }

    public void setAboneAd(String aboneAd) {
        this.aboneAd = aboneAd;
    }

    public String getAboneSoyad() {
        return aboneSoyad;
    }

    public void setAboneSoyad(String aboneSoyad) {
        this.aboneSoyad = aboneSoyad;
    }

    public String getFaturaNo() {
        return faturaNo;
    }

    public void setFaturaNo(String faturaNo) {
        this.faturaNo = faturaNo;
    }

    public Date getFaturaSonOdemeTrh() {
        return faturaSonOdemeTrh;
    }

    public void setFaturaSonOdemeTrh(Date faturaSonOdemeTrh) {
        this.faturaSonOdemeTrh = faturaSonOdemeTrh;
    }

    public BigDecimal getFaturaTutar() {
        return faturaTutar;
    }

    public void setFaturaTutar(BigDecimal faturaTutar) {
        this.faturaTutar = faturaTutar;
    }

    public Short getFaturaDurum() {
        return faturaDurum;
    }

    public void setFaturaDurum(Short faturaDurum) {
        this.faturaDurum = faturaDurum;
    }

    public Kurum getKurum() {
        return kurum;
    }

    public void setKurum(Kurum kurum) {
        this.kurum = kurum;
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
        if (!(object instanceof Borc)) {
            return false;
        }
        Borc other = (Borc) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tr.gov.ptt.gr2tahsilatuygulama.entity.Borc[ id=" + id + " ]";
    }
    
}
