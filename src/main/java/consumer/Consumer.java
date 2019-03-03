package consumer;

import config.Config;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class Consumer {

    public static void main(String[] args) {

        Properties properties = new Properties();

        properties.put("bootstrap.servers", "localhost:9092,localhost:9093");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("group.id","test1");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);

        List<String> topics = Arrays.asList("learning-kafka-topic");

        consumer.subscribe(topics);

        ConsumerRecords<String, String> consumerRecords = consumer.poll(Duration.ofMillis(1000));

        try{

            while(true){

                for (ConsumerRecord<String, String> record: consumerRecords) {

                    System.out.println("message: "+ record.value());
                }
            }
        }catch (Exception e){

            System.out.println(e.getMessage());
        }finally {
            consumer.close();
        }

    }
}
