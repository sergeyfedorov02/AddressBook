package com.company;

        import org.junit.Assert;
        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.Map;

class AddressBookTest {

    /** Для всех тестов, чтобы они работали корректно:
    1) создаем Адресную книгу MeResult, с которой будем работать
    2) кладем в Нашу Адресную книгу изначальные данные(тк например в Remove, для тестов необходимы начальные данные)
    3) создаем TrueResult, где будет храниться правильный ответ, чтобы потом с ним сранивать работу наших методов
    4) сравниваем MyResult и TrueResult
     */

    @org.junit.jupiter.api.Test
    void add() {

        AddressBook MyResult = new AddressBook();
        MyResult.Add(new Person("Васильев"), new Address("Беговая", 22, 2 ));
        MyResult.Add(new Person("Петров"), new Address("Парковая", 13, 5 ));
        MyResult.Add(new Person("Гулиев"), new Address("Ботаническая", 13, 11 ));
        MyResult.Add(new Person("Алексеев"), new Address("Озерковая", 19, 234 ));
        MyResult.Add(new Person("Мишустин"), new Address("Озерковая", 14, 234 ));

        Map<Person, Address> TrueResult = new HashMap<>(Map.of(
                new Person("Васильев"), new Address("Беговая", 22, 2),
                new Person("Петров"), new Address("Парковая", 13, 5),
                new Person("Гулиев"), new Address("Ботаническая", 13, 11),
                new Person("Алексеев"), new Address("Озерковая", 19, 234),
                new Person("Мишустин"), new Address("Озерковая", 14, 234)
        ));

        /*
          Основной тест:
          Создадим нашу Адресную книгу, при помощи метода Add
         */
        Assert.assertEquals(TrueResult, MyResult.getData());

        /*
          Дополнительный тест:
          Попробуем добавить ещё одного человека в Адресную книгу
         */
        MyResult.Add(new Person("Дополнов"), new Address("Садовая", 27, 643 ));
        TrueResult.put(new Person("Дополнов"), new Address("Садовая", 27, 643 ));
        Assert.assertEquals(TrueResult, MyResult.getData());
    }

    @org.junit.jupiter.api.Test
    void remove() {
        AddressBook MyResult1 = new AddressBook();
        MyResult1.Add(new Person("Васильев"), new Address("Беговая", 22, 2 ));
        MyResult1.Add(new Person("Петров"), new Address("Парковая", 13, 5 ));
        MyResult1.Add(new Person("Гулиев"), new Address("Ботаническая", 13, 11 ));
        MyResult1.Add(new Person("Алексеев"), new Address("Озерковая", 19, 234 ));
        MyResult1.Add(new Person("Мишустин"), new Address("Озерковая", 14, 234 ));

        MyResult1.Remove(new Person("Алексеев"));
        MyResult1.Remove(new Person("Мишустин"));

        Map<Person, Address> TrueResult1 = new HashMap<>(Map.of(
                new Person("Васильев"), new Address("Беговая", 22, 2),
                new Person("Петров"), new Address("Парковая", 13, 5),
                new Person("Гулиев"), new Address("Ботаническая", 13, 11 )
        ));

        /*
          Основной тест:
          Удалим нескольких людей из Адресной книги
         */
        Assert.assertEquals(TrueResult1, MyResult1.getData());

        /*
          Дополнительный тест:
          Попробуем удалить человека, которого нет в Адресной книге
         */
        MyResult1.Remove(new Person("Пустов"));
        Assert.assertEquals(TrueResult1, MyResult1.getData());
    }

    @org.junit.jupiter.api.Test
    void change() {
        AddressBook MyResult2 = new AddressBook();
        MyResult2.Add(new Person("Васильев"), new Address("Беговая", 22, 2 ));
        MyResult2.Add(new Person("Петров"), new Address("Парковая", 13, 5 ));
        MyResult2.Add(new Person("Гулиев"), new Address("Ботаническая", 13, 11 ));
        MyResult2.Add(new Person("Алексеев"), new Address("Озерковая", 19, 234 ));
        MyResult2.Add(new Person("Мишустин"), new Address("Озерковая", 14, 234 ));

        MyResult2.Change(new Person("Мишустин"), new Address("Чечеренская", 14, 234 ));
        MyResult2.Change(new Person("Гулиев"), new Address("Университетская", 45, 654 ));

        Map<Person, Address> TrueResult2 = new HashMap<>(Map.of(
                new Person("Васильев"), new Address("Беговая", 22, 2 ),
                new Person("Петров"), new Address("Парковая", 13, 5 ),
                new Person("Гулиев"), new Address("Университетская", 45, 654 ),
                new Person("Алексеев"), new Address("Озерковая", 19, 234 ),
                new Person("Мишустин"), new Address("Чечеренская", 14, 234 )
        ));

        /*
          Основной тест:
          Поменяем Адрес нескольких людей из Адресной книги
         */
        Assert.assertEquals(TrueResult2, MyResult2.getData());

        /*
          Дополнительный тест:
          Попробуем поменять Адрес человека, которого нет в Адресной книге
         */
        MyResult2.Change(new Person("Марков"), new Address("Пушкинская", 24, 442 ));
        Assert.assertEquals(TrueResult2, MyResult2.getData());
    }

    @org.junit.jupiter.api.Test
    void find() {
        AddressBook MyResult3 = new AddressBook();
        MyResult3.Add(new Person("Васильев"), new Address("Беговая", 22, 2 ));
        MyResult3.Add(new Person("Петров"), new Address("Парковая", 13, 5 ));
        MyResult3.Add(new Person("Гулиев"), new Address("Ботаническая", 13, 11 ));

        /*
          Основные тесты:
          Пытаемся найти людей, которые присутствуют в Адресной книге
         */
        Assert.assertEquals(new Address("Беговая", 22, 2), MyResult3.Find(new Person("Васильев")));
        Assert.assertEquals(new Address("Ботаническая", 13, 11 ), MyResult3.Find(new Person("Гулиев")));
        Assert.assertEquals(new Address("Парковая", 13, 5 ), MyResult3.Find(new Person("Петров")));

        /*
          Дополнительный тест:
          Попробуем найти человека, которого нет в Адресной книге
         */
        Assert.assertNull(MyResult3.Find(new Person("Петрова")));
    }

    @org.junit.jupiter.api.Test
    void findAllByStreet() {
        AddressBook MyResult4 = new AddressBook();
        MyResult4.Add(new Person("Васильев"), new Address("Беговая", 22, 2 ));
        MyResult4.Add(new Person("Петров"), new Address("Парковая", 13, 5 ));
        MyResult4.Add(new Person("Гулиев"), new Address("Ботаническая", 13, 11 ));
        MyResult4.Add(new Person("Алексеев"), new Address("Озерковая", 19, 234 ));
        MyResult4.Add(new Person("Мишустин"), new Address("Озерковая", 14, 234 ));

        /*
          Первый тест:
          для двух людей, которые изначально есть в Адресной книге
         */
        ArrayList<Person> TrueResult4 = new ArrayList<>();
        TrueResult4.add(new Person("Алексеев"));
        TrueResult4.add(new Person("Мишустин"));
        Assert.assertEquals(TrueResult4, MyResult4.FindAllByStreet("Озерковая"));

        /*
          Второй тест:
          Добавляем нового человека в Адресную книгу и ищем всех, кто проживает на его улице
          Примечание: очищаем лист TrueResult4(чтобы то, с чем мы сравниваем результат работы FindAllByStreet
          было Правильным ответом -> чтобы тест работал корректно)
         */
        MyResult4.Add(new Person("Абдулов"), new Address("Гороховая", 14, 234 ));
        TrueResult4.clear();
        TrueResult4.add(new Person("Абдулов"));
        Assert.assertEquals(TrueResult4, MyResult4.FindAllByStreet("Гороховая"));

        /*
          Третий тест:
          Попробуем найти людей, проживающих на удице, которой нет в Адресной книге
         */
        TrueResult4.clear();
        Assert.assertEquals(TrueResult4, MyResult4.FindAllByStreet("Ошибочная"));
    }

    @org.junit.jupiter.api.Test
    void findAllByHouse() {
        AddressBook MyResult5 = new AddressBook();
        MyResult5.Add(new Person("Васильев"), new Address("Беговая", 22, 2 ));
        MyResult5.Add(new Person("Петров"), new Address("Парковая", 13, 5 ));
        MyResult5.Add(new Person("Гулиев"), new Address("Ботаническая", 13, 11 ));
        MyResult5.Add(new Person("Алексеев"), new Address("Озерковая", 19, 234 ));
        MyResult5.Add(new Person("Мишустин"), new Address("Озерковая", 14, 234 ));

        /*
          Первый тест:
          для двух людей, которые изначально есть в Адресной книге
         */
        ArrayList<Person> TrueResult5 = new ArrayList<>();
        TrueResult5.add(new Person("Гулиев"));
        TrueResult5.add(new Person("Петров"));
        Assert.assertEquals(TrueResult5, MyResult5.FindAllByHouse(13));

        /*
          Второй тест:
          добавляем нового Человека в Адресную книгу и ищем по его дому,
          Примечание: очищаем лист TrueResult5(чтобы то, с чем мы сравниваем результат работы FindAllByHouse
          было Правильным ответом -> чтобы тест работал корректно)
         */
        MyResult5.Add(new Person("Васильева"), new Address("Спортивная", 19, 4 ));
        TrueResult5.clear();
        TrueResult5.add(new Person("Васильева"));
        TrueResult5.add(new Person("Алексеев"));
        Assert.assertEquals(TrueResult5, MyResult5.FindAllByHouse(19));

        /*
          Третий тест:
          Попробуем найти людей, проживающих в доме, номера которого нет в Адресной книге
         */
        TrueResult5.clear();
        Assert.assertEquals(TrueResult5,  MyResult5.FindAllByHouse(404));
    }
}