package com.example.multimodule.batch;

import org.junit.jupiter.api.Test;
import org.springframework.batch.core.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BatchApplicationTests {

    @Autowired
    Job detailedUserTransformJob;
    @Autowired
    Job simpleUserPrintingJob;

    @Test
    void contextLoads() {
        assertNotNull(detailedUserTransformJob);
        assertNotNull(simpleUserPrintingJob);
    }

}
