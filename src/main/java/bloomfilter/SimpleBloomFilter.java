package bloomfilter;

import java.util.BitSet;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : 1766318593@qq.com
 * @Creation Date : 2018年10月08日下午9:31
 * @Function : todo
 */
public class SimpleBloomFilter {

    private static final int DEFAULT_SIZE = 2 << 24;
    private static final int[] seeds = new int[] {7, 11, 13, 31, 37, 61,};

    private BitSet bits = new BitSet(DEFAULT_SIZE);
    private SimpleHash[] func = new SimpleHash[seeds.length];

    public static void main(String[] args) {
        String value = " stone2083@yahoo.cn ";
        SimpleBloomFilter filter = new SimpleBloomFilter();
        System.out.println(filter.contains(value));
        filter.add(value);
        System.out.println(filter.contains(value));
    }

    public SimpleBloomFilter() {
        for (int i = 0; i < seeds.length; i++) {
            func[i] = new SimpleHash(DEFAULT_SIZE, seeds[i]); // 初始化多少个hash 函数
        }
    }

    /**
     * bloomFilter 制成某个值
     * @param value
     */
    public void add(String value) {
        for (SimpleHash f : func) {
            bits.set(f.hash(value), true); // hash 值的位置 制成 true
        }
    }

    public boolean contains(String value) {
        if (value == null) {
            return false;
        }
        boolean ret = true;
        for (SimpleHash f : func) { // 检查所有bloom 的位置  一旦发现false 就不会执行对应的hash函数
            ret = ret && bits.get(f.hash(value));
        }
        return ret;
    }

    public static class SimpleHash {

        private int cap;
        private int seed;

        public SimpleHash(int cap, int seed) {
            this.cap = cap;
            this.seed = seed;
        }

        public int hash(String value) {
            int result = 0;
            int len = value.length();
            for (int i = 0; i < len; i++) {
                result = seed * result + value.charAt(i);
            }
            return (cap - 1) & result;
        }

    }


}
