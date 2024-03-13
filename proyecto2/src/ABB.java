/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jesus
 */
public class ABB {

    private Nodo_ABB raiz;
    private int cant; //Cantidad de Nodos
    private int altura; //Altura del arbol

    public ABB() {
        raiz = null;
        cant = 0;
        altura = 0;

    }
    
    public boolean esvacio(){
        return raiz ==null;
    }
    
    // Método para insertar un nodo en el árbol
    public void insertar(int dato) {
        raiz = insertarRecursivo(raiz, dato);
    }

    // Método recursivo para insertar un nodo en el árbol
    private Nodo_ABB insertarRecursivo(Nodo_ABB nodo, int dato) {
        if (nodo == null) {
            cant++;
            return new Nodo_ABB(dato);
        }

        if ((float) dato < (float) nodo.getDato()) {
            nodo.setHijo_izq(insertarRecursivo(nodo.getHijo_izq(), dato));
        } else if ((float ) dato > (float) nodo.getDato()) {
            nodo.setHijo_der(insertarRecursivo(nodo.getHijo_der(), dato));
        }
        
        actualizarAltura(nodo);
        return nodo; 
        
         
    }

    // Método para buscar un nodo en el árbol
    public boolean buscar(int dato) {
        return buscarRecursivo(raiz, dato);
    }

    // Método recursivo para buscar un nodo en el árbol
    private boolean buscarRecursivo(Nodo_ABB nodo, int dato) {
        if (nodo == null) {
            return false;
        }

        if ((float) dato == nodo.getDato()) {
            return true;
        } else if ( dato < nodo.getDato()) {
            return buscarRecursivo(nodo.getHijo_izq(), dato);
        } else {
            return buscarRecursivo(nodo.getHijo_der(), dato);
        }
        
    }

    private int calcularAlturadeRaiz (Nodo_ABB p){  
        if (p == null){ 
            // mensaje de advetencia
        }else{ 
            int alturaRaiz = 1; 
            int alturaHijoIzq = calcularAlturadeRaiz(p.getHijo_izq()); 
            int alturaHijoDer = calcularAlturadeRaiz(p.getHijo_der()); 
            if (alturaHijoIzq > alturaHijoDer) { 
                altura = alturaHijoIzq + alturaRaiz; 
            }else { 
                altura = alturaHijoDer + alturaRaiz; 
            }
        }
       return altura; 
    }

    
    
    // Otros métodos como eliminar, calcular altura, etc.

    public int equilibrio(Nodo_ABB nodo){ 
        if (nodo == null) { 
            return 0; 
        }else{ 
           return nodo.getHijo_izq().getAltura() - nodo.getHijo_der().getAltura(); 
            
        }
    } 
        
    public Nodo_ABB getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo_ABB raiz) {
        this.raiz = raiz;
    }
    
    public int max(int altura_izq ,int altura_der){ 
        if ( altura_izq > altura_der){ 
            return altura_izq; 
        }else{ 
            return altura_der; 
        }
    }
    
    public Nodo_ABB actualizarAltura(Nodo_ABB nodo){ 
        
        nodo.setAltura(nodo.getAltura() + 1); 
            max(nodo.getHijo_izq().getAltura(), nodo.getHijo_der().getAltura()); 
            
   int e = equilibrio(nodo); 
   
   if (e > 1 && equilibrio(nodo.getHijo_izq()) >= 0){   
            return Rotar_izq(nodo); 
    }
   
    if (e < -1 && equilibrio(nodo.getHijo_der()) <= 0) {
            return Rotar_der(nodo);
    }
    
    if (e > 1 && equilibrio(nodo.getHijo_izq()) < 0){ 
         nodo.setHijo_izq(Rotar_izq(nodo.getHijo_izq()));
         return Rotar_der(nodo);
    }
    
    if (e < 1 && equilibrio(nodo.getHijo_der()) > 0){ 
         nodo.setHijo_der(Rotar_der(nodo.getHijo_der()));
         return Rotar_izq(nodo);
         
        }
    return nodo; 
    } 
    
    public Nodo_ABB Rotar_izq (Nodo_ABB nodo){ 
    Nodo_ABB nuevaRaiz = nodo.getHijo_izq();
    Nodo_ABB temp = nuevaRaiz.getHijo_der();
 
        // Se realiza la rotacion
    nuevaRaiz.setHijo_der(nodo);
    nodo.setHijo_izq(temp);
 
        // Actualiza alturas
    nodo.setAltura(max(nodo.getHijo_izq().getAltura(), nodo.getHijo_der().getAltura()) + 1); 
    nuevaRaiz.setAltura(max(nuevaRaiz.getHijo_izq().getAltura(), nuevaRaiz.getHijo_der().getAltura()) + 1);
 
    return nuevaRaiz;
    }
 
    // Rotar hacia la izquierda
    private Nodo_ABB Rotar_der(Nodo_ABB nodo) {
        Nodo_ABB nuevaRaiz = nodo.getHijo_der();
        Nodo_ABB temp = nuevaRaiz.getHijo_izq();
 
        // Se realiza la rotacion
        nuevaRaiz.setHijo_izq(nodo);
        nodo.setHijo_der(temp);
 
        // Actualiza alturas
        nodo.setAltura(max(nodo.getHijo_izq().getAltura(), nodo.getHijo_der().getAltura()) + 1);
        nuevaRaiz.setAltura(max(nodo.getHijo_izq().getAltura(), nodo.getHijo_der().getAltura()) + 1);
        
        return nuevaRaiz;
    }
    
    
}