import java.io.*;
import java.util.Arrays;

public class RadixSort {

    static int getMax(int[] arr, int n) {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx) mx = arr[i];
        return mx;
    }

    static void countSort(int[] arr, int n, int exp) {
        int[] output = new int[n];
        int[] count = new int[10];
        Arrays.fill(count, 0);

        for (int i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        for (int i = 0; i < n; i++)
            arr[i] = output[i];
    }

    static void ordenar(int[] arr, int n) {
        int m = getMax(arr, n);
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("entrada_radixsort.txt"));
            String linea = br.readLine();
            br.close();

            if (linea != null) {
                String[] partes = linea.split(",");
                int[] numeros = new int[partes.length];
                for (int i = 0; i < partes.length; i++) {
                    numeros[i] = Integer.parseInt(partes[i].trim());
                }

                ordenar(numeros, numeros.length);

                BufferedWriter bw = new BufferedWriter(new FileWriter("salida_radixsort.txt"));
                bw.write("RadixSort Resultado: " + Arrays.toString(numeros));
                bw.close();

                System.out.println("Proceso RadixSort terminado.");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}