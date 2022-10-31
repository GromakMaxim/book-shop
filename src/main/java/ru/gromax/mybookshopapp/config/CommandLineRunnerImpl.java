package ru.gromax.mybookshopapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import ru.gromax.mybookshopapp.data.TestEntity;
import ru.gromax.mybookshopapp.data.TestEntityCRUDRepository;

import java.util.logging.Logger;

//@Configuration
public class CommandLineRunnerImpl implements CommandLineRunner {

    TestEntityCRUDRepository testEntityCRUDRepository;

    @Autowired
    public CommandLineRunnerImpl(TestEntityCRUDRepository testEntityCRUDRepository) {
        this.testEntityCRUDRepository = testEntityCRUDRepository;
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

    private void deleteById(int id) {
        testEntityCRUDRepository.deleteById(new Long(id));
    }

    private TestEntity updateTestEntityById(int id) {
        TestEntity testEntity = testEntityCRUDRepository.findById(new Long(id)).get();
        testEntity.setData("NEW DATA");
        return testEntityCRUDRepository.save(testEntity);
    }


    private TestEntity readTestEntityById(int id) {
        return testEntityCRUDRepository.findById(new Long(id)).get();
    }

    private void createTestEntity(TestEntity entity) {
        entity.setData(entity.getClass().getSimpleName() + entity.hashCode());
        testEntityCRUDRepository.save(entity);
    }
}
