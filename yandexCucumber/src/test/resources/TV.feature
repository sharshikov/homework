#language: ru

  Функционал: тест

    Сценарий: тест Телевизоры

  Когда выбран раздел "Маркет"
  Когда выбрана категория "Электроника"
  Когда выбран раздел электроники: "Телевизоры"
  Тогда заголовок страницы - "Телевизоры"
  Когда выполнено нажатие на кнопку фильтры
  Когда введено значение цены до: "20000"
  Когда выбраны производители "Samsung,LG"
  Когда выполнено нажатие на кнопку показать подходящие
  Когда выполнено нажатие на кнопку показать по 12, если существует кнопка и проверяем кол-во элментов
  Тогда проверяем есть ли элемент в результате поиска
