import java.util.Stack;

public class CreatureSorting {
    public static void main(String[] args) {
        String[] creatures = {"Dragon", "Phoenix", "Griffin", "Centaur", "Unicorn"};
        int[] powerLevels = {95, 92, 88, 85, 78};

        // Bubble Sort: Descending Order
        System.out.println("* Bubble Sort: Descending Order by Power Level *");
        bubbleSortDescending(creatures, powerLevels);
        printCreatures(creatures, powerLevels);

        // Selection Sort: Ascending Order
        System.out.println("\n*** Selection Sort: Ascending Order by Power Level *");
        selectionSortAscending(creatures, powerLevels);
        printCreatures(creatures, powerLevels);

        // Stack Implementation
        System.out.println("\n*** Stack Implementation: Popping Creatures *");
        stackPopping(creatures, powerLevels);
    }

    // Bubble Sort (Descending)
    public static void bubbleSortDescending(String[] creatures, int[] powers) {
        for (int i = 0; i < powers.length - 1; i++) {
            for (int j = 0; j < powers.length - i - 1; j++) {
                if (powers[j] < powers[j + 1]) {
                    swap(creatures, powers, j, j + 1);
                }
            }
        }
    }

    // Selection Sort (Ascending)
    public static void selectionSortAscending(String[] creatures, int[] powers) {
        for (int i = 0; i < powers.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < powers.length; j++) {
                if (powers[j] < powers[minIndex]) {
                    minIndex = j;
                }
            }
            swap(creatures, powers, i, minIndex);
        }
    }

    // Stack Implementation
    public static void stackPopping(String[] creatures, int[] powers) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < creatures.length; i++) {
            stack.push(creatures[i] + " - " + powers[i]);
        }
        while (!stack.isEmpty()) {
            System.out.println("Popped: " + stack.pop());
        }
    }

    // Utility: Swap elements
    public static void swap(String[] creatures, int[] powers, int i, int j) {
        int tempPower = powers[i];
        powers[i] = powers[j];
        powers[j] = tempPower;

        String tempCreature = creatures[i];
        creatures[i] = creatures[j];
        creatures[j] = tempCreature;
    }

    // Print creatures and power levels
    public static void printCreatures(String[] creatures, int[] powers) {
        for (int i = 0; i < creatures.length; i++) {
            System.out.println(creatures[i] + " - " + powers[i]);
        }
    }
}