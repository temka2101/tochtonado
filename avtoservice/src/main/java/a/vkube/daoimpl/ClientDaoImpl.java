package a.vkube.daoimpl;

import a.vkube.dao.DAO;
import a.vkube.model.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ClientDaoImpl implements DAO<Client, Integer> {

    SessionFactory factory;

    public ClientDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Client client) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.save(client);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Client client) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(client);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Client client) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.update(client);
            session.getTransaction().commit();
        }
    }

    @Override
    public Client findById(Integer id) {
        try (Session session = factory.openSession()){
            return session.get(Client.class, id);
        }
    }

    @Override
    public List<Client> findByAll() {
        try (Session session = factory.openSession()){
            return session.createQuery("FROM Client", Client.class).list();
        }
    }
}
