package com.kbussche;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Reader
{
    public KafkaConsumer<String, String> consumer;

    public void init()
    {
        Properties p = this.getProps();
    	this.consumer = new KafkaConsumer<>(p);
    }

    public void list()
    {
	
	ConsumerRecords<String, String> records = consumer.poll(5);
	System.out.println("yep");
	for (ConsumerRecord<String, String> record : records) {
	  Map<String, Object> data = new HashMap<>();
          data.put("partition", record.partition());
          data.put("offset", record.offset());
          data.put("value", record.value());
          System.out.println( ": " + data);
	}
    }


    private Properties getProps()
    {
        // Todo: setup the maven props plugin and move to config
        Properties p = new Properties();
        p.setProperty("bootstrap.servers", "127.0.0.1:9092");
        //p.setProperty("acks", "all");
	//p.setProperty("group_id", "group_id");
        //p.setProperty("retries", "0");
        //p.setProperty("batch.size", "16384");
        //p.setProperty("auto.commit.interval.ms", "1000");
        //p.setProperty("longer.ms", "0");
        //p.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
	p.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	p.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        //p.setProperty("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        //p.setProperty("block.on.buffer.full", "true");
        return p;
    }

}
