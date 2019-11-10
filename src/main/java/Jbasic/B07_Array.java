package Jbasic;

public class B07_Array {

    public static void main(String[] args) {
        int a[] = new int[5];


        a[0] = 1;
        a[1] = 19;
        a[2] = 1;
        a[3] = 4;
        a[4] = 6;

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);

        }

        int b[] = {2, 4, 7, 0, 23, 3};
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);

        }

        //multidimensial array
        int c[][] = new int[2][3];

        int d[][] = {{2, 3, 4}, {8, 1, 8},{4,74,2}};

        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d[i].length ; j++) {
                System.out.println(d[i][j]);

            }

        }


        //Find minimum value in the array

        int m[][]  = {{17,5,8},{14,6,3},{4,7,2}};

        int min = m[0][0];
        for (int i = 0; i < m.length; i++) {
            for(int j = 0; j < m[i].length; j++){
                if(m[i][j]<min){
                    min = m[i][j];
                }

            }

        }
        System.out.println(min);


        //Find the maximum value in column which have minimum value of whole matrix
        //1. Find the mninimum of matrix
        //2. Identify column of minimum value
        //3. find the maximum number in identified column

        int w[][]  = {{11,10,8},{14,9,3},{4,17,2}};
        int idColumnOfMin=0;
        min = w[0][0];
        for (int i = 0; i < w.length; i++) {
            for(int j = 0; j < w[i].length; j++){
                if(w[i][j]<min){
                    min = w[i][j];
                    idColumnOfMin = j;
                }

            }

        }

        int max = w[0][idColumnOfMin];
        int k=0;

        while(k<w.length){
            if(w[k][idColumnOfMin] > max) {
                max = w[k][idColumnOfMin];
            };
            k++;
        }
        System.out.println(max);
    }
}
