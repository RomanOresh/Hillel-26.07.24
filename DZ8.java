import java.util.Random;

public class DZ8 {

    public static void main(String[] args) {

        int mass[][] = new int[4][4];        // Создание нового массива 4х4
        Random rand  = new Random();

        System.out.println("Матрица 4х4 \n");

        int sumPar = 0;
        int sumNePar = 0;
        long dobPar = 1;
        long dobNePar = 1;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                mass[i][j] = rand.nextInt(1, 50);   // Заполнение массива 4х4 рандомными числами от 1 до 50
                System.out.print(mass[i][j] + " ");              // Вывод полученного массива/матрицы

                if (i == 0 || i == 2 ){                          // Подсчёт суммы парных и непарных рядков
                    sumPar += mass[i][j];
                }else {
                    sumNePar += mass[i][j];
                }

                if (j == 0 || j == 2 ){                          // Подсчёт произведения парных и непарных столбцов
                    dobPar *= mass[i][j];
                }else {
                    dobNePar *= mass[i][j];
                }
            }
            System.out.println(" ");
        }

        int stroki = 0;
        int stolbci = 0;
        int diagonal = 0;
        int diagonalSum = 0;
        int altDiagonal = 0;
        int altDiagonalSum = 0;

        for (int i = 0; i < 4; i++) {
            int strSum = 0;
            int stlbSum = 0;

            diagonalSum += mass[i][i];             // Подсчёт диагонали
            altDiagonalSum += mass[i][4 - i - 1];  // Подсчёт суммы альтернативной диагонали

            for (int j = 0; j < 4; j++) {
                strSum += mass[j][i];              // Подсчёт суммы каждой строки
                stlbSum += mass[i][j];             // Подсчёт суммы каждого столбца
            }
            if (strSum == 4 * (4 * 4 + 1)/2) {     // Формула для определения магической константы
                stroki += i;                       // Если сумма индексов строк == 6, то они магические, и сумма каждой строки 34
            }
            if (stlbSum == 4 * (4 * 4 + 1)/2){     // Если сумма индексов столбцов == 6, то они магические, и сумма каждого столбца 34
                stolbci += i;
            }
            if (diagonalSum == 4 * (4 * 4 + 1)/2){ // Проверка по диагонали
                diagonal += i;
            }
            if (altDiagonalSum == 4 * (4 * 4 +1)/2){ // Проверка по альтернативной диагонали
                altDiagonal += i;
            }

        }

        System.out.println("\nСумма элементов в парных рядах (0,2): " + sumPar);
        System.out.println("Сумма элементов в непарных рядах (1,3): " + sumNePar);
        System.out.println("Произведение элементов в парных столбцах (0,2): " + dobPar);
        System.out.println("Произведение элементов в непарных столбцах (1,3): " + dobNePar);

        if (stroki == 6 && stolbci == 6 && diagonal == 3 && altDiagonal == 3){   // Проверка на магический квадрат
            System.out.println("\nМатрица является магическим квадратом");
        } else {
            System.out.println("\nМатрица не является магическим квадратом");
        }



    }
}

