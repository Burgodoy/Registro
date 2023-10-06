
package mx.itson.registro.procedimiento;

/**
 *
 * @author abrah
 */
public class Reestructura {
    /**
     * Se realizan utilizan varios metodos tal como arreglos de caracteres, cambio 
     * de fuente a mayusculas, trim y split con tal de quitar espacios vacios
     * que pudieron darse por error y de esta manera poder reorganizar los datos
     * que se dieron y poder extraer las primeras 4 letras fde la curp.
     * @param nombre Nombre que a ingresado la persona
     * @param primerApellido Primer apellido correspondiente a la persona
     * @param segundoApellido Segundo apellido correspondiente a la persona
     * @return Primeras 4 letras con las que inicia el CURP de la persona
     */
    public static String primeras4Letras(String nombre, String primerApellido,
            String segundoApellido) {
        
        String resultadoPrimeras4Letras = "";
        String primeraLetra = "";
        String segundaLetra = "";
        String terceraLetra = "";
        String cuartaLetra = "";
        
        /* Quitamos espacios iniciales o finales para evitar errores, pasamos a
        mayusculas las letras y creamos un arreglo de caracteres para ir 
        separandolo dependiendo la letra que se ocupe */
        char [] apellidoPorLetras = primerApellido.trim().toUpperCase().toCharArray();
        
        //agarramos el primer numero del arreglo que representaria la primera
        //letra del apellido
        primeraLetra = String.valueOf(apellidoPorLetras[0]);
        
        /* Iniciamos nuestro contador en la segunda posicion para ahorrarnos una 
        iteracion de la primera letra que no vamos a utilizar ya que nos piden 
        la primera vocal INTERNA del apellido.
        */
        int contador = 1;
        segundaLetra = String.valueOf(apellidoPorLetras[contador]);

        for (char i : apellidoPorLetras) {
            if (String.valueOf(apellidoPorLetras[contador]).startsWith("A")) {
                segundaLetra = String.valueOf(apellidoPorLetras[contador]);
                break;
            }else if(String.valueOf(apellidoPorLetras[contador]).startsWith("E")){
                segundaLetra = String.valueOf(apellidoPorLetras[contador]);
                break;
            }else if (String.valueOf(apellidoPorLetras[contador]).startsWith("I")) {
                segundaLetra = String.valueOf(apellidoPorLetras[contador]);
                break;
            }else if (String.valueOf(apellidoPorLetras[contador]).startsWith("O")) {
                segundaLetra = String.valueOf(apellidoPorLetras[contador]);
                break;
            }else if (String.valueOf(apellidoPorLetras[contador]).startsWith("U")) {
                segundaLetra = String.valueOf(apellidoPorLetras[contador]);
                break;
            }else{
                contador++;
            }
        }
        /*
        
        */
        if (segundoApellido == "") {
            terceraLetra = "X";
        }else{
            char [] segundoApellidoPorLetras = segundoApellido.trim()
                    .toUpperCase().toCharArray();
            terceraLetra = String.valueOf(segundoApellidoPorLetras[0]);
        }
        /*
        
        */
        String[] nombreCompleto = nombre.trim().toUpperCase().split(" ");
        
        int contadorNombre = nombreCompleto.length-1;
        
        if (nombreCompleto.length >1) {
            char [] segundoNombre = nombreCompleto[contadorNombre].toCharArray();
            cuartaLetra = String.valueOf(segundoNombre[0]);
        }else if(nombreCompleto.length == 1){
            char [] primerNombre = nombreCompleto[contadorNombre].toCharArray();
            cuartaLetra = String.valueOf(primerNombre[0]);
        }
        resultadoPrimeras4Letras = primeraLetra + segundaLetra + terceraLetra + cuartaLetra;
        return resultadoPrimeras4Letras;
    }

    /**
     * 
     * @param fecha Fecha en formato numerico Ejemplo: 01/12/2000
     * @param sexo Sexo al cual pertenece la persona.
     * @param entidadFederativa Estado donde nacio la persona.
     * @return Las siguientes 9 letras que corresponden al CURP y serian las
     * posiciones #5-13 y si se usara un arreglo para representar la CURP serian
     * los numeros desde el 4 al 12.
     */
    public static String datosPersonales(String fecha, String sexo,
            String entidadFederativa) {
        
        String resultadoDatosPersonales = "";

        return resultadoDatosPersonales;
    }
    
    
}
