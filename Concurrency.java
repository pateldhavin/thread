class Concurrency extends Thread {

private int[] array;

private int low, high, partialSum;

public Concurrency(int[] array, int low, int high)

{

this.array = array;

this.low = low;

this.high = Math.min(high, array.length);

}

public int getPartial()

{

return partialSum;

}

public void run()

{

partialSum = sum(array, low, high);

}
public static int sum(int[] array, int low, int high)

{

int total = 0;

for (int i = low; i < high; i++) {

total += array[i];

}

return total;

}

public static int sum(int[] array)

{

return sum(array, 0, array.length);

}

public static int parallelSum(int[] array, int threads)

{

int size = (int) Math.ceil(array.length * 1.0 / threads);

Concurrency[] sums = new Concurrency[threads];

for (int i = 0; i < threads; i++) {

sums[i] = new Concurrency(array, i * size, (i + 1) * size);

sums[i].start();

}

try {

for (Concurrency sum : sums) {

sum.join();

}

} catch (InterruptedException e) { }

int total = 0;

for (Concurrency sum : sums) {

total += sum.getPartial();

}

return total;

}

public static int parallelSum(int[] array)

{

return parallelSum(array, Runtime.getRuntime().availableProcessors());

}

}

