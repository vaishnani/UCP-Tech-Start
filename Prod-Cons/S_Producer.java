import java.util.Properties;
import java.util.Scanner;
import javax.swing.plaf.synth.SynthSpinnerUI;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

//Create java class named “SimpleProducer”
public class S_Producer{
   
   public static void main(String[] args) throws Exception{
      
      // Check arguments length value
      if(args.length == 0){
         System.out.println("Enter topic name");
         return;
      }
      
      //Assign topicName to string variable
      String topicName = args[0].toString();
      
      // create instance for properties to access producer configs   
      Properties props = new Properties();
      
      //Assign localhost id
      props.put("bootstrap.servers", "localhost:9092");
      
      //Set acknowledgements for producer requests.      
      props.put("acks", "all");
      
      //If the request fails, the producer can automatically retry,
      props.put("retries", 0);
      
      //Specify buffer size in config
      props.put("batch.size", 16384);
      
      //Reduce the no of requests less than 0   
      props.put("linger.ms", 1);
      
      //The buffer.memory controls the total amount of memory available to the producer for buffering.   
      props.put("buffer.memory", 33554432);
      
      props.put("key.serializer", 
         "org.apache.kafka.common.serialization.StringSerializer");
         
      props.put("value.serializer", 
         "org.apache.kafka.common.serialization.StringSerializer");
      
      Producer<String, String> producer = new KafkaProducer
         <String, String>(props);
      
      //Initiate the Java Scanner class
      Scanner in = new Scanner(System.in);
      while (1==1)
      {
         System.out.println("Please enter your message: (For exit write \"exit\")");
         String sent_msg = in.nextLine();
         if(sent_msg.matches("exit")){
            break;
         }
         producer.send(new ProducerRecord<String, String>(topicName, 
         null, sent_msg));
      }
   }
}