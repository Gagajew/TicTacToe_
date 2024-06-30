package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertSame;

public class TictactoeTest {
    private Tictactoe game;

    @BeforeEach
    public void setUp() {
        game = new Tictactoe();
    }

    @Test
    public void testSwitchCurrentPlayerToPlayer2() {
        game.currentPlayer = game.player1;
        game.switchCurrentPlayer();
        assertSame(game.player2, game.currentPlayer, "Current player should be switched to player 2");
    }

    @Test
    public void testSwitchCurrentPlayerBackToPlayer1() {
        game.currentPlayer = game.player2;
        game.switchCurrentPlayer();
        assertSame(game.player1, game.currentPlayer, "Current player should be switched back to player 1");
    }

    @Test
    public void testHasWinnerWhenPlayerWins() {
        // Setze das Board manuell auf einen Gewinnzustand für Spieler 1
        game.board.place(0, 0, 'X');
        game.board.place(0, 1, 'X');
        game.board.place(0, 2, 'X');
        game.currentPlayer = game.player1;

        game.hasWinner();
        // Annahme: hasWinner gibt eine Art von Ausgabe, die Sie prüfen können,
        // oder ändert den Spielzustand, den Sie überprüfen können
        // Dieser Test könnte an Ihre Implementierung angepasst werden.
    }

    @Test
    public void testHasWinnerWhenNoWinner() {
        // Kein Spieler hat gewonnen; das Board ist nicht voll
        game.board.place(0, 0, 'X');
        game.board.place(0, 1, 'O');
        game.board.place(0, 2, 'X');

        game.hasWinner();
        // Überprüfe auf Unentschieden oder fortlaufendes Spiel
        // Dieser Test könnte an Ihre Implementierung angepasst werden.
    }
}
