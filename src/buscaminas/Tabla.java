/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas;

/**
 *
 * @author marc
 */
import java.util.Random;
import java.util.Scanner;

public class Tabla {
    int[][] minas;
    char[][] tablajuego;
    int linia, columna;
    Random random = new Random();
    Scanner input = new Scanner(System.in);
    
    public Tabla (){
        minas = new int[10][10];
        tablajuego = new char[10][10];
        MinasOn();
        MinasAleatorias();
        llenar();
        iniciaTabla();
        
    }
    
    public boolean ganar(){
        int count=0;
        for(int line = 1 ; line < 9 ; line++)
            for(int column = 1 ; column < 9 ; column++)
                if(tablajuego[line][column]=='_')
                    count++;
        if(count == 10)
            return true;
        else
            return false;                
    }
    
    public void muestramecasillas(){
        for(int i=-1 ; i<2 ; i++)
            for(int j=-1 ; j<2 ; j++)
                if( (minas[linia+i][columna+j] != -1) && (linia != 0 && linia != 9 && columna != 0 && columna != 9) )
                    tablajuego[linia+i][columna+j]=Character.forDigit(minas[linia+i][columna+j], 10);
        
    }
    
    public int getPosition(int linia, int columna){
        return minas[linia][columna];
    }
    
    public boolean setPosition(){
            
            do{
                System.out.print("\nlinia: "); 
                linia = input.nextInt();
                System.out.print("columna: "); 
                columna = input.nextInt();
                
                if( (tablajuego[linia][columna] != '_') && ((linia < 9 && linia > 0) && (columna < 9 && columna > 0)))
                    System.out.println("Campo ya enseñado");
                
                if( linia < 1 || linia > 8 || columna < 1 || columna > 8)
                    System.out.println("Elije un numero entre el 1 - 8");
                
            }while((linia < 1 || linia > 8 || columna < 1 || columna > 8) || (tablajuego[linia][columna] != '_') );
            
            if(getPosition(linia, columna)== -1)
                return true;
            else
                return false;
            
    }
    
    public void ensenia(){
        System.out.println("\n     linias");
        for(int linia = 8 ; linia > 0 ; linia--){
            System.out.print("       "+linia + " ");
            
            for(int columna = 1 ; columna < 9 ; columna++){
                    System.out.print("   "+ tablajuego[linia][columna]);
            }
                
            System.out.println();
        }
            
        System.out.println("\n            1   2   3   4   5   6   7   8");
        System.out.println("                      columnas");
        
    }
    
    public void llenar(){
        for(int line=1 ; line < 9 ; line++)
            for(int column=1 ; column < 9 ; column++){
                
                    for(int i=-1 ; i<=1 ; i++)
                        for(int j=-1 ; j<=1 ; j++)
                            if(minas[line][column] != -1)
                                if(minas[line+i][column+j] == -1)
                                    minas[line][column]++;
                
            }
            
    }
    
    public void enseniaMines(){
        for(int i=1 ; i < 9; i++)
            for(int j=1 ; j < 9 ; j++)
                if(minas[i][j] == -1)
                    tablajuego[i][j]='*';
        
        ensenia();
    }
    
    public void iniciaTabla(){
        for(int i=1 ; i<minas.length ; i++)
            for(int j=1 ; j<minas.length ; j++)
                tablajuego[i][j]= '_';
    }
    
    public void MinasOn(){
        for(int i=0 ; i<minas.length ; i++)
            for(int j=0 ; j<minas.length ; j++)
                minas[i][j]=0;
    }
    
    public void MinasAleatorias(){
        boolean raffled;
        int linia, columna;
        for(int i=0 ; i<10 ; i++){
            
            do{
                linia = random.nextInt(8) + 1;
                columna = random.nextInt(8) + 1;
                
                if(minas[linia][columna] == -1)
                    raffled=true;
                else
                    raffled = false;
            }while(raffled);
            
            minas[linia][columna] = -1;
        }
    }
}

/*
int[fMax][cMax]
private boolean dinsTauler (int f, int c){
return !((f<0)||(f>=fMax)||
    (c<0)||(c>=cMax));
}
vull contar mines veines (f,c)
mines=0;
for(int k=0; k < veins.lenght:k++){
if(dinsTauler(f+ veins[k][0], c+veins[k][1])){
if(hihamina(f+veins[k][0], c+veins[k][1])){
mines++;
}
}


int[8][2]={{-1,-1},{-1,0},{-1,+1},
{0,-1},{0,+1},
{+1,-1},{+1,0},{+1,+1},
*/



