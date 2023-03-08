import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList();
        list.add("Молоко");
        list.add("Хлеб");
        list.add("Сыр");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Выберите операцию: ");
            String line = scanner.nextLine();
            int value = Integer.parseInt(line);
            if (value == 1) {
                addProduct(list, scanner);
            }
            if (value == 2) {
                searchProduct(list);
            }
            if (value == 3) {
                searchProduct(list);
                System.out.println("Какую покупку хотите удалить? Введите номер или название");
                String productDelete = scanner.nextLine();
                try {
                    int productDeleteInt = Integer.parseInt(productDelete);
                    productDelete = list.get(productDeleteInt - 1);
                    list.remove(productDeleteInt - 1);
                } catch (NumberFormatException e) {
                    if (list.contains(productDelete)) {
                        list.remove(productDelete);
                    }
                }
                System.out.println("Покупка " + productDelete + " удалена из вашего списка");
                for (int i = 0; i < list.size(); i++) {
                    System.out.println((i + 1) + ". " + list.get(i));
                }
            }
        }
    }

    private static void searchProduct(ArrayList<String> list) {
        System.out.println("Список покупок: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + 1 + ". " + list.get(i));
        }
    }

    private static void addProduct(ArrayList<String> list, Scanner scanner) {
        System.out.print("Какую покупку хотите добавить?");
        String product = scanner.nextLine();
        list.add(product);
        System.out.print("Итого в списке покупок: " + list.size());
    }
}




