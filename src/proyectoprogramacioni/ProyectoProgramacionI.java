/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectoprogramacioni;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author disma
 */
public class ProyectoProgramacionI {
    
    public static List<Pokemon> pokedex = new ArrayList<>();
    public static String[] regiones = {"Kanto", "Johto", "Hoenn", "Sinnoh", "Unova", "Kalos", "Alola", "Galar", "Paldea"};
    public static String[] tipos = {"Normal", "Fuego", "Agua", "Planta", "Eléctrico", "Hielo", "Lucha", "Veneno", "Tierra", "Volador", "Psíquico", "Bicho", "Roca", "Fantasma", "Dragón", "Siniestro", "Acero", "Hada"};
    public static String[] tipos2 = {"N/A", "Normal", "Fuego", "Agua", "Planta", "Eléctrico", "Hielo", "Lucha", "Veneno", "Tierra", "Volador", "Psíquico", "Bicho", "Roca", "Fantasma", "Dragón", "Siniestro", "Acero", "Hada"};
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Inicializar el frame
        JFrame frame = new JFrame("Pokedex");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        
        //Dar color al panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(Color.BLACK);
        
        //El logo de pokedex al inicio
        URL logoURL = ProyectoProgramacionI.class.getResource("/Pokedex_logo.png");
        ImageIcon logoIcon = new ImageIcon(logoURL);
        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        //Cambiar el icono del programa porque si
        URL iconURL = ProyectoProgramacionI.class.getResource("/Pokeball_logo.png");
        ImageIcon frameIcon = new ImageIcon(iconURL);
        frame.setIconImage(frameIcon.getImage());
        
        //Registrar los botones
        JButton btnRegister = new JButton("Registrar Pokémon");
        JButton btnList = new JButton("Listar Pokémon");
        JButton btnReview = new JButton("Buscar Pokémon");
        JButton btnExit = new JButton("Salir");

        //Centrar los botones
        btnRegister.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnList.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnReview.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnExit.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        //Registrar pokemones ehuheuehue
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel panel = new JPanel();
                panel.setLayout(new GridLayout(7, 2, 5, 5)); //7 filas, 2 columnas, 5 de espacio h y v
                
                //Textfields para cada uno de los criterios
                panel.add(new JLabel("Nombre del Pokémon:"));
                JTextField nombreField = new JTextField();
                panel.add(nombreField);

                //Mentira inclui 3 combo boxes porque es mas user friendly :eldiablo:
                panel.add(new JLabel("Región del Pokémon:"));
                JComboBox<String> regionBox = new JComboBox<>(regiones);
                panel.add(regionBox);

                panel.add(new JLabel("Tipo Primario:"));
                JComboBox<String> tipoBox = new JComboBox<>(tipos);
                panel.add(tipoBox);

                panel.add(new JLabel("Tipo Secundario:"));
                JComboBox<String> tipo2Box = new JComboBox<>(tipos2);
                panel.add(tipo2Box);

                panel.add(new JLabel("Habilidad:"));
                JTextField habilidadField = new JTextField();
                panel.add(habilidadField);

                panel.add(new JLabel("Altura (en metros):"));
                JTextField alturaField = new JTextField();
                panel.add(alturaField);

                panel.add(new JLabel("Peso (en kg):"));
                JTextField pesoField = new JTextField();
                panel.add(pesoField);

                //Confirm Dialog
                int result = JOptionPane.showConfirmDialog(frame, panel, "Registrar Pokémon", JOptionPane.OK_CANCEL_OPTION);
                
                //Usamos los getters
                if (result == JOptionPane.OK_OPTION) {
                    String nombre = nombreField.getText();
                    String region = (String) regionBox.getSelectedItem();
                    String tipo1 = (String) tipoBox.getSelectedItem();
                    String tipo2 = (String) tipo2Box.getSelectedItem();
                    String habilidad = habilidadField.getText();
                    String altura = alturaField.getText();
                    String peso = pesoField.getText();
                    
                    //Validacion para que todo haya sido ingresado correctamente
                    if (nombre.equals("") || region.equals("") || tipo1.equals("") || habilidad.equals("") || altura.equals("") || peso.equals("")) {
                        JOptionPane.showMessageDialog(frame, "Completa todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Agregar el Pokémon a la lista
                    pokedex.add(new Pokemon(nombre, region, tipo1, tipo2, habilidad, altura, peso));
                    JOptionPane.showMessageDialog(frame, "Pokémon registrado con éxito.");
                }
            }
        });

        //Listar pokemones ehuehuehue
        btnList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pokedex.isEmpty()) {
                    //No tenes pokemones :(
                    JOptionPane.showMessageDialog(frame, "No Hay Pokémon Registrados.");
                } else {
                    //Combobox para mostrar los dos criterios de listar
                    String[] opciones = {"Región", "Tipo"};
                    JComboBox<String> comboBox = new JComboBox<>(opciones);

                    int resultado = JOptionPane.showConfirmDialog(
                        frame,
                        comboBox,
                        "Seleccione una Categoría para Listar",
                        JOptionPane.OK_CANCEL_OPTION
                    );

                    if (resultado == JOptionPane.OK_OPTION) {
                        String seleccion = (String) comboBox.getSelectedItem();
                        String resultados = "";
                        
                        //Por cada opcion de busqueda se muestra el numero de pokemones registrados por categoria
                        //Aplicable para todos incluso si tienen valores de 0
                        if (seleccion.equals("Región")) {
                            String[] regiones = {"Kanto", "Johto", "Hoenn", "Sinnoh", "Unova", "Kalos", "Alola", "Galar", "Paldea"};
                            for (String region : regiones) {
                                long count = pokedex.stream().filter(pokemon -> pokemon.getRegion().equalsIgnoreCase(region)).count();
                                resultados += region + ": " + count + " Pokémon\n";
                            }
                        } else if (seleccion.equals("Tipo")) {
                            String[] tipos = {"Normal", "Fuego", "Agua", "Planta", "Eléctrico", "Hielo", "Lucha", "Veneno", "Tierra", "Volador", "Psíquico", "Bicho", "Roca", "Fantasma", "Dragón", "Siniestro", "Acero", "Hada"};
                            for (String tipo : tipos) {
                                long count = pokedex.stream().filter(pokemon -> pokemon.getTipo1().equalsIgnoreCase(tipo) || pokemon.getTipo2().equalsIgnoreCase(tipo)).count();
                                resultados += tipo + ": " + count + " Pokémon\n";
                            }
                        }
                        
                        //Los resultados
                        JTextArea textArea = new JTextArea(resultados);
                        textArea.setEditable(false);
                        JScrollPane scrollPane = new JScrollPane(textArea);
                        scrollPane.setPreferredSize(new Dimension(300, 200));
                        JOptionPane.showMessageDialog(frame, scrollPane, "Lista De Pokémon", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });

        //A buscar pokemones en ~100 lineas de codigo!!
        btnReview.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pokedex.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "No Hay Pokémon Registrados para Buscar.");
                } else {
                    JPanel panel = new JPanel();
                    panel.setLayout(new GridLayout(2, 2, 5, 5));

                    panel.add(new JLabel("Criterio de Búsqueda:"));
                    String[] opciones = {"Nombre", "Región", "Tipo"};
                    JComboBox<String> criterioBox = new JComboBox<>(opciones);
                    panel.add(criterioBox);

                    panel.add(new JLabel("Seleccione Valor:"));
                    JTextField nombreField = new JTextField();
                    JComboBox<String> valorBox = new JComboBox<>();
                    panel.add(nombreField);

                    //Cambiar entre textfield y combobox
                    criterioBox.addActionListener(event -> {
                        panel.remove(3); // Eliminar el componente existente (nombre o valor)
                        if (criterioBox.getSelectedItem().equals("Nombre")) {
                            panel.add(nombreField, 3); // Mostrar el campo de texto para nombre
                        } else {
                            valorBox.removeAllItems();
                            if (criterioBox.getSelectedItem().equals("Región")) {
                                for (String region : regiones) {
                                    valorBox.addItem(region);
                                }
                            } else if (criterioBox.getSelectedItem().equals("Tipo")) {
                                for (String tipo : tipos) {
                                    valorBox.addItem(tipo);
                                }
                            }
                            panel.add(valorBox, 3); // Mostrar el combo box para región o tipo
                        }
                        panel.revalidate();
                        panel.repaint();
                    });

                    // Inicializar valores con nombre como default
                    criterioBox.setSelectedIndex(0);

                    int resultado = JOptionPane.showConfirmDialog(
                        frame,
                        panel,
                        "Buscar Pokémon",
                        JOptionPane.OK_CANCEL_OPTION
                    );

                    if (resultado == JOptionPane.OK_OPTION) {
                        String criterioSeleccionado = (String) criterioBox.getSelectedItem();
                        String resultados = "";
                        
                        //resultados a base de criterio de seleccion
                        if (criterioSeleccionado.equals("Nombre")) {
                            String nombreIngresado = nombreField.getText();
                            for (Pokemon pokemon : pokedex) {
                                if (pokemon.getNombre().equalsIgnoreCase(nombreIngresado)) {
                                    resultados += pokemon.toString() + "\n";
                                }
                            }
                        } else {
                            String valorSeleccionado = (String) valorBox.getSelectedItem();
                            for (Pokemon pokemon : pokedex) {
                                if (criterioSeleccionado.equals("Región") && pokemon.getRegion().equalsIgnoreCase(valorSeleccionado)) {
                                    resultados += pokemon.toString() + "\n";
                                } else if (criterioSeleccionado.equals("Tipo") && 
                                           (pokemon.getTipo1().equalsIgnoreCase(valorSeleccionado) || pokemon.getTipo2().equalsIgnoreCase(valorSeleccionado))) {
                                    resultados += pokemon.toString() + "\n";
                                }
                            }
                        }
                        
                        //No hay nada lol
                        if (resultados.isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "No se encontraron Pokémon con el criterio ingresado.");
                        } else {
                            //Formato del coso de la respuesta
                            JTextArea textArea = new JTextArea(resultados);
                            textArea.setEditable(false);
                            JScrollPane scrollPane = new JScrollPane(textArea);
                            scrollPane.setPreferredSize(new Dimension(400, 300));
                            JOptionPane.showMessageDialog(frame, scrollPane, "Pokémon Encontrados", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }
            }
        });

        
        //Ya te cansaste de registrar pokemones?
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        
        //Mas cosas del jframe inicial
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(logoLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        mainPanel.add(btnRegister);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(btnList);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(btnReview);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(btnExit);

        frame.add(mainPanel);
        frame.setVisible(true);
        
    }
}
