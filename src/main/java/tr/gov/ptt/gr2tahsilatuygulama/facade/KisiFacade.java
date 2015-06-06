/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.gr2tahsilatuygulama.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tr.gov.ptt.gr2tahsilatuygulama.entity.Kisi;

/**
 *
 * @author Administrator
 */
@Stateless
public class KisiFacade extends AbstractFacade<Kisi> {
    @PersistenceContext(unitName = "tr.gov.ptt_gr2tahsilatuygulama_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public KisiFacade() {
        super(Kisi.class);
    }
   
    public Kisi girisKontrol(Kisi p_kisi)
    {
      Kisi k=(Kisi)em.createNamedQuery("Kisi.girisKontrol").setParameter("kullaniciAd",p_kisi.getKullaniciAd()).setParameter("sifre",p_kisi.getSifre()).getSingleResult();
      return k;
             
    }
   
}
