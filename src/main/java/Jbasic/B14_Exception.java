package Jbasic;


public class B14_Exception {


    public static void main(String[] args) {
// one try can br followed by multiple catch blocks
        int a = 6;
        int b = 0;
        int[] c = new int[5];
        try {
            //int k = a / b;
            //System.out.println(k);
            System.out.println(c[9]);
        }
        catch (ArithmeticException at)
        {
            System.out.println("Im catching the arithmetik exception");
        }
        catch (IndexOutOfBoundsException oob)
        {
            System.out.println("Im catching the Out of Bound exception");
        }
        catch (Exception e) {
            System.out.println("Im catching the exception");
        }
        finally {
            //This block is executed  irrespective or exeptiocn thrown or not
            System.out.println("Finally block");
        }
        ;


    }
}
