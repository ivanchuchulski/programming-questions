package example.leetcode;

public class Leetcode_67_AddBinary {
    public String addBinary(String left, String right) {
        int i = left.length() - 1;
        int j = right.length() - 1;
        var sb = new StringBuilder(Math.max(left.length(), right.length()) + 1);
        boolean carryOne = false;

        while (i >= 0 && j >= 0) {
            int sum = Character.getNumericValue(left.charAt(i--)) + Character.getNumericValue(right.charAt(j--))
                    + (carryOne ? 1 : 0);
            carryOne = sum > 1;
            sb.append(sum % 2);
        }

        while (i >= 0) {
            int sum = Character.getNumericValue(left.charAt(i--)) + (carryOne ? 1 : 0);
            carryOne = sum > 1;
            sb.append(sum % 2);
        }

        while (j >= 0) {
            int sum = Character.getNumericValue(right.charAt(j--)) + (carryOne ? 1 : 0);
            carryOne = sum > 1;
            sb.append(sum % 2);
        }

        if (carryOne) {
            sb.append("1");
        }

        return sb.reverse().toString();
    }
}