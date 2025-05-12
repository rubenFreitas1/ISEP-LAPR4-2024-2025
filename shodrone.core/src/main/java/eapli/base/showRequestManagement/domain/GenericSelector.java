package eapli.base.showRequestManagement.domain;

import eapli.framework.io.util.Console;

import java.util.ArrayList;
import java.util.List;

public class GenericSelector {

    public static <T> T selectItem(Iterable<T> items, ItemPrinter<T> printer, String prompt) {
        List<T> itemList = new ArrayList<>();
        items.forEach(itemList::add);

        if (itemList.isEmpty()) {
            System.out.println("No items available.");
            return null;
        }

        System.out.println(prompt);

        for (int i = 0; i < itemList.size(); i++) {
            System.out.printf("%d - %s%n", i + 1, printer.print(itemList.get(i)));
        }

        int choice = -1;
        while (choice < 1 || choice > itemList.size()) {
            choice = Console.readInteger("Enter your choice : ");
        }

        return itemList.get(choice - 1);
    }

    public interface ItemPrinter<T> {
        String print(T item);
    }
}