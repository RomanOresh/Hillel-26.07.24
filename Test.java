

public class Test {
    public static void main(String[] args) {
        // Для проверки работы определения магического квадрата


        int mass[][] = {{4,14,15,1}, {9,7,6,12}, {5,11,10,8}, {16,2,3,13}}; // Магический квадрат


        System.out.println("Матрица 4х4 \n");



        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(mass[i][j] + " ");              // Вывод полученного массива/матрицы
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

        if (stroki == 6 && stolbci == 6 && diagonal == 3 && altDiagonal == 3){   // Проверка на магический квадрат
            System.out.println("\nМатрица является магическим квадратом");
        } else {
            System.out.println("\nМатрица не является магическим квадратом");
        }

    }
}

