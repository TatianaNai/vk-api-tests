# VK API tests

Реализован фреймворк для проверки VK API метода messages.createChat https://dev.vk.com/method/messages.createChat.  
Для вызова метода используется ключ доступа сообщества.  
Тесты написаны с помощью фреймворка TestNG, библиотеки VK Java SDK. Для логирования использован Slf4j.  

Реализованы следующие тесты:  
- Создание чата с валидными данными 
- Создание чата без параметра title
- Создание чата с пустым параметром title
- Создание чата с невалидным access token

## Предусловия

1. Создать два тестовых сообщества ВКонтакте  
2. id сообщества указан в URL сообщества  
3. Сформировать access_token в сообществе, в разделе: Управление - Дополнительно - Работа с API - Ключи доступа  

## Запуск проекта

Клонировать репозиторий

```bash
  git clone https://github.com/TatianaNai/vk-api-tests.git
```

Запустить тесты

```bash
  mvn clean test -DgroupId1=… -DaccessToken1=… -DgroupId2=… -DaccessToken2=…
```

Запустить тесты определенной группы

```bash
  mvn clean test -DgroupId1=… -DaccessToken1=… -DgroupId2=… -DaccessToken2=… -Dgroups=…
```
