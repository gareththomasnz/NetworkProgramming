package Cubes;

public class TestCubes {
	 public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        for (int i = 1; i <= N; i++)
            System.out.println(i + " " + Cubes.cube(i));
    }
}
