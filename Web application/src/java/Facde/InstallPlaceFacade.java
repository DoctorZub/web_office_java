/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facde;

import Entities.InstallPlace;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author miste
 */
@Stateless
public class InstallPlaceFacade extends AbstractFacade<InstallPlace> {

    @PersistenceContext(unitName = "TESTIKPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InstallPlaceFacade() {
        super(InstallPlace.class);
    }
    
}
