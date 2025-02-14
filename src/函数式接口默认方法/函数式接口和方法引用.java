package 函数式接口默认方法;

public class 函数式接口和方法引用 {
    public static void main(String[] args) {
        // 使用 Lambda 表达式
        Printer printerLambda = System.out::println;
        printerLambda.printMessage("hello, world");

        // 使用方法引用简化 Lambda 表达式
        Printer printerMethodRef = PrinterService::printUpperCase;  // 方法引用
        printerMethodRef.printMessage("hello, world");
    }
}
