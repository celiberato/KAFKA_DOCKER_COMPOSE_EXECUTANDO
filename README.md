sudo lsof -i tcp:9081

https://www.fosstechnix.com/install-apache-kafka-and-zookeeper-ubuntu-24/

sudo wget https://downloads.apache.org/kafka/4.0.0/kafka_2.13-4.0.0.tgz

sudo tar xzf kafka_2.13-4.0.0.tgz

sudo mv kafka_2.13-4.0.0.tgz /opt/kafka

]sudo bin/kafka-consumer-groups.sh --bootstrap-server localhost:9092 --group test-consumidor --describe


sudo nano /etc/systemd/system/zookeeper.service






kafka-console-consumer.sh \
  --bootstrap-server kafka:9092 \
  --topic meu-topico \
  --group test-consumidor
