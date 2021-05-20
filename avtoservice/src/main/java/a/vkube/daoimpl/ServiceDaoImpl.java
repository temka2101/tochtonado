package a.vkube.daoimpl;

import a.vkube.dao.DAO;
import a.vkube.model.Service;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ServiceDaoImpl implements DAO<Service, Integer> {

    SessionFactory factory;

    public ServiceDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Service service) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.save(service);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Service service) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(service);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Service service) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.update(service);
            session.getTransaction().commit();
        }
    }

    @Override
    public Service findById(Integer id) {
        try (Session session = factory.openSession()){
            return session.get(Service.class, id);
        }
    }

    @Override
    public List<Service> findByAll() {
        try (Session session = factory.openSession()){
            return session.createQuery("FROM Service", Service.class).list();
        }
    }
}
