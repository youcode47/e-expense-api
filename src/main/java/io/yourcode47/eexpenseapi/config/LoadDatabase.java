package io.yourcode47.eexpenseapi.config;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import io.yourcode47.eexpenseapi.model.Category;
import io.yourcode47.eexpenseapi.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class LoadDatabase {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(CategoryService categoryService) {
        return args -> {
            List<Category> categories = generateRandomCategories();
            LOGGER.info("***************BEGIN CATEGORY CREATION***************");
            categories.forEach(categoryService::save);
            LOGGER.info("***************END CATEGORY CREATION***************");
        };
    }

    private List<Category> generateRandomCategories() {
        List<Category> categories = new ArrayList<>();
        Faker faker = null;
        Name name = null;

        for (int i = 0; i < 100; i++) {
            faker = Faker.instance();
            name = faker.name();

            Category category = Category.builder()
                    .name(name.name())
                    .build();
            categories.add(category);
        }
        return categories;
    }
}
