package a.vkube.dao;

import java.util.List;

public interface DAO<Entity, Key>{
    void create(Entity entity);
    void delete(Entity entity);
    void update(Entity entity);
    Entity findById(Key key);
    List<Entity> findByAll();
}
