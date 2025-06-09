# Sudoku em Java (Versão Terminal)

Este repositório contém uma implementação do clássico jogo Sudoku, desenvolvido em Java para ser executado no terminal. O projeto foi criado como parte de um desafio da Digital Innovation One (DIO), focado em aplicar conceitos de programação orientada a objetos e lógica de jogo.

---

## 🚀 Funcionalidades

* **Tabuleiro Interativo**: Exibe o tabuleiro de Sudoku no terminal, permitindo que o jogador insira jogadas.
* **Validação de Movimentos**: Verifica se cada jogada é válida de acordo com as regras do Sudoku (linhas, colunas e subgrids 3x3).
* **Células Fixas**: Distingue entre números iniciais do quebra-cabeça (fixos) e números inseridos pelo jogador.
* **Detecção de Vitória**: Informa ao jogador quando o Sudoku é resolvido corretamente.
* **Entrada de Dados por Argumentos**: O tabuleiro inicial pode ser carregado passando argumentos na linha de comando.

---

## 🛠️ Tecnologias Utilizadas

* **Java**: Linguagem de programação principal.
* **Git & GitHub**: Para controle de versão e hospedagem do código.

---

## 📂 Estrutura do Projeto

O projeto está organizado nas seguintes classes:

* `Cell.java`: Representa uma única célula do tabuleiro, armazenando seu valor e se é uma célula fixa (inicial do jogo).
* `Board.java`: Gerencia a lógica do tabuleiro 9x9, incluindo a inicialização, a configuração de valores de células e a validação de movimentos.
* `Sudoku.java`: Contém o método `main`, lida com a entrada do usuário, exibe o tabuleiro e controla o fluxo geral do jogo.

---

## 🎮 Como Jogar

Siga os passos abaixo para compilar e executar o jogo no seu terminal.

1.  **Clone o Repositório:**
    Comece clonando este repositório para sua máquina local:

    ```bash
    1. git clone https://github.com/GeovanniMarques/sudoku.git
    2. Importe o projeto para sua IDE (Eclipse ou VS Code).
    3. Execute a classe `Main.java`.
    ```

2.  **Compile o Código:**
    Compile os arquivos Java usando o compilador `javac`:

    ```bash
    javac Cell.java Board.java Sudoku.java
    ```

3.  **Execute o Jogo:**
    Você pode executar o jogo passando o estado inicial do tabuleiro como argumentos de linha de comando. Recomenda-se usar os argumentos fornecidos pela DIO para um quebra-cabeça predefinido:

    ```bash
    java Sudoku 0,0;4,false 1,0;7,false 2,0;9,true 3,0;5,false 4,0;8,true 5,0;6,true 6,0;2,true 7,0;3,false 8,0;1,false 0,1;1,false 1,1;3,true 2,1;5,false 3,1;4,true 5,1;2,false 6,1;8,false 7,1;9,true 8,1;6,true 0,2;2,false 1,2;6,true 2,2;8,false 3,2;9,false 4,2;1,true 5,2;3,false 6,2;7,false 7,2;4,false 8,2;5,true 0,3;5,true 1,3;1,false 2,3;3,true 3,3;7,false 4,3;6,false 5,3;4,false 6,3;9,false 7,3;8,true 8,3;2,false 0,4;8,false 1,4;9,true 2,4;7,false 3,4;1,true 4,4;2,true 5,4;5,true 6,4;3,false 7,4;6,true 8,4;4,false 0,5;6,false 1,5;4,true 2,5;2,false 3,5;3,false 4,5;9,false 5,5;8,false 6,5;1,true 7,5;5,false 8,5;7,true 0,6;7,true 1,6;5,false 2,6;4,false 3,6;2,false 4,6;3,true 5,6;9,false 6,6;6,false 7,6;1,true 8,6;8,false 0,7;9,true 1,7;8,true 2,7;1,false 3,7;6,false 4,7;4,true 5,7;7,false 6,7;5,false 7,7;2,true 8,7;3,false 0,8;3,false 1,8;2,false 2,8;6,true 3,8;8,true 4,8;5,true 5,8;1,false 6,8;4,true 7,8;7,false 8,8;9,false
    ```
    (Note que a linha de comando para execução é longa. Copie e cole **toda** a sequência de argumentos sem quebras de linha para garantir a correta inicialização do tabuleiro.)

4.  **Faça Suas Jogadas:**
    Após o tabuleiro ser exibido, você pode fazer suas jogadas digitando a **linha**, **coluna** e o **valor** separados por espaços (ex: `0 0 5`). As linhas e colunas são indexadas de 0 a 8. Para limpar uma célula, insira `0` como valor.

    ```
    Sua jogada (linha coluna valor) ou 'sair': 0 0 5
    ```

5.  **Encerrar o Jogo:**
    Digite `sair` a qualquer momento para sair do jogo.

---

## ✍️ Autor

Desenvolvido por **Geovanni Marques** 🚀  
Conecte-se comigo no [LinkedIn](https://www.linkedin.com/in/geovanni-marques/)