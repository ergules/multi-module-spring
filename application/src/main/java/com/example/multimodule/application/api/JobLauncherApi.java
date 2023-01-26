package com.example.multimodule.application.api;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jobs")
@RequiredArgsConstructor
public class JobLauncherApi {

    private final Job simpleUserPrintingJob;
    private final Job detailedUserTransformJob;
    private final JobLauncher jobLauncher;

    @PostMapping("/print")
    @SneakyThrows
    public void triggerPrintJob() {
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("triggered", System.currentTimeMillis()).toJobParameters();
        jobLauncher.run(simpleUserPrintingJob, jobParameters);
    }

    @PostMapping("/transform")
    @SneakyThrows
    public void triggerTransformJob() {
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("triggered", System.currentTimeMillis()).toJobParameters();
        jobLauncher.run(detailedUserTransformJob, jobParameters);
    }

}
