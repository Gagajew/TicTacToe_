package org.example;

import java.util.Scanner;

public class Tictactoe {
    Player player1; //Variable player1 vom Typ Player
    Player player2; //Variable player2 vom Typ Player
    Player currentPlayer; //Variable currentPlayer vom Typ Player
    Board board; //Variable board vom Typ Board

    public Tictactoe() { //public Konstruktor Tictactoe
        this.player1 = new Player('X'); //marker X für player1 zugewiesen
        this.player2 = new Player('O'); //marker O für player2 zugewiesen
        this.currentPlayer = this.player1; //erster Spieler ist player1
        this.board = new Board(); //dem Board wird die Methode Board() zugewiesen
    }

    public void start() {
        System.out.println("The game has started!");
        this.board.clear(); // Das Board ist leer beim Spielstart
        playGame();
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        boolean winner = false;

        while (!board.isFull() && !winner) {
            this.board.print();
            System.out.println("Current player: " + this.currentPlayer.getMarker());

            int row, col;
            while (true) {
                System.out.print("Enter row (0, 1, 2):");
                row = scanner.nextInt();
                System.out.print("Enter col (0, 1, 2):");
                col = scanner.nextInt();

                if (row >= 0 && row < 3 && col >= 0 && col < 3 && board.isCellEmpty(row, col)) {
                    break;
                } else {
                    System.out.println("Invalid input! Please try again.");
                }
            }
        }
    }
}
