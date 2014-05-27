public class Solution {
    public ListNode sortList(ListNode head) {
        int count = 0;
        for (ListNode node = head; node != null; node = node.next) {
            count++;
        }
        int[] data = new int[count];
        int i = 0;
        for (ListNode node = head; node != null; node = node.next) {
            data[i] = node.val;
            i++;
        }

        buildMaxHeapify(data);
        heapSort(data);
        i = 0;
        for (ListNode node = head; node != null; node = node.next) {
            node.val = data[i];
            i++;
        }
        return head;
    }

    private static void buildMaxHeapify(int[] data){
        int startIndex = getParentIndex(data.length - 1);
        for (int i = startIndex; i >= 0; i--) {
            maxHeapify(data, data.length, i);
        }
    }

    private static void maxHeapify(int[] data, int heapSize, int index){
        // 当前点与左右子节点比较
        int left = getChildLeftIndex(index);
        int right = getChildRightIndex(index);

        int largest = index;
        if (left < heapSize && data[index] < data[left]) {
            largest = left;
        }
        if (right < heapSize && data[largest] < data[right]) {
            largest = right;
        }
        if (largest != index) {
            int temp = data[index];
            data[index] = data[largest];
            data[largest] = temp;
            maxHeapify(data, heapSize, largest);
        }
    }

    private static void heapSort(int[] data) {
        for (int i = data.length - 1; i > 0; i--) {
            int temp = data[0];
            data[0] = data[i];
            data[i] = temp;
            maxHeapify(data, i, 0);
        }
    }

    private static int getParentIndex(int current){
        return (current - 1) >> 1;
    }

    private static int getChildLeftIndex(int current){
        return (current << 1) + 1;
    }

    private static int getChildRightIndex(int current){
        return (current << 1) + 2;
    }
}
