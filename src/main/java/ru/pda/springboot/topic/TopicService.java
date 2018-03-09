package ru.pda.springboot.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getAllTopics() {
        final Iterable<Topic> topicsIterable = topicRepository.findAll();

        final List<Topic> topics = new ArrayList<>();
        topicsIterable.forEach( topics::add );

        return topics;
    }

    public Topic getTopic(final Long id) {
        final Optional<Topic> topicOptional = topicRepository.findById(id);
        return topicOptional.orElse(null); // Optional#get will throw an exception if no value is present
    }

    public void addTopic(final Topic topic) {
        // todo: topic ids may clash
        topicRepository.save(topic); // this will update an existing record if it exists by id
    }

    public void updateTopic(final Long id, final Topic topic) {
        topicRepository.save(topic); // this will save or update by id
    }

    public void deleteTopic(final Long id) {
        topicRepository.deleteById(id); // will throw an exception if entity with this id does not exist
    }
}