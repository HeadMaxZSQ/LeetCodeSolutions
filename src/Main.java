// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        Question134 question134 = new Question134();
        int result = question134.canCompleteCircuit(gas, cost);
        System.out.println("result=" + result);
    }
}