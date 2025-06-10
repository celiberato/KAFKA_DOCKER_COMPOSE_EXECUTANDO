#!/bin/bash

BROKER="your-eventhub-namespace.servicebus.windows.net:9093"
TOPIC="meu-topico"
USERNAME="your-eventhub-username"
PASSWORD="your-eventhub-key"

echo "Producing messages to Kafka topic: $TOPIC"

for i in {1..10}; do
  echo "Mensagem $i" | kcat -P -b $BROKER -t $TOPIC -X security.protocol=SASL_SSL -X sasl.mechanism=PLAIN -X sasl.username=$USERNAME -X sasl.password=$PASSWORD
done

echo "Messages sent successfully!"