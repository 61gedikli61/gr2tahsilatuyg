/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.gr2tahsilatuygulama.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "THS_MENU")
@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m"),
    @NamedQuery(name = "Menu.findByNo", query = "SELECT m FROM Menu m WHERE m.no = :no"),
    @NamedQuery(name = "Menu.findByBaslik", query = "SELECT m FROM Menu m WHERE m.baslik = :baslik"),
    @NamedQuery(name = "Menu.findByLink", query = "SELECT m FROM Menu m WHERE m.link = :link"),
    @NamedQuery(name = "Menu.findBySirano", query = "SELECT m FROM Menu m WHERE m.sirano = :sirano")})
public class Menu implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NO")
    


@SequenceGenerator(name="menuseq",sequenceName = "SEQ_THS_MENU",initialValue = 1,allocationSize=1)
    @GeneratedValue(generator="menuseq",strategy = GenerationType.SEQUENCE)
    private BigDecimal no;
    @Size(max = 100)
    @Column(name = "BASLIK")
    private String baslik;
    @Size(max = 250)
    @Column(name = "LINK")
    private String link;
    @Column(name = "SIRANO")
    private BigInteger sirano;
    @JoinTable(name = "THS_MENU_TIP", joinColumns = {
        @JoinColumn(name = "MENUNO", referencedColumnName = "NO")}, inverseJoinColumns = {
        @JoinColumn(name = "TIPNO", referencedColumnName = "NO")})
    @ManyToMany(cascade = CascadeType.ALL)
    
    private List<Tip> tipList;

    public Menu() {
    }

    public Menu(BigDecimal no) {
        this.no = no;
    }

    public BigDecimal getNo() {
        return no;
    }

    public void setNo(BigDecimal no) {
        this.no = no;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public BigInteger getSirano() {
        return sirano;
    }

    public void setSirano(BigInteger sirano) {
        this.sirano = sirano;
    }

    public List<Tip> getTipList() {
        return tipList;
    }

    public void setTipList(List<Tip> tipList) {
        this.tipList = tipList;
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
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.no == null && other.no != null) || (this.no != null && !this.no.equals(other.no))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tr.gov.ptt.gr2tahsilatuygulama.entity.Menu[ no=" + no + " ]";
    }
    
}
