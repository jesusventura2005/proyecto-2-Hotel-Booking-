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
    public void insertar(Object dato) {
        raiz = insertarRecursivo(raiz, dato);
    }

    // Método recursivo para insertar un nodo en el árbol
    private Nodo_ABB insertarRecursivo(Nodo_ABB nodo, Object dato) {
        if (nodo == null) {
            cant++;
            return new Nodo_ABB(dato);
        }

        if (((Reservacion)dato).getCedula() < ((Reservacion)nodo.getDato()).getCedula()) {
            nodo.setHijo_izq(insertarRecursivo(nodo.getHijo_izq(), dato));
        }else if (((Reservacion)dato).getCedula() > ((Reservacion)nodo.getDato()).getCedula()){
            nodo.setHijo_der(insertarRecursivo(nodo.getHijo_der(), dato));
        } 
//        }else{ Caso útil si hay repetición en la lista (no es el caso por el momento) 
//        return nodo;
//        }
    actualizarAltura(nodo);
    return nodo; 

    }

    // Método para buscar un nodo en el árbol
//    public boolean buscar(int dato) {
//        return buscarRecursivo(raiz, dato);
//    }
//
//    // Método recursivo para buscar un nodo en el árbol
//    private boolean buscarRecursivo(Nodo_ABB nodo, int dato) {
//        if (nodo == null) {
//            return false;
//        }
//
//        if ((float) dato == nodo.getDato()) {
//            return true;
//        } else if ( dato < nodo.getDato()) {
//            return buscarRecursivo(nodo.getHijo_izq(), dato);
//        } else {
//            return buscarRecursivo(nodo.getHijo_der(), dato);
//        }
//        
//    }

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
           return GetAltura(nodo.getHijo_der()) - GetAltura(nodo.getHijo_izq()); 
            
        }
    } 
        
    public Nodo_ABB getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo_ABB raiz) {
        this.raiz = raiz;
    }
    
    public int max(int altura_izq ,int altura_der){
        if (altura_izq > altura_der){ 
            return altura_izq; 
        }else{ 
            return altura_der; 
        }
    }
    
    public Nodo_ABB actualizarAltura(Nodo_ABB nodo){ 

    nodo.setAltura(max(GetAltura(nodo.getHijo_izq()), GetAltura(nodo.getHijo_der()) + 1)); 
            
   int e = equilibrio(nodo); 
   
   if (e > 1 && equilibrio(nodo.getHijo_der()) >= 0){   
            return Rotar_izq(nodo); 
    }
   
    if (e < -1 && equilibrio(nodo.getHijo_izq()) <= 0) {
            return Rotar_der(nodo);
    }
    
    if (e < -1 && equilibrio(nodo.getHijo_der()) > 0){ 
//         nodo.setHijo_der(Rotar_der(nodo.getHijo_der()));
//         return Rotar_izq(nodo);
           return RDI(nodo);  
    }
    
    if (e > 1 && equilibrio(nodo.getHijo_der()) < 0){ 
//        nodo.setHijo_izq(Rotar_izq(nodo.getHijo_izq()));
//        return Rotar_der(nodo); 
          return RDD(nodo); 
        }
    return nodo; 
    } 
    
    public Nodo_ABB Rotar_izq (Nodo_ABB nodo){ 
    Nodo_ABB nuevaRaiz = nodo.getHijo_der();
    Nodo_ABB temp = nuevaRaiz.getHijo_izq();
 
        // Se realiza la rotacion
    nuevaRaiz.setHijo_izq(nodo);
    nodo.setHijo_der(temp);
 
        // Actualiza alturas
    nodo.setAltura(max(GetAltura(nodo.getHijo_izq()), GetAltura(nodo.getHijo_der()) + 1)); 
    nuevaRaiz.setAltura(max(GetAltura(nuevaRaiz.getHijo_izq()), GetAltura(nuevaRaiz.getHijo_der())) + 1);
 
    return nuevaRaiz;
    }
 
    // Rotar hacia la izquierda
    private Nodo_ABB Rotar_der(Nodo_ABB nodo) {
        Nodo_ABB nuevaRaiz = nodo.getHijo_izq();
        Nodo_ABB temp = nuevaRaiz.getHijo_der();
 
        // Se realiza la rotacion
        nuevaRaiz.setHijo_der(nodo);
        nodo.setHijo_izq(temp);
 
        // Actualiza alturas
        nodo.setAltura(max(GetAltura(nodo.getHijo_izq()), GetAltura(nodo.getHijo_der()) + 1));
        nuevaRaiz.setAltura(max(GetAltura(nuevaRaiz.getHijo_izq()), GetAltura(nuevaRaiz.getHijo_der()) + 1));
        
        return nuevaRaiz;
    }
    
    private Nodo_ABB RDD (Nodo_ABB nodo){ 
        Nodo_ABB NuevaRaizC = nodo.getHijo_der(); 
        Nodo_ABB temp = NuevaRaizC.getHijo_izq(); 
        
        nodo.setHijo_der(temp);
        temp.setHijo_der(NuevaRaizC);
        NuevaRaizC.setHijo_izq(null);
        
        nodo.setAltura(max(GetAltura(nodo.getHijo_izq()), GetAltura(nodo.getHijo_der()) + 1));
        NuevaRaizC.setAltura(max(GetAltura(NuevaRaizC.getHijo_izq()), GetAltura(NuevaRaizC.getHijo_der()) + 1));
        temp.setAltura(max(GetAltura(temp.getHijo_izq()), GetAltura(temp.getHijo_der())+ 1 )); 
         
        return Rotar_izq(nodo); 
      
    }
    
    private Nodo_ABB RDI (Nodo_ABB nodo){ 
        Nodo_ABB NuevaRaizC = nodo.getHijo_izq(); 
        Nodo_ABB temp = NuevaRaizC.getHijo_der(); 
        
        nodo.setHijo_izq(temp);
        temp.setHijo_izq(NuevaRaizC);
        NuevaRaizC.setHijo_der(null);
        
        nodo.setAltura(max(GetAltura(nodo.getHijo_izq()), GetAltura(nodo.getHijo_der()) + 1));
        NuevaRaizC.setAltura(max(GetAltura(NuevaRaizC.getHijo_izq()), GetAltura(NuevaRaizC.getHijo_der()) + 1));
        temp.setAltura(max(GetAltura(temp.getHijo_izq()), GetAltura(temp.getHijo_der())+ 1 )); 
         
        return Rotar_der(nodo); 
      
    }
    
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Árbol Binario de Búsqueda:\n");
        sb.append(toStringRecursivo(raiz));
        return sb.toString();
    }

    public String toStringRecursivo(Nodo_ABB nodo) {
        StringBuilder sb = new StringBuilder();
        if (nodo != null) {
            sb.append(toStringRecursivo(nodo.getHijo_izq()));
            sb.append(((Reservacion)nodo.getDato()).toStringReservacion()).append(", ");
            sb.append(toStringRecursivo(nodo.getHijo_der()));
        }
        return sb.toString();
    }
    
    
    public int GetAltura (Nodo_ABB nodo){ 
        if (nodo == null){ 
            return 0;  
        }else{ 
            return nodo.getAltura(); 
    }
    } 
}