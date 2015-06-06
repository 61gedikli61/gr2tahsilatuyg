/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.gr2tahsilatuygulama.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tr.gov.ptt.gr2tahsilatuygulama.entity.Tip;

/**
 *
 * @author Administrator
 */
@Stateless
public class TipFacade extends AbstractFacade<Tip> {
    @PersistenceContext(unitName = "tr.gov.ptt_gr2tahsilatuygulama_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipFacade() {
        super(Tip.class);
    }
    
}
