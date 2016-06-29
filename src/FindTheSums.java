
public class FindTheSums {

	//Return neat representation of values in a
	public static String arrayToString(int[][] a) {
		String s = "";
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (j < a[i].length - 1)
					s = s + a[i][j] + " ";
				else
					s = s + a[i][j];
			}
			if (i < a.length - 1)
				s = s + "\n";
		}
		return s;
	}
	
	//Create new output array, b, that has same dimensions as a.
	//For each a[i][j], where i and j are valid indices in a, 
	//if a[i][j] is part of a horizontal sum in a that equals sumToFind, 
	//then b[i][j] = a[i][j]; otherwise, b[i][j] = 0. The method should return b.
	public static int[][] horizontalSums(int[][] a, int sumToFind) {
		int[][] b = new int[a.length][a[0].length];
        boolean[][] searched = new boolean[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            int start = 0;
            int sum = 0;
            int j = 0;
            while (j < a[0].length) {
                if (sum < sumToFind) {
                    sum += a[i][j];
                    j++;
                } 
                if (sum > sumToFind) {
                    start++;
                    j = start;
                    sum = 0;
                }
                if (sum == sumToFind) {
                    for (int x = start; x < j; x++)
                        searched[i][x] = true;
                    	start++;
                    	j = start;
                    	sum = 0;
                }      
            }
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (searched[i][j])
                    b[i][j] = a[i][j];
                else
                    b[i][j] = 0;
            }
        }
        return b;
	}
	
	//Create new output array, b, that has same dimensions as a.
	//For each a[i][j], where i and j are valid indices in a, 
	//if a[i][j] is part of a vertical sum in a that equals sumToFind, 
	//then b[i][j] = a[i][j]; otherwise, b[i][j] = 0. The method should return b.
	public static int[][] verticalSums(int[][] a, int sumToFind) {
		int[][] b = new int[a.length][a[0].length];
        boolean[][] searched = new boolean[a.length][a[0].length];
        for (int j = 0; j < a[0].length; j++) {
            int start = 0;
            int sum = 0;
            int i = 0;
            while (i < a.length) {
                if (sum < sumToFind) {
                    sum += a[i][j];
                    i++;
                } 
                if (sum > sumToFind) {
                    start++;
                    i = start;
                    sum = 0;
                }
                if (sum == sumToFind) {
                    for (int x = start; x < i; x++)
                        searched[x][j] = true;
                    	start++;
                    	i = start;
                    	sum = 0;
                }      
            }
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (searched[i][j])
                    b[i][j] = a[i][j];
                else
                    b[i][j] = 0;
            }
        }
        return b;
	}
}
