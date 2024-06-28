package org.example;

public class Board {
            private final char[][] cells;


            public Board() {
                this.cells = new char[3][3];
            }

            public boolean isCellEmpty(int x, int y) {
                return this.cells[x][y] == ' ';
            }

            public void place(int x, int y, char marker) {
                if (isCellEmpty(x, y)) {
                    this.cells[x][y] = marker;
                }
            }

            public boolean isFull() {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (cells[i][j] == ' ') {
                            return false;
                        }
                    }
                }
        return true;
    }

    public void clear() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = ' ';
            }
        }
    }

    public void print() {
        System.out.println("-------");
        for (int i = 0; i < 3; i++) {
            System.out.println("|" + cells[i][0] + "|" + cells[i][1] + "|" + cells[i][2] + "|");
            if (i == 2) {
                System.out.println("-------");
            }
        }
    }
}
