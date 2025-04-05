/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facde;

import Entities.Equipment;
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

    @PersistenceContext(unitName = "TESTIKPU")
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
        Query q = getEntityManager().createQuery("select e from Equipment e order by e.equipmentId");
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
        Query q = em.createQuery("SELECT SUM(e.price) FROM Equipment e");
        Number sum = (Number) q.getSingleResult();
        return sum;
    }
    
    public Number sumPriceEVS() {
        Query q = em.createQuery("SELECT SUM(e.price) FROM Equipment e JOIN e.installPlace i WHERE i.departmentPlace = 'ЭВС'");
        Number sum = (Number) q.getSingleResult();
        return sum;
    } 
    public Number sumPriceGKS() {
        Query q = em.createQuery("SELECT SUM(e.price) FROM Equipment e JOIN e.installPlace i WHERE i.departmentPlace = 'ГКС'");
        Number sum = (Number) q.getSingleResult();
        return sum;
    }
    public Number sumPriceLES() {
        Query q = em.createQuery("SELECT SUM(e.price) FROM Equipment e JOIN e.installPlace i WHERE i.departmentPlace = 'ЛЭС'");
        Number sum = (Number) q.getSingleResult();
        return sum;
    }


public List<Equipment> findRangeEVS(int[] range) {
        Query q = em.createQuery("SELECT e FROM Equipment e JOIN e.installPlace i WHERE i.departmentPlace ='ЭВС'");
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }
public List<Equipment> findRangeGKS(int[] range) {
        Query q = em.createQuery("SELECT e FROM Equipment e JOIN e.installPlace i WHERE i.departmentPlace ='ГКС'");
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }
public List<Equipment> findRangeLES(int[] range) {
        Query q = em.createQuery("SELECT e FROM Equipment e JOIN e.installPlace i WHERE i.departmentPlace ='ЛЭС'");
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

public int countEVS() {
        Query q = em.createQuery("SELECT COUNT(e) FROM Equipment e JOIN e.installPlace i WHERE i.departmentPlace ='ЭВС'");
        return ((Long) q.getSingleResult()).intValue();
    }
public int countGKS() {
        Query q = em.createQuery("SELECT COUNT(e) FROM Equipment e JOIN e.installPlace i WHERE i.departmentPlace ='ГКС'");
        return ((Long) q.getSingleResult()).intValue();
    }
public int countLES() {
        Query q = em.createQuery("SELECT COUNT(e) FROM Equipment e JOIN e.installPlace i WHERE i.departmentPlace ='ЛЭС'");
        return ((Long) q.getSingleResult()).intValue();
    }

public List<Equipment> findRangenew(int[] range) {
        Query q = em.createQuery("SELECT e FROM Equipment e ORDER BY e.equipmentId");
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }
}
