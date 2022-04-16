package ru.zhen.junit.services;

import java.util.Comparator;
import java.util.List;

public class DataService {

    public static int findMax(List<Integer> numbers) throws Exception {

        //Лист либо пустой либо имеет значение null
        if(numbers == null || numbers.size() ==0 ) {
            throw new Exception(("List of numbers is empty null"));

        }
        int max = numbers.get(0);

        for ( int i=0; i< numbers.size(); i++) {

            int current = numbers.get(i);
            if(max<current){
                max = current;
            }
        }
        return max;
    }

    public static int findMaxByStreams (List<Integer> numbers) throws Exception {
        Integer max = numbers.stream().max(Comparator.naturalOrder())                     //naturalOrder Искать максимум если reverseOrder то искать минимум
                .orElseThrow(()->new Exception("List of numbers is empty null")) ;                 //Если не нашли  .orElseThrow(()->new Лямдовое выражение Exception)
        return max;
    }
}
