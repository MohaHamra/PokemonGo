/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pokemon.go;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import fitxers.FitxerCaratula;
import java.sql.SQLException;
import java.util.Scanner;
import model.entrenador;
import model.entrenadorDAO;

/**
 *
 * @author Moha
 */
public class POKEMONGO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        POKEMONGO app = new POKEMONGO();
        app.run();
    }
    
    private void run() {
        String ruta = "fitxers/logo.pok";
        FitxerCaratula fitxer = new FitxerCaratula(ruta);
        
        try {
            List<String> lineas = fitxer.cargarCaratula();
            for (String linea : lineas) {
                System.out.println(linea);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        pedrirAutentificacion();
        boolean exit = false;
        do{
            int opcion = Menu();
            switch(opcion){
                case 0:
                    exit=true;
                    break;
                case 1:
                    AltaEntrenador();
                    break;
                case 2:
                    BajaEntrenador();
                    break;                     
                case 3:                    
                    ConsultarEntrenador();
                    break;  
                case 5:
                    TodosEntrenadores();
                    break;
                case 6:
                    CazarPokemon();
                case 7:
                    ListarPokemonsCazados();
                case 8:
                    ListarPokemonsExsistentes();
                }   
            }while(!exit);
        
    }
    
    private int Menu() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] options = {
            "DAR DE ALTA ENTRENADOR", "DAR DE BAJA ENTRENADOR", "CONSULTAR ENTRENADOR",
            "CAZAR POKEMON", "LISTAR POKEMONS CAZADOS", "LISTAR POKEMONS EXSISTENTES",};
        for (int i = 0; i < options.length; i++) {
            System.out.format("[%d]. %s\n", i, options[i]);
        }
        System.out.print("Elige una opcion: ");
        int op;
        try {
            op = Integer.parseInt((reader.readLine()));
        } catch (NumberFormatException | IOException e) {
            op = -1;
        }
        return op;
    }

    private void AltaEntrenador() {
        try {
            System.out.println("Has elegido la opcion DAR DE ALTA ENTRENADOR!");
            Scanner sc = new Scanner(System.in);
            System.out.println("Introduce el nombre:");
            String nom = sc.nextLine();
            System.out.println("Introduce la contrasenya:");
            String contra = sc.nextLine();
            
            entrenadorDAO catalogo = new entrenadorDAO();
            
            entrenador entr = new entrenador(nom, contra);

            
            if (catalogo.exsisteixEntrenador(nom) == null){
                catalogo.altraEntrenador(entr);
            }
            else{
                System.out.println("El entrenador ya exsiste!");
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void BajaEntrenador() {
        try {
            System.out.println("Has elegido la opcion DAR DE BAJA ENTRENADOR!");
            Scanner sc = new Scanner(System.in);
            System.out.println("Introduce el nombre:");
            String nom = sc.nextLine();
            
            entrenadorDAO catalogo = new entrenadorDAO();
            entrenador entr = catalogo.exsisteixEntrenador(nom);
            if (entr != null){
                catalogo.borrarEntrenador(entr);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void ConsultarEntrenador() {
        try {
            System.out.println("Has elegido la opcion CONSULTAR ENTRENADORES!");
            Scanner sc = new Scanner(System.in);
            System.out.println("Introduce el nombre:");
            String nom = sc.nextLine();
            
            entrenadorDAO catalogo = new entrenadorDAO();
            entrenador entr = catalogo.devolverEntrenador(nom);
            
            if(entr != null){
                System.out.println(entr);
            }
            else{
                System.out.println("Entrenador no exsiste!");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private void TodosEntrenadores() {
        try {
            System.out.println("Has elegido la opcion CONSULTAR TODOS LOS ENTRENADORES!");
            entrenadorDAO catalogo = new entrenadorDAO();
            catalogo.totsEntrenadors();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private void ListarPokemonsCazados() {
        System.out.println("Has elegido la opcion LISTAR POKEMONS CAZADOS!");
    }

    private void CazarPokemon() {
        System.out.println("Has elegido la opcion CAZAR POKEMON!");
        
    }

    private void ListarPokemonsExsistentes() {
        System.out.println("Has elegido la opcion LISTAR POKEMONS EXSISTENTES!");
    }
    
     public static void pedrirAutentificacion() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Introdueix l'usuari: ");
            String nom = sc.nextLine();
            System.out.println("Introdueix la contrasenya:");
            String contra = sc.nextLine();
            
            entrenadorDAO dao = new entrenadorDAO();
            entrenador entr = new entrenador();
            entr = dao.exsisteixEntrenador(nom);
            if(entr != null){
                if(entr.getPassword().equals(contra)){
                    System.out.println("Bienvenido " + nom);
                }
                else{
                    System.out.println("Constrasenya incorrecta!");
                    System.exit(0);
                }
            }else{
                dao.altraEntrenador(new entrenador(nom, contra));
                System.out.println("Usuario dado de alta correctamente!"); 
                System.out.println("Bienvenido " + nom);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
