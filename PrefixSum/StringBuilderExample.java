package PrefixSum;

public class StringBuilderExample {
    public static void main(String[] args) {
        String[] fruits = { "Apple", "Banana", "Cherry", "Mango" };

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < fruits.length; i++) {
            sb.append(fruits[i]);
            if (i < fruits.length - 1) {
                sb.append(", "); // add comma between items
            }
        }
        sb.append("]");

        System.out.println(sb.toString());
    }
}
