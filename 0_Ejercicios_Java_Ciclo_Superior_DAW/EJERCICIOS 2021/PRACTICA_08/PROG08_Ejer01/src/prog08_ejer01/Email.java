package prog08_ejer01;

public class Email implements Comparable<Email>{
    private String email;
    
    //Constructores
    public Email(){
    }
    public Email(String email){
        this.email=email;
    }
    
    //Métodos get y set
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    //Sobreescribo método compareTo
    @Override
    public int compareTo(Email e){
        return email.compareTo(e.getEmail());
    }
    
    //Sobreescribo método equals
    /* Aunque no utilizo el método equals
    lo sobreescribo a modo de aprendizaje
    es necesario comprobar que es Objeto de tipo Telefono
    */
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Email){
            Email e=(Email)obj;
            return email==e.getEmail();
        }
        return false;
    }
}