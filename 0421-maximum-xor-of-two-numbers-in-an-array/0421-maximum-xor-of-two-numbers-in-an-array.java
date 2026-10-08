class Solution {

    class Node {

        Node[] children = new Node[2];
    }

    Node root = new Node();

    public int findMaximumXOR(int[] nums) {

        int max = 0;

        insert(nums[0]);

        for (int i = 1; i < nums.length; i++) {

            max = Math.max(max, getMaxXOR(nums[i]));

            insert(nums[i]);
        }

        return max;
    }

    private void insert(int num) {

        Node curr = root;

        for (int bit = 30; bit >= 0; bit--) {

            int currentBit = (num >> bit) & 1;

            if (curr.children[currentBit] == null) {

                curr.children[currentBit] = new Node();
            }

            curr = curr.children[currentBit];
        }
    }

    private int getMaxXOR(int num) {

        Node curr = root;

        int result = 0;

        for (int bit = 30; bit >= 0; bit--) {

            int currentBit = (num >> bit) & 1;

            int oppositeBit = 1 - currentBit;

            if (curr.children[oppositeBit] != null) {

                result |= (1 << bit);

                curr = curr.children[oppositeBit];

            } else {

                curr = curr.children[currentBit];
            }
        }

        return result;
    }
}