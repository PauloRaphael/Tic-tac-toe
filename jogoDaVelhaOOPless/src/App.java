import java.util.ArrayList;
import java.util.Scanner;

public class App {
    
  public static Scanner scan = new Scanner(System.in);
    
  public static void main(String[] args) {

        boolean vitoria = false;
        String escolha = "";
        int jogada = 0;
        final char jogador1 = 'X';
        final char jogador2 = 'O';
        char[] tabuleiro = {'A', 'B', 'C',
    	    				'D', 'E', 'F',
                            'G', 'H', 'I'};
        ArrayList<Integer> ocupados = new ArrayList<Integer>();
        System.out.println("X começa!");
        
        mostrarTabuleiro(tabuleiro);
        
        try{
            while(!vitoria) {
                
                if(fazerJogada(escolha, jogada, jogador1, tabuleiro, ocupados)) {
                    mostrarTabuleiro(tabuleiro);
                    vitoria = checarVitoria(tabuleiro);
                    if(vitoria == true) {
                        System.out.println();
                        System.out.println("O jogadores com os X's ganhou!");
                        mostrarTabuleiro(tabuleiro);
                        break;
                    }
                }

                if(fazerJogada(escolha, jogada, jogador2, tabuleiro, ocupados)) {
                    mostrarTabuleiro(tabuleiro);
                    vitoria = checarVitoria(tabuleiro);
                    if(vitoria == true) {
                        System.out.println();
                        System.out.println("O jogadores com os O's ganhou!");
                        mostrarTabuleiro(tabuleiro);
                        break;
                    }
                }
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        
        if(!vitoria) {
            System.out.println("Ih, deu velha");
        }

    }
    
    public static void mostrarTabuleiro(char[] tabuleiro) {
        
        int counter = 0;
       
        System.out.println();
        for(char lugar : tabuleiro) {
   		    System.out.print(" | " + lugar);
            if(counter == 2 || counter == 5 || counter == 8) {
        	    System.out.println(" | ");
            }
            if(counter == 2 || counter == 5) {
                System.out.println(" -------------");
            }
        counter++;
        }
    }

    public static boolean fazerJogada(String escolha, int jogada, char jogador, char[] tabuleiro, ArrayList<Integer> ocupados) throws InterruptedException{
        
        boolean jogadaValida = false;
    
        System.out.println();
        
        while(!jogadaValida) {
                
            System.out.println("Escolha a posição que deseja jogar: ");
                
            escolha = scan.nextLine();
            escolha = escolha.toUpperCase();
                
            switch(escolha) {
                case "A":
                    jogada = 0;
                    jogadaValida = true;
                    break;
                case "B":
                    jogada = 1;
                    jogadaValida = true;
                    break;
                case "C":
                    jogada = 2;
                    jogadaValida = true;
                    break;
                case "D":
                    jogada = 3;
                    jogadaValida = true;
                    break;
                case "E":
                    jogada = 4;
                    jogadaValida = true;
                    break;
                case "F":
                    jogada = 5;
                    jogadaValida = true;
                    break;
                case "G":
                    jogada = 6;
                    jogadaValida = true;
                    break;
                case "H":
                    jogada = 7;
                    jogadaValida = true;
                    break;
                case "I":
                    jogada = 8;
                    jogadaValida = true;
                    break;
                default:
                    jogadaValida = false;
                    System.out.println("Escolha uma posição valida!");
                    Thread.sleep(2500);
                    System.out.println();
                    mostrarTabuleiro(tabuleiro);
                    jogada = 0;
                break;
            }

            if(checarOcupados(jogada, ocupados) && ocupados.size() > 0) {
                System.out.println("Essa posição ja está ocupada!");
                Thread.sleep(2500);
                mostrarTabuleiro(tabuleiro);
                System.out.println();
                jogadaValida = false;
                
            } else {
                tabuleiro[jogada] = jogador;
                ocupados.add(jogada);
            }

            
        }
        return jogadaValida;
            
    }

    public static boolean checarOcupados(int jogada, ArrayList<Integer> ocupados) {

        for(int ocupado : ocupados) {
            if(ocupado == jogada) {
                return true;
            } 
        }
        return false;
    }
    
    public static boolean checarVitoria(char tabuleiro[]){
        
        //vitoria vertical
        if(tabuleiro[0] == tabuleiro[3] && tabuleiro[3] == tabuleiro[6]) {
            return true;
        } else if(tabuleiro[1] == tabuleiro[4] && tabuleiro[4] == tabuleiro[7]) {
            return true;
        } else if(tabuleiro[2] == tabuleiro[5] && tabuleiro[5] == tabuleiro[8]) {
            return true;
        }
        
        //vitoria horizontal 
        if(tabuleiro[0] == tabuleiro[1] && tabuleiro[1] == tabuleiro[2]) {
            return true;
        } else if(tabuleiro[3] == tabuleiro[4] && tabuleiro[4] == tabuleiro[5]) {
            return true;
        } else if(tabuleiro[6] == tabuleiro[7] && tabuleiro[7] == tabuleiro[8]) {
            return true;
        }
        
        //vitoria diagonal 
        if(tabuleiro[0] == tabuleiro[4] && tabuleiro[4] == tabuleiro[8]) {
            return true;
        } else if(tabuleiro[2] == tabuleiro[4] && tabuleiro[4] == tabuleiro[6]) {
            return true;
        }

        return false;
    }
}

