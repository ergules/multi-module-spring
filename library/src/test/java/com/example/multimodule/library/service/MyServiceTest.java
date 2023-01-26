package com.example.multimodule.library.service;

import com.example.multimodule.library.entity.CustomMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class MyServiceTest {

    @Autowired
    private MyService myService;

    @Autowired
    EntityManager em;

    @Test
    void contextLoads() {
    }

    @Test
    void whenCustomMessageUpdatedReturnNew() {
        String newMessage = "new-message" + Instant.now().getEpochSecond();
        myService.saveCustom(newMessage);

        CustomMessage msg = em.find(CustomMessage.class, 1L);
        assertThat(msg.getMessage()).isEqualTo(newMessage);
    }

    @Test
    void dataScriptLoaded() {
        long count = (long) em.createQuery("select count(c) from CustomMessage c")
                .getSingleResult();
        assertThat(count).isEqualTo(2);
    }

}
