/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.gr2tahsilatuygulama.facade;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tr.gov.ptt.gr2tahsilatuygulama.entity.Kurum;

/**
 *
 * @author Administrator
 */
@Stateless
public class KurumFacade extends AbstractFacade<Kurum> {
    @PersistenceContext(unitName = "tr.gov.ptt_gr2tahsilatuygulama_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public KurumFacade() {
        super(Kurum.class);
    }
      
    public int kurumIdGetir(String p_kurumAd)
    {
    Kurum kurum=(Kurum)em.createNamedQuery("Kurum.findByAd").setParameter("ad",p_kurumAd).getSingleResult();
    return kurum.getId().intValue();
    }
   
    public List<String> tamamlaKurumAdi(String p_sorgu)
    {   
        List<String> kurumAdiListesi=new ArrayList<String>();
        List<Kurum> kurumlistesi=findAll();
        
        for(Kurum kurum:kurumlistesi)
        {
            if(kurum.getAd().toUpperCase().startsWith(p_sorgu.toUpperCase()))
            {
                kurumAdiListesi.add(kurum.getAd());
            }
        }
        return kurumAdiListesi;
    }
}
