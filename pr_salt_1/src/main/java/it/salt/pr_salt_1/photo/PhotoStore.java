/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.salt.pr_salt_1.photo;

import java.util.List;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author oscar.favero
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class PhotoStore {

    @PersistenceContext(name = "salt")
    private EntityManager em;

    /**
     *
     * @param id
     * @return Photo
     */
    public Photo find(Long id) {
        return em.find(Photo.class, id);
    }

    /**
     *
     * @param site
     * @return List<Photo>
     */
    public List<Photo> findBySite(String site) {
        return em.createNamedQuery(Photo.FIND_BY_SITE, Photo.class)
                .setParameter("site", site)
                .getResultList();
    }

    /**
     *
     * @param id
     * @param site
     * @return Optional<Photo>
     */
    public Optional<Photo> findByIdAndSite(Long id, String site) {
        try {
            Photo result = em.createNamedQuery(Photo.FIND_BY_ID_AND_SITE, Photo.class)
                    .setParameter("id", id)
                    .setParameter("site", site)
                    .getSingleResult();
            return Optional.of(result);
        } catch (NoResultException ex) {
            return Optional.empty();
        }
    }

}
