package ru.zhen.junit.services;

import org.junit.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.Assert.*;


public class DataServiceTest {

    @Before
    public void SetUp() throws Exception {
        System.out.println("Run before every test"); // Если мы хотим выполнять чтото перед каждым методом


        }
        @After
        public void tearDown() throws Exception {
            System.out.println("Test passed"); // Если мы хотим выполнять что то после каждого метода
    }

    @Test
    public void test() throws Exception {
        System.out.println("Hello world"); // Просто тест который выводит тест
    }

    @BeforeClass
    public void TestAll() throws Exception { //Будет выполняться перед тестами один раз

    }

    @AfterClass
    public void TestAll1() throws Exception { // Будет выполнять после тестов один раз

    }

    @Test
    public void findMax() throws Exception {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        int max = DataService.findMax(numbers);

        assertThat(max).isEqualTo(7);
    }

    @Test(expected = Exception.class) //NullPointerException.class еще один класс на который мы можем ссылатсья
    public void testFindMaxException() throws Exception {
        List<Integer> numbers = Arrays.asList();

        DataService.findMax(numbers);
    }

    @Test
    public void TestfindMaxByStreams() throws Exception {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<Integer> numbers2 = Arrays.asList(32, 5, 12, 43, 54, 60, 67);

        int max = DataService.findMaxByStreams(numbers);
        int max2 = DataService.findMaxByStreams(numbers2);

        assertThat(max).isEqualTo(7);
        assertThat(max2).isNotNull().isGreaterThan(60).isEqualTo(67); //Можно делать цыпочки тестов
    }

    @Test(expected = Exception.class) //NullPointerException.class еще один класс на который мы можем ссылатсья
    public void testFindMaxExceptionByStreams() throws Exception {
        List<Integer> numbers = Arrays.asList();

        DataService.findMaxByStreams(numbers);
    }

    @Test(expected = Exception.class) //NullPointerException.class еще один класс на который мы можем ссылатсья
    public void testFindMaxExceptionByStreams_Null_List() throws Exception {
        List<Integer> numbers = null;

        DataService.findMaxByStreams(numbers);
    }

    @Test(timeout = 1000) // Хотим что бы тест отрабатывал в течение одной секунды
    public void PerfomanceTest() throws Exception { // Нужно для того что бы тесты выполнялись с определенным быстро действием

       List<Integer> numbers = Stream.iterate(0, n->n+1).limit(2000).collect(Collectors.toList()); // Возращение в лист

        DataService.findMaxByStreams(numbers);

    }

    // В этом проекте мы в начале рассмотрелипринцып тестирования First
    // Далее создали функцию которую мы тестировали
    // Даже переписали ее при помощи функции Stream
    // Протестировали ее различными функциями в том числе на предмент Expectionov
    // А так же затронули тестирования производительности
}

