package Basic_Interface;
import java.util.function.Supplier;

public class SupplierExample {
    static void main(String[] args) {
        Supplier<String> s = new Supplier<String>() {
            @Override
            public String get() {
                return "Supplier Inner Class";
            }
        };
        System.out.println(s.get());
    }
}
// Supplier s1 = () -> "Suppplier Lamda ";
// System.out.printl(s1.get());
