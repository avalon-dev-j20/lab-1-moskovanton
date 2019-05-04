package ru.avalon.java.j20.labs.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Модель получения последовательности чисел Фибоначчи.
 *
 * <p>Числа Фибонааччи (иногда пишут Фибона́чи[1]) — элементы
 * числовой последовательности 0, 1, 1, 2, 3, 5, 8, 13, 21,
 * 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181,
 * 6765, 10946, 17711, … (последовательность A000045 в OEIS),
 * в которой первые два числа равны либо 1 и 1, либо 0 и 1,
 * а каждое последующее число равно сумме двух предыдущих
 * чисел. Названы в честь средневекового математика Леонардо
 * Пизанского (известного как Фибоначчи).
 *
 * @see <a href="https://ru.wikipedia.org/wiki/%D0%A7%D0%B8%D1%81%D0%BB%D0%B0_%D0%A4%D0%B8%D0%B1%D0%BE%D0%BD%D0%B0%D1%87%D1%87%D0%B8">Числа Фибоначчи</a>
 */
public class Fibonacci implements Iterable<Integer> {
    
    private int n;
    private List<Integer> fibonacciList = new ArrayList<>();

    public Fibonacci(int n) {
        if(n < 2) throw new IllegalArgumentException("n must be >= 2");
        this.n = n;
        fibonacciList.add(1);
        fibonacciList.add(1);
        for(int i = 2; i < n; i++){
            fibonacciList.add(fibonacciList.get(i-1) + fibonacciList.get(i-2));
        }
    }

    /**
     * Итератор, выполняющий обход последовательности
     * чисел Фибоначчи.
     */
    //private static class FibonacciIterator implements Iterator<Integer> {
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
                
            private int currentPos = 0;
        
        /**
         * Определяет, есть ли следующее значение
         * последовательности чисел Фибоначчи.
         *
         * @return {@code true}, если следующее число
         * последовательности существует. В обратном случае
         * {@code false}.
         */
        
            @Override
            public boolean hasNext() {
                return currentPos < fibonacciList.size();
            }

        /**
         * Возвращает следующее число последовательности
         * чисел Фибоначчи.
         *
         * @return следующее число последовательности.
         */
            @Override
            public Integer next() {
                if (!hasNext()) throw new NoSuchElementException();
                return fibonacciList.get(currentPos++);
            }
        };
    }

    /**
     * Возвращает итератор, позволяющий выполнить обход
     * последовательности чисел Фибоначчи.
     *
     * @return итератор последовательности чисел Фибоначчи
     */
    
}
