public class Board {
    private final Cell[][] board;
    private final int SIZE = 9;
    private final int SUBGRID_SIZE = 3;

    public Board() {
        this.board = new Cell[SIZE][SIZE];
        // Inicializa todas as células como vazias (0) e não fixas
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = new Cell(0, false);
            }
        }
    }

    public void setCellValue(int row, int col, int value, boolean isFixed) {
        if (isValidCoordinate(row, col) && isValidValue(value)) {
            board[row][col] = new Cell(value, isFixed);
        } else {
            System.out.println("Coordenada ou valor inválido para setCellValue: (" + row + ", " + col + ") = " + value);
        }
    }

    public int getCellValue(int row, int col) {
        if (isValidCoordinate(row, col)) {
            return board[row][col].getValue();
        }
        return -1; // Valor inválido ou erro
    }

    public boolean isCellFixed(int row, int col) {
        if (isValidCoordinate(row, col)) {
            return board[row][col].isFixed();
        }
        return false; // Coordenada inválida
    }

    // Valida se a coordenada está dentro dos limites do tabuleiro
    private boolean isValidCoordinate(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE;
    }

    // Valida se o valor está entre 1 e 9
    private boolean isValidValue(int value) {
        return value >= 0 && value <= SIZE; // 0 para células vazias
    }

    // Verifica se um número pode ser colocado em uma dada célula sem violar as regras
    public boolean isValidMove(int row, int col, int value) {
        // Verifica linha
        for (int c = 0; c < SIZE; c++) {
            if (c != col && board[row][c].getValue() == value) {
                return false;
            }
        }

        // Verifica coluna
        for (int r = 0; r < SIZE; r++) {
            if (r != row && board[r][col].getValue() == value) {
                return false;
            }
        }

        // Verifica subgrade 3x3
        int startRow = row - row % SUBGRID_SIZE;
        int startCol = col - col % SUBGRID_SIZE;
        for (int r = startRow; r < startRow + SUBGRID_SIZE; r++) {
            for (int c = startCol; c < startCol + SUBGRID_SIZE; c++) {
                if (r != row || c != col) { // Evita comparar a própria célula
                    if (board[r][c].getValue() == value) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // Verifica se o tabuleiro está completamente preenchido e é válido
    public boolean isBoardSolved() {
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                int value = board[r][c].getValue();
                if (value == 0 || !isValidMove(r, c, value)) {
                    return false; // Tabuleiro não preenchido ou com movimentos inválidos
                }
            }
        }
        return true; // Todos os espaços preenchidos e válidos
    }


    // Imprime o tabuleiro no terminal
    public void printBoard() {
        System.out.println("-------------------------");
        for (int r = 0; r < SIZE; r++) {
            System.out.print("|");
            for (int c = 0; c < SIZE; c++) {
                int value = board[r][c].getValue();
                String displayValue = (value == 0) ? " " : String.valueOf(value);
                System.out.print(" " + displayValue + (board[r][c].isFixed() ? "*" : " ")); // Adiciona * para números fixos
                if ((c + 1) % SUBGRID_SIZE == 0) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if ((r + 1) % SUBGRID_SIZE == 0 && (r + 1) != SIZE) {
                System.out.println("-------------------------");
            }
        }
        System.out.println("-------------------------");
    }
}