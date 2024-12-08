/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoprogramacioni;

/**
 *
 * @author disma
 */

class Pokemon {
    private String nombre;
    private String region;
    private String tipo1;
    private String tipo2;
    private String habilidad;
    private String altura;
    private String peso;

    public Pokemon(String nombre, String region, String tipo1, String tipo2, String habilidad, String altura, String peso) {
        this.nombre = nombre;
        this.region = region;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
        this.habilidad = habilidad;
        this.altura = altura;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }
    
    public String getRegion(){
        return region;
    }
    
    public String getTipo1() {
        return tipo1;
    }
    
    public String getTipo2(){
        return tipo2;
    }

    public String getHabilidad() {
        return habilidad;
    }
    
    public String getAltura() {
        return altura;
    }
    
    public String getPeso() {
        return peso;
    }

    @Override
    public String toString() {
        return "----Pokemon----" + "\n" +
                "Nombre: " + nombre + "\n" +
                "Region: " + region + "\n" +
                "Tipo(s): " + tipo1 + " / " + tipo2 + "\n" +
                "Habilidad: " + habilidad + "\n" +
                "Altura: " + altura + "m\n" +
                "Peso: " + peso + "kg\n";
    }
}
