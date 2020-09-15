package test;

import lab0.Variant3;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestVariant3 {

    @Test
    public void massTest() {
        assertEquals(new int[]{1, 2, 3}, new int[]{1, 2, 3});
    }

    @Test(dataProvider = "integerTaskProvider")
    public void integerTaskTest(int number, int expected) {
        Variant3 item = new Variant3();
        long actual = Variant3.integerTask(number);
        assertEquals(actual,expected);
    }

    @DataProvider
    public Object[][] integerTaskProvider() {
        return new Object[][]{{5050, 4}, {0, 0},{900,0}};
    }


    @Test(dataProvider = "booleanTaskProvider")
    public void booleanTaskTest(int number, boolean expected) {
        Variant3 item = new Variant3();
        boolean actual = item.booleanTask(number);
        assertEquals(actual,expected);
    }

    @DataProvider
    public Object[][] booleanTaskProvider() {
        return new Object[][]{{2, true}, {3, false}, {7,false}};
    }


    @Test(dataProvider = "ifTaskProvider")
    public void ifTaskTest(int number, int expected) {
        Variant3 item = new Variant3();
        int actual = item.ifTask(number);
        assertEquals(actual,expected);
    }

    @DataProvider
    public Object[][] ifTaskProvider() {
        return new Object[][]{{5, 6}, {-5, -7},{0, 10}};
    }

    @Test(dataProvider = "caseTaskProvider")
    public void caseTaskTest(int number, String expected) {
        Variant3 item = new Variant3();
        String actual = item.caseTask(number);
        assertEquals(actual,expected);
    }

    @DataProvider
    public Object[][] caseTaskProvider() {
        return new Object[][]{{1, "Winter"}, {6, "Summer"},{9, "Autumn"}, {12, "Winter"}};
    }



    @Test(expectedExceptions = IllegalArgumentException.class, dataProvider = "negativeCaseTaskProvider")
    public void negativeCaseTaskTest(int number){
        Variant3.caseTask(number);
    }

    @DataProvider
    public Object[][] negativeCaseTaskProvider(){
        return new Object[][]{{-2}, {13}};
    }


    @Test(dataProvider = "forTaskProvider")
    public void forTaskTest(int number1,int number2, int[] expected) {
        Variant3 item = new Variant3();
        int[] actual = item.forTask(number1,number2);
        assertEquals(actual,expected);
    }

    @DataProvider
    public Object[][] forTaskProvider() {
        return new Object[][]{{10, 15,new int[]{11, 12, 13, 14}}};
    }


    @Test(dataProvider = "whileTaskProvider")
    public void whileTaskTest(int number1, int number2, int[] expected) {
        Variant3 item = new Variant3();
        int[] actual = item.whileTask(number1,number2);
        assertEquals(actual,expected);
    }

    @DataProvider
    public Object[][] whileTaskProvider() {
        return new Object[][]{{6, 3, new int[]{2, 0}},{20, 3, new int[]{6, 2}}};
    }

    @Test(dataProvider = "minMaxTaskProvider")
    public void minMaxTaskTest(int[][] rectangles, int expected) {
        Variant3 item = new Variant3();
        int actual = item.minmaxTask(rectangles);
        assertEquals(actual,expected);
    }

    @DataProvider
    public Object[][] minMaxTaskProvider() {
        return new Object[][]{{new int[][]{{2, 3}, {5, 6}, {1, 1}, {2, 2}, {6, 4}}, 22}};
    }

    @Test(dataProvider = "arrayTaskProvider")
    public void arrayTaskTest(int number1, int number2, int number3, int[] expected) {
        Variant3 item = new Variant3();
        int[] actual = item.arrayTask(number1, number2, number3);
        assertEquals(actual,expected);
    }

    @DataProvider
    public Object[][] arrayTaskProvider() {
        int[] out = {2, 6, 10, 14, 18};
        return new Object[][]{{5, 2, 4, out}};
    }

    @Test(dataProvider = "matrixTaskProvider")
    public void matrixTaskTest(int number1, int number2, int[] list, int[][] expected) {
        Variant3 item = new Variant3();
        int[][] actual = item.matrixTask(number1, number2, list);
        for (int i = 0; i < number1; i++) {
            assertEquals(actual[i],expected[i]);
        }
    }

    @DataProvider
    public Object[][] matrixTaskProvider() {
        int[] input = {1, 7, 5};
        int[][] output= {{1, 1, 1},
                {7, 7, 7},
                {5, 5, 5}};
        return new Object[][]{{3,3, input, output}};
    }


}




