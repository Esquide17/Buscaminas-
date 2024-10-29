
import java.util.Random;
import java.util.Scanner;

public class Buscaminas {
	// declaracion de las variables
	static boolean jugar;
	static int tamanoTableroX;
	static int tamanoTableroY;
	static int cantidadBombas;
	// declaracion del array buscaminas que simulara el tablero
	static String[][] buscaminas;
	// array para determinar el estado de las casillas
	static boolean[][] descubiertas;
	static Scanner teclado = new Scanner(System.in);

	public static void colocarBombasPrincipiante() {
		// nivel principiante, tamaño 9x9
		tamanoTableroX = 9;
		tamanoTableroY = 9;
		// cantidad de bombas del nivel principiante
		cantidadBombas = 10;
		// inicializacion del los arrays con un tamaño de 9x9
		buscaminas = new String[tamanoTableroX][tamanoTableroY];
		descubiertas = new boolean[tamanoTableroX][tamanoTableroY];
		// creacion de objeto para generar valores aleatorios
		Random random = new Random();
		// bucle for que se repetira hasta que se introduzca el numero de bombas del
		// nivel
		for (int bombasColocadas = 0; bombasColocadas < cantidadBombas;) {
			// coloca las bombas de forma aleatoria en el table, en la filas x y las
			// columnas y
			int fila = random.nextInt(tamanoTableroX);
			int columna = random.nextInt(tamanoTableroY);
			// si la casilla contiene un null se cumple la condicion
			if (buscaminas[fila][columna] == null) {
				// cambia el null por una bomba X, he tenido que poner X como bomba ya que los
				// emojis de bombas ocupaban mas espacio que los numeros
				buscaminas[fila][columna] = "X";
				bombasColocadas++;
			}
		}
	}

	public static void colocarBombasIntermedio() {
		// nivel Intermedio, tamaño 16x16
		tamanoTableroX = 16;
		tamanoTableroY = 16;
		// cantidad de bombas del nivel intermedio
		cantidadBombas = 40;
		// inicializacion del los arrays con un tamaño de 16x16
		buscaminas = new String[tamanoTableroX][tamanoTableroY];
		descubiertas = new boolean[tamanoTableroX][tamanoTableroY];
		// creacion de objeto para generar valores aleatorios
		Random random = new Random();
		// bucle for que se repetira hasta que se introduzca el numero de bombas del
		// nivel
		for (int bombasColocadas = 0; bombasColocadas < cantidadBombas;) {
			// coloca las bombas de forma aleatoria en el table, en la filas x y las
			// columnas y
			int fila = random.nextInt(tamanoTableroX);
			int columna = random.nextInt(tamanoTableroY);
			// si la casilla contiene un null se cumple la condicion
			if (buscaminas[fila][columna] == null) {
				// cambia el null por una bomba
				buscaminas[fila][columna] = "X";
				bombasColocadas++;
			}
		}
	}

	public static void colocarBombasAvanzado() {
		// nivel avanzado, tamaño 16x30
		tamanoTableroX = 16;
		tamanoTableroY = 30;
		// cantidad de bombas del nivel avanzado
		cantidadBombas = 99;
		// inicializacion del los arrays con un tamaño de 16x30
		buscaminas = new String[tamanoTableroX][tamanoTableroY];
		descubiertas = new boolean[tamanoTableroX][tamanoTableroY];
		// creacion de objeto para generar valores aleatorios
		Random random = new Random();
		// bucle for que se repetira hasta que se introduzca el numero de bombas del
		// nivel
		for (int bombasColocadas = 0; bombasColocadas < cantidadBombas;) {
			// coloca las bombas de forma aleatoria en el table, en la filas x y las
			// columnas y
			int fila = random.nextInt(tamanoTableroX);
			int columna = random.nextInt(tamanoTableroY);
			// si la casilla contiene un null se cumple la condicion
			if (buscaminas[fila][columna] == null) {
				// cambia el null por una bomba
				buscaminas[fila][columna] = "X";
				bombasColocadas++;
			}
		}
	}

	public static void colocarBombasPersonalizado() {
		// nivel personalizado, hay que introducir el numero de filas y de columnas
		System.out.print("Número de filas: ");
		tamanoTableroX = teclado.nextInt();
		System.out.print("Número de columnas: ");
		tamanoTableroY = teclado.nextInt();
		// cantidad de bombas del nivel personalizado
		System.out.print("Indica el numero de bombas :");
		cantidadBombas = teclado.nextInt();
		// inicializacion del los arrays con un tamaño segun las filas y columnas
		// introducidas
		buscaminas = new String[tamanoTableroX][tamanoTableroY];
		descubiertas = new boolean[tamanoTableroX][tamanoTableroY];
		// creacion de objeto para generar valores aleatorios
		Random random = new Random();
		// bucle for que se repetira hasta que se introduzca el numero de bombas del
		// nivel
		for (int bombasColocadas = 0; bombasColocadas < cantidadBombas;) {
			// coloca las bombas de forma aleatoria en el table, en la filas x y las
			// columnas y
			int fila = random.nextInt(tamanoTableroX);
			int columna = random.nextInt(tamanoTableroY);
			// si la casilla contiene un null se cumple la condicion
			if (buscaminas[fila][columna] == null) {
				// cambia el null por una bomba
				buscaminas[fila][columna] = "X";
				bombasColocadas++;
			}
		}
	}

	public static void cambiarABombas() {
		// bucle for anidado que recorre el array y cambia los null por 0
		for (int i = 0; i < buscaminas.length; i++) {
			for (int j = 0; j < buscaminas[0].length; j++) {
				if (buscaminas[i][j] == null) {
					buscaminas[i][j] = "0";
				}
			}
		}
		// bucle for que recorre el array bidimensional
		for (int i = 0; i < buscaminas.length; i++) {
			for (int j = 0; j < buscaminas[0].length; j++) {
				// declaracion e inicializacion de la variable contador
				int contador = 0;
				// si la casilla tiene un 0 se cumple la condicion
				if (buscaminas[i][j].equals("0")) {
					// bucle for que recorre en un 3x3 las casilla que rodean ese 0
					for (int k = i - 1; k <= i + 1; k++) {
						for (int t = j - 1; t <= j + 1; t++) {
							// si esa casilla cumple todas esas condiciones aumenta el contador en 1
							if (k >= 0 && t >= 0 && k < tamanoTableroX && t < tamanoTableroY && buscaminas[k][t].equals("X")) {
								contador++;
							}
						}
					}
					// establezco esa casilla con el numero de bombas que la rodean
					buscaminas[i][j] = String.valueOf(contador);

				}
			}
		}
	}

	public static void imprimirTablero() {

		// bucle for anidado para imprimir el buscaminas
		for (int i = 0; i < buscaminas.length; i++) {
			// imprime el numero de la fila
			System.out.printf("%4d.  ", i + 1);
			for (int j = 0; j < buscaminas[0].length; j++) {
				// si la casilla ha sido descubierta se cumple la condicion
				if (descubiertas[i][j]) {
					// imprimer las casilla descubiertas
					System.out.printf("%4s", buscaminas[i][j]);
				} else {
					// imprime las que no estan descubiertas tapadas
					System.out.printf("%4s", "■");
				}
			}
			System.out.println();
		}
		// saltos de linea
		System.out.println();
		System.out.println("   ---------------------------------");
		System.out.println();
	}

	public static void jugar() {
		boolean seguir = true;
		// bucle while
		while (seguir) {
			System.out.println("Ingresa la fila y columna (ejemplo: 1 2) para descubrir la casilla:");
			// introucir la casilla a descubrir
			int fila = teclado.nextInt() - 1;
			int columna = teclado.nextInt() - 1;
			// si se cumple la condicion se descubre la casilla llamando al metodo
			// descubirirCasilla
			if (fila >= 0 && fila < tamanoTableroX && columna >= 0 && columna < tamanoTableroY) {
				descubrirCasilla(fila, columna);
				// si la casilla es una bomba has perdido
				if (buscaminas[fila][columna].equals("X")) {
					System.out.println("¡Has perdido! Encontraste una bomba.");
					// salto de linea
					System.out.println();
					// llama al metodo mostrarBombas para mostras todas las bombas que habia y las
					// casillas descubiertas
					mostrarBombas();
					// las condiciones booleanas jugar y seguir pasan a ser falsas para dejar de
					// jugar.
					seguir = false;
					jugar = false;
					// este else if es para comprobar si todas las casillas que no son bombas ya han
					// sido descubiertas, llama al metodo casillasDescubiertas
				} else if (casillasDescubiertas()) {
					System.out.println("¡Has ganado! Todas las casillas han sido descubiertas.");
					// salto de linea
					System.out.println();
					// llama al metodo para imprimir el tablero final
					imprimirTablero();
					// las condiciones booleanas jugar y seguir pasan a ser falsas para dejar de
					// jugar.
					seguir = false;
					jugar = false;

				}
			} else {
				// si la ubicacion no existe muestra este mensaje
				System.out.println("Ubicación no válida. Ingresa una ubicación dentro del rango.");
			}
			// imrpime el tablero siempre que el juego continue
			if (seguir && jugar) {
				imprimirTablero();
			}

		}

	}

	public static void descubrirCasilla(int fila, int columna) {
		// verificar si la casilla no ha sido descubierta
		if (!descubiertas[fila][columna]) {
			// marca la casilla como descubierta
			descubiertas[fila][columna] = true;
			// comprobamos si la casilla introducida es un 0
			if (buscaminas[fila][columna].equals("0")) {
				// Descubre las casillas adyacentes si la casilla tiene valor 0
				for (int i = fila - 1; i <= fila + 1; i++) {
					for (int j = columna - 1; j <= columna + 1; j++) {
						if (i >= 0 && j >= 0 && i < tamanoTableroX && j < tamanoTableroY) {
							// recursividad, para descubrir la casilla
							descubrirCasilla(i, j);
						}
					}
				}
			}
		}
	}

	public static boolean casillasDescubiertas() {
		// bucle for anidado para recorrer el array booleano
		for (int i = 0; i < descubiertas.length; i++) {
			for (int j = 0; j < descubiertas[0].length; j++) {
				// verifica si una casilla no ha sido descubierta y no es una bomba
				if (!descubiertas[i][j] && !buscaminas[i][j].equals("X")) {
					return false;
				}
			}
		}
		// retorna true cuando todas las casillas no bombas han sido descubiertas
		return true;
	}

	public static void mostrarBombas() {
		// bucle for anidado para mostrar todas las Bombas si has perdido la partida
		for (int i = 0; i < buscaminas.length; i++) {
			System.out.printf("%4d.  ", i + 1);
			for (int j = 0; j < buscaminas[0].length; j++) {
				// muestra las bombas
				if (buscaminas[i][j].equals("X")) {
					System.out.printf("%4s", buscaminas[i][j]);
					// muestras las casillas ya descubiertas
				} else if (descubiertas[i][j]) {
					System.out.printf("%4s", buscaminas[i][j]);
				} else {
					System.out.printf("%4s", "■");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// inicializacion de la variable booleana jugar en true
		jugar = true;
		System.out.println("Bienvinido al buscaminas:");
		// bucle while que se cumplira mientras jugar sea true
		while (jugar) {
			System.out.println(
					"Indica el nivel:\n - 1.Principiante \n - 2.Intermedio\n - 3.Avanzado\n - 4.Personalizado\n - 5.Salir");
			// intoducir el nivel
			String eleccion = teclado.nextLine();
			switch (eleccion) {
			case "1":
			case "Principiante":
				colocarBombasPrincipiante();
				cambiarABombas();
				imprimirTablero();
				jugar();
				break;
			case "2":
			case "Intermedio":
				colocarBombasIntermedio();
				cambiarABombas();
				imprimirTablero();
				jugar();
				break;
			case "3":
			case "Avanzado":
				colocarBombasAvanzado();
				cambiarABombas();
				imprimirTablero();
				jugar();
				break;
			case "4":
			case "Personalizado":
				colocarBombasPersonalizado();
				cambiarABombas();
				imprimirTablero();
				jugar();
				break;
			case "5":
			case "salir":
				// combate igual a false para salir del switch
				jugar = false;
				System.out.println(" Gracias por jugar ! ");
				break;
			default:
				break;
			}
		}
		System.out.println();
		System.out.println(" Version 1.0 Buscaminas. Gracias por jugar !");
		System.out.println(" By: Rodrigo Esquide Gómez");
	}
}