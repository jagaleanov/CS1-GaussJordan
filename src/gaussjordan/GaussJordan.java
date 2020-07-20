package gaussjordan;

public class GaussJordan {

    public double[][] operate(double[][] matrix) {

        int piv = 0;
        int rows = matrix.length;

        for (int i = 0; i < rows; i++) {
            matrix = pivot(matrix, piv, rows);
            matrix = zeros(matrix, piv, rows);
            piv++;
        }
        return matrix;
    }

    public double[][] pivot(double[][] matrix, int piv, int rows) {
        double temp = matrix[piv][piv];
        for (int y = 0; y < (rows + 1); y++) {
            matrix[piv][y] = matrix[piv][y] / temp;
        }
        return matrix;
    }

    public double[][] zeros(double[][] matrix, int piv, int rows) {
        for (int i = 0; i < rows; i++) {
            if (i != piv) {
                double c = matrix[i][piv];
                for (int j = 0; j < (rows + 1); j++) {
                    matrix[i][j] = ((-c) * matrix[piv][j]) + matrix[i][j];
                }
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        GaussJordan gauss = new GaussJordan();
        
        double matrix[][] = {
            {2,-1,1,2},     //= {a b c | d}
            {3,1,-2,9},     //= {e f g | h}
            {-1,2,5,-5}     //= {i j k | l}
        };

        double[][] Result = gauss.operate(matrix);

        for (double[] row : Result) {
            for(double col : row){
                System.out.print(col + "  ");
            }
            System.out.println();
        }
    }
}
