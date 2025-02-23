import java.util.*;

class InventoryItem implements Comparable<InventoryItem> {

    int id;
    String name;
    int quantity;

    public InventoryItem(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public int compareTo(InventoryItem other) {
        return Integer.compare(this.id, other.id);
    }

}

class Inventory {

    private ArrayList<InventoryItem> items = new ArrayList<>();

    public void addItem(InventoryItem item) {
        items.add(item);
    }

    public void removeItem(int id) {
        int index = binarySearch(items, id);
        if (index != -1) {
            items.remove(index);
        } else {
            System.out.println("Item not found");
        }
    }

    public void updateQuantity(int id, int quantity) {
        int index = binarySearch(items, id);
        if (index != -1) {
            InventoryItem item = items.get(index);
            item.quantity = quantity;
        } else {
            System.out.println("Item not found");
        }
    }

    public int binarySearch(ArrayList<InventoryItem> items, int key) {
        int low = 0;
        int high = items.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (key < items.get(mid).id) {
                high = mid - 1;
            } else if (key > items.get(mid).id) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public void bubbleSort() {
        for (int i = 0; i < items.size()-1; i++) {
            for (int j = 0; j < items.size()-i-1; j++) {
                if (items.get(j).id > items.get(j+1).id) {
                    InventoryItem temp = items.get(j);
                    items.set(j, items.get(j+1));
                    items.set(j+1, temp);
                }
            }
        }
    }

    public void printInventoryReport() {
        for (InventoryItem item : items) {
            System.out.println(item.name + ": " + item.quantity);
        }
    }


    public static void main(String[] args) {

        Inventory inv = new Inventory();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("Select option:");
            System.out.println("1. Add item");
            System.out.println("2. Remove item");
            System.out.println("3. Update quantity");
            System.out.println("4. Print report");
            System.out.println("5. Quit");

            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter item id: ");
                int id = sc.nextInt();
                System.out.print("Enter name: ");
                String name = sc.next();
                System.out.print("Enter quantity: ");
                int qty = sc.nextInt();

                InventoryItem item = new InventoryItem(id, name, qty);
                inv.addItem(item);

            } else if (choice == 2) {
                System.out.print("Enter item id to remove: ");
                int id = sc.nextInt();
                inv.removeItem(id);

            } else if (choice == 3) {
                System.out.print("Enter item id: ");
                int id = sc.nextInt();
                System.out.print("Enter new quantity: ");
                int qty = sc.nextInt();
                inv.updateQuantity(id, qty);

            } else if (choice == 4) {
                inv.bubbleSort();
                inv.printInventoryReport();

            } else if (choice == 5) {
                break;
            }
        }

        sc.close();

    }

}