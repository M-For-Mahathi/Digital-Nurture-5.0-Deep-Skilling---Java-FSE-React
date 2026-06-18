public class SearchTest {

    public static void main(String[] args) {

        // Unsorted array for linear search
        Product[] productList = {
            new Product(104, "Keyboard", "Electronics"),
            new Product(201, "Notebook", "Stationery"),
            new Product(055, "Headphones", "Electronics"),
            new Product(312, "Desk Lamp", "Furniture"),
            new Product(178, "Mouse", "Electronics")
        };

        // Sorted array (by productId) for binary search
        Product[] sortedProductList = {
            new Product(055, "Headphones", "Electronics"),
            new Product(104, "Keyboard", "Electronics"),
            new Product(178, "Mouse", "Electronics"),
            new Product(201, "Notebook", "Stationery"),
            new Product(312, "Desk Lamp", "Furniture")
        };

        System.out.println("=== Linear Search ===");

        // Best case: target is the first element - O(1)
        Product result1 = SearchAlgorithms.linearSearch(productList, 104);
        System.out.println("Search productId 104: " + (result1 != null ? result1 : "Not found"));

        // Worst case: target is the last element or not present - O(n)
        Product result2 = SearchAlgorithms.linearSearch(productList, 312);
        System.out.println("Search productId 312: " + (result2 != null ? result2 : "Not found"));

        Product result3 = SearchAlgorithms.linearSearch(productList, 999);
        System.out.println("Search productId 999: " + (result3 != null ? result3 : "Not found"));

        System.out.println();
        System.out.println("=== Binary Search ===");

        // Best case: target is the middle element - O(1)
        Product result4 = SearchAlgorithms.binarySearch(sortedProductList, 178);
        System.out.println("Search productId 178: " + (result4 != null ? result4 : "Not found"));

        // Worst case: target is at the edge or not present - O(log n)
        Product result5 = SearchAlgorithms.binarySearch(sortedProductList, 055);
        System.out.println("Search productId 055: " + (result5 != null ? result5 : "Not found"));

        Product result6 = SearchAlgorithms.binarySearch(sortedProductList, 999);
        System.out.println("Search productId 999: " + (result6 != null ? result6 : "Not found"));

        System.out.println();
        System.out.println("=== Time Complexity Comparison ===");
        System.out.println("Linear Search  -> Best: O(1)  | Average: O(n)     | Worst: O(n)");
        System.out.println("Binary Search  -> Best: O(1)  | Average: O(log n) | Worst: O(log n)");
        System.out.println();
        System.out.println("For an e-commerce platform with a large product catalog,");
        System.out.println("binary search is more suitable due to O(log n) time complexity.");
        System.out.println("However, the product array must be sorted by productId beforehand.");
    }
}