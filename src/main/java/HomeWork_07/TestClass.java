package HomeWork_07;

import HomeWork_07.annotation.AfterSuit;
import HomeWork_07.annotation.BeforeSuit;
import HomeWork_07.annotation.Test;

import java.lang.reflect.Method;
import java.util.*;

/**
 * 1. Создать класс, который может выполнять «тесты»,
 * в качестве тестов выступают классы с наборами методов с аннотациями @Test.
 * Для этого у него должен быть статический метод start(),
 * которому в качестве параметра передается или объект типа Class, или имя класса.
 * Из «класса-теста» вначале должен быть запущен метод с аннотацией @BeforeSuite, если такой имеется,
 * далее запущены методы с аннотациями @Test, а по завершению всех тестов – метод с аннотацией @AfterSuite.
 * К каждому тесту необходимо также добавить приоритеты (int числа от 1 до 10),
 * в соответствии с которыми будет выбираться порядок их выполнения, если приоритет одинаковый, то порядок не имеет значения.
 * Методы с аннотациями @BeforeSuite и @AfterSuite должны присутствовать в единственном экземпляре,
 * иначе необходимо бросить RuntimeException при запуске «тестирования».
 */


public class TestClass {

    public static void main(String[] args) {
        Class classForTest = Java1_HomeWork_1.class;
        start(classForTest);
    }
    public static void start(Class cls){

        Method[] methods = Java1_HomeWork_1.class.getDeclaredMethods();

        Method beforeSuit = null;
        int numBs = 0;
        for (Method mth : methods) {
            if (mth.getAnnotation(BeforeSuit.class) != null){
                numBs++;
                beforeSuit = mth;
                if (numBs > 1){
                    throw new RuntimeException("Не должно быть больше одной аннотации BeforeSuit");
                }
            }
        }
        if (beforeSuit != null){
            System.out.println(beforeSuit.getName() + ".invoke(args[]);");
        }

        SortedMap<Integer, Method> testMethodsSortedByPriority = new TreeMap<>();
        for (Method mth : methods){
            if (mth.getAnnotation(Test.class) != null){
                testMethodsSortedByPriority.put(mth.getAnnotation(Test.class).priority(), mth);
            }
        }
        testMethodsSortedByPriority.forEach((key, value) -> {
            Method mth = (Method) value;
            System.out.println(mth.getName() + ".invoke(args[]); - Priority - " + key);
        });

        Method аfterSuit = null;
        int numAs = 0;
        for(Method mth : methods) {
            if (mth.getAnnotation(AfterSuit.class) == null) {
                continue;
            }
            numAs++;
            if (numAs > 1) {
                throw new RuntimeException("Не должно быть больше одной аннотации AfterSuit");
            }
        }
        if (аfterSuit != null){
            System.out.println(аfterSuit.getName() + ".invoke(args[]);");
        }
    }

}
