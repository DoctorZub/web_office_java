/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author miste
 */
@Stateless
public class InstallPlaceFacade extends AbstractFacade<InstallPlace> {

    @PersistenceContext(unitName = "OfficePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InstallPlaceFacade() {
        super(InstallPlace.class);
    }
    
}
