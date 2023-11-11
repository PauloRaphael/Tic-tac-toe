package jogoDaVelhaOOP;

import java.util.ArrayList;
import java.util.Scanner;

public class Tabuleiro {
    
    Scanner scan = new Scanner(System.in);
    boolean vitoria = false;
    String escolha = "";
    int jogada = 0;
    final char jogador1 = 'X';
    final char jogador2 = 'O';
    char[] tabuleiro = {'A', 'B', 'C',
	    				'D', 'E', 'F',
                        'G', 'H', 'I'};
    ArrayList<Integer> ocupados = new ArrayList<Integer>();

    
}
