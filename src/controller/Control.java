package controller;
import view.*;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

import model.*;
public class Control {
    IoManager io;
    MasterMind masterMind;
    DecimalFormat decimalFormat = new DecimalFormat("##,###.##");
    TallerMatrices taller;
    ChessHorse horse;
    Scanner consola = new Scanner(System.in);
    private int[][] matrizSuma;
	private int rowSize;
	private int columnSize;
 
   public Control() {
        io = new IoManager();
        masterMind = new MasterMind();
        taller = new TallerMatrices();
        horse = new ChessHorse();
        
    }
    public void init() {
    //this.menu();
    //Suma binaria
    //io.showGraphicMessage(Arrays.toString(taller.sumBin(io.readGraphicString("Ingrese primer numero bin para sumar"), io.readGraphicString("Ingrese segundo numero bin para sumar"))));

    //Matriz magica
    //io.showGraphicMessage(printMatrixInteger(taller.verificarMatrizMagica(leerMatriz())));

    //Trasponer matriz
    //io.showGraphicMessage(printMatrixInteger(taller.transponerMatriz(leerMatriz())));

    //Sumar todos los elementos de matriz
    //io.showGraphicMessage(""+taller.summAllElementsOfMatrix(leerMatriz()));

    //Diagonal secundaria
    //io.showGraphicMessage(taller.imprimirDiagonalSecundaria(leerMatriz()));

    //Diagonal principal
    //io.showGraphicMessage(taller.imprimirDiagonalPrincipal(leerMatriz()));

    //Suma y resta de matrices
    //io.showGraphicMessage(printMatrixInteger(taller.calculateAddAndSubstractOfMatrices(leerMatriz(), leerMatriz(),'R')));

    //Multiplicacion matrices
    //io.showGraphicMessage(printMatrixInteger(taller.multiply(leerMatriz(), leerMatriz())));

   //Movimiento caballo
     //io.showMessage(""+horse.showMatrix() + horse.generatePlays());

    //...
    //io.showGraphicMessage((Arrays.toString(taller.ordenarInsercion())));
    //io.showGraphicMessage(""+taller.searchBinary(io.readGraphicInt("Ingrese numero a buscar")));
    //printMatrix(masterMind.getMatriz());

    //int superior = calculateMatrizSuperior(masterMind.getMatriz());

    //System.out.println("\n");nt inferior = calculateMatrizInferior(masterMind.getMatriz());
    //io.showGraphicMessage(Arrays.toString(taller.bubbleSort()));

    }

    /*
    public void masterMind() {
    	masterMind.generateHiddenNumber();
    	String playerNumber = "";
    	while(masterMind.getLives() != 0) {
    		playerNumber = io.readString("Numero oculto: [? , ? , ? , ?]\n" + masterMind.showResult() + 
    				"\nNumero de vidas: "+ masterMind.getLives()+ "\nIngreseNumero");
    		masterMind.fillMove(playerNumber);
    	}
    	if (masterMind.compareFijas()) 
			io.showMessage("NUMERO OCULTO: "+ Arrays.toString(masterMind.getHiddenNumber()) + "\n" + masterMind.showResult()
			+ "\nJUEGO TERMINADO-USTED GANO");
    	else
    		io.showMessage("NUMERO OCULTO: "+ Arrays.toString(masterMind.getHiddenNumber()) + "\n" + masterMind.showResult()
    		+ "\nJUEGO TERMINADO-USTED PERDIO");
    	
    } 
    */
    public int[][] leerMatriz() {
    	this.rowSize = io.readGraphicInt("Ingrese numero de filas");
    	this.columnSize = io.readGraphicInt("Ingrese numero de columnas");
    	matrizSuma = new int[rowSize][columnSize];
    	io.showGraphicMessage("Digite valores que quiera añadir a cada posicion de la matriz");
    	for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < columnSize; j++) {
				matrizSuma[i][j] = io.readGraphicInt("Matriz ["+i+"]["+j+"]: ");
			}
		}
    	return matrizSuma; 
    }
    public String printMatrixInteger(int[][]matrixInt) {
		StringBuilder text = new StringBuilder();
		for (int i = 0; i < matrixInt.length; i++) {
			for (int j = 0; j < matrixInt[i].length; j++) {
				text.append(String.format(" %2d  ", matrixInt[i][j]));
			}
			text.append("\n");
		}
		return text.toString();
	}
    public void printMatrix(int[][] grid) {
        for(int i=0; i<grid.length; i++) {
           for(int j=0; j<grid[i].length; j++)
               System.out.print(grid[i][j] + " ");
           System.out.println();
        }
    }    
    
    public int calculateMatrizSuperior(int [][]grid) {
    	int suma = 0;
    	int c = 0;
    	for(int i=0; i<grid.length; i++) {
            for(int j=c; j<grid[i].length; j++) {
            	if (i != j) {
            		System.out.print(grid[i][j] + " ");
                	suma += grid[i][j];
				}
            	
            }
            c++;
        }
    	System.out.println("/n");
    	System.out.println(suma);
    	return suma;
    }
    public int  calculateMatrizInferior(int [][]grid) {
    	int suma = 0;
    	int c = 0;
    	for(int i=0; i<grid.length; i++) {
            for(int j=c; j<grid[i].length; j++) {
            	if(i != j) {
            		System.out.print(grid[j][i] + " ");
                	suma += grid[j][i];
            	}
            	
            }
            c++;
        }
    	System.out.println("/n");
    	System.out.println(suma);
    	return suma;
    }

}

/*
public void menu() {
    int op=0;
    do {
            op = io.readMenu();
            switch (op) {
            case 1:
            	addEmployee();
                break;
            case 2:
            	deleteEmployee();
                 break;
            case 3:
                 printBusinessData();
                 break;
            case 4:
                printEmployeesData03();
                break;
            case 5:
            	printEmployeeData();
                break;
            case 6:
                 io.showGraphicMessage("Finalización");
                 break;
             }

    } while (op != 4);
}
*/
		/*
		employee.setId(io.readGraphicShort("Ingrese su codigo"));
		employee.setFirstName(io.readGraphicString("Ingrese su nombre"));
		employee.setLastName(io.readGraphicString("Ingrese su apellido"));
		employee.setSalary(io.readGraphicDouble("Ingrese su salario"));
		employee.setChildrenNumber(io.readGraphicShort("Ingrese numero de hijos"));

		io.showGraphicMessage("Ingrese su fecha de nacimiento");
		MyDate myDate = new MyDate(io.readGraphicShort("Año: "), io.readGraphicShort("Mes: "), io.readGraphicShort("Dia: "));
		employee.setBirthDate(myDate);

		io.showGraphicMessage("Ingrese su fecha de contratacion");
		myDate = new MyDate(io.readGraphicShort("Año: "), io.readGraphicShort("Mes: "), io.readGraphicShort("Dia: "));
		employee.setHireDate(myDate);

		io.showGraphicMessage(""+employee);
		io.showGraphicMessage("Edad "+ employee.getAge());
		io.showGraphicMessage("Antiguedad "+ employee.getOldJob());
		io.showGraphicMessage("Edad decimal " + employee.getAgeDouble());*/
		
		
		
	
