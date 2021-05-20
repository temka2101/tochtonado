package a.vkube.daoimpl;

import a.vkube.dao.DAO;
import a.vkube.model.Gender;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class GenderDaoImpl implements DAO<Gender, Integer> {

    SessionFactory factory;

    public GenderDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Gender gender) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.save(gender);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Gender gender) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(gender);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Gender gender) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.update(gender);
            session.getTransaction().commit();
        }
    }

    @Override
    public Gender findById(Integer id) {
        try (Session session = factory.openSession()){
            return session.get(Gender.class, id);
        }
    }

    @Override
    public List<Gender> findByAll() {
        try (Session session = factory.openSession()){
            return session.createQuery("FROM Gender", Gender.class).list();
        }
    }
}
