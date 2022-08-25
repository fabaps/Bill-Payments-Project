public class Transaccion {

  double monto;
  int id;
  

  public Transaccion(int id, double monto){
    this.id = id;
    this.monto = monto;
  } 

  @Override
  public String toString(){
    return String.format("[%d : %.2f]", this.id, this.monto);
  }

}