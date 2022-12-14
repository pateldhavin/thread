import java.util.Random;

public class Main {

public static void main(String[] args)

{

Random random = new Random();

int[] array = new int[200000000];

for (int i = 0; i < array.length; i++) {

array[i] = random.nextInt(10) + 1;

}

long startTime = System.currentTimeMillis();

System.out.println("Total :" + " " + Concurrency.sum(array));

System.out.println("Single Thread Time: " + (System.currentTimeMillis() - startTime));

startTime = System.currentTimeMillis();

System.out.println("Total :" + " " + Concurrency.parallelSum(array));

System.out.println("Parallel Thread Time: " + (System.currentTimeMillis() - startTime));

}

}