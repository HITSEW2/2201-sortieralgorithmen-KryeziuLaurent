import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] namen = {
                "Laura", "Henry", "Zoe", "Kevin", "Sophie", "Paul", "Vanessa", "Jonas", "Mia", "David",
                "Ulrike", "Felix", "Charlotte", "Tim", "Bastian", "Greta", "Amelie", "Yvonne", "Oscar", "Hannah",
                "Lukas", "Sarah", "Dominik", "Wiebke", "Giulia", "Tobias", "Isabel", "Fabian", "Clara", "Zara",
                "Max", "Ronja", "Wolfgang", "Anna", "Quentin", "Jasmin", "Pia", "Victor", "Ben", "Xaver",
                "Emma", "Noah", "Robin", "Ian", "Nina", "Elena", "Klara", "Yannick", "Olivia", "Uwe"
        };

        Scanner sc = new Scanner(System.in);

        System.out.println("Sortiert mit InsertionSort:");
        insertionSort(namen);
        for (int i = 0; i < namen.length; i++) {
            System.out.print(namen[i]+ ", ");
        }
        System.out.println();
        System.out.println("Sortiert mit BubbleSort:");
        bubbleSort(namen);
        for (int i = 0; i < namen.length; i++) {
            System.out.print(namen[i] + ", ");
        }
        System.out.println();

        System.out.println("Gib einen Namen ein, den du suchen möchtest:");
        String gesucht = sc.nextLine();

        if (binaereSuche(namen, gesucht) >= 0) {
            System.out.println("Name '" + gesucht + "' gefunden an Position: " + binaereSuche(namen, gesucht));
        } else {
            System.out.println("Name '" + gesucht + "' nicht gefunden.");
        }

    }

    public static void insertionSort(String[] namen) {
        for (int i = 0; i < namen.length; i++) {
            String temp = namen[i];

            int j = i - 1;

            while (j >= 0 && namen[j].compareTo(temp) > 0) {
                namen[j + 1] = namen[j];
                j--;
            }
            namen[j + 1] = temp;

        }
    }

    public static void bubbleSort(String[] namen) {
        for (int i = 0; i < namen.length - 1; i++) {
            for (int j = 0; j < namen.length - i - 1; j++) {
                if (namen[j].compareTo(namen[j + 1]) > 0) {
                    String temp = namen[j];
                    namen[j] = namen[j + 1];
                    namen[j + 1] = temp;
                }
            }
        }
    }

    public static int binaereSuche(String[] namen, String gesucht) {
        int start = 0;
        int ende = namen.length - 1;

        for (; start <= ende;) {
            int mitte = (start + ende) / 2;

            if (namen[mitte].equalsIgnoreCase(gesucht)) {
                return mitte;
            } else if (namen[mitte].toLowerCase().compareTo(gesucht) < 0) {
                start = mitte + 1;
            } else {
                ende = mitte - 1;
            }
        }

        return -1;
    }

}