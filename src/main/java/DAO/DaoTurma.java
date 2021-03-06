/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import model.ModelTurma;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Cpd01
 */
public class DaoTurma {

    Session session = HibernateUtil.getSessionFactory().openSession();

    public void salvarAluno(ModelTurma modelTurma) {

        try {

            session.getTransaction().begin();
            session.persist(modelTurma);
            session.getTransaction().commit();
            session.flush();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }

        }

    }

    public void excluirAluno(ModelTurma modelTurma) {

        try {

            session.getTransaction().begin();
            session.delete(modelTurma);
            session.getTransaction().commit();
            session.flush();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }

        }

    }

    public void atualizarAluno(ModelTurma modelTurma) {

        try {
            session.getTransaction().begin();
            session.update(modelTurma);
            session.getTransaction().commit();
            session.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    public List<ModelTurma> listaAluno() {
        List<ModelTurma> listaTurma = new ArrayList<>();
        Query sql = (Query) session.createQuery("from ModelTurma");
        listaTurma = sql.getResultList();

        return listaTurma;
    }
}
