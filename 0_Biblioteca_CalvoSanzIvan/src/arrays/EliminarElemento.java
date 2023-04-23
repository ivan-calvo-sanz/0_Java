package arrays;

public class EliminarElemento {
    
    
    
        /**
     * METODO elimina un Vehículo de Concesionario 
     * copiando de un array a otro array
     */
    public boolean eliminaVehiculoV1(String matricula) {
        Vehiculo[] copiaVehiculos = new Vehiculo[MAXIMO_VEHICULOS];
        int j = 0;
        boolean devuelve = false;
        int pos = buscaVehiculo(matricula);

        for (int i = 0; i < numVehExist; i++) {
            if (i != pos) {
                copiaVehiculos[j] = vehiculos[i];
                j++;
            } else {
                devuelve = true;
            }
        }
        numVehExist--;
        vehiculos = copiaVehiculos;
        return devuelve;
    }

    /**
     * METODO elimina un Vehículo de Concesionario 
     * recorriendo el array desde la posición que ocupa el vehiculo que pasa 
     * por parámtero [i] se copia dentro del mismo array el vehículo situado
     * en la siguiente posición [i+1]
     */
    public boolean eliminaVehiculoV2(String matricula) {
        int pos = buscaVehiculo(matricula);
        boolean devuelve = false;
        if (pos != -1) {
            for (int i = pos; i < numVehExist - 1; i++) {
                vehiculos[i] = vehiculos[i + 1];
            }
            numVehExist--;
            devuelve = true;
        } else {
            System.out.println("El vehiculo no existe");
        }
        return devuelve;
    }
    
    
    
}
