package EDD;

import ClasesAux.Habitacion;
import ClasesAux.Reservacion;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * La clase ABB representa un árbol binario de búsqueda (ABB) que almacena reservaciones y habitaciones.
 * @author Carlos De Freitas
 * @version 17/03/2024
 */
public class ABB {

    private Nodo_ABB raiz;
    private int cant; //Cantidad de Nodos

    /**
     * Constructor de la clase ABB.
     */
    public ABB() {
        raiz = null;
        cant = 0;

    }
    
    /**
     * Verifica si el árbol está vacío.
     * @return true si el árbol está vacío, false de lo contrario.
     */
    public boolean esvacio(){
        return raiz ==null;
    }
    
    /**
     * Inserta una reservación en el árbol.
     * @param dato La reservación a insertar.
     */
    public void insertarReservacion(Object dato) {
        raiz = insertarRecursivoReservacion(raiz, dato);
        
    }

    /**
    * Inserta una reservación en el árbol de manera recursiva.
    * @param nodo El nodo actual en el proceso de inserción.
    * @param dato La reservación a insertar.
    * @return El nuevo nodo raíz del árbol después de la inserción.
    */
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
    
    /**
    * Inserta una habitación en el árbol.
    * @param dato La habitación a insertar.
    */
    public void insertarHabitacion(Object dato) {
        raiz = insertarRecursivoHabitacion(raiz, dato);
    }

    /**
    * Inserta una habitación en el árbol de manera recursiva.
    * @param nodo El nodo actual en el proceso de inserción.
    * @param dato La habitación a insertar.
    * @return El nuevo nodo raíz del árbol después de la inserción.
    */
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
    
    /**
    * Busca una reservación en el árbol por su número de cédula.
    * @param cedula El número de cédula del huésped.
    * @return La reservación encontrada, o null si no se encontró.
    */
    public Reservacion buscarReservacion(int cedula) {
        return buscarRecursivoReservacion(raiz, cedula);
    }

    /**
    * Busca una reservación en el árbol de manera recursiva por su número de cédula.
    * @param nodo El nodo actual en el proceso de búsqueda.
    * @param cedula El número de cédula del huésped.
    * @return La reservación encontrada, o null si no se encontró.
    */
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
    
    /**
    * Busca una habitación en el árbol por su número.
    * @param numero El número de la habitación.
    * @return La habitación encontrada, o null si no se encontró.
    */
    public Habitacion buscarHabitacion(int numero) {
        return buscarRecursivoHabitacion(raiz, numero);
    }
    
    /**
    * Busca una habitación en el árbol de manera recursiva por su número.
    * @param nodo El nodo actual en el proceso de búsqueda.
    * @param numero El número de la habitación.
    * @return La habitación encontrada, o null si no se encontró.
    */
    private Habitacion buscarRecursivoHabitacion(Nodo_ABB nodo, int numero) {
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
    
    /**
    * Elimina una reservación del árbol por su número de cédula.
    * @param cedula El número de cédula del huésped de la reservación a eliminar.
    */
    public void eliminarReservacion(int cedula){
        Reservacion reservacionbuscada = buscarReservacion(cedula); 
        raiz = eliminarRecursivo(raiz, reservacionbuscada); 
    }

    /**
    * Elimina una reservación del árbol de manera recursiva por su número de cédula.
    * @param nodo El nodo actual en el proceso de eliminación.
    * @param dato La reservación a eliminar.
    * @return El nuevo nodo raíz del árbol después de la eliminación.
    */
    public Nodo_ABB eliminarRecursivo(Nodo_ABB nodo, Object dato){
        Nodo_ABB temp; 
        if (nodo == null){ 
            return nodo; 
        } 

        if (((Reservacion)dato).getCedula() < ((Reservacion)nodo.getDato()).getCedula()) { 
            nodo.setHijo_izq(eliminarRecursivo(nodo.getHijo_izq(), dato)); 

        }else if(((Reservacion)dato).getCedula() > ((Reservacion)nodo.getDato()).getCedula()){
            nodo.setHijo_der(eliminarRecursivo(nodo.getHijo_der(), dato));
            
        }else{ 

            if ((nodo.getHijo_izq() == null) || (nodo.getHijo_der() == null)){ 
                temp = null; 
                    if (temp == nodo.getHijo_der()){
                        temp = nodo.getHijo_izq(); 
                    }else{ 
                        temp = nodo.getHijo_der(); 
                    }

                    if (temp == null){
                        nodo = null;
                    }else{ 
                        nodo = temp; 
                    }
            }else{ 

                temp = getNodoValorMaximo(nodo.getHijo_izq());

                nodo.setDato((Reservacion)temp.getDato());

                nodo.setHijo_izq(eliminarRecursivo(nodo.getHijo_izq(), ((Reservacion)temp.getDato())));

            }
        }

        if (nodo == null){
            return nodo; 
        }
        nodo = actualizarAlturaReservacion(nodo, dato);
        return nodo; 
    }

    /**
    * Calcula el factor de equilibrio de un nodo en el árbol.
    * El factor de equilibrio se define como la diferencia entre la altura del subárbol derecho y la altura del subárbol izquierdo.
    * @param nodo El nodo para calcular el factor de equilibrio.
    * @return El factor de equilibrio del nodo.
    */
    public int equilibrio(Nodo_ABB nodo){
        if (nodo == null) {
            return 0;
        }else{
           return GetAltura(nodo.getHijo_der()) - GetAltura(nodo.getHijo_izq());
            
        }
    }
    
    /**
    * Obtiene la raíz del árbol.
    * @return La raíz del árbol.
    */
    public Nodo_ABB getRaiz() {
        return raiz;
    }

    /**
    * Establece la raíz del árbol.
    * @param raiz La nueva raíz del árbol.
    */
    public void setRaiz(Nodo_ABB raiz) {
        this.raiz = raiz;
    }
    
    /**
    * Calcula el máximo entre dos alturas.
    * @param altura_izq La altura del subárbol izquierdo.
    * @param altura_der La altura del subárbol derecho.
    * @return El máximo entre las alturas.
    */
    public int max(int altura_izq ,int altura_der){
        if (altura_izq > altura_der){
            return altura_izq;
        }else{
            return altura_der;
        }
    }
    
    /**
    * Actualiza la altura de un nodo en el árbol después de una inserción o eliminación.
    * @param nodo El nodo que se actualizará.
    * @param dato El dato de la reservación que se insertó o eliminó.
    * @return El nodo actualizado.
    */
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
        return Rotar_izq(nodo); 
        
        
        }
    
    return nodo;
    }
    
    /**
    * Actualiza la altura de un nodo en el árbol después de una inserción o eliminación.
    * @param nodo El nodo que se actualizará.
    * @param dato El dato de la habitación que se insertó o eliminó.
    * @return El nodo actualizado.
    */
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
    
    /**
    * Realiza una rotación a la izquierda en un nodo del árbol.
    * @param nodo El nodo sobre el cual se realizará la rotación.
    * @return El nuevo nodo raíz después de la rotación.
    */
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
 
    /**
    * Realiza una rotación a la derecha en un nodo del árbol.
    * @param nodo El nodo sobre el cual se realizará la rotación.
    * @return El nuevo nodo raíz después de la rotación.
    */
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
    
    /**
    * Obtiene la altura de un nodo en el árbol.
    * @param nodo El nodo del cual se desea obtener la altura.
    * @return La altura del nodo.
    */
    public int GetAltura (Nodo_ABB nodo){
        if (nodo == null){
            return 0;
        }else{ 
            return nodo.getAltura();
        }
    }
    
    /**
    * Encuentra el nodo con el valor máximo en un subárbol.
    * @param nodo El nodo raíz del subárbol.
    * @return El nodo con el valor máximo en el subárbol.
    */
    private Nodo_ABB getNodoValorMaximo(Nodo_ABB nodo) {
        Nodo_ABB actual = nodo;

        while (actual.getHijo_der() != null){
           actual = actual.getHijo_der();
        }

        return actual;
    }

}