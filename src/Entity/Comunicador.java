/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Melanio
 */
public class Comunicador {

        private static Object objeto = null;

        public static void setObjeto(Object newObjeto) {
            objeto = newObjeto;
        }

        public static Object getObjeto() {
            return objeto;
        }
    }

