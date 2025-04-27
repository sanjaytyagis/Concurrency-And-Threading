package ForkJoin;
import java.util.concurrent.*;

public class SumTask extends RecursiveTask<Integer> {
	
    private int[] numbers;
    private int start, end;

    public SumTask(int[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - start <= 2) {
            // Base case: Sum the small portion directly
            int sum = 0;
            for (int i = start; i < end; i++) {
                sum += numbers[i];
            }
            return sum;
        } else {
            // Recursive case: Split the task into two smaller tasks
            int mid = (start + end) / 2;
            SumTask leftTask = new SumTask(numbers, start, mid);
            SumTask rightTask = new SumTask(numbers, mid, end);
            
            // Fork the tasks
            leftTask.fork();
            rightTask.fork();
            
            // Wait for results of the two tasks
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();
            
            // Combine the results
            return leftResult + rightResult;
        }
    }
}