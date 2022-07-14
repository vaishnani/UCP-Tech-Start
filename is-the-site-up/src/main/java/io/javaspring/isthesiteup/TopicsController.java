package io.javaspring.isthesiteup;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicsController {

    @Autowired
    private TopicServices topicServices;

    @RequestMapping("/topics")
    public List<Topics> getAllTopics(){
        return topicServices.getAllTopics();
    }

    @RequestMapping("topics/{id}")
    public Topics getTopic(@PathVariable String id){
        return topicServices.getTopic(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics")
    public void addTopic(@RequestBody Topics topic){
        System.out.println("Correct Call");
        topicServices.addTopic(topic);
    }

}
