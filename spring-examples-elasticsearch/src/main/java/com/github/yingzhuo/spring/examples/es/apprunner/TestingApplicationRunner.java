package com.github.yingzhuo.spring.examples.es.apprunner;

import com.github.yingzhuo.spring.examples.es.domain.Gender;
import com.github.yingzhuo.spring.examples.es.domain.User;
import com.github.yingzhuo.spring.examples.es.repo.UserRepo;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class TestingApplicationRunner implements ApplicationRunner {

    private final UserRepo userRepo;

    @Autowired
    public TestingApplicationRunner(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        final String id = "yingzhuo1234567890";

        User user1 = new User();
        user1.setId(id);
        user1.setName("应卓");
        user1.setGender(Gender.MALE);

        userRepo.save(user1);

        Iterable<User> users = userRepo.search(QueryBuilders.queryStringQuery("应"));

        users.forEach(it -> {
            System.out.println(it.getId());
            System.out.println(it.getName());
            System.out.println(it.getGender());
        });
    }

}
