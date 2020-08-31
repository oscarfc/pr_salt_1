/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.salt.pr_salt_1.user;

import it.salt.pr_salt_1.security.Credential;
import java.util.Collection;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 *
 * @author oscar.favero
 */
@Stateless
public class UserStore {

    @PersistenceContext(name = "salt")
    EntityManager em;

    /**
     *
     */
    @PostConstruct
    public void init() {

    }

    /**
     *
     * @return
     */
    public Collection<User> all() {
//        return em.createNamedQuery(User.FIND_ALL)
//                .getResultList();
        return null;
    }

    /**
     *
     * @param id
     * @return
     */
    public Optional<User> find(Long id) {
//        User found = em.find(User.class, id);
        User found = null;
        return found == null ? Optional.empty() : Optional.of(found);
    }

    /**
     *
     * @param u
     * @return
     */
    public User create(User u) {
        System.out.println("-------" + u + " ---------");
//        if (findByUsr(u.getUsr()).isPresent()) {
//            throw new UserAlreadyExistException(u.getUsr());
//        }
//        u.setPwd(SecurityEncoding.shaHash(u.getPwd()));
//        return em.merge(u);
        return null;
    }

    /**
     *
     * @param u
     * @return
     */
    public User update(User u) {
//        return em.merge(u);
        return null;
    }

    /**
     *
     * @param id
     */
    public void delete(Long id) {
//        em.remove(em.find(User.class, id));
    }

    /**
     *
     * @param usr
     * @return
     */
    public Optional<User> findByUsr(String usr) {
        return em.createNamedQuery(User.FIND_BY_USR, User.class)
                .setParameter("usr", usr)
                .getResultStream()
                .findFirst();
    }

    public Optional<User> search(Credential credential) {
//        credential.setPwd(SecurityEncoding.shaHash(credential.getPwd()));
        try {
            User found = em.createNamedQuery(User.FIND_BY_USR_PWD, User.class)
                    .setParameter("usr", credential.getUsr())
                    .setParameter("pwd", credential.getPwd())
                    .getSingleResult();
            return Optional.of(found);
        } catch (Exception ex) {
            Logger.getLogger(UserStore.class.getName()).log(Level.SEVERE, null, ex);
            return Optional.empty();
        }
    }
}
