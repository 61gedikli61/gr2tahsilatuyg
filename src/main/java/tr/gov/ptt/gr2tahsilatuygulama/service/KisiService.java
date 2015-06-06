
package tr.gov.ptt.gr2tahsilatuygulama.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import tr.gov.ptt.gr2tahsilatuygulama.entity.Kisi;
import tr.gov.ptt.gr2tahsilatuygulama.facade.KisiFacade;

@Stateless
public class KisiService 
{  @EJB
  private KisiFacade kisiFacade;

  public Kisi girisKontrol(Kisi p_kisi)
    {
     return kisiFacade.girisKontrol(p_kisi);
    }
  
      public void kisiguncelle(Kisi p_kisi)
    {
        kisiFacade.edit(p_kisi);
     
  
}
}
