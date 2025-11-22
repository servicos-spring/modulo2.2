## domain

Guarda as regras principais do sistema, como entidades e interfaces de repositório.

## domain/entity

Modelos que representam os dados do usuário e do token.

## domain/repository

Interface que define como os dados devem ser acessados, sem depender de tecnologia.

## springframework

Parte prática do sistema, onde tudo é implementado usando Spring.

## springframework/configuration

Configurações do Spring, como segurança.

## springframework/controller

As rotas HTTP da aplicação e o que elas recebem e devolvem.

## springframework/controller/adapter

Ponte entre o controller e as regras do domínio.

## springframework/controller/request

Objetos usados para receber dados do cliente.

## springframework/controller/response

Objetos usados para enviar respostas ao cliente.

## springframework/repository

Implementa de verdade o acesso ao banco usando Spring.

## springframework/repository/adapter

Implementações que convertem o repositório do domínio para o Spring.

## springframework/repository/client

Classes específicas para integração com o Mongo (ou outro banco).

## springframework/repository/orm

Mapeamento e implementação dos dados no banco.

## springframework/security

Toda parte de autenticação e JWT.

## springframework/security/dto

Objetos usados pela segurança, como detalhes do usuário e token.