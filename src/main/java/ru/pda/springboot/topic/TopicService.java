package ru.pda.springboot.topic;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    private final List<Topic> topics = Arrays.asList(
          new Topic(111L, "111 topic", "111 topic description")
        , new Topic(333L, "333 topic", "333 topic description")
        , new Topic(666L, "666 topic", "666 topic description")
    );

    public List<Topic> getAllTopics() {
        return topics;
    }
}