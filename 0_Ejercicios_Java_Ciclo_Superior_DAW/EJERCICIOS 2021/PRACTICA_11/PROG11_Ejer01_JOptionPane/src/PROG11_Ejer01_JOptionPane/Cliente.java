package PROG11_Ejer01_JOptionPane;

/**
 *
 * @author IVAN
 */
public class Cliente {
    private int cod;
    private String nombre;
    private String tel;
    
    public Cliente() {
    }

    public Cliente(int cod, String nombre, String tel) {
        this.cod = cod;
        this.nombre = nombre;
        this.tel = tel;
    }

    public int getCod() {
        return cod;
    }
    public void setCod(int cod) {
        this.cod = cod;
    }
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    
    public String imprimeCliente(){
        return "Cliente:"+cod+" | Nombre: "+nombre+" Tel: "+tel;
    }
    
}