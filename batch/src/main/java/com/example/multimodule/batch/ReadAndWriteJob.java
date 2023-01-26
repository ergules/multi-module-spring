package com.example.multimodule.batch;

import com.example.multimodule.library.entity.DetailedUser;
import com.example.multimodule.library.entity.SimpleUser;
import com.example.multimodule.library.repository.DetailedUserRepository;
import com.example.multimodule.library.repository.SimpleUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;

import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class ReadAndWriteJob {

    final DetailedUserRepository detailedUserRepository;
    final SimpleUserRepository simpleUserRepository;
    final JobBuilderFactory jobBuilderFactory;
    final StepBuilderFactory stepBuilderFactory;

    @Bean
    public ItemReader<DetailedUser> detailedUserReader() {
        RepositoryItemReader<DetailedUser> itemReader = new RepositoryItemReader<>();
        itemReader.setRepository(detailedUserRepository);
        itemReader.setMethodName("findAll");
        itemReader.setSort(Map.of("id", Sort.Direction.ASC));
        return itemReader;
    }

    @Bean
    public ItemProcessor<DetailedUser, SimpleUser> userTransformer() {
        return detailedUser -> {
            SimpleUser simpleUser = new SimpleUser();
            simpleUser.setName(detailedUser.getFirstname() + " " + detailedUser.getLastname());
            return simpleUser;
        };
    }

    @Bean
    public ItemWriter<SimpleUser> simpleUserWriter() {
        RepositoryItemWriter<SimpleUser> itemWriter = new RepositoryItemWriter<>();
        itemWriter.setRepository(simpleUserRepository);
        itemWriter.setMethodName("save");
        return itemWriter;
    }


    @Bean
    public Step detailedUserTransformAmdPersistStep() {
        return stepBuilderFactory.get("userTransformAndPersist")
                .<DetailedUser, SimpleUser>chunk(1)
                .reader(detailedUserReader())
                .processor(userTransformer())
                .writer(simpleUserWriter())
                .build();
    }

    @Bean
    public Job detailedUserTransformJob() {
        return jobBuilderFactory.get("detailedUserTransformJob")
                .start(detailedUserTransformAmdPersistStep())
                .build();
    }

}
