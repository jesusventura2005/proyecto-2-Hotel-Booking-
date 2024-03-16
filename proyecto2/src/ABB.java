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
        }else{ 
        return nodo;
        }
    nodo = actualizarAltura(nodo,dato);
    return nodo; 
    }

    public Reservacion buscar(int cedula) {
        return buscarRecursivo(raiz, cedula);
    }

    private Reservacion buscarRecursivo(Nodo_ABB nodo, int cedula) {
        if (nodo == null) {
            return null; // Si el nodo es nulo, la cédula no está presente en el árbol
        }
        // Comparamos la cédula del nodo actual con la cédula buscada
        int cedulaNodo = ((Reservacion) nodo.getDato()).getCedula();
        if (cedula == cedulaNodo) {
            return (Reservacion) nodo.getDato(); // Se encontró la reservación
        } else if (cedula < cedulaNodo) {
            // Si la cédula buscada es menor, buscamos en el subárbol izquierdo
            return buscarRecursivo(nodo.getHijo_izq(), cedula);
        } else {
            // Si la cédula buscada es mayor, buscamos en el subárbol derecho
            return buscarRecursivo(nodo.getHijo_der(), cedula);
        }
    }


    private int calcularAlturadeRaiz (Nodo_ABB p){
        if (p == null){
            // mensaje de advertencia
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
    
    public Nodo_ABB actualizarAltura(Nodo_ABB nodo, Object dato){

    nodo.setAltura(max(GetAltura(nodo.getHijo_izq()), GetAltura(nodo.getHijo_der())) + 1);
            
    int e = equilibrio(nodo);
   
    if (e > 1 && ((Reservacion)dato).getCedula() > ((Reservacion)nodo.getHijo_der().getDato()).getCedula()){
            return Rotar_izq(nodo);
    }
   
    if (e < -1 && ((Reservacion)dato).getCedula() < ((Reservacion)nodo.getHijo_izq().getDato()).getCedula()) {
            return Rotar_der(nodo);
    }
    
    if (e < -1 && equilibrio(nodo.getHijo_izq()) > 0){
        nodo.setHijo_izq(Rotar_izq(nodo.getHijo_izq()));
        return Rotar_der(nodo); 
    }
    
    if (e > 1 && equilibrio(nodo.getHijo_der()) < 0){
        nodo.setHijo_der(Rotar_der(nodo.getHijo_der()));
        Rotar_izq(nodo); 
        return nodo;
        
        }
    
    return nodo;
    } 
    
    private Nodo_ABB Rotar_izq (Nodo_ABB nodo){
    Nodo_ABB nuevaRaiz = nodo.getHijo_der();
    Nodo_ABB temp = nuevaRaiz.getHijo_izq();

        // Se realiza la rotacion
    nuevaRaiz.setHijo_izq(nodo);
    nodo.setHijo_der(temp);
    
        // Actualiza alturas
    nodo.setAltura(max(GetAltura(nodo.getHijo_izq()), GetAltura(nodo.getHijo_der())) + 1);
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
    nodo.setAltura(max(GetAltura(nodo.getHijo_izq()), GetAltura(nodo.getHijo_der())) + 1);
    nuevaRaiz.setAltura(max(GetAltura(nuevaRaiz.getHijo_izq()), GetAltura(nuevaRaiz.getHijo_der())) + 1);
        
    return nuevaRaiz;
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
            sb.append(((Reservacion)nodo.getDato()).toString()).append(", ");
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