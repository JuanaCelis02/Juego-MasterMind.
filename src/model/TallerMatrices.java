package model;

import java.util.Arrays;

public class TallerMatrices {
	private int [][] matrizSuma;
	private int rowSize;
	private int columnSize;
	
	public TallerMatrices() {
		matrizSuma = new int[rowSize][columnSize];
	}
	
	public int getRowSize() {
		return rowSize;
	}

	public void setRowSize(int rowSize) {
		this.rowSize = rowSize;
	}

	public int getColumnSize() {
		return columnSize;
	}

	public void setColumnSize(int columnSize) {
		this.columnSize = columnSize;
	}

	public int[][] getMatrizSuma() {
		return matrizSuma;
	}

	public void setMatrizSuma(int[][] matrizSuma) {
		this.matrizSuma = matrizSuma;
	}
	// Sumar dos numeros binarios
	public int [] sumBin(String binOne, String binTwo) {
		int[] binOneVector= createVectInt(binOne);
		int[] binTwoVector= createVectInt(binTwo);
		int []result = new int[8];
		int sum = 0;
		for (int i =  result.length-1; i >= 0; i--) {
			sum += binOneVector[i]+ binTwoVector[i];
			if (sum == 2) {
				result[i] = 0;
				sum = 1;
			}else if (sum == 3) {
				result[i] = 1;
				sum = 1;
			}else{
				result[i] = sum;
				sum = 0;
			}
		}
		return result;		
	}
	public int [] createVectInt(String bin) {
		int[] result = new int[8];
		for (int i = bin.length()-1, j = result.length-1; i >= 0; i--, j--) {
			result[j]=bin.charAt(i)-48;
		}
		return result;
	}
	// Verificar matriz magica.
	public int[][] verificarMatrizMagica(int[][]matriz) {
    	int sumColumnas [] = new int[matriz.length];
    	int sumFilas [] = new int[matriz.length];
    	for (int i = 0; i < matriz.length; i++) {
    		for (int j = 0; j < matriz[0].length; j++) {
				sumFilas[i] += matriz[i][j];
				sumColumnas[i] += matriz[j][i];
			}
		}
    	magicOrNot(sumFilas, sumColumnas);
    	return matriz;

    }
	
	
	
	
	
	
	
    public boolean magicOrNot(int[] addFilas, int [] addColumns) {
    	boolean magic = false;
    	for (int i = 0; i < addFilas.length; i++) {
			for (int j = 0; j < addColumns.length; j++) {
				if(addFilas[i] == addColumns[i]) {
					magic = true;
				}
			}
		}
    	System.out.println(magic);
    	return magic;
    }
    // Generar traspuesta de la matriz
    public int[][] transponerMatriz(int[][] matriz){
    	int[][] transpuesta = new int[ matriz[0].length][matriz.length];
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[i].length;j++){
                transpuesta[j][i] = matriz[i][j];
            }
        }
        return transpuesta;
    }
    // Suma de todos los numeros de una matriz
    public int summAllElementsOfMatrix(int[][]matriz) {
    	int sumFilas = 0;
    	for (int i = 0; i < matriz.length; i++) {
    		for (int j = 0; j < matriz[0].length; j++){
    			sumFilas+= matriz[i][j];
			}
		}
    	System.out.println(sumFilas);
    	return sumFilas;
    	
    }
    //Diagonal Secundaria
    public String imprimirDiagonalSecundaria(int[][]matriz) {
    	int[] diagonalSecundaria = new int[matriz.length];
    	for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[i].length;j++){
                 if(i+j == matriz.length-1){
                	 diagonalSecundaria[i] = matriz[i][j];
                 }
            }
        }
        return Arrays.toString(diagonalSecundaria);
    }    
    public String imprimirDiagonalPrincipal(int[][]matriz) {
    	int[] diagoPrincipal = new int[matriz.length];
    		for(int i=0;i<matriz.length;i++){
    	        for(int j=0;j<matriz[i].length;j++){
    	            if(i==j){
    	                diagoPrincipal[i] = matriz[i][j];
    	            }
    	        }
    		}      
        return Arrays.toString(diagoPrincipal);
    }  
    //Suma y resta de matrices
    public int[][] calculateAddAndSubstractOfMatrices(int[][]matrixOne, int[][]matrixTwo, char addOrSubstract){
    	int[][] result = new int[matrixOne.length][matrixOne[0].length];
    	switch (addOrSubstract) {
		case 'S':
			if ((matrixOne.length == matrixTwo.length) && (matrixOne[0].length==matrixTwo[0].length))
		           for (int i=0; i< matrixOne.length; i++) 
		               for (int j=0; j < matrixOne[i].length; j++) 				
		                result[i][j]=matrixOne[i][j]+matrixTwo[i][j];								
		break;
		case 'R':
			if ((matrixOne.length == matrixTwo.length) && (matrixOne[0].length==matrixTwo[0].length))
		           for (int i=0; i< matrixOne.length; i++) 
		               for (int j=0; j < matrixOne[i].length; j++) 			
		                result[i][j]=matrixOne[i][j]-matrixTwo[i][j];						    
		break;
		}    
        return result;
    }	
    //Multiplicacion de matrices
    public int[][] multiply(int[][] a, int[][] b) {
	    int[][] c = new int[a.length][b[0].length];
	    // se comprueba si las matrices se pueden multiplicar
	    if (a[0].length == b.length) {
	        for (int i = 0; i < a.length; i++) {
	            for (int j = 0; j < b[0].length; j++) {
	                for (int k = 0; k < a[0].length; k++) {
	                    // aquÃ­ se multiplica la matriz
	                    c[i][j] += a[i][k] * b[k][j];
	                }
	            }
	        }
	    }
	 //si no se cumple la condiciÃ³n se retorna una matriz vacÃ­a
	    return c;
	}
    
    //...
	public String returnBinaryNumber(int number) {
		int residuo = 0;
		String numberConvert = "";
		while(number > 0) {
			residuo = number%2;
			numberConvert = residuo+numberConvert;
			number = number/2;
	    }
	    return numberConvert;
	}
	public int[] parse(String num){
	    int[] nums = new int[num.length()];
	    for(int i=0; i<num.length(); i++){
	        nums[i] = Character.getNumericValue(num.charAt(i));
	    }
	    return nums;
	}
    public int[] ordenarInsercion(){
    	int[] nums = {10,9,8,7,6,5,4,3,2,1,35,78};
        int aux;
        for (int i = 1; i < nums.length; i++) {
            aux = nums[i]; 
            for (int j = i-1; j >=0 && nums[j]>aux; j--) {
            	nums[j+1]=nums[j];
            	nums[j]=aux;
            }
        }
        return nums;
    }
    
    public int searchBinary(int num) {
    	int[] valores = {2,4,6,8,15,30};
		int inicio = 0;
		int fin = valores.length - 1;
		int elementPos = -1;
		while (inicio <= fin) {
		    int midIndex = (inicio + fin) / 2;
		    if (num == valores[midIndex]) {
		       elementPos = midIndex;
		       break;
		    } else if (num < valores[midIndex]) {
		    	fin = midIndex-1;
		    } else if (num > valores[midIndex]) {
		    	inicio = midIndex+1;
		    }
		}
		return elementPos;
    }
    
    public int jumpSearch(int x) {
    	int[] numberList = {2,4,6,8,15,30};
        int lengthList = numberList.length; 
        int step = (int)Math.floor(Math.sqrt(lengthList)); //Encontrar tamaño de bloque que se va a saltar
        // Encontrar el bloque donde está el elemento
        // presente (si está presente)
        int prev = 0; 
        while (numberList[Math.min(step, lengthList)-1] < x) {
        	prev = step; 
            step += (int)Math.floor(Math.sqrt(lengthList)); 
            if (prev >= lengthList) 
                return -1; 
        } 
        //Haciendo una búsqueda lineal de x en bloque
        //comenzando con anterior.
        while (numberList[prev] < x) {
        prev++; 
        // Si llegamos al siguiente bloque o al final de la lista, el elemento no está presente.
          if (prev == Math.min(step, lengthList)) 
          return -1; 
        } 
        // Si se encuentra el elemento
        if (numberList[prev] == x) 
            return prev;
        return -1; 
    } 
    
    public int interpolationSearch(int x){
    	int[] numberList = {2,4,6,8,15,30};
        int ini = 0; 
        int fin = (numberList.length - 1); // Encuentra índices de dos esquinas
        
        // Dado que la lista está ordenada, un elemento presente
        // en la ista debe estar en el rango definido por la esquina
        while (ini <= fin && x >= numberList[ini] && x <= numberList[fin]) {
            if (ini == fin) {
            	if (numberList[ini] == x) return ini; 
                	return -1; 
            } 
            // Probar la posición manteniendo distribución uniforme en mente. 
            int position = ini + (((fin-ini) / 
                  (numberList[fin]-numberList[ini]))*(x - numberList[ini])); 
            // Condición del objetivo encontrado
            if (numberList[position] == x) 
                return position; 
            // Si x es mayor, x está en la parte superior
            if (numberList[position] < x) 
            	ini = position + 1; 
            // Si x es menor, x está en la parte inferior
            else
            	fin = position - 1; 
            
        } 
        return -1; 
    } 	
    
    public int exponentialSearch(int x) {
    	int[] numberList = {15,4,6,8,1,30};
    	int n = numberList.length;
    	//Si x está presente en la primera ubicación retorna 0
    	if (numberList[0] == x) 
    		return 0; 
    	// Encuentra el rango para la búsqueda binaria por duplicación repetida
    	int i = 1; 
    	while (i < n && numberList[i] <= x) 
    		i = i*2; 
    	//Llame a la búsqueda binaria para el rango encontrado.
    		return Arrays.binarySearch(numberList, i/2, Math.min(i, n), x); 
    }
    // Algoritmos de ordenamiento
    
    public int[] bubbleSort(){
    	int[] numberList = {15,4,6,8,1,30};
        int n = numberList.length; 
            for (int i = 0; i < n-1; i++) 
             for (int j = 0; j < n-i-1; j++) 
               if (numberList[j] > numberList[j+1]) { 
            	// intercambia numberList [j + 1] y numberList [i]
                 int temp = numberList[j]; 
                 numberList[j] = numberList[j+1];
                 numberList[j+1] = temp; 
              } 
            return numberList;
   } 
    
    public void insertionSort() {
    	int[] numberList = {15,4,6,8,1,30};
        for (int i = 1; i < numberList.length; i++) {
            int current = numberList[i];
            int j = i - 1;
            while(j >= 0 && current < numberList[j]) {
            	numberList[j+1] = numberList[j];
                j--;
            }
            // en este punto hemos salido, entonces j es -1
            // o está en el primer elemento donde actual >= a [j]
            numberList[j+1] = current;
        }
        System.out.println(Arrays.toString(numberList));
        
    }
    public void selectionSort() {
    	int[] numberList = {15,4,6,8,1,30};
        for (int i = 0; i < numberList.length; i++) {
            int min = numberList[i];
            int minId = i;
            for (int j = i+1; j < numberList.length; j++) {
                if (numberList[j] < min) {
                    min = numberList[j];
                    minId = j;
                }
            }
            // swapping
            int temp = numberList[i];
            numberList[i] = min;
            numberList[minId] = temp;
        }
        System.out.println(Arrays.toString(numberList));
    }
    
    public void shell() {
    	int[] numberList = {15,4,6,8,1,30};
    	int salto, aux, i;
        boolean cambios = false;
        for (salto = numberList.length / 2; salto != 0; salto /= 2) 
           cambios = true;
           while (cambios) {   // Mientras se intercambie algún elemento                                         
               cambios = false;
               for (i = salto; i < numberList.length; i++)  // se da una pasada
                    if (numberList[i - salto] > numberList[i]) {       // y si están desordenados
                        aux = numberList[i];                  // se reordenan
                        numberList[i] = numberList[i - salto];
                        numberList[i - salto] = aux;
                        cambios = true;              // y se marca como cambio.                                   
                    }      
            }
        System.out.println(Arrays.toString(numberList));
    }
    
    public void quickSort(int[] vector, int izquierda, int derecha) {
        int pivote = vector[izquierda];
        int i = izquierda;
        int j = derecha;
        int auxIntercambio;
        while (i < j) {
            while (vector[i] <= pivote && i < j) 
                i++;
            while (vector[j] > pivote)
                j--;
            if (i < j) {
                auxIntercambio = vector[i];
                vector[i] = vector[j];
                vector[j] = auxIntercambio;
            }
        }
        vector[izquierda] = vector[j];
        vector[j] = pivote;
        if (izquierda < j - 1) 
            quickSort(vector, izquierda, j - 1);
        if (j + 1 < derecha) 
            quickSort(vector, j + 1, derecha);   
    }
    
	public String removeSpaces(String word) {
		String withoutSpace = "";
		for (int i = 0; i < word.length(); i++) 
			if(word.charAt(i) != 32)
				withoutSpace += word.charAt(i);	
		return withoutSpace;
	}
	
	public int[] asignarStringToVector(String number) {
		int[] aux = new int[number.length()];
		for (int i = 0; i < number.length(); i++)
			aux[i] = number.charAt(i)- 48;
		return aux;
	}
	public String numberDecimalToBinary(int number, int base) {
		String aux = "";
		int dividendo = 0, cociente = 0, residuo = 0;
		dividendo = number;
		while (base <= dividendo) {
			cociente = dividendo / base;
			residuo = dividendo % base;
			dividendo = cociente;
			aux += " " + residuo;
		}
			aux += " " + cociente;
		return invertirCadena(aux);
	}
	public String invertirCadena(String number) {
		String aux = "";
		for (int i = number.length() - 1; i >= 0; i--) {
			aux += number.charAt(i);
		}
		return aux;
	}
}
