package prog10_ejer01;

/**
 *
 * @author IVAN
 */
public class Idioma {
    private String idioma;
    private String traduccion;

    public Idioma() {
    }

    public Idioma(String idioma, String traduccion) {
        this.idioma = idioma;
        this.traduccion = traduccion;
    }

    public String getIdioma() {
        return idioma;
    }
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
    public String getTraduccion() {
        return traduccion;
    }
    public void setTraduccion(String traduccion) {
        this.traduccion = traduccion;
    }
    
}