public class GenericSort {
    public static void main(String[] args) {
        GeometricObject[] arr = {new Circle(5), new Circle(8), new Rectangle(4, 3), new Rectangle(2, 4)};
        sort(arr);
        System.out.println("Sorted Geometric objects:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].toString());
        }
    }
    public static <E extends GeometricObject> void sort(E[] list) {
        E min;
        int minIndex;

        for (int i = 0; i < list.length - 1; i++) {
            min = list[i];
            minIndex = i;

            for (int j = i + 1; j < list.length; j++) {
                if (min.getArea() > list[j].getArea()) {
                    min = list[j];
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                list[minIndex] = list[i];
                list[i] = min;
            }
        }
    }
}
