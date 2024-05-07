/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menuUtils;

/**
 *
 * @author mabardaji
 */
public class OptionDuplicateException extends Exception {

    public OptionDuplicateException(String message) {
        super("Opción ya existente-> " + message);
    }
    
    
    
}
