import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;


public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int[][] mes = new int[30][2];
       int maxTemp = 0, minTemp = 999, varTemp = 0, varSoma = 0, a = 0, b = 0,
                         hoje = 0, qtdQuente = 0, ontem = 0;

        for (int l = 0; l < 30; l++) {
            for (int c = 0; c < 2; c++) {
                mes[l][c] = random.nextInt(45);
                if (mes[l][c] > maxTemp)
                    maxTemp = mes[l][c];
                if (mes[l][c] < minTemp)
                    minTemp = mes[l][c];
                a = mes[l][0];
                b = mes[l][1];
                if (a > b) {
                    varSoma = a - b;
                } else {
                    varSoma = b - a;
                }

            }

            if (varSoma > varTemp)
                varTemp = l;
        }

        for (int l = 0; l < 30; l++) {
            int indexOntem = l -1;
            if (l > 1) {
                ontem = Math.max(mes[indexOntem][0], mes[indexOntem][1]);
                hoje = Math.max(mes[l][0], mes[l][1]);
            }

            if (hoje > ontem && l != 1) {
                qtdQuente++;

            }
        }


        for (int l = 0; l < 30; l++) {
            System.out.printf("Dia %d = ", l + 1);
            for (int c = 0; c < 2; c++) {
                System.out.printf("[%d] ", mes[l][c]);
                a = mes[l][0];
                b = mes[l][1];
            }
            System.out.print(" Media = " + (a + b) / 2);
            System.out.println();
            a = 0;
            b = 0;
        }
        System.out.println("Temperatura Maxima = " + maxTemp);
        System.out.println("Temperatura Minima = " + minTemp);
        System.out.println("Dia com maior variação entre mínima e máxima = " + varTemp);
        System.out.println("Quantidade de dias mais quentes do que o dia anterior = " + qtdQuente);


        sc.close();
    }
}



