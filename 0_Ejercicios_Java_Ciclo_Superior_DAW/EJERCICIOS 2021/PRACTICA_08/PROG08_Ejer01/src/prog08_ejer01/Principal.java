package prog08_ejer01;
// EJEMPLOS PARA COMPROBAR EL FUNCIONAMIENTO DEL PROGRAMA
// X12345678F,"nombre","apellidos",+(82)12345678, 612345678,test@TEST.com,(91)23456789 ,prueba@prueba.com
// 12345678Z,"nombre","apellidos", prueba@prueba.com,(952)333333,test@test.com ,952333333,test@TEST.com

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Principal {
    static ArrayList<Telefono> telefonos;
    static ArrayList<Email> emails;
    
    static Pattern pDni=Pattern.compile("^[A-Za-z]?[0-9]{1,9}[A-Za-z]$");
    static Pattern pNom=Pattern.compile("^[\"][A-Za-z]+[\"]$");
    static Pattern pTel=Pattern.compile("^(\\+)?(\\([0-9]{2,3}\\))?([0-9]{6,9})$");
    static Pattern pEmail=Pattern.compile("^([^0-9|^\\@|^\\.|^www\\.])[A-Za-z0-9]+[\\@][A-Za-z0-9]+[\\.][A-Za-z]{2,3}$");

    public static void main(String[] args) {
        String cadena="";
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));       
        try {
            System.out.println("Introduce datos cliente:");
            cadena=reader.readLine();
        } catch (Exception e) {
            System.out.println("Se ha producido un error al introducir los datos de cliente");
        }
        descomponer(cadena);
    }
    
    private static void descomponer(String cadena){
        String[] subCadena=cadena.split(",");
        Matcher mDni,mNom,mTel,mEmail;
        Cliente c=new Cliente();
        String plus;
        String tel;
        String pre;
        telefonos=new ArrayList<Telefono>();
        emails=new ArrayList<Email>();
        boolean repTel;
        boolean repEmail;
        
        int i=1;
        for(String s:subCadena){
            plus="";
            tel="";
            pre="";
            s=s.trim();
            mDni=pDni.matcher(s);
            mNom=pNom.matcher(s);
            mTel=pTel.matcher(s);
            mEmail=pEmail.matcher(s);
            repTel=false;
            repEmail=false;
            
            //Si la subcadena es DNI
            if(mDni.matches()&&(i==1)){
                c.setDni(s);
            //Si la subcadena es Nombre
            }else if(mNom.matches()&&(i==2)){
                s=s.substring(1,s.length()-1);
                c.setNombre(s);
            //Si la subcadena es Apellidos
            }else if(mNom.matches()&&(i==3)){
                s=s.substring(1,s.length()-1);
                c.setApellidos(s);
            //Si la subcadena es Telefono
            }else if(mTel.matches()){
                if(mTel.group(1)!=null){
                    if(mTel.group(1).equals("+")){
                        plus="+";
                    }
                }
                if(mTel.group(2)!=null){
                    pre=mTel.group(2).substring(1,mTel.group(2).length()-1);
                }
                if(mTel.group(3)!=null){
                    tel=mTel.group(3);
                }
                Telefono telefono=new Telefono();
                telefono.setTel(Long.valueOf(pre+tel));
                telefono.setPlus(plus);
                for(Telefono t:telefonos){ 
                    if(t.compareTo(telefono)==0) repTel=true;
                }
                if(repTel==false) telefonos.add(telefono);
            //Si la subcadena es Email
            }else if(mEmail.matches()){
                Email email=new Email();
                s=s.toLowerCase();
                email.setEmail(s);
                for(Email e: emails){
                    if(e.compareTo(email)==0) repEmail=true;
                }
                if(repEmail==false) emails.add(email);
            //Si no coincide con ningun Pattern
            }else{
                System.out.println("El texto introducido no es correcto");
            }            
            i++;
        }
        
        //Ordenar el ArrayList telefonos y emails e añadirlos a la Clase Cliente
        //mediante el método reverse se da la vuelta al ArrayList para que los teléfonos queden según indica el enunciado
        Collections.sort(telefonos);
        Collections.reverse(telefonos);
        c.setTelefonos(telefonos);
        Collections.sort(emails);
        c.setEmails(emails);
        
        // Genera DOM vacio con el elemento raíz "datos_cliente"
        Document doc=DOMUtil.crearDOMVacio("datos_cliente");
        // Introducir los datos
        introducirDatosXML(doc,c);
        // Generar el XML en un archivo externo "prueba.xml"
        DOMUtil.DOM2XML(doc, "prueba.xml");   
    }
    
    private static void introducirDatosXML(Document doc,Cliente c){
        Element e=null;
        Element s=null;
        
        //Genera Elemento "id" como elemento hijo del documento donde se añade el texto del DNI.
        e=doc.createElement("id");
        e.setTextContent(c.getDni());
        doc.getDocumentElement().appendChild(e);
        
        //Genera Elemento "nombre" como elemento hijo del documento donde se añade el texto del Nombre.
        e=doc.createElement("nombre");
        e.setTextContent(c.getNombre());
        doc.getDocumentElement().appendChild(e);
        
        //Genera Elemento "apellidos" como elemento hijo del documento donde se añade el texto de Apellidos.
        e=doc.createElement("apellidos");
        e.setTextContent(c.getApellidos());
        doc.getDocumentElement().appendChild(e);
        
        //Genera Elemento "telefonos" con atributo con la cantidad de telefonos
        //Genera los hijos de cada telefono
        //Como deben aparecer primero los numeros nacionales (sin +) genero 2 bucles
        e=doc.createElement("telefonos");
        e.setAttribute("total", String.valueOf(c.getTelefonos().size()));
        for(Telefono t: c.getTelefonos()){
            if(t.getPlus().equals("")){
                s=doc.createElement("telefono");
                s.setTextContent(String.valueOf(t.getTel()));
                e.appendChild(s);
            }
        }
        for(Telefono t:c.getTelefonos()){
            if(t.getPlus().equals("+")){
                s=doc.createElement("telefono");
                s.setTextContent(t.getPlus()+String.valueOf(t.getTel()));
                e.appendChild(s);
            }  
        }
        doc.getDocumentElement().appendChild(e);
        
        //Genera Elemento "emails" y dentro cada uno de los elementos "email"
        e=doc.createElement("mails");
        for(Email x:c.getEmails()){
            s=doc.createElement("mail");
            s.setTextContent(x.getEmail());
            e.appendChild(s);
        }
        doc.getDocumentElement().appendChild(e);
        
        
    }
    
    
}