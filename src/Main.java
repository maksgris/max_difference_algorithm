import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class Main {

    static ZipFile zipFile;

    static {
        try {
            zipFile = new ZipFile("S:/Java Projects/max_difference_algorithm/src/pd1_data.zip");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static int maxDiff(ArrayList<Integer> arr) { // Bruteforce method, complexity = n(n-1)/2 * O(1) = O(n^2)
        int maxDiff = -1;
        int n = arr.size();
        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n; j++)
                if (arr.get(j) > arr.get(i)) {
                    maxDiff = Math.max(maxDiff, arr.get(j) - arr.get(i));
                }
        return maxDiff;
    }

    public static void main(String[] args) throws IOException {

        Enumeration<? extends ZipEntry> entries = zipFile.entries();

        if (entries.hasMoreElements()) {
            ZipEntry entry = entries.nextElement();
            InputStream stream = zipFile.getInputStream(entry);
            Scanner scanner = new Scanner(stream);
            ArrayList<Integer> numbers = new ArrayList<>();
            while (scanner.hasNextInt())
                numbers.add(scanner.nextInt());


            System.out.println("Maximum difference in an array is = " + maxDiff(numbers) + "\n");


            /*for (int number : numbers)
                System.out.print(number + " ");*/


            stream.close();
        }

    }
}
