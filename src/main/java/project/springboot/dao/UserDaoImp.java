package project.springboot.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import project.springboot.model.User;

import java.util.List;


@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private EntityManager entityManager;


    @Override
    public void createUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> readAllUser() {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }

    @Override
    public User readUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void deleteUserById(Long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }


}