
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public class Seminario2 {
   /**
    * @param args the command line arguments
    */
public static void main(String[]args){
    // Todo code application logic here
    int opcion=0, elemento;
    String nombre;
    ArbolBinario arbolito= new ArbolBinario();
    do{
        try{
            opcion= Integer.parseInt(JOptionPane.showInputDialog(null, 
                     "1. Agregar un Nodo\n" +
                     "2. Recorrer el arbol inOrden\n" +
                     "3. Recorrer el arbol preOrden\n" + 
                     "4. Recorrer el arbol postOrden\n" +  
                     "5. Buscar un Nodo en el Arbol\n"+
                     "6. Eliminar un Nodo del Arbol\n"+
                     "7. Salir\n" +
                     "Elige una opcion...","Arboles Binarios", JOptionPane.QUESTION_MESSAGE));
                    switch (opcion){
                case 1:
                    elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Ingresa el Numero del Nodo...","Agregando Nodo" 
                        ,JOptionPane.QUESTION_MESSAGE));
                        nombre = JOptionPane.showInputDialog(null, "Ingresa el Nombre del Nodo...","Agregando Nodo"
                        ,JOptionPane.QUESTION_MESSAGE);
                    arbolito.agregarNodo(elemento,nombre);                               
                    break;
                case 2:
                    if(!arbolito.estaVacio()){
                        System.out.println();
                        arbolito.inOrden(arbolito.raiz);
                    }else{
                    JOptionPane.showMessageDialog(null, "El Arbol esta vacio","Cuidado", 
                        JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;
                case 3:
                     if(!arbolito.estaVacio()){
                        System.out.println();
                        arbolito.preOrden(arbolito.raiz);
                    }else{
                    JOptionPane.showMessageDialog(null, "El Arbol esta vacio","Cuidado", 
                        JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;
                case 4:
                    if(!arbolito.estaVacio()){
                        System.out.println();
                        arbolito.postOrden(arbolito.raiz);
                    }else{
                    JOptionPane.showMessageDialog(null, "El Arbol esta vacio","Cuidado", 
                        JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;
                case 5:
                    if (!arbolito.estaVacio()){
                        elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Ingresa el Numero del Nodo que buscas...","Buscando Nodo" 
                        ,JOptionPane.QUESTION_MESSAGE));
                        if(arbolito.buscarNodo(elemento)==null){
                          JOptionPane.showMessageDialog(null,"Nodo no fue encontrado en el Arbol","No se encuentra", 
                            JOptionPane.INFORMATION_MESSAGE);
                        }else{
                           System.out.println("El Nodo Encontrado, es el nodo:" + arbolito.buscarNodo(elemento));
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"El Arbol esta vacio","Cuidado", 
                        JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;
                case 6:
                    if (!arbolito.estaVacio()){
                        elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Ingresa el Nodo a eliminar...","Eliminando Nodo" 
                        ,JOptionPane.QUESTION_MESSAGE));
                        if(arbolito.eliminar(elemento)==false){
                          JOptionPane.showMessageDialog(null,"Nodo no fue encontrado del Arbol","No se encuentra", 
                            JOptionPane.INFORMATION_MESSAGE);
                        }else{
                          JOptionPane.showMessageDialog(null,"Nodo fue eliminado en el Arbol","No se encuentra", 
                            JOptionPane.INFORMATION_MESSAGE);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"El Arbol esta vacio","Cuidado", 
                        JOptionPane.INFORMATION_MESSAGE);
                    }
                    
                    break;
                case 7:
                    JOptionPane.showMessageDialog(null, "Aplicacion Finalizada","Fin", 
                        JOptionPane.INFORMATION_MESSAGE);
                    break;
                    default:
                    JOptionPane.showMessageDialog(null, "Opcion Incorrecta","!Cuidado!", 
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }catch (NumberFormatException n){
            JOptionPane.showMessageDialog(null,"Error" + n.getMessage());
        }
        }while (opcion!=7);
    }
}