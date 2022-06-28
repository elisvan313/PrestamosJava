/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prestamos.controlador;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import prestamos.controlador.exceptions.NonexistentEntityException;
import prestamos.entity.Tbcliente;

/**
 *
 * @author Elisvan
 */
public class TbclienteJpaController implements Serializable {

    public TbclienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PrestamosPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public TbclienteJpaController() {
    }
    
    
    public void create(Tbcliente tbcliente) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tbcliente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tbcliente tbcliente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
             Integer cedula = tbcliente.getCedula();
                if (findTbcliente(cedula) == null) {
                    throw new NonexistentEntityException("El cliente con cedula :" + cedula + " no existe.");
                }else{
                    tbcliente = em.merge(tbcliente);
                    em.getTransaction().commit();
                }
        } catch (Exception ex) {
            
            
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer cedula) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tbcliente tbcliente;
            try {
                tbcliente = em.getReference(Tbcliente.class, cedula);
               
               
               
               // tbcliente.getIdtbcliente();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("El cliente con  cedula " + cedula + " no existe.", enfe);
            }
            em.remove(tbcliente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tbcliente> findTbclienteEntities() {
        return findTbclienteEntities(true, -1, -1);
    }

    public List<Tbcliente> findTbclienteEntities(int maxResults, int firstResult) {
        return findTbclienteEntities(false, maxResults, firstResult);
    }

    private List<Tbcliente> findTbclienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tbcliente.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Tbcliente findTbcliente(Integer cedula) {
        Tbcliente cliente = new Tbcliente();
        EntityManager em = getEntityManager();
        try {
            
            return em.find(Tbcliente.class, cedula);
        } finally {
            em.close();
        }
    }

    public int getTbclienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tbcliente> rt = cq.from(Tbcliente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
