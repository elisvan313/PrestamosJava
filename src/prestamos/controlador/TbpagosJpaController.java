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
import prestamos.entity.Tbpagos;


public class TbpagosJpaController implements Serializable {

    public TbpagosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PrestamosPU");

    public TbpagosJpaController() {
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tbpagos tbpagos) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tbpagos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tbpagos tbpagos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tbpagos = em.merge(tbpagos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tbpagos.getIdpago();
                if (findTbpagos(id) == null) {
                    throw new NonexistentEntityException("The tbpagos with id " + id + " no longer exists.");
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
            Tbpagos tbpagos;
            try {
                tbpagos = em.getReference(Tbpagos.class, id);
                tbpagos.getIdpago();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tbpagos with id " + id + " no longer exists.", enfe);
            }
            em.remove(tbpagos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tbpagos> findTbpagosEntities() {
        return findTbpagosEntities(true, -1, -1);
    }

    public List<Tbpagos> findTbpagosEntities(int maxResults, int firstResult) {
        return findTbpagosEntities(false, maxResults, firstResult);
    }

    private List<Tbpagos> findTbpagosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tbpagos.class));
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

    public Tbpagos findTbpagos(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tbpagos.class, id);
        } finally {
            em.close();
        }
    }

    public int getTbpagosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tbpagos> rt = cq.from(Tbpagos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
