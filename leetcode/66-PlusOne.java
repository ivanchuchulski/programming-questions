class PlusOne {
    public int[] plusOne(int[] digits) {
        StringBuilder resultDigits = new StringBuilder(digits.length);

        int lastIndex = digits.length - 1;
        int firstSum = digits[lastIndex] + 1;
        boolean carryOne = firstSum == 10;
        resultDigits.append(carryOne ? 0 : digits[lastIndex] + 1);

        for (int i = lastIndex - 1; i >= 0; i--) {
            int currentDigit = carryOne ? (digits[i] + 1) : digits[i];

            carryOne = currentDigit == 10;

            resultDigits.append(carryOne ? 0 : currentDigit);
        }

        // if last addition was with a carry, whe need to add another one
        if (carryOne) {
            resultDigits.append(1);
        }

        return getResultAsArray(resultDigits);
    }

    private int[] getResultAsArray(StringBuilder resultDigits) {
        int[] resultArr = new int[resultDigits.length()];

        int j = 0;
        for (int i = resultArr.length - 1; i >= 0; i--) {
            int parsedInt = Integer.parseInt(String.valueOf(resultDigits.charAt(i)));
            resultArr[j++] = parsedInt == 10 ? 0 : parsedInt;
        }

        return resultArr;
    }
}
