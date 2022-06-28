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
import prestamos.entity.Tbprestamo;

/**
 *
 * @author Elisvan
 */
public class TbprestamoJpaController implements Serializable {

    public TbprestamoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PrestamosPU");

    public TbprestamoJpaController() {
     
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tbprestamo tbprestamo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tbprestamo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tbprestamo tbprestamo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tbprestamo = em.merge(tbprestamo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tbprestamo.getCodigo();
                if (findTbprestamo(id) == null) {
                    throw new NonexistentEntityException("EL prestamo  con el codigo " + id + " no existe.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tbprestamo tbprestamo;
            try {
                tbprestamo = em.getReference(Tbprestamo.class, id);
                tbprestamo.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("El prestamo con codigo " + id + " no existe.", enfe);
            }
            em.remove(tbprestamo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tbprestamo> findTbprestamoEntities() {
        return findTbprestamoEntities(true, -1, -1);
    }

    public List<Tbprestamo> findTbprestamoEntities(int maxResults, int firstResult) {
        return findTbprestamoEntities(false, maxResults, firstResult);
    }

    private List<Tbprestamo> findTbprestamoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tbprestamo.class));
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

    public Tbprestamo findTbprestamo(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tbprestamo.class, id);
        } finally {
            em.close();
        }
    }

    public int getTbprestamoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tbprestamo> rt = cq.from(Tbprestamo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
