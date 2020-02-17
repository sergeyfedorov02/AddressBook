package com.company;

import org.junit.jupiter.api.Assertions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class AddressBookTest {

    /** Для всех тестов, чтобы они работали корректно:
     * 1) создаем Адресную книгу myResult, с которой будем работать
     * 2) кладем в Нашу Адресную книгу изначальные данные(тк например в remove, для тестов необходимы начальные данные)
     * 3) создаем trueResult, где будет храниться правильный ответ, чтобы потом с ним сранивать работу наших методов
     * 4) сравниваем myResult и trueResult
     */

    @org.junit.jupiter.api.Test
    void add() {
        AddressBook myResult = new AddressBook();
        /* Основной тест:
         Добавим нескольких людей в Адресную книгу
         */
        Assertions.assertTrue(myResult.add(new Person("Васильев", "Даниил"),
                new Address("Беговая", 22, 2)));
        Assertions.assertTrue(myResult.add(new Person("Петров", "Василий"),
                new Address("Парковая", 13, 5)));
        Assertions.assertTrue(myResult.add(new Person("Гулиев", "Дмитрий"),
                new Address("Ботаническая", 13, 11)));
        Assertions.assertTrue(myResult.add(new Person("Алексеев", "Игорь"),
                new Address("Озерковая", 19, 234)));
        Assertions.assertTrue(myResult.add(new Person("Мишустин", "Сергей"),
                new Address("Озерковая", 14, 234)));

        Map<Person, Address> trueResult = new HashMap<>(Map.of(
                new Person("Васильев", "Даниил"), new Address("Беговая", 22, 2),
                new Person("Петров", "Василий"), new Address("Парковая", 13, 5),
                new Person("Гулиев", "Дмитрий"), new Address("Ботаническая", 13, 11),
                new Person("Алексеев", "Игорь"), new Address("Озерковая", 19, 234),
                new Person("Мишустин", "Сергей"), new Address("Озерковая", 14, 234)
        ));

        // Проверим список людей в Адресной книге
        Assertions.assertEquals(trueResult, myResult.addressBook);

        // Попробуем добавить уже существующего человека
        Assertions.assertFalse(myResult.add(new Person("Мишустин", "Сергей"),
                new Address("Озерковая", 14, 234)));

        // Проверим список людей в Адресной книге
        Assertions.assertEquals(trueResult, myResult.addressBook);

    }

    /**
     Дополнительный тест:
     * Попробуем добавить человека, у которого одно из полей == null
     */

    @org.junit.jupiter.api.Test
    void addNull() {
        AddressBook myResult = new AddressBook();
        Assertions.assertThrows(NullPointerException.class, () ->
                myResult.add(null, new Address("Озерковая", 14, 234)));
        Assertions.assertThrows(NullPointerException.class, () ->
                myResult.add(new Person("Петров", "Сергей"), null));
        Assertions.assertThrows(NullPointerException.class, () ->
                myResult.add(new Person(null, "Сергей"), new Address("Озерковая", 14, 234)));
        Assertions.assertThrows(NullPointerException.class, () ->
                myResult.add(new Person(null, "Сергей"), new Address("Озерковая", 14, 234)));
        Assertions.assertThrows(NullPointerException.class, () ->
                myResult.add(new Person("Петров", null), new Address("Озерковая", 14, 234)));
        Assertions.assertThrows(NullPointerException.class, () ->
                myResult.add(new Person("Петров", "Сергей"), new Address(null, 14, 234)));
        Assertions.assertThrows(NullPointerException.class, () ->
                myResult.add(new Person("Петров", "Сергей"), new Address("Озерковая", null, 234)));
        Assertions.assertThrows(NullPointerException.class, () ->
                myResult.add(new Person("Петров", "Сергей"), new Address("Озерковая", 14, null)));
    }

    @org.junit.jupiter.api.Test
    void remove() {
        AddressBook myResult = new AddressBook();
        myResult.add(new Person("Васильев", "Даниил"), new Address("Беговая", 35, 2 ));
        myResult.add(new Person("Петров", "Василий"), new Address("Парковая", 31, 5 ));
        myResult.add(new Person("Гулиев", "Дмитрий"), new Address("Ботаническая", 31, 11 ));
        myResult.add(new Person("Алексеев", "Игорь"), new Address("Озерковая", 91, 234 ));
        myResult.add(new Person("Мишустин", "Сергей"), new Address("Озерковая", 32, 234 ));

        /* Основной тест:
        Удалим нескольких людей из Адресной книги
        */
        Assertions.assertTrue(myResult.remove(new Person("Алексеев", "Игорь")));
        Assertions.assertTrue(myResult.remove(new Person("Мишустин", "Сергей")));

        Map<Person, Address> trueResult = new HashMap<>(Map.of(
                new Person("Васильев", "Даниил"), new Address("Беговая", 35, 2),
                new Person("Петров", "Василий"), new Address("Парковая", 31, 5),
                new Person("Гулиев", "Дмитрий"), new Address("Ботаническая", 31, 11 )
        ));

        // Проверим список оставшихся людей
        Assertions.assertEquals(trueResult, myResult.addressBook);

        /* Дополнительный тест:
        Попробуем удалить человека, которого нет в Адресной книги
        */

        Assertions.assertFalse(myResult.remove(new Person("Пустов", "Анатолий")));

        // Проверим список оставшихся людей
        Assertions.assertEquals(trueResult, myResult.addressBook);
    }

    /**
     Дополнительный тест:
     * Попробуем удалить null
     */

    @org.junit.jupiter.api.Test
    void removeNull() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            AddressBook result= new AddressBook();
            result.remove(null);
        });
    }

    @org.junit.jupiter.api.Test
    void change() {
        AddressBook myResult = new AddressBook();
        myResult.add(new Person("Васильева", "Света"), new Address("Беговая", 22, 2 ));
        myResult.add(new Person("Петрова", "Василиса"), new Address("Парковая", 13, 5 ));
        myResult.add(new Person("Гулиева", "Дарья"), new Address("Ботаническая", 13, 11 ));
        myResult.add(new Person("Алексеева", "Илона"), new Address("Озерковая", 19, 234 ));
        myResult.add(new Person("Мишустина", "Саша"), new Address("Озерковая", 14, 234 ));

        /* Основной тест:
        Поменяем Адрес нескольких людей из Адресной книги
        */
        Assertions.assertTrue(myResult.change(new Person("Мишустина", "Саша"),
                new Address("Чечеренская", 14, 234 )));
        Assertions.assertTrue(myResult.change(new Person("Гулиева", "Дарья"),
                new Address("Университетская", 45, 654 )));

        Map<Person, Address> trueResult = new HashMap<>(Map.of(
                new Person("Васильева", "Света"), new Address("Беговая", 22, 2 ),
                new Person("Петрова", "Василиса"), new Address("Парковая", 13, 5 ),
                new Person("Гулиева", "Дарья"), new Address("Университетская", 45, 654 ),
                new Person("Алексеева", "Илона"), new Address("Озерковая", 19, 234 ),
                new Person("Мишустина", "Саша"), new Address("Чечеренская", 14, 234 )
        ));

        // Проверим список людей в Адресной книге
        Assertions.assertEquals(trueResult, myResult.addressBook);

        /* Дополнительный тест:
        Попробуем изменить адрес человека, которого нет в Адресной книге
        */
        Assertions.assertFalse(myResult.change(new Person("Марков", "Илья"),
                new Address("Пушкинская", 24, 442 )));

        // Проверим список людей в Адресной книге
        Assertions.assertEquals(trueResult, myResult.addressBook);
    }

    /**
     Дополнительный тест:
     * Попробуем изменить адрес человека,у которого какая-то из позиций измененного адреса отсутствует
     */
    @org.junit.jupiter.api.Test
    void changeNull() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            AddressBook result= new AddressBook();
            result.add(new Person("Марков", "Илья"), new Address("Пригородная", 24, 442 ));
            result.change(new Person("Марков", "Илья"), new Address(null, 13, 53 ));
        });
        Assertions.assertThrows(NullPointerException.class, () -> {
            AddressBook result= new AddressBook();
            result.add(new Person("Марков", "Илья"), new Address("Пригородная", 24, 442 ));
            result.change(new Person("Марков", "Илья"), new Address("Пушкинская", null, 442 ));
        });
        Assertions.assertThrows(NullPointerException.class, () -> {
            AddressBook result= new AddressBook();
            result.add(new Person("Марков", "Илья"), new Address("Пригородная", 24, 442 ));
            result.change(new Person("Марков", "Илья"), new Address("Пушкинская", 24, null ));
        });
    }

    @org.junit.jupiter.api.Test
    void find() {
        AddressBook myResult = new AddressBook();
        myResult.add(new Person("Васильев", "Вячеслав"), new Address("Беговая", 22, 2 ));
        myResult.add(new Person("Петров", "Стас"), new Address("Парковая", 13, 5 ));
        myResult.add(new Person("Гулиева", "Мария"), new Address("Ботаническая", 13, 11 ));

        /* Основные тесты:
        Пытаемся найти людей, которые присутствуют в Адресной книге
        */
        Assertions.assertEquals(new Address("Беговая", 22, 2),
                myResult.find(new Person("Васильев", "Вячеслав")));
        Assertions.assertEquals(new Address("Ботаническая", 13, 11 ),
                myResult.find(new Person("Гулиева", "Мария")));
        Assertions.assertEquals(new Address("Парковая", 13, 5 ),
                myResult.find(new Person("Петров", "Стас")));

        /* Дополнительный тест:
        Попробуем найти человека, которого нет в Адресной книге
        */
        AddressBook result= new AddressBook();
        result.add(new Person("Марков", "Евгений"), new Address("Пушкинская", 24, 54 ));
        Assertions.assertNull(result.find(new Person("Марков", "Илья")));

    } @org.junit.jupiter.api.Test
    void findAllByStreet() {
        AddressBook myResult = new AddressBook();
        myResult.add(new Person("Васильев", "Захар"), new Address("Беговая", 22, 2 ));
        myResult.add(new Person("Петров", "Руслан"), new Address("Парковая", 13, 5 ));
        myResult.add(new Person("Гулиев", "Александр"), new Address("Ботаническая", 13, 11 ));
        myResult.add(new Person("Алексеев", "Егор"), new Address("Озерковая", 19, 234 ));
        myResult.add(new Person("Мишустин", "Дмитрий"), new Address("Озерковая", 14, 234 ));

        /* Первый тест:
        для двух людей, которые изначально есть в Адресной книге
        */
        ArrayList<Person> trueResult = new ArrayList<>();
        trueResult.add(new Person("Мишустин", "Дмитрий"));
        trueResult.add(new Person("Алексеев", "Егор"));
        Assertions.assertEquals(trueResult, myResult.findAllByStreet("Озерковая"));

        /* Второй тест:
        Добавляем нового человека в Адресную книгу и ищем всех,кто проживает на его улице
        Примечание: очищаем лист trueResult(чтобы то, с чем мы сравниваем результат работы findAllByStreet
        было Правильным ответом -> чтобы тест работал корректно)
        */
        myResult.add(new Person("Абдулов", "Ильдар"), new Address("Гороховая", 14, 234 ));
        trueResult.clear();
        trueResult.add(new Person("Абдулов", "Ильдар"));
        Assertions.assertEquals(trueResult, myResult.findAllByStreet("Гороховая"));

        /* Третий тест:
        Попробуем найти людей, проживающих на удице, которой нет в Адресной книге
        */
        trueResult.clear();
        Assertions.assertEquals(trueResult, myResult.findAllByStreet("Ошибочная"));
    }

    @org.junit.jupiter.api.Test
    void findAllByHouse() {
        AddressBook myResult = new AddressBook();
        myResult.add(new Person("Васильев", "Василий"), new Address("Беговая", 22, 2 ));
        myResult.add(new Person("Петров", "Петр"), new Address("Парковая", 13, 5 ));
        myResult.add(new Person("Гулиев", "Гуливер"), new Address("Ботаническая", 13, 11 ));
        myResult.add(new Person("Алексеев", "Алексей"), new Address("Озерковая", 19, 234 ));
        myResult.add(new Person("Мишустин", "Михаил"), new Address("Озерковая", 14, 234 ));

        /* Первый тест:
        для двух людей, которые изначально есть в Адресной книге
        */
        ArrayList<Person> trueResult = new ArrayList<>();
        trueResult.add(new Person("Гулиев", "Гуливер"));
        trueResult.add(new Person("Петров", "Петр"));
        Assertions.assertEquals(trueResult, myResult.findAllByHouse(13));

        /* Второй тест:
        добавляем нового Человека в Адресную книгу и ищем по его дому,
        Примечание: очищаем лист trueResult(чтобы то, с чем мы сравниваем результат работы findAllByHouse
        было Правильным ответом -> чтобы тест работал корректно)
        */
        myResult.add(new Person("Васильева", "Татьяна"), new Address("Спортивная", 19, 4 ));
        trueResult.clear();
        trueResult.add(new Person("Васильева", "Татьяна"));
        trueResult.add(new Person("Алексеев", "Алексей"));
        Assertions.assertEquals(trueResult, myResult.findAllByHouse(19));

        /* Третий тест:
        Попробуем найти людей, проживающих в доме, номера которого нет в Адресной книге
        */
        trueResult.clear();
        Assertions.assertEquals(trueResult, myResult.findAllByHouse(404));
    }
}