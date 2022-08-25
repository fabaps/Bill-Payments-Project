import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.Random;

public class MyThread extends Thread {

  ConcurrentLinkedQueue<Transaccion> generador;
  int correlativo;
  

  public MyThread() {
    super();
    this.generador = new ConcurrentLinkedQueue<Transaccion>();
  }

  public ConcurrentLinkedQueue<Transaccion> imprimir(){
    return this.generador;
  }

  Random r = new Random();

  @Override
  public void run() {
    while (true) {
      int monto = r.nextInt(999)+ 1;
      Transaccion nueva = new Transaccion(correlativo,monto);
      generador.add(nueva);
      System.out.print(nueva);
      correlativo++;

      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {

      }
    }
  }
}