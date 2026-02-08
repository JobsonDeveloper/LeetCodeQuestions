package Find_Smallest_Letter_Greater_Than_Target;

public class Code {
    public static void main(String[] args) {
        char[] letters = new char[]{'f', 'g', 'h', 'i', 'j', 'k', 'l'};
        char target = 'h';
        char letter = nextGreatestLetter(letters, target);

        System.out.println("-------------------");
        System.out.println("Letra: " + letter);
        System.out.println("-------------------");
    }

    // Método que recebe:
    // - letters: array de caracteres ORDENADO
    // - target: caractere que queremos superar
    public static char nextGreatestLetter(char[] letters, char target) {
        // Ponteiro do início do array
        int left = 0;
        // Ponteiro do fim do array
        int right = letters.length - 1;

        // Enquanto ainda existir um intervalo válido de busca
        while (left <= right) {
            // Calcula o índice do meio
            // Forma segura para evitar overflow
            int mid = left + (right - left) / 2;
            System.out.println("-----------------");
            System.out.println("Mid: " + letters[mid]);

            // Se o caractere do meio for MENOR OU IGUAL ao target
            // ele NÃO SERVE, pois precisamos de algo MAIOR
            if (letters[mid] <= target) {

                // Ignoramos o lado esquerdo (inclusive o mid)
                // e continuamos procurando à direita
                left = mid + 1;
                System.out.println(left + ": left : " + letters[left]);
            } else {
                // Se letters[mid] > target
                // encontramos um possível candidato
                // mas pode existir outro menor ainda à esquerda
                right = mid - 1;
                System.out.println(right + ": right : " + letters[right]);
            }
        }

        // Quando o loop termina:
        // - left aponta para o PRIMEIRO caractere MAIOR que target
        // - OU left == letters.length (não achou nenhum)

        System.out.println("------------");
        System.out.println("letters[left % letters.length]: " + letters[left % letters.length]);
        // O % garante o "volta ao início" (wrap around)
        return letters[left % letters.length];
    }
}
