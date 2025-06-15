## SUBIR SERVIÇO ZOOKEEPER
 sudo /opt/zookeeper/bin/zkServer.sh start /opt/zookeeper/conf/zoo.cfg
[2025-06-15 17:01:30,405] INFO Awaiting socket connections on 0.0.0.0:9092. (kafka.network.DataPlaneAcceptor)

## SUBIR SERVIÇO KAFKA
sudo /home/kafka/bin/kafka-server-start.sh /home/kafka/config/server.properties
 
## ENVIAR MENSAGEM
sudo sh /home/kafka/bin/kafka-console-producer.sh --bootstrap-server localhost:9092 --topic my-topic

## RECEBER MENSAGEM
sudo sh kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic my-topic










sudo /opt/zookeeper/bin/zkServer.sh start /opt/zookeeper/conf/zoo.cfg 

https://www.digitalocean.com/community/tutorials/how-to-install-apache-kafka-on-ubuntu-20-04

https://phoenixnap.com/kb/install-apache-zookeeper
