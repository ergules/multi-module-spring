package com.example.multimodule.batch;

import com.example.multimodule.library.entity.SimpleUser;
import com.example.multimodule.library.repository.SimpleUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;

import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class ReadAndPrintJob {

    final SimpleUserRepository simpleUserRepository;
    final JobBuilderFactory jobBuilderFactory;
    final StepBuilderFactory stepBuilderFactory;

    @Bean
    public ItemReader<SimpleUser> simpleUserReader() {
        RepositoryItemReader<SimpleUser> itemReader = new RepositoryItemReader<>();
        itemReader.setRepository(simpleUserRepository);
        itemReader.setMethodName("findAll");
        itemReader.setSort(Map.of("id", Sort.Direction.ASC));
        return itemReader;
    }

    @Bean
    public ItemWriter<SimpleUser> simpleUserPrinter() {
        return list -> {
            System.out.printf("printing %d records%n", list.size());
            list.forEach(System.out::println);
        };
    }


    @Bean
    public Step simpleUserPrintScrStep() {
        return stepBuilderFactory.get("simpleUserPrint")
                .<SimpleUser, SimpleUser>chunk(10)
                .reader(simpleUserReader())
                .writer(simpleUserPrinter())
                .build();
    }

    @Bean
    public Job simpleUserPrintingJob() {
        return jobBuilderFactory.get("simpleUserPrintingJob")
                .start(simpleUserPrintScrStep())
                .build();
    }

}
