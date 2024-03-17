package Proyecto2;

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
    public void insertarReservacion(Object dato) {
        raiz = insertarRecursivoReservacion(raiz, dato);
        
    }

    // Método recursivo para insertar un nodo en el árbol
    private Nodo_ABB insertarRecursivoReservacion(Nodo_ABB nodo, Object dato) {
        if (nodo == null) {
            cant++;
            return new Nodo_ABB(dato);
        }

        if (((Reservacion)dato).getCedula() < ((Reservacion)nodo.getDato()).getCedula()) {
            nodo.setHijo_izq(insertarRecursivoReservacion(nodo.getHijo_izq(), dato));
        }else if (((Reservacion)dato).getCedula() > ((Reservacion)nodo.getDato()).getCedula()){
            nodo.setHijo_der(insertarRecursivoReservacion(nodo.getHijo_der(), dato)); 
        }else{ 
        return nodo;
        }
        nodo = actualizarAlturaReservacion(nodo,dato);
        return nodo;
    }
    
    public void insertarHabitacion(Object dato) {
        raiz = insertarRecursivoHabitacion(raiz, dato);
    }

    private Nodo_ABB insertarRecursivoHabitacion(Nodo_ABB nodo, Object dato) {
        if (nodo == null) {
            cant++;
            return new Nodo_ABB(dato);
        }

        if (((Habitacion)dato).getNumero()< ((Habitacion)nodo.getDato()).getNumero()) {
            nodo.setHijo_izq(insertarRecursivoHabitacion(nodo.getHijo_izq(), dato));
        }else if (((Habitacion)dato).getNumero() > ((Habitacion)nodo.getDato()).getNumero()){
            nodo.setHijo_der(insertarRecursivoHabitacion(nodo.getHijo_der(), dato)); 
        }else{ 
        return nodo;
        }
        nodo = actualizarAlturaHabitacion(nodo,dato);
        return nodo;
    }
    
    public Reservacion buscarReservacion(int cedula) {
        return buscarRecursivoReservacion(raiz, cedula);
    }

    private Reservacion buscarRecursivoReservacion(Nodo_ABB nodo, int cedula) {
        if (nodo == null) {
            return null; // Si el nodo es nulo, la cédula no está presente en el árbol
        }
        // Comparamos la cédula del nodo actual con la cédula buscada
        int cedulaNodo = ((Reservacion) nodo.getDato()).getCedula();
        if (cedula == cedulaNodo) {
            return (Reservacion) nodo.getDato(); // Se encontró la reservación
        } else if (cedula < cedulaNodo) {
            // Si la cédula buscada es menor, buscamos en el subárbol izquierdo
            return buscarRecursivoReservacion(nodo.getHijo_izq(), cedula);
        } else {
            // Si la cédula buscada es mayor, buscamos en el subárbol derecho
            return buscarRecursivoReservacion(nodo.getHijo_der(), cedula);
        }
    }
    
    public Habitacion buscarHabitacion(int numero) {
        return buscarRecursivoHabitacion(raiz, numero);
    }
    
    public Habitacion buscarRecursivoHabitacion(Nodo_ABB nodo, int numero) {
        if (nodo == null) {
            return null;
        }
        
        int numeroNodo = ((Habitacion) nodo.getDato()).getNumero();
        if (numero == numeroNodo) {
            return (Habitacion) nodo.getDato();
        } else if (numero < numeroNodo) {
            
            return buscarRecursivoHabitacion(nodo.getHijo_izq(), numero);
        } else {
            
            return buscarRecursivoHabitacion(nodo.getHijo_der(), numero);
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
    
    public Nodo_ABB actualizarAlturaReservacion(Nodo_ABB nodo, Object dato){

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
    
    public Nodo_ABB actualizarAlturaHabitacion(Nodo_ABB nodo, Object dato){

    nodo.setAltura(max(GetAltura(nodo.getHijo_izq()), GetAltura(nodo.getHijo_der())) + 1);
            
    int e = equilibrio(nodo);
   
    if (e > 1 && ((Habitacion)dato).getNumero() > ((Habitacion)nodo.getHijo_der().getDato()).getNumero()){
        return Rotar_izq(nodo);
    }
   
    if (e < -1 && ((Habitacion)dato).getNumero() < ((Habitacion)nodo.getHijo_izq().getDato()).getNumero()) {
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
    
    public int GetAltura (Nodo_ABB nodo){
        if (nodo == null){
            return 0;
        }else{ 
            return nodo.getAltura();
        }
    }

}