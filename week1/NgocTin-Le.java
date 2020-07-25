
class Main {
    public static void main(String[] args) {
        System.out.println("Minimum element: " + findMinimum(new int[]{3, 4, 5, 1, 2})); //1
        System.out.println("Minimum element: " + findMinimum(null)); //Integer.MIN_VALUE
        System.out.println("Minimum element: " + findMinimum(new int[]{})); //Integer.MIN_VALUE
        System.out.println("Minimum element: " + findMinimum(new int[]{10})); //10
        System.out.println("Minimum element: " + findMinimum(new int[]{4, 5, 6, 7, 0, 1, 2})); //0

        // Another average case
        System.out.println("Minimum element: " + findMinimum(new int[]{4, 5, 6, 7, 8, 10, -1, 0, 1, 2, 3})); //0

        // Worst cases
        System.out.println("Minimum element: " + findMinimum(new int[]{1, 2, 4, 5, 6, 7, 0})); //0
        System.out.println("Minimum element: " + findMinimum(new int[]{0, 1, 2, 4, 5, 6, 7})); //0
    }

    // Finds the minimum number in a rotated sorted array of integers. Returns Integer.MIN_VALUE for invalid input.
    // Time complexity is O(log n)
    // Space complexity is O(1)
    public static int findMinimum(int[] array) {
        // Excluded the edge cases that array is null or empty or has one element
        if (array != null && array.length > 0) {

            if (array.length == 1) {
                return array[0];
            }

            int left = 0;
            int right = array.length - 1;

            while (left <= right) {
                // Re-assign mid point
                int mid = (right - left) / 2;

                // Get pivot point on the right
                if (mid > left && array[mid] > array[mid + 1]) {
                    return array[mid + 1];
                }
                // Get pivot point on the left
                if (mid < right && array[mid] < array[mid - 1]) {
                    return array[mid];
                }

                // Look into the left part
                if (array[left] > array[mid]) {
                    right = mid;
                }
                // Look into the right part
                else if (array[right] < array[mid]) {
                    left = mid;
                }
            }
        }

        return Integer.MIN_VALUE;
    }
}
