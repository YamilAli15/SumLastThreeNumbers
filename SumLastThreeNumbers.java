import java.util.ArrayList;
import java.util.List;

public class SumLastThreeNumbers {
    public static void main(String[] args) {
        // Inicializamos los primeros 3 números (solo últimos 4 dígitos)
        int num1 = 2023 % 10000, num2 = 2024 % 10000, num3 = 2025 % 10000;

        // Lista para detectar ciclos
        List<Integer> sequence = new ArrayList<>();

        // Agregamos los primeros números a la secuencia
        sequence.add(num1);
        sequence.add(num2);
        sequence.add(num3);

        while (true) {
            int next = (num1 + num2 + num3) % 10000; // Calculamos los últimos 4 dígitos

            // Si el ciclo se repite, detenemos el cálculo
            if (sequence.contains(next)) {
                break;
            }

            sequence.add(next);

            // Actualizamos los números para la siguiente iteración
            num1 = num2;
            num2 = num3;
            num3 = next;
        }

        // Encontramos el tamaño del ciclo
        int cycleLength = sequence.size();

        // Posición objetivo (mod ciclo)
        long position = 2023202320232023L % cycleLength;

        // Obtenemos el número correspondiente
        int result;
        if (position == 0) {
            result = sequence.get(cycleLength - 1); // Último elemento del ciclo
        } else {
            result = sequence.get((int) position - 1); // -1 porque las listas empiezan desde 0
        }

        // Imprimimos el resultado
        System.out.println("Los últimos 4 dígitos son: " + result);
    }
}
