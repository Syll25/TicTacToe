package syll25.tictactoe.logic.state;

/*
1. przepisać na record
2. dorobić PlayerDTO opakowujące dane dla konkretnego gracza
3. przekształcić size w metodę, która wylicza rozmiar na podstawie tablicy board
 */
public class StateDTO {
    public String player1Name;
    public String player2Name;
    public String player1Sign;
    public String player2Sign;
    public String[][] board;
    public int size;

}
