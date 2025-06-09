import java.util.InputMismatchException;
import java.util.Scanner;

public class Sudoku {
    private static Board board;
    private static Scanner scanner;

    public static void main(String[] args) {
        board = new Board();
        scanner = new Scanner(System.in);

        // Inicializa o tabuleiro com os argumentos passados
        if (args.length > 0) {
            System.out.println("Inicializando tabuleiro com argumentos...");
            parseAndSetInitialBoard(args);
        } else {
            System.out.println("Nenhum argumento de tabuleiro inicial fornecido. Tabuleiro vazio será exibido.");
            System.out.println("Para iniciar com um quebra-cabeça, passe os argumentos na linha de comando.");
            System.out.println("Exemplo: java SudokuGame 0,0;4,false 1,0;7,false ...");
        }

        System.out.println("\nBem-vindo ao Sudoku!");
        System.out.println("Preencha o tabuleiro digitando LINHA COLUNA VALOR (ex: 0 0 5).");
        System.out.println("Digite 'sair' para encerrar o jogo.");

        gameLoop();

        System.out.println("\nObrigado por jogar!");
        scanner.close();
    }

    private static void parseAndSetInitialBoard(String[] args) {
        for (String cellData : args) {
            try {
                String[] parts = cellData.split(";");
                String[] coords = parts[0].split(",");
                String[] valueFixed = parts[1].split(",");

                int row = Integer.parseInt(coords[0].trim());
                int col = Integer.parseInt(coords[1].trim());
                int value = Integer.parseInt(valueFixed[0].trim());
                boolean isFixed = Boolean.parseBoolean(valueFixed[1].trim());

                board.setCellValue(row, col, value, isFixed);
            } catch (Exception e) {
                System.err.println("Erro ao analisar argumento: '" + cellData + "'. Certifique-se de que o formato é 'linha,coluna;valor,isFixo'.");
                System.err.println("Detalhes do erro: " + e.getMessage());
            }
        }
    }

    private static void gameLoop() {
        while (true) {
            board.printBoard();

            if (board.isBoardSolved()) {
                System.out.println("\nParabéns! Você resolveu o Sudoku!");
                break;
            }

            System.out.print("\nSua jogada (linha coluna valor) ou 'sair': ");
            String inputLine = scanner.nextLine().trim();

            if (inputLine.equalsIgnoreCase("sair")) {
                break;
            }

            try {
                String[] parts = inputLine.split(" ");
                if (parts.length != 3) {
                    System.out.println("Formato inválido. Por favor, digite LINHA COLUNA VALOR (ex: 0 0 5).");
                    continue;
                }

                int row = Integer.parseInt(parts[0]);
                int col = Integer.parseInt(parts[1]);
                int value = Integer.parseInt(parts[2]);

                // Valida as coordenadas e o valor
                if (row < 0 || row >= 9 || col < 0 || col >= 9 || value < 0 || value > 9) {
                    System.out.println("Valores fora do intervalo permitido (0-8 para linha/coluna, 0-9 para valor).");
                    System.out.println("Use 0 para limpar uma célula.");
                    continue;
                }

                if (board.isCellFixed(row, col)) {
                    System.out.println("Esta célula é um número inicial do quebra-cabeça e não pode ser alterada.");
                    continue;
                }

                if (value != 0 && !board.isValidMove(row, col, value)) {
                    System.out.println("Movimento inválido! O número " + value + " não pode ser colocado em (" + row + ", " + col + ").");
                    continue;
                }

                // Se tudo estiver certo, faz a jogada
                board.setCellValue(row, col, value, false); // Jogadas do usuário não são fixas

            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Certifique-se de digitar números para linha, coluna e valor.");
            } catch (Exception e) {
                System.out.println("Ocorreu um erro: " + e.getMessage());
            }
        }
    }
}