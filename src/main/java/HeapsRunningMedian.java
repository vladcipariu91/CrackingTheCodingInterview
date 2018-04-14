import java.util.*;

public class HeapsRunningMedian {

    private PriorityQueue<Integer> minHeap, maxHeap;

    HeapsRunningMedian() {
        minHeap = new PriorityQueue<>((first, second) -> first - second);
        maxHeap = new PriorityQueue<>((first, second) -> second - first);
    }

    void addNewNumber(int randomNumber) {
        // Note: addNewNumber maintains a condition that maxHeap.size() >= minHeap.size()
        if (maxHeap.size() == minHeap.size()) {
            if (minHeap.peek() != null && randomNumber > minHeap.peek()) {
                maxHeap.offer(minHeap.poll());
                minHeap.offer(randomNumber);
            } else {
                maxHeap.offer(randomNumber);
            }
        } else {
            if (randomNumber < maxHeap.peek()) {
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(randomNumber);
            } else {
                minHeap.offer(randomNumber);
            }
        }
    }

    double getMedian() {
        // maxHeap is always at least as big as minHeap. So if maxHeap is empty, then minHeap is also.
        if (maxHeap.isEmpty()) {
            return 0;
        }

        if (maxHeap.size() == minHeap.size()) {
            return ((double) minHeap.peek() + (double) maxHeap.peek()) / 2;
        } else {
            // If maxHeap and minHeap are of different sizes, then maxHeap must have one extra element. Return maxHeap's
            // top element.
            return maxHeap.peek();
        }
    }

    public static void main(String[] args) {
        HeapsRunningMedian heapsRunningMedian = new HeapsRunningMedian();
        List<Integer> ints = Arrays.asList(12, 4, 5, 3, 8, 7);
        for (int i = 0; i < ints.size(); i++) {
            heapsRunningMedian.addNewNumber(ints.get(i));
            System.out.println(heapsRunningMedian.getMedian());
        }
    }
}
