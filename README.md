
## Java project using Kafka Client to send messages to a Kafka broker

  
  

start zookeeper

  

```

./zookeeper-server-start.sh ../config/zookeeper.properties

```

  

start kafka

  

```

./kafka-server-start.sh ../config/server.properties

```

  

creates a new topic named learning-kafka-topic

```

./kafka-topics.sh --create --topic learning-kafka-topic -zookeeper localhost:2181 --replication-factor 1 --partitions 1

```

  

show created topics

```

./kafka-topics.sh --describe --zookeeper localhost:2181

```

  
  
  

show the messages consumed

  

```

./kafka-console-consumer.sh --zookeeper localhost:2181 --topic learning-kafka-topic --from-beginning

```

  

should return some stuffs like that:

  

```

Message Value: 1

Message Value: 2

Message Value: 3

Message Value: 4

...

Message Value: 49

```