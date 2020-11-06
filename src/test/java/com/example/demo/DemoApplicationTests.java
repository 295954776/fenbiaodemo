package com.example.demo;

import com.dangdang.ddframe.rdb.sharding.id.generator.IdGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private IdGenerator idGenerator;

    @Test
    public void generateId(){
    }

}
