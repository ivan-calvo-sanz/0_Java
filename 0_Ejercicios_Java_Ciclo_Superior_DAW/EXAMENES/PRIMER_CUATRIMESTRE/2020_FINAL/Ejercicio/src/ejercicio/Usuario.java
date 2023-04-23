package ejercicio;
import java.io.Serializable;

public class Usuario implements Serializable{
    public static final long serialVersionUID=1L;   
    private String login;
    private String contraseña="";
    private int claveCifrado;
    private String contraseñaCifrada="";

    public Usuario(String login, String contraseña, int claveCifrado) {
        this.login = login;
        this.claveCifrado = claveCifrado;
        cifrarContraseña(contraseña);
        this.contraseña = "*****";
    }
    public Usuario(){
    }
    
    private void cifrarContraseña(String contraseña){
        double letra;
        char letraCifrada;
        double dispersion=0;
        for(int i=0;i<contraseña.length();i++){
            letra=(char)contraseña.toUpperCase().charAt(i);
            if((letra+claveCifrado)>90){
                dispersion=(letra+claveCifrado)-90;
                letraCifrada=(char)(64+dispersion);
            }else{
                letraCifrada=(char)(letra+claveCifrado);
            }
            this.contraseñaCifrada=this.contraseñaCifrada+letraCifrada;
        }
    }
    
    public String desCifrarContraseña(String contraseñaCifrada,int claveCifrado){
        String contraseña="";
        double letraCifrada;
        char letra;
        double dispersion=0;
        for(int i=0;i<contraseñaCifrada.length();i++){
            letraCifrada=(char)contraseñaCifrada.toUpperCase().charAt(i);
            if((letraCifrada-claveCifrado)<65){
                dispersion=(letraCifrada-claveCifrado)-65;
                letra=(char)(91+dispersion);
            }else{
                letra=(char)(letraCifrada-claveCifrado);
            }
            contraseña=contraseña+letra;
        }
        return contraseña;
    }

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getContraseña() {
        return contraseña;
    }
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    public int getClaveCifrado() {
        return claveCifrado;
    }
    public void setClaveCifrado(int claveCifrado) {
        this.claveCifrado = claveCifrado;
    }
    public String getContraseñaCifrada() {
        return contraseñaCifrada;
    }
    public void setContraseñaCifrada(String contraseñaCifrada) {
        this.contraseñaCifrada = contraseñaCifrada;
    }
    
}