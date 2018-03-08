package ru.pda.springboot.topic;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

    public Topic getTopic(final Long id) {
        final Optional<Topic> topicOptional = topics.stream().filter(t -> t.getId().equals(id)).findFirst();
        return topicOptional.orElse(null); // Optional#get will throw an exception if no value is present
    }
}