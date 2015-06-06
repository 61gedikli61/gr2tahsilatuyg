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
import javax.persistence.ManyToMany;
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
@Table(name = "THS_TIP")
@NamedQueries({
    @NamedQuery(name = "Tip.findAll", query = "SELECT t FROM Tip t"),
    @NamedQuery(name = "Tip.findByNo", query = "SELECT t FROM Tip t WHERE t.no = :no"),
    @NamedQuery(name = "Tip.findByAd", query = "SELECT t FROM Tip t WHERE t.ad = :ad")})
public class Tip implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NO")
    


    @SequenceGenerator(name="tipseq",sequenceName = "SEQ_THS_TIP",initialValue = 1,allocationSize=1)
    @GeneratedValue(generator="tipseq",strategy = GenerationType.SEQUENCE)
    private BigDecimal no;
    @Size(max = 30)
    @Column(name = "AD")
    private String ad;
    @ManyToMany(mappedBy = "tipList",cascade = CascadeType.ALL)
    private List<Menu> menuList;
    @OneToMany(mappedBy = "tip",cascade = CascadeType.ALL)
    private List<Kisi> kisiList;

    public Tip() {
    }

    public Tip(BigDecimal no) {
        this.no = no;
    }

    public BigDecimal getNo() {
        return no;
    }

    public void setNo(BigDecimal no) {
        this.no = no;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public List<Kisi> getKisiList() {
        return kisiList;
    }

    public void setKisiList(List<Kisi> kisiList) {
        this.kisiList = kisiList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (no != null ? no.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tip)) {
            return false;
        }
        Tip other = (Tip) object;
        if ((this.no == null && other.no != null) || (this.no != null && !this.no.equals(other.no))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tr.gov.ptt.gr2tahsilatuygulama.entity.Tip[ no=" + no + " ]";
    }
    
}
