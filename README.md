
https://www.fosstechnix.com/install-apache-kafka-and-zookeeper-ubuntu-24/

sudo wget https://downloads.apache.org/kafka/3.7.0/kafka_2.12-3.7.0.tgz

sudo tar xzf kafka_2.12-3.7.0.tgz

sudo mv kafka_2.12-3.7.0 /opt/kafka

sudo nano /etc/systemd/system/zookeeper.service






kafka-console-consumer.sh \
  --bootstrap-server kafka:9092 \
  --topic meu-topico \
  --group test-consumidor
