package ru.gromax.mybookshopapp.data;

import jakarta.persistence.EntityManagerFactory;
import lombok.Setter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public abstract class AbstractHibernateDAO<T> {

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Setter
    private Class<T> clazz;

    public T findOne(Long id){
        return getSession().find(clazz, id);
    }

    public Session getSession(){
        return entityManagerFactory.createEntityManager().unwrap(Session.class);
    }
}
