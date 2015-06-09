/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.gr2tahsilatuygulama.facade;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tr.gov.ptt.gr2tahsilatuygulama.entity.Borc;

/**
 *
 * @author Administrator
 */
@Stateless
public class BorcFacade extends AbstractFacade<Borc> {
    @PersistenceContext(unitName = "tr.gov.ptt_gr2tahsilatuygulama_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BorcFacade() {
        super(Borc.class);
    }
     public List<Borc> borcGetir(Borc p_borc)
    {
      List<Borc> borclistesi= em.createNamedQuery("Borc.findByKurumIdAboneNo").setParameter("kurumId",p_borc.getKurum().getId()).setParameter("aboneNo", p_borc.getAboneNo()).getResultList();
          return borclistesi;
    }
    
}
