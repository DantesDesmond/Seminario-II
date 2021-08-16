/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public class ArbolBinario {

    NodoArbol raiz;

    public ArbolBinario() {
        raiz = null;
    }

    //Creamos un metodo para insertar un nodo en el Arbool
    public void agregarNodo(int d, String nom) {
        NodoArbol nuevo = new NodoArbol(d, nom);
        if (raiz == null) {
            raiz = nuevo;
        } else {
            NodoArbol auxiliar = raiz;
            NodoArbol padre;
            while (true) {
                padre = auxiliar;
                if (d < auxiliar.dato) {
                    auxiliar = auxiliar.hijoIzquierdo;
                    if (auxiliar == null) {
                        padre.hijoIzquierdo = nuevo;
                        return;
                    } else {
                        auxiliar = auxiliar.hijoDerecho;
                        if (auxiliar == null) {
                            padre.hijoDerecho = nuevo;
                            return;
                        }
                    }
                }
            }
        }
    }
    // Creamos un método que me diga cuando el árbol esta vacío o nulo

    public boolean estaVacio() {
        return raiz == null;
    }
    //Creamos otro metodo para recorrer el Arbon en la forma Inorden

    public void inOrden(NodoArbol r) {
        if (r != null) {
            inOrden(r.hijoIzquierdo);
            System.out.print(r.dato + ", ");
            inOrden(r.hijoDerecho);
        }
    }
    //Creamos otro metodo para recorrer el Arbon en la forma PreOrden

    public void preOrden(NodoArbol r) {
        if (r != null) {
            System.out.print(r.dato + ", ");
            preOrden(r.hijoIzquierdo);
            preOrden(r.hijoDerecho);
        }
    }
    //Creamos otro metodo para recorrer el Arbon en la forma PostOrden  

    public void postOrden(NodoArbol r) {
        if (r != null) {
            postOrden(r.hijoIzquierdo);
            postOrden(r.hijoDerecho);
            System.out.print(r.dato + ", ");
        }
    }
    //Creamos otro metodo para buscar un nodo en el Arbol

    public NodoArbol buscarNodo(int d) {
        NodoArbol aux = raiz;
        while (aux.dato != d) {
            if (d < aux.dato) {
                aux = aux.hijoIzquierdo;
            } else {
                aux = aux.hijoDerecho;
            }
            if (aux == null) {
                return null;
            }
        }
        return aux;
    }
    //Creamos un Metodo para eliminar un Nodo del Arbol

    public boolean eliminar(int d) {
        NodoArbol auxiliar=raiz;
        NodoArbol padre=raiz;
        boolean esHijoIzq = true;
        while (auxiliar.dato != d) {
            padre = auxiliar;
            if (d < auxiliar.dato) {
                esHijoIzq = true;
                auxiliar = auxiliar.hijoIzquierdo;
            } else {
                esHijoIzq = false;
                auxiliar = auxiliar.hijoDerecho;
            }
            if (auxiliar == null) {
                return false;
            }
        }//Fin del while
        if (auxiliar.hijoIzquierdo == null && auxiliar.hijoDerecho == null) {
            if (auxiliar == raiz) {
                raiz = null;
            } else if (esHijoIzq) {
                padre.hijoIzquierdo = null;
            } else {
                padre.hijoDerecho = null;
            }
        } else if (auxiliar.hijoDerecho == null) {
            if (auxiliar == raiz) {
                raiz = auxiliar.hijoIzquierdo;
            } else if (esHijoIzq) {
                padre.hijoIzquierdo = auxiliar.hijoIzquierdo;
            } else {
                padre.hijoDerecho = auxiliar.hijoIzquierdo;
            }
        } else if (auxiliar.hijoIzquierdo == null) {
            if (auxiliar == raiz) {
                raiz = auxiliar.hijoDerecho;
            } else if (esHijoIzq) {
                padre.hijoIzquierdo = auxiliar.hijoDerecho;
            } else {
                padre.hijoDerecho = auxiliar.hijoIzquierdo;
            }
        } else {
            NodoArbol reemplazo=obtenerNodoReemplazo(auxiliar);
            if (auxiliar == raiz) {
                raiz = reemplazo;
            } else if (esHijoIzq) {
                padre.hijoIzquierdo = reemplazo;
            } else {
                padre.hijoDerecho = reemplazo;
            }
            reemplazo.hijoIzquierdo = auxiliar.hijoIzquierdo;
        }
        return true;
    }
    // Creamos el metodo que sera el encargado de devolvernos el Nodo Reemplazo

    public NodoArbol obtenerNodoReemplazo(NodoArbol nodoReemp) {
        NodoArbol reemplazarPadre = nodoReemp;
        NodoArbol reemplazo = nodoReemp;
        NodoArbol auxiliar = nodoReemp.hijoDerecho;
        while (auxiliar != null) {
            reemplazarPadre = reemplazo;
            reemplazo = auxiliar;
            auxiliar = auxiliar.hijoIzquierdo;
        }
        if (reemplazo != nodoReemp.hijoDerecho) {
            reemplazarPadre.hijoIzquierdo = reemplazo.hijoDerecho;
            reemplazo.hijoDerecho = nodoReemp.hijoDerecho;
        }
        System.out.println("El Nodo Reemplazo es " + reemplazo);
        return reemplazo;
    }
}
