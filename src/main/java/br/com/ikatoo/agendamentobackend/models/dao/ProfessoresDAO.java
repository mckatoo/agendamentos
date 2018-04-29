/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ikatoo.agendamentobackend.models.dao;

import br.com.ikatoo.agendamentobackend.connection.ConnectionFactory;
import br.com.ikatoo.agendamentobackend.models.Professores;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author mckatoo
 */
public class ProfessoresDAO {

    public Professores save(Professores professores) {

        EntityManager em = new ConnectionFactory().getConnection();

        try {
            em.getTransaction().begin();
            if (professores.getIdprofessor() == null) {
                em.persist(professores);
            } else {
                em.merge(professores);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return professores;

    }

    public Professores remove(Integer id) {

        EntityManager em = new ConnectionFactory().getConnection();
        Professores professores = null;

        try {
            professores = em.find(Professores.class, id);
            em.getTransaction().begin();
            em.remove(professores);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return professores;

    }

    public Professores findById(Integer id) {

        EntityManager em = new ConnectionFactory().getConnection();
        Professores professores = null;

        try {
            professores = em.find(Professores.class, id);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }

        return professores;

    }

    public List<Professores> findAll() {

        EntityManager em = new ConnectionFactory().getConnection();
        List<Professores> professores = null;

        try {
            professores = em.createQuery("from Professores p").getResultList();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }

        return professores;

    }

}
