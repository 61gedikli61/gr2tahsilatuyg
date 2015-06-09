
package tr.gov.ptt.gr2tahsilatuygulama.bean;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;
import tr.gov.ptt.gr2tahsilatuygulama.entity.Borc;
import tr.gov.ptt.gr2tahsilatuygulama.service.BorcService;

@ManagedBean
@SessionScoped
public class BorcBean 
{
    private Borc borc;
    private List<Borc> borcListesi;
    private List<Borc> seciliborclar;
    private Double toplam;
    private Double alinan;
    private Double paraustu;

    public Double getToplam() {
        return toplam;
    }

    public void setToplam(Double toplam) {
        this.toplam = toplam;
    }

    public Double getAlinan() {
        return alinan;
    }

    public void setAlinan(Double alinan) {
        this.alinan = alinan;
    }

    public Double getParaustu() {
        return paraustu;
    }

    public void setParaustu(Double paraustu) {
        this.paraustu = paraustu;
    }
    
    @EJB
    private BorcService borcservice;
    
    public Borc getBorc() {
        return borc;
    }

    public void setBorc(Borc borc) {
        this.borc = borc;
    }

    public BorcBean() {
       borc =new  Borc();
       borcListesi=new ArrayList<Borc>();
       seciliborclar=new ArrayList<Borc>();
       toplam=0.0;
       alinan=0.0;
       paraustu=0.0;
    }

    public List<Borc> getSeciliborclar() {
        return seciliborclar;
    }

    public void setSeciliborclar(List<Borc> seciliborclar) {
        this.seciliborclar = seciliborclar;
    }

    
    
    public List<Borc> getBorcListesi() {
        return borcListesi;
    }

    public void setBorcListesi(List<Borc> borcListesi) {
        this.borcListesi = borcListesi;
    }

    
    
    public String borcListele()
    {
     borcListesi=borcservice.borcGetir(borc);
     borc=borcListesi.get(0);
     return "tahsilatlistele.xhtml?faces-redirect=true";
    }
   public List<String> tamamlaKurumAdi(String p_sorgu)
   {
       return borcservice.tamamlaKurumAdi(p_sorgu);
   }
   public int kurumIdGetir(String p_kurumadi)
   {
       return borcservice.kurumIdGetir(p_kurumadi);
   
   }
   public String hesapla()
   {  
       toplam=0.0;
       alinan=0.0;
       paraustu=0.0;
               
       for(Borc borc:seciliborclar)
       {
               
     toplam=toplam+borc.getFaturaTutar().doubleValue();
       
       }
       paraUstu();
       return "";
   }
   public void paraUstu()
   {
       paraustu=alinan-toplam;
   }
    
}
