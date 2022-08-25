class Plus_OneTest {

    private Leetcode_66_Plus_One solution;

    @BeforeEach
    void setUp() {
        solution = new Leetcode_66_Plus_One();
    }

    @Test
    void test1() {
        int[] input = new int[]{1, 2, 1};
        int[] result = solution.plusOne(input);
        assertArrayEquals(new int[]{1, 2, 2}, result);
    }

    @Test
    void test2() {
        int[] input = new int[]{1, 9, 9};
        int[] result = solution.plusOne(input);
        assertArrayEquals(new int[]{2, 0, 0}, result);
    }

    @Test
    void test3() {
        int[] input = new int[]{1, 7, 9};
        int[] result = solution.plusOne(input);
        assertArrayEquals(new int[]{1, 8, 0}, result);
    }

    @Test
    void test4() {
        int[] input = new int[]{9, 9};
        int[] result = solution.plusOne(input);
        assertArrayEquals(new int[]{1, 0, 0}, result);
    }
}