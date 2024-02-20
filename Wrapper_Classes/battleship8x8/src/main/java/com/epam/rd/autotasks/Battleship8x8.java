package com.epam.rd.autotasks;

import java.math.BigInteger;

public class Battleship8x8 {
    private final long ships;
    private long shots = 0L;

    public Battleship8x8(final long ships) {
        this.ships = ships;
    }

    public boolean shoot(String shot) { // Метод для произведения выстрела, принимающий строку shot
        int let = shot.charAt(0) - 64; // Получение номера столбца выстрела из символа в кодировке ASCII
        int num = shot.charAt(1) - 48; // Получение номера строки выстрела из символа в кодировке ASCII
        int index = 63 - ((num - 1) * 8 + (let - 1)); // Вычисление индекса клетки в игровом поле

        BigInteger fire = BigInteger.valueOf(shots); // Создание объекта BigInteger, представляющего переменную shots
        fire = fire.setBit(index); // Установка бита в позиции index в объекте fire

        BigInteger map = BigInteger.valueOf(ships); // Создание объекта BigInteger, представляющего переменную ships

        if (map.testBit(index)) { // Проверка, установлен ли бит в позиции index в объекте map
            shots = fire.longValue(); // Присваивание shots значению объекта fire
            return true; // Возврат true, если бит установлен в позиции index
        }

        shots = fire.longValue(); // Присваивание shots значению объекта fire
        return false; // Возврат false, если бит не установлен в позиции index
    }

    public String state() { // Метод для получения текущего состояния игрового поля
        StringBuilder s = new StringBuilder(); // Создание объекта StringBuilder для формирования строки состояния игрового поля
        BigInteger map = BigInteger.valueOf(ships); // Создание объекта BigInteger, представляющего переменную ships
        BigInteger fire = BigInteger.valueOf(shots); // Создание объекта BigInteger, представляющего переменную shots
        boolean m, f; // Объявление логических переменных m и f

        for (int i = 0; i < 64; i++) { // Цикл по всем клеткам игрового поля
            m = map.testBit(63 - i); // Проверка, установлен ли бит в позиции (63 - i) в объекте map
            f = fire.testBit(63 - i); // Проверка, установлен ли бит в позиции (63 - i) в объекте fire

            if (m && f) { // Если и бит установлен в позиции (63 - i) в объекте map, и бит установлен в позиции (63 - i) в объекте fire
                s.append("☒"); // Добавление символа "☒" в строку состояния
            } else if (m) { // Если бит установлен только в позиции (63 - i) в объекте map
                s.append("☐"); // Добавление символа "☐" в строку состояния
            } else if (f) { // Если бит установлен только в позиции (63 - i) в объекте fire
                s.append("×"); // Добавление символа "×" в строку состояния
            } else { // Если ни один из битов не установлен в позиции (63 - i)
                s.append("."); // Добавление символа "." в строку состояния
            }
            if ((i % 8) == 7) { // Если i делится на 8 без остатка
                s.append("\n"); // Добавление символа новой строки в строку состояния
            }
        }
        return s.toString(); // Возврат строки состояния игрового поля
    }
}
