package ejercicio1;



import java.util.ArrayList;

/**
 *
 * @author IVAN
 */
public class FlotaTransporte {
    ArrayList<Transporte> transportes=new ArrayList<Transporte>();

    public FlotaTransporte() {
    }
    
    public void anadirTransportes(){
        String matricula=String.valueOf(generarNumAleatorio(0,9999));
        int i=generarNumAleatorio(0,3);
        String marcaModelo=Transporte.MarcaModelo[i];
        i=generarNumAleatorio(0,2);
        Combustible.TipoCombustible tipo;
        if(i==0){
            tipo=Combustible.TipoCombustible.GASOLINA;
        }else if(i==1){
            tipo=Combustible.TipoCombustible.DIESEL;
        }else{
            tipo=Combustible.TipoCombustible.BIODIESEL;
        }
        int kmsMaximos=generarNumAleatorio(0,300000);
        int kmsRecorridos=generarNumAleatorio(0,2000);
        i=generarNumAleatorio(0,1);
        boolean enFuncionamiento=true;
        if(i==0){
            enFuncionamiento=false;
        }
        double gastoMantenimiento=(double)generarNumAleatorio(0,1000);
        double gastoCombustible=(double)generarNumAleatorio(0,500);
        
        i=generarNumAleatorio(0,1);
        //Si tipoTransporte=1 generamos TransportePrivado
        if(i==1){
            int codConductor=generarNumAleatorio(0,50);
            TransportePrivado t=new TransportePrivado(codConductor,matricula,marcaModelo,tipo,
            kmsMaximos,kmsRecorridos,enFuncionamiento,gastoMantenimiento,gastoCombustible);
            transportes.add(t);
        }else{
            TransportePublico t=new TransportePublico(matricula,marcaModelo,tipo,
            kmsMaximos,kmsRecorridos,enFuncionamiento,gastoMantenimiento,gastoCombustible);
            transportes.add(t);
        }
    }
    
    public void listarFlota(){
        for(int i=0;i<transportes.size();i++){
            System.out.println(transportes.get(i).toString());
        }
    }
    
    public void listarFlotaActiva(){
        for(int i=0;i<transportes.size();i++){
            if(transportes.get(i).isEnFuncionamiento()){
                System.out.println(transportes.get(i).toString());
            }
        }
    }
    
    public int buscaMatricula(String matricula){
        for(int i=0;i<transportes.size();i++){
            if(transportes.get(i).getMatricula().equalsIgnoreCase(matricula)){
                return i;
            }
        }
        return -1;
    }
    
    public int añadirViaje(String matricula,int kms, double gastoCombustible){
        for(int i=0;i<transportes.size();i++){
            if(transportes.get(i).getMatricula().equalsIgnoreCase(matricula)){
                transportes.get(i).añadirViaje(kms, gastoCombustible);
                return i;
            }
        }
        return -1;        
    }
    
    public int anadirMantenimiento(String matricula, double gastoMantenimiento){
        for(int i=0;i<transportes.size();i++){
            if(transportes.get(i).getMatricula().equalsIgnoreCase(matricula)){
                transportes.get(i).añadirMantenimiento(gastoMantenimiento);
                return i;
            }
        }
        return -1;        
    }
    
    public double ingresosTotal(){
        double ingresos=0;
        for(int i=0;i<transportes.size();i++){
            ingresos+=transportes.get(i).calcularIngresos();
        }
        return ingresos;
    }
    
    public double gastosEstimados(){
        double gastos=0;
        for(int i=0;i<transportes.size();i++){
            gastos+=transportes.get(i).estimarGastoTotal();
        }
        return gastos;
    }
    
    public double gastosReales(){
        double gastos=0;
        for(int i=0;i<transportes.size();i++){
            gastos=+transportes.get(i).getGastoCombustible()+transportes.get(i).getGastoMantenimiento();
        }
        return gastos;        
    }
    
    public ArrayList<Transporte> getTransportes() {
        return transportes;
    }
    public void setTransportes(ArrayList<Transporte> transportes) {
        this.transportes = transportes;
    }
    
    
    //GENERA nº aleatorio
   public static int generarNumAleatorio(int n1,int n2){
        //genera un numero aleatrorio hasta máximo n
        //int numeroAleatorio=(int)(Math.random()*n+1);
        //genera un numero aleatrorio entre n1 y n2
        int numeroAleatorio=(int)(Math.random()*((n2+1)-n1))+n1;
        
        return numeroAleatorio;
    }

}