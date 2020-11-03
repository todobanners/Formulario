package com.todobanners.formulario;

public class Contacto {

    private String nombre;
    private int fechad;
    private int fecham;
    private int fechaa;
    private String telefono;
    private String email;
    private String descripcion;
    private String fecha;

    public Contacto(String nombre, int fechad, int fecham, int fechaa, String telefono, String email, String descripcion) {
        this.nombre = nombre;
        this.fechad = fechad;
        this.fecham = fecham;
        this.fechaa = fechaa;
        this.telefono = telefono;
        this.email = email;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFechad() {
        return fechad;
    }

    public void setFechad(int fechad) {
        this.fechad = fechad;
    }

    public int getFecham() {
        return fecham;
    }

    public void setFecham(int fecham) {
        this.fecham = fecham;
    }

    public int getFechaa() {
        return fechaa;
    }

    public void setFechaa(int fechaa) {
        this.fechaa = fechaa;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    //Metodos propios

    public boolean emptySpace(){
        boolean empty;
        if (nombre.length() == 0 || fecha.length() == 0 || telefono.length() == 0 || email.length() == 0 || descripcion.length() == 0){
            empty = true;
        }else{
            empty = false;
        }
        return(empty);
    }
}