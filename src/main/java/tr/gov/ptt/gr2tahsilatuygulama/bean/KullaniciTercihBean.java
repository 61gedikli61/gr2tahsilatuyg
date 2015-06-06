
package tr.gov.ptt.gr2tahsilatuygulama.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import tr.gov.ptt.gr2tahsilatuygulama.service.KisiService;

@ManagedBean(name="tercih")
@SessionScoped
public class KullaniciTercihBean implements Serializable
{  
    @ManagedProperty(value="#{kisiBean}")
    private KisiBean kisiBean;
    private Object kisiService;

    public void setKisiBean(KisiBean kisiBean) {
        this.kisiBean = kisiBean;
    }

    public void setTemaListesi(List<String> temaListesi) {
        this.temaListesi = temaListesi;
    }
    @EJB
    private KisiService kisiservice;
    private List<String> temaListesi;
    private String secilitema;

    public String getSecilitema() {
        return secilitema;
    }

    public void setSecilitema(String secilitema) {
        this.secilitema = secilitema;
    }

    public KullaniciTercihBean()
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
                          
                          secilitema="afterdark";
    
    }
    @PostConstruct
    public void vttemecek()
    {
        secilitema=kisiBean.getKisi().getTema();
        if(secilitema==null )
        {
            secilitema="bluesky";
        }
         
    }
    public List<String> getTemaListesi()
    {
        return   temaListesi;
    }
    public void temaKaydet()
    {
      kisiBean.getKisi().setTema(secilitema);
      kisiservice.kisiguncelle(kisiBean.getKisi());
    
    }

    public KisiBean getKisiBean() {
        return kisiBean;
    }
}
