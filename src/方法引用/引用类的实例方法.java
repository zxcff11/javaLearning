package 方法引用;

public class 引用类的实例方法 {
    interface UseString {
        String use(String str, int start, int length);
    }

    public static String subAuthor(String str, UseString useString) {
        int start = 0;
        int length = 1;
        return useString.use(str, start, length);
    }

    public static void main(String[] args) {
        subAuthor("北京化工大学", String::substring);
    }
}
