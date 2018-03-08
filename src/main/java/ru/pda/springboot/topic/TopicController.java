package ru.pda.springboot.topic;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unused")
@RestController
public class TopicController {

    @RequestMapping("/topics")
    public List<Topic> getAllTopics() {
        return Arrays.asList(
              new Topic(111L, "111 topic", "111 topic description")
            , new Topic(333L, "333 topic", "333 topic description")
            , new Topic(666L, "666 topic", "666 topic description")
        );
    }
}