// importamos las librerías que vamos a utilizar
import java.util.Random;
import java.util.Scanner;

public class JuegoAdivinarNumero {
  public static void main(String[] args) {
    int minNumero = 1;
    int maxNumero = 100;
    int maxIntentos = 10; // Número máximo de intentos permitidos
    adivinarNumero(minNumero, maxNumero, maxIntentos);
  }

  public static void adivinarNumero(int minNumero, int maxNumero, int maxIntentos) {
    // Creando una nueva instancia de la clase 'Random' para generar un número
    // aleatorio
    Random rand = new Random();
    // Guarda en la variable numeroAleatorio un número aleatorio dentro del rango
    // especificado
    int numeroAleatorio = rand.nextInt(maxNumero - minNumero + 1) + minNumero;
    // Mensajes de inicio del juego y condiciones
    System.out.println("¡Bienvenido al juego de adivinar el número!");
    System.out.println("Estoy pensando en un número entre " + minNumero + " y " + maxNumero + ".");
    System.out.println("Intenta adivinar cuál número es... ");
    System.out.println("Tienes " + maxIntentos + " intentos para lograrlo. ");
    System.out.println("¡Buena suerte!");

    // Bucle de adivinanzas
    Scanner scanner = new Scanner(System.in);
    try {
      int intentos = 0;
      int numeroUsuario;

      while (intentos < maxIntentos) {
        System.out.print("Introduce tu número: ");
        numeroUsuario = scanner.nextInt();
        intentos++;

        if (numeroUsuario == numeroAleatorio) {
          System.out
              .println("¡Felicidades! ¡Has adivinado el número " + numeroAleatorio + " en " + intentos + " intentos!");
          return;
        } else if (numeroUsuario < numeroAleatorio) {
          System.out.println("No adivinaste, el número que estoy pensando es mayor.");
        } else {
          System.out.println("No adivinaste, el número que estoy pensando es menor.");
        }
      }
      // Mensaje de derrota
      System.out.println("¡Lo siento! Has alcanzado el número máximo de intentos (" + maxIntentos + "). El número era: " + numeroAleatorio);
    } finally {
      scanner.close();
    }
  }
}
