public class Main {

  public static void print2DArray(int[][] a) {
    for (int[] row : a) {
        for (int value : row) {
            System.out.print(value);
            System.out.print(" ");
        }
        System.out.println();
    }
}

  public static void print2DArray(double[][] a) {
  for (double[] row : a) {
      for (double value : row) {
          System.out.print(value);
          System.out.print(" ");
      }
      System.out.println();
  }
}

  public static int[][] copySquare(int[][] a) {
    int[][] copy = new int[a.length][a[0].length];

    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[i].length; j++) {
        copy[i][j] = a[i][j];
      }
    }

    return copy;
  }

  public static int[][] copyRectangle(int[][] a) {
    int[][] copy = a;

    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[i].length; j++) {
        copy[i][j] = a[i][j];
      }
    }

    return copy;
  }

  public static int[][] copyRagged(int[][] a) {
    int[][] copy = a;

    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[i].length; j++) {
        copy[i][j] = a[i][j];
      }
    }

    return copy;
  }

  public static double[][] printTranspose(double[][] a) {
    double[][] copy = new double[a[0].length][a.length];
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[i].length; j++) {
        copy[j][i] = a[i][j];
      }
    }
    return copy;
  }
  
  public static double[][] withWeightedAverage(double[][] a, double[] weights) {
    int rows = a.length;
    int col = a[0].length;
    double[][] copy = new double[rows + 1][col + 1];

    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[i].length; j++) {
        copy[i][j] = a[i][j];
      }
    }

    for (int i = 0; i < rows; i++) {
      double total = 0;
      for (int j = 0; j < a[i].length; j++) {
          total += (a[i][j] * weights[j]);
      }
      copy[i][col] = total;
    }

    for (int j = 0; j < a[0].length; j++) {
      double total = 0;
      for (int i = 0; i < a.length; i++) {
        total += a[i][j];
      }
      copy[rows][j] = total / rows;
    }

    double total = 0;
      for (double currNum : copy[rows]) {
          total += currNum;
      }
      copy[rows][col] = total / col;

    return copy;
  }
  public static void main(String[] args) {

    int[][] a1 = new int[][] {
      {1,2,3},
      {4,5,6},
      {7,8,9}
    };

    int[][] a2 = new int[][] {
      {1,2,3,4},
      {5,6,7,8},
      {9,10,11,12}
    };

    int[][] a3 = new int[][] {
      {1},
      {2,3,4},
      {5,6}
    };

    print2DArray(copySquare(a1));
    print2DArray(copyRectangle(a1));
    print2DArray(copyRagged(a1));

    System.out.println("--------------------------------------------------------------------------------");

    print2DArray(copyRectangle(a2));
    print2DArray(copyRagged(a2));

    System.out.println("--------------------------------------------------------------------------------");

    print2DArray(copyRagged(a3));

    System.out.println("--------------------------------------------------------------------------------");

    double[][] a4 = new double[][] {
      {99, 85, 98},
      {98, 57, 79},
      {92, 77, 74},
      {94, 62, 81},
      {99, 94, 92},
      {80, 76.5, 67},
      {76, 58.5, 90.5},
      {92, 66, 91},
      {77, 70.5, 66.5},
      {89, 89.5, 81}
    };

    print2DArray(printTranspose(a4));

    System.out.println("--------------------------------------------------------------------------------");

    double[] weights = new double[]{.25, .25, .5};

    print2DArray(withWeightedAverage(a4, weights));
    
  }
}