
## SEM ZOOKEEPER

wget https://downloads.apache.org/kafka/4.0.0/kafka_2.13-4.0.0.tgz
tar -xvzf kafka_2.13-4.0.0.tgz
cd kafka_2.13-4.0.0

---------------------------
cd /opt/zookeepe
sudo /opt/zookeeper/bin/zkServer.sh start  /opt/zookeeper/conf/zoo.cfg

cd /opt/kafka
sudo /opt/kafka/bin/kafka-server-start.sh  /opt/kafka/config/server.properties

-------------------------

## SUBIR SERVIÇO ZOOKEEPER
 sudo /opt/zookeeper/bin/zkServer.sh start /opt/zookeeper/conf/zoo.cfg
[2025-06-15 17:01:30,405] INFO Awaiting socket connections on 0.0.0.0:9092. (kafka.network.DataPlaneAcceptor)

## SUBIR SERVIÇO KAFKA
sudo /home/kafka/bin/kafka-server-start.sh /home/kafka/config/server.properties
 
## ENVIAR MENSAGEM
sudo sh /home/kafka/bin/kafka-console-producer.sh --bootstrap-server localhost:9092 --topic my-topic

## RECEBER MENSAGEM
sudo sh kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic my-topic

## BAXAR KAFKA
 sudo curl "https://downloads.apache.org/kafka/4.0.0/kafka_2.13-4.0.0.tgz" -o ~/Downloads/kafka.tgz

sudo tar -xvzf ~/Downloads/kafka.tgz

sudo curl "https://downloads.apache.org/zookeeper/zookeeper-3.9.3/apache-zookeeper-3.9.3.tar.gz" -o ~/Downloads/zookeeper.tar.gz

sudo tar -xvzf ~/Downloads/tar -xvf file.tar

tar -xvf zookeeper.tar

sudo mv apache-zookeeper-3.9.3/ zookeeper

nohup bin/zkServer.sh start &

export JAVA_HOME="path that you found"
 
export PATH=$JAVA_HOME/bin:$PATH





sudo /opt/zookeeper/bin/zkServer.sh start /opt/zookeeper/conf/zoo.cfg 

https://www.digitalocean.com/community/tutorials/how-to-install-apache-kafka-on-ubuntu-20-04

https://phoenixnap.com/kb/install-apache-zookeeper
