/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author miste
 */
@Stateless
public class EquipmentFacade extends AbstractFacade<Equipment> {
    private List<Equipment> list = new ArrayList();

    @PersistenceContext(unitName = "OfficePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EquipmentFacade() {
        super(Equipment.class);
    }
    
     public List<Equipment> findAlltest() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(Equipment.class));
        return getEntityManager().createQuery(cq).getResultList();
    }
     
     public List<Equipment> getApp() {
        Query q = getEntityManager().createQuery("select e from Equipment e");
        return q.getResultList();
     }

    public List<Equipment> getApp2() {
        return em.createNamedQuery("Equipment.findAll").getResultList();
    }
    
    public List<Equipment> search(String searchValue) {
        return em.createQuery("SELECT e FROM Equipment e WHERE e.equipName = :equipName").setParameter("equipName", searchValue).getResultList();
    }
    
    public List<Equipment> searchDEP(String searchValue) {
        return em.createQuery("SELECT e FROM Equipment e JOIN e.installPlace i WHERE i.departmentPlace = :dep").setParameter("dep", searchValue).getResultList();
    }
    
    
    public Number sumPrice() {
        Query q = em.createQuery("SELECT SUM(e.price) FROM Equipment e JOIN e.installPlace i WHERE i.departmentPlace = 'ЭВС'");
        Number sum = (Number) q.getSingleResult();
        return sum;
    } 
}