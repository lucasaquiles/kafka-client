package producer;

import config.Config;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.stream.IntStream;

public class Producer {

    private static final String TOPIC_NAME = "learning-kafka-topic";
    private static final int PARTITION = 0;
    private static final String KEY = "message 1";

    public static void main(String[] args) {

        Properties properties = Config.getProperties();

        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);

        IntStream.range(1,50).forEach(it-> {

            final String message = "Message Value: " + Integer.toString(it);

            // An option here is use the robin approach avoid pass partion and key values and makes kafka uses the best way to partitions
            producer.send(new ProducerRecord<String, String>(TOPIC_NAME, PARTITION , KEY, message));
        });

        producer.close();
    }

}
