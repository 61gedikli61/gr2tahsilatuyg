
package tr.gov.ptt.gr2tahsilatuygulama.bean;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;
import tr.gov.ptt.gr2tahsilatuygulama.entity.Kisi;
import tr.gov.ptt.gr2tahsilatuygulama.service.KisiService;
import tr.gov.ptt.gr2tahsilatuygulama.util.JSFUtil;


@ManagedBean
@SessionScoped
public class KisiBean 
{
    private Kisi kisi;
    
    @EJB
    private KisiService kisiservice;
    
    private List<String> temaListesi;

    public List<String> getTemaListesi() {
        return temaListesi;
    }
    
    public KisiBean() 
    {
     kisi=new Kisi();

    
     
     kisi.setTema("bluesky");
     temaListesi=new ArrayList<>();
     temalistesiDoldur();
      kisi.setKullaniciAd("ogedikli");
     kisi.setSifre("616161");
    }
    
    public Kisi getKisi() 
    {
        return kisi;
    }

    public void setKisi(Kisi kisi) {
        this.kisi = kisi;
    }
    public void temalistesiDoldur()
    {
         temaListesi=new ArrayList<String>();
        temaListesi.add("afterdark");
          temaListesi.add("afternoon");
            temaListesi.add("afterwork");
              temaListesi.add("bluesky");
                temaListesi.add("flick");
                  temaListesi.add("blitzer");
                   temaListesi.add("sunny");
                    temaListesi.add("vader");
                     temaListesi.add("sam");
                   temaListesi.add("redmond");
                      temaListesi.add("rocket");
                        temaListesi.add("trontastic");
                          temaListesi.add("cruze");
    }
    public String girisKontrol()
    {
    Kisi vtkisi= kisiservice.girisKontrol(this.kisi);
    if(vtkisi!=null)
    {   this.kisi=vtkisi;
       HttpSession session=JSFUtil.getSession();
       session.setAttribute("username", vtkisi.getKullaniciAd());  
      
       return "menu.xhtml?faces-redirect=true" ;
    }
    else
    {   JSFUtil.hatamesajiekle("Yanlış giriş:","Kullanıcı adı ya da şifre yanlış!");
        return "giris.xhtml?faces-redirect=true";
        
    }
  
            
 }
  public String guvenlicikis()
    {  
       JSFUtil.sessionBitir();
       return "giris.xhtml?faces-redirect=true";
    }
    public void temaKaydet()
    {
        kisiservice.kisiguncelle(kisi);
    }
    
    
}
