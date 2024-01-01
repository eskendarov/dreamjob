package ru.job4j.dreamjob.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.job4j.dreamjob.configuration.DatasourceConfiguration;
import ru.job4j.dreamjob.model.User;

import java.util.Optional;
import java.util.Properties;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Sql2oUserRepositoryTest {

    private static Sql2oUserRepository sql2oUserRepository;

    @BeforeAll
    public static void initRepositories() throws Exception {
        var properties = new Properties();
        try (var inputStream = Sql2oVacancyRepositoryTest.class
                .getClassLoader().getResourceAsStream("connection.properties")
        ) {
            properties.load(inputStream);
        }
        var url = properties.getProperty("datasource.url");
        var username = properties.getProperty("datasource.username");
        var password = properties.getProperty("datasource.password");

        var configuration = new DatasourceConfiguration();
        var datasource = configuration.connectionPool(url, username, password);
        var sql2o = configuration.databaseClient(datasource);

        sql2oUserRepository = new Sql2oUserRepository(sql2o);
    }

    @AfterEach
    public void cleanup() {
        sql2oUserRepository.findAll().forEach(user -> sql2oUserRepository.deleteByEmail(user.getEmail()));
    }

    @Test
    public void whenSaveThenGetSame() {
        var user = new User("Enver", "envereskendarov@gmail.com", "password1234");
        var saved = sql2oUserRepository.save(user).orElseThrow();
        assertThat(user).isEqualTo(saved);
    }


    @Test
    public void whenSaveUserWithDuplicateEmailThenFail() {
        User user1 = new User(0, "Enver", "envereskendarov@gmail.com", "password123");
        User user2 = new User(0, "Eva", "envereskendarov@gmail.com", "password456");
        sql2oUserRepository.save(user1);
        Optional<User> duplicateUser = sql2oUserRepository.save(user2);
        assertThat(duplicateUser).isEmpty();
    }

    @Test
    public void whenFindNonExistentUserThenEmptyOptional() {
        Optional<User> nonExistentUser = sql2oUserRepository.findByEmailAndPassword(
                "nonexistent@example.com", "password"
        );
        assertThat(nonExistentUser).isEmpty();
    }

    @Test
    public void whenDeleteUserThenUserShouldBeDeleted() {
        User user = new User("Enver", "envereskendarov@gmail.com", "password123");
        User savedUser = sql2oUserRepository.save(user).orElseThrow();
        boolean deleted = sql2oUserRepository.deleteByEmail(savedUser.getEmail());
        assertThat(deleted).isTrue();
        var founded = sql2oUserRepository.findByEmailAndPassword(savedUser.getEmail(), user.getPassword());
        assertThat(founded).isEmpty();
    }
}
