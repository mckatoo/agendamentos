/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ikatoo.agendamentobackend.models.dao;

import br.com.ikatoo.agendamentobackend.connection.ConnectionFactory;
import br.com.ikatoo.agendamentobackend.models.Turmas;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author mckatoo
 */
public class TurmasDAO {

    public Turmas save(Turmas turmas) {

        EntityManager em = new ConnectionFactory().getConnection();

        try {
            em.getTransaction().begin();
            if (turmas.getIdturma() == null) {
                em.persist(turmas);
            } else {
                em.merge(turmas);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return turmas;

    }

    public Turmas remove(Integer id) {

        EntityManager em = new ConnectionFactory().getConnection();
        Turmas turmas = null;

        try {
            turmas = em.find(Turmas.class, id);
            em.getTransaction().begin();
            em.remove(turmas);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return turmas;

    }

    public Turmas findById(Integer id) {

        EntityManager em = new ConnectionFactory().getConnection();
        Turmas turmas = null;

        try {
            turmas = em.find(Turmas.class, id);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }

        return turmas;

    }

    public List<Turmas> findAll() {

        EntityManager em = new ConnectionFactory().getConnection();
        List<Turmas> turmas = null;

        try {
            turmas = em.createQuery("from Turmas p").getResultList();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }

        return turmas;

    }

}
