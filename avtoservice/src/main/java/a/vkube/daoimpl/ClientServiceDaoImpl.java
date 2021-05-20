package a.vkube.daoimpl;

import a.vkube.dao.DAO;
import a.vkube.model.ClientService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ClientServiceDaoImpl implements DAO<ClientService, Integer> {

    SessionFactory factory;

    public ClientServiceDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(ClientService clientService) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.save(clientService);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(ClientService clientService) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(clientService);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(ClientService clientService) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.update(clientService);
            session.getTransaction().commit();
        }
    }

    @Override
    public ClientService findById(Integer id) {
        try (Session session = factory.openSession()){
            return session.get(ClientService.class, id);
        }
    }

    @Override
    public List<ClientService> findByAll() {
        try (Session session = factory.openSession()){
            return session.createQuery("FROM ClientService", ClientService.class).list();
        }
    }
}
