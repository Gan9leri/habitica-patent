<h1>Проект автоматизации тестирования <a target="_blank" href="https://habitica.com/"> Habitica.com </a> </h1>

<p align="center">
<a href="https://habitica.com/"><img src="images/logo/habitica_logo.png"  >
</p>

## Содержание
+ [Описание](#Описание)
+ [Технологии и инструменты](#Технологии-и-инструменты)
+ [Реализованные проверки](#Реализованные-проверки)
+ [Запуск тестов](#Запуск-тестов)
    + [Допустимые комбинации](#Допустимые-комбинации)
    + [Локальный запуск тестов](#Локальный-запуск-тестов)
    + [Удаленный запуск тестов](#Удаленный-запуск-тестов)
+ [Cборка тестов в Jenkins](#Cборка-тестов-в-Jenkins)
+ [Интеграция с Allure Report](#интеграция-с-allure-report)
    + [Диаграммы прохождения тестов](#Диаграммы-прохождения-тестов)
    + [Развернутый результат прохождения тестов](#Развернутый-результат-прохождения-тестов)
+ [Интеграция с Allure TestOps](#Интеграция-с-Allure-TestOps)
+ [Интеграция с Jira](#Интеграция-с-Jira)
+ [Уведомления в Telegram с использованием бота](#Уведомления-в-Telegram-с-использованием-бота)
+ [Пример выполнения теста в Selenoid](#Пример-выполнения-теста-в-Selenoid)

## Технологии и инструменты

<div align="center">
<a href="https://www.jetbrains.com/idea/"><img alt="InteliJ IDEA" height="50" src="images/logo/Idea.svg" width="50"/></a>
<a href="https://github.com/"><img alt="GitHub" height="50" src="images/logo/GitHub.svg" width="50"/></a>  
<a href="https://www.java.com/"><img alt="Java" height="50" src="images/logo/Java.svg" width="50"/></a>
<a href="https://gradle.org/"><img alt="Gradle" height="50" src="images/logo/Gradle.svg" width="50"/></a>  
<a href="https://junit.org/junit5/"><img alt="JUnit 5" height="50" src="images/logo/Junit5.svg" width="50"/></a>
<a href="https://selenide.org/"><img alt="Selenide" height="50" src="images/logo/Selenide.svg" width="50"/></a>
<a href="https://aerokube.com/selenoid/"><img alt="Selenoid" height="50" src="images/logo/Selenoid.svg" width="50"/></a>
<a href="https://rest-assured.io/"><img alt="RestAssured" height="50" src="images/logo/RestAssured.svg" width="50"/></a>
<a href="https://www.browserstack.com/"><img alt="Browserstack" height="50" src="images/logo/Browserstack.svg" width="50"/></a>
<a href="https://appium.io/"><img alt="Appium" height="50" src="images/logo/Appium.svg" width="50"/></a>
<a href="https://developer.android.com/studio"><img alt="Android Studio" height="50" src="images/logo/Android_Studio.svg" width="50"/></a>
<a href="https://www.jenkins.io/"><img alt="Jenkins" height="50" src="images/logo/Jenkins.svg" width="50"/></a>
<a href="https://github.com/allure-framework/"><img alt="Allure Report" height="50" src="images/logo/Allure.svg" width="50"/></a>
<a href="https://qameta.io/"><img alt="Allure TestOps" height="50" src="images/logo/Allure_TO.svg" width="50"/></a>
<a href="https://www.atlassian.com/software/jira"><img alt="Jira" height="50" src="images/logo/Jira.svg" width="50"/></a>  
<a href="https://telegram.org/"><img alt="Telegram" height="50" src="images/logo/Telegram.svg" width="50"/></a>
</div>  

## Описание
Habitica — трекер задач, который совместил философию RPG и GTD (доведение дел до завершения) в своей веб-версии и приложениях для Android и iOS.
Проект состоит из UI-тестов, API и мобильных тестов на Android. <br/>

- [x] `IntelliJ IDEA` - IDE, используемая для разработки проекта
- [x] `Java` - язык программирования, на котором реализован проект
- [x] `Gradle` - система сборки проекта
- [x] `Junit5` - фреймворк, с помощью которого реализованы тесты
- [x] `Selenide` - фреймворк, с помощью которого реализованы UI-тесты
- [x] `REST-assured` - фреймворк, с помощью которого реализованы API-тесты
- [x] `Appium` - фреймворк, с помощью которого реализованы тесты для мобильного приложения
- [x] `Selenoid` - инструмент для удаленного запуска браузера в Docker контейнерах
- [x] `Browserstack` - удаленная ферма, на устройствах которой испытывались тесты для мобильного приложения
- [x] `Android Studio` - инструмент, с помощью которого запускался эмулятор мобильного устройства с мобильным приложением
- [x] `Jenkins` - CI/CD для удаленного запуска тестов
- [x] `Allure Report` - инструмент для логирования и анализа результатов работы тестов
- [x] `Allure TestOps` - инструмент для логирования и анализа результатов работы тестов
- [x] `Telegram` - инструмент для логирования и анализов результатов работы тестов
- [x] `Jira` - система багтрекинга для хранения тест кейсов

**Краткий список интересных фактов о проекте**:
- `PageObject` шаблон проектирования
- Использование техноголии `Owner` для придания тестам гибкости и легкости конфигурации
- Возможность запуска тестов: локально, удалённо, по тегам
- Использование `Faker` для генерации данных
- Использование `Lombok` для моделей в API тестах
- Использование собственных расширений:
    - `@WithLogin` для предварительной авторизации
- Возможность запуска тестов напрямую из Allure TestOps
- Интеграция с Jira
- Уведомление о результатах прохождения в Telegram
- По итогу прохождения автотестов генерируется Allure отчет. Содержание отчета:
    - Шаги теста
    - Скриншот страницы на последнем шаге
    - Исходный код страницы в браузере
    - Логи консоли браузера
    - Видео выполнения автотеста

  
## Реализованные проверки
### Web
- [x] UI: Проверка владельца испытания
- [x] UI: Проверка логотипа
- [x] UI: Навигация по разделам главной страницы
- [x] UI: Проверка отправки сообщения в чат команды
- [x] UI: Проверка работы кнопки Щит
- [x] UI: Проверка лидера команды
- [x] UI: Проверка возможности создания задачи

### Api
- [x] API: Позитивный тест на авторизацию
- [x] API: Негативный тест на авторизацию
- [x] API: Тест на получение списка тэгов
- [x] API: Тест на удаление задачи
- [x] API: Тест на добавление задачи через Api

### Mobile
- [x] Mobile: Проверка возможности пропустить Intro
- [x] Mobile: Проверка экрана авторизации
- [x] Mobile: Проверка экрана регистрации

## Запуск тестов

### Допустимые комбинации

```mermaid 
flowchart LR
    A(gradle) --> B(clean)
    B --> C{Выбрать тег}
    C --> D[test]
    C --> E[web]
    C --> F[api]
    C --> G[mobile]
    E --> H[-Dhost=local]
    E --> I[-Dhost=selenoid]
    G --> J[-DdeviceHost=browserstack]
    G --> K[-DdeviceHost=emulation]
    G --> L[-DdeviceHost=real]
```

### Локальный запуск тестов
#### Запуск всех тестов

Для запуска следует открыть IntelliJ IDEA и выполнить в терминале:
```
gradle clean test -Dhost=local
```

#### WEB

```
gradle clean web -Dhost=local
```

#### API
```
gradle clean api -Dhost=local
```

#### Mobile
Для запуска тестов на реальном устройстве:
```
gradle clean mobile -DdeviceHost=real
```
Для запуска тестов на эмуляторе
```
gradle clean mobile -DdeviceHost=emulation
```
Для запуска тестов на удаленной ферме:
```
gradle clean mobile -DdeviceHost=browserstack
```

<details>
   <summary>Дополнительные команды:</summary>
  
1. Выполнить запрос на формирование отчета:
```
gradle allureReport
```
2. Открыть отчет в браузере:
```
gradle allureServe
```

</details>

### Удаленный запуск тестов
Тесты можно запустить из терминала IntelliJ IDEA, а выполнены они будут в удаленно запущенном браузере в Docker-контейнере Selenoid:

```
gradle clean test -Dhost=selenoid
```

Параметры, которыми можно управлять:
```
-DbrowserName - наименование браузера. По умолчанию chrome
-DbrowserSize - размер окна браузера. По умолчанию 1920x1080
-DbrowserVersion - номер версии браузера. По умолчанию 100.0
```

## Cборка тестов в <b><a target="_blank" href="https://jenkins.autotests.cloud/job/27-Ga9nrad-HabiticaPatent/">Jenkins</a></b>

>Для запуска сборки необходимо перейти в раздел `Build with Parameters` и нажать кнопку `Build`.
>Сборка с параметрами позволяет перед запуском задать нужные параметры для сборки:
 
<img src="images/screenshots/buildWithParametres.PNG">

## Интеграция с <b><a target="_blank" href="https://jenkins.autotests.cloud/job/27-Ga9nrad-HabiticaPatent/allure/">Allure report</a></b>
#### Диаграммы прохождения тестов
`ALLURE REPORT` - отображает дату и время теста, общее количество запущенных тестов, а также диаграмму с процентом и количеством успешных и провалившихся тестов <br/>
`TREND` - отображает тенденцию выполнения тестов<br/>
`SUITES` - отображает распределение тестов по сьютам <br/>
`CATEGORIES` - отображает распределение неудачных тестов по типам дефектов

<img src="images/screenshots/AllureReport.PNG">

#### Развернутый результат прохождения тестов:

<img src="images/screenshots/Result.PNG">


## Интеграция с <b><a target="_blank" href="https://allure.autotests.cloud/project/4349">Allure TestOps</a></b>

>Диаграммы прохождения тестов
>
<img src="images/screenshots/TestOpsDashbord.PNG">

>Тест кейсы:
> 
<img src="images/screenshots/TestOpsTests.PNG"> 

## Интеграция с <b><a target="_blank" href="https://jira.autotests.cloud/browse/HOMEWORK-1305">Jira</a></b>

>В Jira создана задача
>
<img src="images/screenshots/task.PNG">

>В разделе `Allure:Test Cases` отображаются тесты
> 
<img src="images/screenshots/JiraTests.PNG">

## Уведомления в Telegram с использованием бота

> Бот, созданный в Telegram, после завершения сборки отправляет сообщение с отчетом о прохождении тестов
> 
<img src="images/screenshots/bot.PNG">

## Пример выполнения теста в Selenoid

> К каждому UI-тесту в отчете прилагается видео
<p align="center">
  <img src="images/video/web.gif">
</p>

> К каждому мобильному тесту, выполняемому в Browserstack, к отчету прилагается видео
<p align="center">
  <img src="images/video/mobile.gif">
</p>
