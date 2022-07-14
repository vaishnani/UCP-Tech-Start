package io.javaspring.isthesiteup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicServices {

    List<Topics> topics = new ArrayList<>( Arrays.asList(
        new Topics("1","2","3"),
        new Topics("4","5","6"))
    );

    public List<Topics> getAllTopics(){
        return topics;
    }    

    public Topics getTopic(String id){
        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topics topic){
        System.out.println("Correct call to services");
        topics.add(topic);
    }
}
