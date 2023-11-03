package Objetos;

import java.io.Serializable;

/**
 * La clase Usuario representa a un usuario con información personal.
 */
public class Usuario implements Serializable {
    public String nom = "Sin registrar";
    public String apellido = "Sin registrar";
    public int cedula = 0;
    public int numerotelefonico = 0;
    public String domicilio = "Sin registrar";

    public Usuario(String nom, String apellido, int cedula, int numerotelefonico, String domicilio) {
        this.nom = nom;
        this.apellido = apellido;
        this.cedula = cedula;
        this.numerotelefonico = numerotelefonico;
        this.domicilio = domicilio;
    }

    // Métodos getter y setter para el campo "apellido"
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Establece el nombre del usuario.
     *
     * @param nom El nombre del usuario.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Establece la cédula del usuario.
     *
     * @param newcedula La cédula del usuario.
     */
    public void setCedula(int newcedula) {
        this.cedula = newcedula;
    }

    /**
     * Establece el número telefónico del usuario.
     *
     * @param numerotelefonico El número telefónico del usuario.
     */
    public void setNumerotelefonico(int numerotelefonico) {
        this.numerotelefonico = numerotelefonico;
    }

    /**
     * Establece el domicilio del usuario.
     *
     * @param domicilio El domicilio del usuario.
     */
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    /**
     * Obtiene el nombre del usuario.
     *
     * @return El nombre del usuario.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Obtiene el apellido del usuario.
     *
     * @return El apellido del usuario.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Obtiene la cédula del usuario.
     *
     * @return La cédula del usuario.
     */
    public int getCedula() {
        return cedula;
    }

    /**
     * Obtiene el número telefónico del usuario.
     *
     * @return El número telefónico del usuario.
     */
    public int getNumerotelefonico() {
        return numerotelefonico;
    }

    /**
     * Obtiene el domicilio del usuario.
     *
     * @return El domicilio del usuario.
     */
    public String getDomicilio() {
        return domicilio;
    }

    /**
     * Devuelve una representación en cadena de la información del usuario.
     *
     * @return Una cadena que contiene el nombre, apellido, cédula, número telefónico y domicilio del usuario.
     */
    @Override
    public String toString() {
        return "\nNombre: " + nom + " " + apellido +
                "\nCédula: " + cedula + ", " +
                "\nNúmero Telefónico: " + numerotelefonico + ", " +
                "\nDomicilio: " + domicilio;
    }
}