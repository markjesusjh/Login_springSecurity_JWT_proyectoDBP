package com.proyecto01.dev.Exception;

public class ManejoErrores extends Exception {
    private String mensaje_error;

    public ManejoErrores(String mensaje_error) {
        super(mensaje_error);
        this.mensaje_error = mensaje_error;
    }

    public ManejoErrores(String mensaje_error, Long id) {
        super(mensaje_error + id);
        this.mensaje_error = mensaje_error;
    }


}
