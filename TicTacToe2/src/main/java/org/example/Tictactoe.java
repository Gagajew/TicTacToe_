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

    public void switchCurrentPlayer() {
        this.currentPlayer = (this.currentPlayer == this.player1) ? this.player2 : this.player1;
        //Die Spieler werden gewechselt

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
            board.place(row, col, currentPlayer.getMarker());
            winner = checkForWinner();
            switchCurrentPlayer();
        }

        if (!winner) {
            System.out.println("Wow...its a draw!");
        }
        System.out.println("Do you want to play again? (Y/N)");
        String playAgain = scanner.next();
    
        if (playAgain.equalsIgnoreCase("y")) {
            System.out.println("Great");
            start();
        } else if (playAgain.equalsIgnoreCase("n")) {
            System.out.println("Okay then...goodbye!");
            scanner.close();
        }
    }

        public boolean checkForWinner() {
            boolean winner = false;

            if (board.checkWin(currentPlayer.getMarker())) {
                winner = true;
                this.board.print();
                System.out.println("Player " + this.currentPlayer.getMarker() + " won!");
            }
            return winner;
        }

    }
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
        hasWinner();
    }

    public void switchCurrentPlayer() {
        this.currentPlayer = (this.currentPlayer == this.player1) ? this.player2 : this.player1;
        //Die Spieler werden gewechselt

    }

    public void hasWinner() { //Methode zur Überprüfung, ob es einen Gewinner gibt und wer gewonnen hat
        Scanner scanner = new Scanner(System.in);
        boolean winner = false;


        while (!board.isFull() && !winner) { //während das Board leer ist und es keinen Gewinner gibt
            this.board.print(); //wird das Board dargestellt
            System.out.println("Current player: " + this.currentPlayer.getMarker()); //der Spieler, der an der Reihe ist, wird angezeigt

            int row, col; //Spalte und Reihe definiert als Integer
            while (true) {
                System.out.print("Enter row (0, 1, 2):"); //Ausgabe des Textes in der Klammer
                row = scanner.nextInt(); //Eingabe der Reihe
                System.out.print("Enter col (0, 1, 2):");
                col = scanner.nextInt(); //Eingabe der Zeile

                if (row >= 0 && row < 3 && col >= 0 && col < 3 && board.isCellEmpty(row, col)) { //wenn der eingegebene Wert innerhalb der Matrix liegt und das Feld leer ist
                    break; //wird die Schleife aufgehalten
                } else {
                    System.out.println("Invalid input! Please try again."); //sonst kommt die Meldung
                }
            }
            board.place(row, col, currentPlayer.getMarker()); //marker wird entsprechend gesetzt
            switchCurrentPlayer();
        }
    }
}
