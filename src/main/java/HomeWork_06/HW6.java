package HomeWork_06;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Random;

public class HW6 {
    private static final Logger LOGGER = LogManager.getLogger(HW6.class);

    public static void main(String[] args) {
        LOGGER.info("Старт программы");

        Random random = new Random();
        HW6 hw6 = new HW6();
        int[] arr = new int[15];
        LOGGER.info("Вход: ");
//        System.out.print("Вход: ");
        for (int i = 0; i < 15; i++) {
            arr[i] = random.nextInt(10);
            LOGGER.info(arr[i] + "; ");
        }

        System.out.println();

        int[] copyArr = hw6.numbersBeFour(arr);

        LOGGER.info("Выход: ");
        System.out.print("Выход: ");
        for (int i = 0; i < copyArr.length; i++) {
            LOGGER.info(copyArr[i] + "; ");
        }
        LOGGER.info("Конец программы");
    }

    /**
     * 1. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
     * Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
     * идущих после последней четверки.
     * Входной массив должен содержать хотя бы одну четверку, иначе в методе необходимо выбросить RuntimeException.
     */
    public int[] numbersBeFour(int[] arr) {
        int[] arrCopy;
        int size = 0;
        for (int i = arr.length-1; i > 0; i--) {
            size++;
            if (arr[i] == 4 && i + 1 >= arr.length-1) {
                LOGGER.warn("numbersBeFour. После последней четверки нет других цифр");
                throw new RuntimeException("После последней четверки нет других цифр");
            }
            else if (arr[i] == 4 && i + 1 <= arr.length) {
                arrCopy = new int[size];
                arrCopy = Arrays.copyOfRange(arr, i + 1, arr.length);
                return arrCopy;
            }
        }
        LOGGER.error("numbersBeFour. В массиве нет четверок.");
        throw new RuntimeException("В массиве нет четверок");
    }

    /**
     * 2. Написать метод, который проверяет состав массива из чисел 1 и 4.
     * Если в нем нет хоть одной четверки или единицы, то метод вернет false;
     * Написать набор тестов для этого метода (по 3-4 варианта входных данных).
     */
    public boolean checkOneOrFour(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1 || arr[i] == 4){
                return true;
            }
        }
        return false;
    }
}
