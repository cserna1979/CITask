package com.example.csern.citask;

/**
 * Created by csern on 16/08/2017.
 */

public class Constaints {
    /**
     * Transición Home -> Detalle
     */
    public static final int CODIGO_DETALLE = 100;

    /**
     * Transición Detalle -> Actualización
     */
    public static final int CODIGO_ACTUALIZACION = 101;

    /**
     * Puerto que utilizas para la conexión.
     * Dejalo en blanco si no has configurado esta carácteristica.
     */
    private static final String PUERTO_HOST = "81";

    /**
     * Dirección IP de genymotion o AVD
     */
    private static final String IP = "http://151.182.211.133:";
    /**
     * URLs del Web Service
     */
    public static final String GET = IP + PUERTO_HOST + "/CITask/obtener_user.php";
    public static final String GET_BY_ID = IP + PUERTO_HOST + "/CITask/consultar_user.php";
    public static final String UPDATE = IP + PUERTO_HOST + "/CITask/update_user.php";
    public static final String DELETE = IP + PUERTO_HOST + "/CITask/delete_user.php";
    public static final String INSERT = IP + PUERTO_HOST + "/CITask/insert_user";

    /**
     * Clave para el valor extra que representa al identificador de una meta
     */
    public static final String EXTRA_ID = "IDEXTRA";
}

/*
ejemplo:
    public static final String GET_BY_ID = IP + PUERTO_HOST + "/I%20Wish/obtener_meta_por_id.php";
    public static final String UPDATE = IP + PUERTO_HOST + "/I%20Wish/actualizar_meta.php";
    public static final String DELETE = IP + PUERTO_HOST + "/I%20Wish/borrar_meta.php";
    public static final String INSERT = IP + PUERTO_HOST + "/I%20Wish/insertar_meta.php";
 */
