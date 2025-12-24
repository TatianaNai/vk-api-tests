# VK API tests

Реализован фреймворк для проверки VK API метода messages.createChat. Для вызова метода используется ключ доступа сообщества.  
Тесты написаны с помощью фреймворка TestNG, библиотеки VK Java SDK.  

Реализованы следующие тесты:  
- Создание чата с валидными данными 
- Создание чата без параметра title
- Создание чата с пустым параметром title
- Создание чата с невалидным access token

## Запуск проекта

Клонировать репозиторий

```bash
  git clone https://github.com/TatianaNai/vk-api-tests.git
```

Запустить тесты

```bash
  mvn clean test -DgroupId1=… -DaccessToken1=… -DgroupId2=… -DaccessToken2=…
```

Запустить тесты в группе

```bash
  mvn clean test -DgroupId1=… -DaccessToken1=… -DgroupId2=… -DaccessToken2=… -Dgroups=…
```
