https://phoenixnap.com/kb/install-apache-zookeeper

sudo useradd zookeeper -m

sudo usermod --shell /bin/bash zookeeper

sudo passwd zookeeper

sudo usermod -aG sudo zookeeper

sudo getent group sudo

sudo mkdir -p /data/zookeeper

sudo chown -R zookeeper:zookeeper /data/zookeeper

sudo wget https://dlcdn.apache.org/zookeeper/zookeeper-3.8.4/apache-zookeeper-3.8.4-bin.tar.gz

sudo tar -xvf apache-zookeeper-3.8.4-bin.tar.gz

sudo mv apache-zookeeper-3.8.4-bin zookeeper

sudo chown -R zookeeper:zookeeper /opt/zookeeper

sudo mkdir -p /var/lib/kafka/

sudo chown kafka:kafka /var/lib/kafka/
---------------
sudo vim /opt/zookeeper/conf/zoo.cfg

tickTime = 2000

dataDir = /data/zookeeper

clientPort = 2181

initLimit = 5

syncLimit = 2
-------

cd /opt/zookeeper  

sudo bin/zkServer.sh start

bin/zkCli.sh -server 127.0.0.1:2181

bin/zkServer.sh stop

 sudo chmod 777  logs

/etc/systemd/system/Kafka.service

=======================
[Unit]
Description=Apache Kafka Server
Requires=zookeeper.service
After=zookeeper.service

[Service]
Type=simple
User=kafka
ExecStart=/opt/kafka/bin/kafka-server-start.sh /opt/kafka/config/server.properties
ExecStop=/opt/kafka/bin/kafka-server-stop.sh
Restart=on-failure

[Install]
WantedBy=multi-user.target
===========================================





----------
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
