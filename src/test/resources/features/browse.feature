Feature: Просмотр списка товаров

  @browse
  Scenario: Просмотр списка товаров в категории "Электроника"
    Given пользователь на главной странице магазина
    When он переходит в категорию "Электроника"
    Then он видит список товаров этой категории