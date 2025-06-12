
sudo docker build -t app-v1:latest .

sudo docker run app-v1:latest

http://learn.conduktor.io/kafka/how-to-install-apache-kafka-on-linux/

 sudo chmod 777 /data/zookeeper/zookeeper_server.pid

 cat logs/server.log

 
journalctl -u zookeeper.service --no-pager | tail -50

sudo chown -R zookeeper:zookeeper /var/lib/zookeeper
sudo systemctl restart zookeeper****
 
=====================
sudo nano /etc/systemd/system/kafka.service
[Unit]
Requires=zookeeper.service
After=zookeeper.service

[Service]
Type=simple
User=kafka
ExecStart=/bin/sh -c '/opt/kafka/bin/kafka-server-start.sh /opt/kafka/config/server.properties > /opt/kafka/kafka.log 2>&1'
ExecStop=/opt/kafka/bin/kafka-server-stop.sh
Restart=on-abnormal

[Install]
WantedBy=multi-user.target
===============================

sudo nano /etc/systemd/system/zookeeper.service
[Unit]
Description=Apache Zookeeper Server
After=network.target

[Service]
Type=simple
User=kafka
ExecStart=/opt/kafka/bin/zookeeper-server-start.sh /opt/kafka/config/zookeeper.properties
ExecStop=/opt/kafka/bin/zookeeper-server-stop.sh
Restart=on-abnormal

[Install]
WantedBy=multi-user.target
===============================

sudo systemctl daemon-reload
sudo systemctl enable kafka
sudo systemctl start kafka

----------
https://gist.github.com/vipmax/9ceeaa02932ba276fa810c923dbcbd4f

sudo adduser kafka

sudo adduser kafka sudo

su -l kafka

cd /opt                                                              # go to /opt folder

curl  https://dlcdn.apache.org/kafka/3.2.0/kafka_2.13-3.2.0.tgz -O   # download archive to folder

tar -zxvf kafka*.tgz                                                 # extract archive 

rm kafka*.tgz                                                        # remove archive 

ln -s kafka_2.13-3.2.0/ kafka                                        # create symbolic link  



# just creates a file with the following content  -----------

cat <<EOF > /etc/systemd/system/kafka-zookeeper.service            


[Unit]
Description=Apache Zookeeper server (Kafka)
Documentation=http://zookeeper.apache.org
Requires=network.target remote-fs.target
After=network.target remote-fs.target

[Service]
Type=simple
User={{USER || kafka}}
Environment=JAVA_HOME={{must be JAVA_HOME here || /usr/lib/jvm/java-1.8.0-openjdk}}
ExecStart=/opt/kafka/bin/zookeeper-server-start.sh /opt/kafka/config/zookeeper.properties
ExecStop=/opt/kafka/bin/zookeeper-server-stop.sh

[Install]
WantedBy=multi-user.target

EOF
---------------------

# just creates a file with the following content  

cat <<EOF > /etc/systemd/system/kafka.service

[Unit]
Description=Apache Kafka server (broker)
Documentation=http://kafka.apache.org/documentation.html
Requires=network.target remote-fs.target
After=network.target remote-fs.target kafka-zookeeper.service

[Service]
Type=simple
User={{USER || kafka}}
Environment=JAVA_HOME={{must be JAVA_HOME here || /usr/lib/jvm/java-1.8.0-openjdk}}
ExecStart=/opt/kafka/bin/kafka-server-start.sh /opt/kafka/config/server.properties
ExecStop=/opt/kafka/bin/kafka-server-stop.sh

[Install]
WantedBy=multi-user.target

EOF

-------------------

3 * Edit service files

nano /etc/systemd/system/kafka-zookeeper.service

nano /etc/systemd/system/kafka.service


4. Edit kafka settings

nano /opt/kafka/config/server.properties

listeners=PLAINTEXT://{{IP || 192.168.0.103}}:9092

5. Reload and start the systemd services

systemctl daemon-reload

systemctl enable kafka-zookeeper.service

systemctl enable kafka.service

systemctl start kafka-zookeeper.service

systemctl start kafka.service

systemctl status kafka-zookeeper.service

systemctl status kafka.service

6. Check services state

systemctl status kafka-zookeeper.service

systemctl status kafka.service








# Checkout do site DeliciasChef aqui!
[DeliciasChef!](https://gitlab.com/celiberato/deliciaschef)

# Como testar a API?

#### Endereço do servidor:
#ATENÇAO!! Para testar o servidor hospedado na nuvem, deve ser utilizado o seguinte endpoint, e importar o arquivo de testes do postman na ferramenta informado abaixo:
http://200.98.173.74:3024/pedidos/

#### Instale o software Postman:
https://www.postman.com/downloads/

#### Importe o arquivo exportado do postman, no seguinte link:
https://gitlab.com/celiberato/deliciaschef/-/blob/master/postman/deliciaschef.postman_collection.json

# Como executar teste untários:

#### Instale a última versão do eclipse spring tools suite 4
https://spring.io/tools

#### Clone o projeto para uma pasta do disco
https://gitlab.com/celiberato/deliciaschef

#### Execute os script de carregamento do postgres no docker
- Para windows:
    - https://gitlab.com/celiberato/deliciaschef/-/blob/master/subir_postgres_docker-dev.bat
    - https://gitlab.com/celiberato/deliciaschef/-/blob/master/subir_postgres_docker-local.bat

- Para linux:
    - https://gitlab.com/celiberato/deliciaschef/-/blob/master/subir_postgres_docker-dev.sh
    - https://gitlab.com/celiberato/deliciaschef/-/blob/master/subir_postgres_docker-local.sh

#### Execute o maven update do projeto

#### Execute o maven install na interface

#### Execute os testes unitários no eclipse


# Documentação do Software

DELÍCIAS CHEF
===================
Índice Analítico
----------------
* 1. [Introdução](#1-introdução)
    * 1.1 [Finalidade](#11-finalidade)
    * 1.2 [Escopo](#12-escopo)
    * 1.3 [Definições, Acrônimos e Abreviações](#13-definições-acrônimos-e-abreviações)
    * 1.4 [Referências](#14-referências)
    * 1.5 [Visão Geral](#15-visão-geral)
* 2. [Representação da Arquitetura](#2-representação-da-arquitetura)
* 3. [Metas e Restrições de Arquitetura](#3-metas-e-restrições-de-arquitetura)
* 4. [Visão de Casos de Uso](#4-visão-de-casos-de-uso)
    * 4.1 [Realizações de Casos de Uso](#41-realizações-de-casos-de-uso)
* 5. [Visão Lógica](#5-visão-lógica)
    * 5.1 [Visão Geral](#51-visão-geral)
    * 5.2 [Pacotes de Design Significativos do Ponto de Vista da Arquitetura](#52-pacotes-de-design-significativos-do-ponto-de-vista-da-arquitetura)
* 6. [Visão de Processos](#6-visão-de-processos)
* 7. [Visão de Implantação](#7-visão-de-implantação)
* 8. [Visão de Implementação](#8-visão-de-implementação)
    * 8.1 [Visão Geral](#81-visão-geral)
    * 8.2 [Camadas](#82-camadas)
* 9. [Visão de Dados (opcional)](#9-visão-de-dados-opcional)
* 10. [Tamanho e Desempenho](#10-tamanho-e-desempenho)
* 11. [Qualidade](#11-qualidade)

Documento de Arquitetura de Software
------------------------------------

## 1. Introdução

Desenvolver uma API REST para simular uma loja virtual. Esta loja deve ter um cadastro de seus clientes, produtos e pedidos. Fique à vontade para escolher como fará a arquitetura do sistema, bem como frameworks que utilizará.  

### 1.1 Finalidade

Este documento apresenta uma visão geral abrangente da arquitetura do sistema e utiliza uma série de visões arquiteturais diferentes para ilustrar os diversos aspectos do sistema. Sua intenção é capturar e transmitir as decisões significativas do ponto de vista da arquitetura que foram tomadas em relação ao sistema.

### 1.2 Escopo

Serão avaliados os seguintes pontos:  
- Qualidade do software
- Boas práticas de programação
- Testes unitários
- Controle de versão
- Documentação 

### 1.3 Definições, Acrônimos e Abreviações

DeliciasChef: 

Delícias Chef é uma API para a execução de um site de e-commerce de alimentos. Ela inclui APIs para a criação de:
- Categorias
- Clientes
- Endereços
- Municípios
- UF
- Fornecedores
- Funcionários
- Pedidos
- Ítens de Pedidos
- Produtos

### 1.4 Referências

### 1.5 Visão Geral

## 2. Representação da Arquitetura

## 3. Metas e Restrições de Arquitetura

- Uso da língua inglesa (código e documentação)
- Uso de Docker
- Publicação em alguma plataforma na nuvem (Heroku, AWS, Google Cloud, ...)
- Autenticação de usuários 

## 4. Visão de Casos de Uso

Os casos de uso do projeto são:

- Manter Categorias
- Manter Clientes
- Manter Endereços
- Manter Fornecedores
- Manter Funciinários
- Manter Pedidos
- Manter Produtos

### 4.1 Realizações de Casos de Uso

#### Cenário 1
Participantes: Marcela


- (1) Marcela entra no site
- (2) O sistema exibe uma lista de ofertas
- (2) O usuário pesquisa produtos
- (3) O sistema retorna lista de produtos de acordo com a descrição informada
- (4) O usuário verifica o detalhe do produto
- (5) O sistema retorna as seguintes informaçõe dos produtos:
    -  Preço
    -  Descrição
-  (6) O usuário adiciona ao carrinho de compras
-  (7) O usuário adiciona/diminui a quantidade
-  (8) O usuário finaliza a compra
-  (9) O usuáio informa o cupom de descontos
-  (10) O usuário efetua o pagamento

## 5. Visão Lógica

A visualização lógica do projeto é composta de 3 pacotes principais: API de Interface com o Usuário, Serviços de Negócios e Objetos de Negócios.

O Pacote de API de Interface com o Usuário disponibiliza o acesso a todas as APIs expostas pelo projeto.

O Pacote de Serviços de Negócios implementa as regras para o devido funcionamento do projeto.

O Pacote de Objetos de Negócios inclui classes de entidade para as seguntes entidades:

- Categorias
- Clientes
- Endereços
- Fornecedores
- Funciinários
- Pedidos
- Produtos


### 5.1 Visão Geral

- Camada de API: acessa somente a camada de serviço e modelo
- Camada de Serviços: acessa os repositórios, modelos e outros serviços da aplicação. Não acessa API.
- Camada de Modelo: acessa outros modelos. Não acessa APIs nen Serviços


### 5.2 Pacotes de Design Significativos do Ponto de Vista da Arquitetura

- Os pacotes principais do jogo são:
    - br.com.celiberato.deliciaschef:
        - boptstrap  
        - component
        - configuration
        - constants
        - controller
        - domain converter
        - domain document
        - domain Request
        - domain vo
        - domain
        - exception
        - exception handler
        - repositories
        - services
        - tests
        - utils

## 6. Visão de Processos

- Não se Aplica

## 7. Visão de Implantação

O projeto deve ser implantado na nuvem para testes, podendo ser em implentado em provedor de livre escolha. O projeto deve ser implantado como um microserviço.

## 8. Visão de Implementação

- Ferramentas de desenvolvimento: Eclipse (Spring Tools Suite 4), Postman, Lombok, Maven, Tomcat, LInux, Docker, Postgres

### 8.1 Visão Geral


### 8.2 Camadas

- API
- Serviços
- Modelo

## 9. Visão de Dados (opcional)

- Não se Aplica

## 10. Tamanho e Desempenho

- Não é requisito do projeto nenhum tipo de contingência, como balanceamento de carga.

## 11. Qualidade

É requisito dos projetos os seguintes pontos:

- Conhecimento técnico
- Estílo de código
- Conhecimentos de arquiteturas
- Padrões de programação
- Boas práticas
# interview-JAVA-back_EXECUTANDO
