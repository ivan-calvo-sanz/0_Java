package prog08_ejer01;

public class Telefono implements Comparable<Telefono> {
    private Long tel;
    private String plus;
    
    //Constructores
    public Telefono(){
    }
    public Telefono(Long tel,String plus){
        this.tel=tel;
        this.plus=plus;
    }

    //Métodos get y set
    public Long getTel() {
        return tel;
    }
    public void setTel(Long tel) {
        this.tel = tel;
    }
    public String getPlus() {
        return plus;
    }
    public void setPlus(String plus) {
        this.plus = plus;
    }
    
    //Sobreescribo método compareTo
    @Override
    public int compareTo(Telefono t){
        return tel.compareTo(t.getTel());
    }
    
    //Sobreescribo método equals
    /* Aunque no utilizo el método equals
    lo sobreescribo a modo de aprendizaje
    es necesario comprobar que es Objeto de tipo Telefono
    */
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Telefono){
            Telefono t=(Telefono)obj;
            return tel==t.getTel();
        }
        return false;
    }
}