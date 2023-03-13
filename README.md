# Проект UI-автотестов

## Файлы настройки перед запуском
- [config.properties](src\main\resources\config.properties) - с указанием url и webdriver
- [user.properties](src\main\resources\user.properties) - с указанием user и password

## Веб-страницы с описанием шагов
- AuthorizationPage
- CheckoutCompletePage
- CheckoutOverviewPage
- CheckoutYourInformationPage
- ProductsPage
- WebPage
- YourCartPage

## Класс тест-кейсов TestBuy 
- Кейс 1. Проверка успешной покупки
  - Предусловие: выполнение авторизации с корректными данными
  - Шаг 1. Добавление первого продукта в корзину
  - Шаг 2. Переход в корзину
  - Шаг 3. Нажатие на кнопку Checkout
  - Шаг 5. Заполнение полей First Name, Last Name, Zip Code
  - Шаг 6. Нажатие на кнопку Continue
  - Шаг 7. Нажатие на кнопку Finish
  - Ожидаемый результат: редирект на https://www.saucedemo.com/checkout-complete.html
  - Ожидаемый результат: выводится сообщение "Thank you for your order!"
- Кейс 2. Проверка сообщения об ошибке при попытке ввода логина на несуществующего пользователя
  - Шаг 1. Заполение поля Username значением test
  - Шаг 2. Заполение поля Password значением test
  - Шаг 3. Нажатие на кнопку Login
  - Ожидаемый результат: выводится сообщение “Epic sadface: Username and password do not match any user in this service”

## Команды запуска тест-кейсов и Allure отчета
```
mvn clean test
mvn allure:serve
```