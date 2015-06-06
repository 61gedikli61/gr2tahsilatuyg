
package tr.gov.ptt.gr2tahsilatuygulama.bean;

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
    
    
      public KisiBean() 
    {
     kisi=new Kisi();
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
 public String girisKontrol()
 {
    Kisi vtkisi= kisiservice.girisKontrol(this.kisi);
    if(vtkisi!=null)
    {   this.kisi=vtkisi;
       HttpSession session=JSFUtil.getSession();
       session.setAttribute("username", vtkisi.getKullaniciAd());  
       System.out.println("ddddd");
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
    
    
    
}
