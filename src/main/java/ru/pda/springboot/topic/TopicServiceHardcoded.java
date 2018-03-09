package ru.pda.springboot.topic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@SuppressWarnings("unused")
public class TopicServiceHardcoded { // old hard-coded version before moving to JPA database repository

    private final List<Topic> topics = new ArrayList<>( Arrays.asList( // make the list modifiable
          new Topic(111L, "111 topic", "111 topic description")
        , new Topic(333L, "333 topic", "333 topic description")
        , new Topic(666L, "666 topic", "666 topic description")
    ) );

    public List<Topic> getAllTopics() {
        return topics;
    }

    public Topic getTopic(final Long id) {
        final Optional<Topic> topicOptional = topics.stream().filter(t -> t.getId().equals(id)).findFirst();
        return topicOptional.orElse(null); // Optional#get will throw an exception if no value is present
    }

    public void addTopic(final Topic topic) {
        // todo: topic ids may clash
        topics.add(topic);
    }

    public void updateTopic(final Long id, final Topic topic) {
        final Topic existingTopic = getTopic(id);
        if (existingTopic == null) {
            System.out.println( String.format("Topic with id = %d is not found. Nothing to update.", id) );// todo: use logger instead
            return;
        }

        // id is not updated, update only name and description
        existingTopic.setName( topic.getName() );
        existingTopic.setDescription( topic.getDescription() );
    }

    public void deleteTopic(final Long id) {
        topics.removeIf( t -> t.getId().equals(id) );
    }
}