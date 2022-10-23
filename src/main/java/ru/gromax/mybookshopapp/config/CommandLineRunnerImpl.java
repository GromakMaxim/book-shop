package ru.gromax.mybookshopapp.config;

import jakarta.persistence.EntityManagerFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import ru.gromax.mybookshopapp.data.TestEntity;

import java.util.logging.Logger;

@Configuration
public class CommandLineRunnerImpl implements CommandLineRunner {

    EntityManagerFactory entityManagerFactory;

    @Autowired
    public CommandLineRunnerImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public void run(String... args) throws Exception {
        int limit = 15;
        for (int i = 0; i < limit; i++) {
            createTestEntity(new TestEntity());
        }

        TestEntity testEntity = readTestEntityById(3);
        if (testEntity != null) {
            Logger.getLogger(this.getClass().getSimpleName()).info("read: " + testEntity.toString());
        } else {
            throw new NullPointerException();
        }

        var updatedEntity = updateTestEntityById(5);
        if (updatedEntity != null) {
            Logger.getLogger(this.getClass().getSimpleName()).info("updated: " + updatedEntity.toString());
        } else {
            throw new NullPointerException();
        }

        deleteById(2);
    }

    private void deleteById(int id){
        Transaction tx = null;

        try (Session session = entityManagerFactory.createEntityManager().unwrap(Session.class)) {
            tx = session.beginTransaction();

            var found = readTestEntityById(id);
            found = session.merge(found);
            session.remove(found);

            tx.commit();
        } catch (HibernateException hibernateException) {
            if (tx != null) {
                tx.rollback();
            } else {
                hibernateException.printStackTrace();
            }
        }
    }

    private TestEntity updateTestEntityById(int id) {
        Transaction tx = null;
        TestEntity result = null;

        try (Session session = entityManagerFactory.createEntityManager().unwrap(Session.class)) {
            tx = session.beginTransaction();

            var foundEntity = readTestEntityById(id);
            foundEntity.setData("NEW DATA INSERTED");
            result = session.merge(foundEntity);

            tx.commit();
        } catch (HibernateException hibernateException) {
            if (tx != null) {
                tx.rollback();
            } else {
                hibernateException.printStackTrace();
            }
        }
        return result;
    }


    private TestEntity readTestEntityById(int id) {
        Transaction tx = null;
        TestEntity result = null;

        try (Session session = entityManagerFactory.createEntityManager().unwrap(Session.class)) {
            tx = session.beginTransaction();

            result = session.find(TestEntity.class, id);

            tx.commit();
        } catch (HibernateException hibernateException) {
            if (tx != null) {
                tx.rollback();
            } else {
                hibernateException.printStackTrace();
            }
        }
        return result;
    }

    private void createTestEntity(TestEntity entity) {
        Transaction tx = null;
        try (Session session = entityManagerFactory.createEntityManager().unwrap(Session.class)) {

            tx = session.beginTransaction();
            entity.setData(entity.getClass().getSimpleName() + entity.hashCode());
            session.save(entity);
            tx.commit();
        } catch (HibernateException hibernateException) {
            if (tx != null) {
                tx.rollback();
            } else {
                hibernateException.printStackTrace();
            }
        }
    }
}
