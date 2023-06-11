Feature: Register User

  Scenario Outline: zakładał konto na stronie https://hotel-testlab.coderslab.pl
    Given przegladarka otwarta na stronie hotel-testlab.coderslab.pl
    When podajemy e-mail <email> a nastepnie imie <fName> nazwisko <lname> i haslo <pass>
    Then przejscie do strony uzytkownika i potwierdzenie utworzenia konta
    And zamknij przegladarke


      Examples:
      |email             |fName  |lname  |pass         |
      |adamNsfdertgowak88@wp.pl   |adam   |nowak  |1135454685854|
      |daniefsdreyyl25564645@opl.pl |daniel |kowal  |46748/7468486|