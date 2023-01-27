package com.example.multimodule.batch;

import com.example.multimodule.library.entity.DetailedUser;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ReadAndWriteJobIntegrationTests {

    @Autowired
    ItemReader<DetailedUser> itemReader;
    @Autowired
    EntityManager em;

    @Test
    void itemReaderStarts() {
        assertNotNull(itemReader);
    }

    @Test
    @SneakyThrows
    void itemReaderReads() {
        persistADetailedUser();

        assertNotNull(itemReader.read());
        assertNull(itemReader.read());
    }

    private void persistADetailedUser() {
        DetailedUser detailedUser = new DetailedUser();
        detailedUser.setFirstname("first_name");
        detailedUser.setLastname("last_name");
        em.merge(detailedUser);
    }

}