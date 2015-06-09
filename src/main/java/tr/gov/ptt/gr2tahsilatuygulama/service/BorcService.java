/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.gr2tahsilatuygulama.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import tr.gov.ptt.gr2tahsilatuygulama.entity.Borc;
import tr.gov.ptt.gr2tahsilatuygulama.facade.BorcFacade;
import tr.gov.ptt.gr2tahsilatuygulama.facade.KurumFacade;

/**
 *
 * @author Administrator
 */
@Stateless
public class BorcService {
    @EJB
    private BorcFacade borcfacade;
    
    @EJB
    private KurumFacade kurumFacade;
            
  public List<Borc> borcGetir(Borc p_borc)
    {
        p_borc.getKurum().setId(new BigDecimal(kurumFacade.kurumIdGetir(p_borc.getKurum().getAd())));
        return borcfacade.borcGetir(p_borc);
    }
  
  public  List<String> tamamlaKurumAdi(String p_sorgu)
    {   
        
        return kurumFacade.tamamlaKurumAdi(p_sorgu);
    }
    public  int kurumIdGetir(String p_sorgu)
    {   
        
        return kurumFacade.kurumIdGetir(p_sorgu);
    }
}
