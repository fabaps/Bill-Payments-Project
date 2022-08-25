import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;

public class BillPayments extends MyThread{

  private static final Logger LOGGER = Logger.getLogger(BillPayments.class.getName());

  public static void main(String[] args) throws Exception,ArgsNotDefinedException {

    BufferedReader tec = new BufferedReader(new InputStreamReader(System.in));
    
    ConcurrentLinkedQueue <Transaccion> estado100 = new ConcurrentLinkedQueue<Transaccion>();
    ConcurrentLinkedQueue <Transaccion> estado200 = new ConcurrentLinkedQueue<Transaccion>();
    ConcurrentLinkedQueue <Transaccion> estado300 = new ConcurrentLinkedQueue<Transaccion>();
    ConcurrentLinkedQueue <Transaccion> estado201 = new ConcurrentLinkedQueue<Transaccion>();
    ConcurrentLinkedQueue <Transaccion> estado301 = new ConcurrentLinkedQueue<Transaccion>();
    ConcurrentLinkedQueue <Transaccion> estado400 = new ConcurrentLinkedQueue<Transaccion>();


    System.out.println("*********Bill Payments**********");
    System.out.println("--------------------------------");

    System.out.println("Fabián Perdomo");
    System.out.println("PJ-1 Interciclo CC2");

    System.out.println();

    if (args.length == 4){
      int a = Integer.parseInt(args[0]);
      int b = Integer.parseInt(args[1]);
      int c = Integer.parseInt(args[2]);
      int d = Integer.parseInt(args[3]);



      int correlativo = 1;
      Random r = new Random();

      while(true){

        int monto1 = r.nextInt(999) - 555;
        int monto2 = r.nextInt(999) - 555;
        int monto3 = r.nextInt(999)- 555;
        Transaccion nueva = new Transaccion(correlativo++,monto1);
        estado100.add(nueva);
        Thread.sleep(a);
        LOGGER.info("Entrando a Estado 100: "+ nueva);
        System.out.println("Estado 100 ->> " + estado100);
        System.out.println();
        if (nueva.monto > 0){
          Thread.sleep(b);
          estado200.add(estado100.remove());
          LOGGER.info("Entrando a Estado 200: "+ nueva);
          System.out.println("Estado 200 ->> " + estado200);
          System.out.println();
          Thread.sleep(c);
          LOGGER.info("Entrando a Estado 300: "+ estado200.peek());
          estado300.add(estado200.remove());
          System.out.println("Estado 300 ->> " + estado300);
          System.out.println();
        
          int prob = r.nextInt(5) + 1;

          if (prob == 1){
            Thread.sleep(d);
            LOGGER.info("Entrando a Estado 301: "+ estado300.peek());
            estado301.add(estado300.remove());
            System.out.println("Estado 301 ->> " + estado301);
            System.out.println();

          } else if (prob == 2){
            Thread.sleep(d);
            LOGGER.info("Entrando a Estado 400: "+ estado300.peek());
            estado400.add(estado300.remove());
            System.out.println("Estado 400 ->> " + estado400);
            System.out.println();
          } else if (prob == 3){
            Thread.sleep(d);
            LOGGER.info("Entrando a Estado 400: "+ estado300.peek());
            estado400.add(estado300.remove());
            System.out.println("Estado 400 ->> " + estado400);
            System.out.println();
          } else if (prob == 4){
            Thread.sleep(d);
            LOGGER.info("Entrando a Estado 400: "+ estado300.peek());
            estado400.add(estado300.remove());
            System.out.println("Estado 400 ->> " + estado400);
            System.out.println();
          } else if (prob == 5){
            Thread.sleep(d);
            LOGGER.info("Entrando a Estado 400: "+ estado300.peek());
            estado400.add(estado300.remove());
            System.out.println("Estado 400 ->> " + estado400);
            System.out.println();
          }


        } else {
          Thread.sleep(b);
          estado201.add(estado100.remove());
          LOGGER.info("Entrando a Estado 201: "+ nueva);
          System.out.println("Estado 201 ->>" + estado201);
          System.out.println();
        }
 
      }
      
    } else {
      throw new ArgsNotDefinedException();
    }



  }
}

class ArgsNotDefinedException extends Exception{
  public ArgsNotDefinedException(){
    super("Ingresar los cuatro tiempos de transacciones");
  }
}