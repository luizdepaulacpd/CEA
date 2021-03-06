/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import model.ModelAluno;
import model.ModelBoletim;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Cpd01
 */
public class DaoBoletim {

    Session session = HibernateUtil.getSessionFactory().openSession();

    public void salvarBoletim(ModelBoletim modelBoletim) {

        try {

            session.getTransaction().begin();
            session.persist(modelBoletim);
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

    public void excluirBoletim(ModelBoletim modelBoletim) {

        try {

            session.getTransaction().begin();
            session.delete(modelBoletim);
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

    public void atualizarBoletim(ModelBoletim modelBoletim) {

        try {
            session.getTransaction().begin();
            session.update(modelBoletim);
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

    public List<ModelBoletim> listaBoletim() {
        List<ModelBoletim> listaBoletim = new ArrayList<>();
        Query sql = (Query) session.createQuery("from ModelBoletim");
        listaBoletim = sql.getResultList();

        return listaBoletim;
    }

}
