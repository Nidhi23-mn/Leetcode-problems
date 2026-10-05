class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
        int m = a.length, n = b.length;
        int total = m + n;
        int mid1 = -1, mid2 = -1;
        int i = 0, j = 0, count = 0;
        int prev = 0, curr = 0;

        while (count <= total / 2) {
            prev = curr;
            if (i < m && (j >= n || a[i] <= b[j])) {
                curr = a[i++];
            } else {
                curr = b[j++];
            }
            count++;
        }

        if (total % 2 == 0) return (prev + curr) / 2.0;
        else return curr;
    }
}
