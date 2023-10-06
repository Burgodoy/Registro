
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
     * que se dieron y poder extraer las primeras 4 letras de la curp de la persona.
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
        // con un ciclo for identificamos si se encuentra una vocal
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
        /* Si el espacio del segundo apellido se encuntra vacio por defecto la 
        tercera letra es X, si se encuentra algo escrito recurrimos a los mismo pasos 
        anteriores con lo cual al agarrar el primer elemento del arreglo obtenemos
        la primera letra del segundo apellido que corresponde a la tercera letra del curp.
        */
        if (segundoApellido.isBlank()) {
            terceraLetra = "X";
        }else{
            char [] segundoApellidoPorLetras = segundoApellido.trim()
                    .toUpperCase().toCharArray();
            terceraLetra = String.valueOf(segundoApellidoPorLetras[0]);
        }
        
        /* Para la cuarta letra creamos un arreglo de tipo string el cual esta creado
        por el metodo split para identificar cuando se hizo un espacio, despues 
        creamos un arreglo de caracteres ya sea el caso de si fue 1 solo nombre o multiples
        en caso de 1 escogemos el primer arreglo string, lo hacemos arreglo char y
        escogemos el primer lugar, en caso de multimples seleccionamos el ultimo lugar
        proseguimos con el arreglo de caracteres y seleccionamos de nuevo la primera posicion
        */
        String[] nombreCompleto = nombre.trim().toUpperCase().split(" ");
        
        int contadorNombreCompuesto = nombreCompleto.length-1;
        
        if (nombreCompleto.length >2) {
            char [] segundoNombre = nombreCompleto[contadorNombreCompuesto].toCharArray();
            cuartaLetra = String.valueOf(segundoNombre[0]);
        }else if(nombreCompleto.length == 2){
            char [] primerNombre = nombreCompleto[0].toCharArray();
            cuartaLetra = String.valueOf(primerNombre[0]);
        }
        resultadoPrimeras4Letras = primeraLetra + segundaLetra + terceraLetra + cuartaLetra;
        return resultadoPrimeras4Letras;
    }

    /**
     * Por medio de un arreglo de tipo char en la variable AÑO se utilizan las ultimas 
     * 2 posiciones para utilizarse, por ultimo se agrega el mes y el dia todo con el
     * orden de formato Ultimos 2digitosAño,2digitosMes,2DigitosDia. 230101
     * @param dia Dia del mes que se tuvo registro del nacimiento de la persona.
     * @param mes Mes del nacimiento de la persona.
     * @param año Año de nacimiento de la persona.
     * @return Las siguientes 9 letras que corresponden al CURP y serian las
     * posiciones #5-10 y si se usara un arreglo para representar la CURP serian
     * los numeros desde el 4 al 9.
     */
    public static String fecha(String dia, String mes, String año) {

        char [] añoPorLetras = año.toCharArray();
        String añoUltimosDigitos = String.valueOf(añoPorLetras[2] + String.valueOf(añoPorLetras[3]));
        String resultadofecha = añoUltimosDigitos + mes + dia;
        return resultadofecha;
    }
    /**
     * Se utilizan los datos recabados del jframe para determinar que inicio de
     * letra se utilizara de acuerdo al sexo de la persona asi como la clave de entidad
     * federativa que se utilizara, todo por medio de un switch/case.
     * @param sexo Sexo de la persona.
     * @param entidadFederativa Estado de la republica donde nacio la persona o 
     * en su defecto el pais donde nacio.
     * @return 3 letras correspondientes a la posicion numero 11 al 13 de la curp
     * en caso de usarse un arreglo seria la posicion 10 al 12.
     */
    public static String datosPersonales(String sexo, String entidadFederativa) {
        String resultadoDatosPersonales = "S";
        String estado = "";

        switch (entidadFederativa) {
            case "Aguascalientes":
                estado = "AS";
                break;

            case "Baja California":
                estado = "BC";
                break;

            case "Baja California Sur":
                estado = "BS";
                break;

            case "Campeche":
                estado = "CC";
                break;

            case "Coahuila de Zaragoza":
                estado = "CL";
                break;

            case "Colima":
                estado = "CM";
                break;

            case "Chiapas":
                estado = "CS";
                break;

            case "Chihuahua":
                estado = "CH";
                break;

            case "Ciudad de México":
                estado = "DF";
                break;

            case "Durango":
                estado = "DG";
                break;

            case "Guanajuato":
                estado = "GT";
                break;

            case "Guerrero":
                estado = "GR";
                break;

            case "Hidalgo":
                estado = "HG";
                break;

            case "Jalisco":
                estado = "JC";
                break;

            case "México":
                estado = "MC";
                break;

            case "Michoacán de Ocampo":
                estado = "MN";
                break;

            case "Morelos":
                estado = "MS";
                break;

            case "Nayarit":
                estado = "NT";
                break;

            case "Nuevo León":
                estado = "NL";
                break;

            case "Oaxaca":
                estado = "OC";
                break;

            case "Puebla":
                estado = "PL";
                break;

            case "Querétaro":
                estado = "QT";
                break;

            case "Quintana Roo":
                estado = "QR";
                break;

            case "San Luis Potosí":
                estado = "SP";
                break;

            case "Sinaloa":
                estado = "SL";
                break;

            case "Sonora":
                estado = "SR";
                break;

            case "Tabasco":
                estado = "TC";
                break;

            case "Tamaulipas":
                estado = "TS";
                break;

            case "Tlaxcala":
                estado = "TL";
                break;

            case "Veracruz de Ignacio de la Llave":
                estado = "VZ";
                break;

            case "Yucatán":
                estado = "YN";
                break;

            case "Zacatecas":
                estado = "ZS";
                break;

            case "Nacido en el Extranjero":
                estado = "NE";
                break;
        }
                
        if (sexo == "Mujer") {
         resultadoDatosPersonales = "M" + estado;   
        }else if (sexo == "Hombre") {
         resultadoDatosPersonales = "H" + estado;   
        }
        
        return resultadoDatosPersonales;
    }
    /**
     * Utilizacion de arreglos char para segmentar los apellidos y el nombre con 
     * tal de compararlos despues en un ciclo for y que este nos identifique cual
     * es la primera consonante interna del primer, segundo apellido y la consonante
     * interna del nombre, posteriormente se convierte el valor string de la fecha a
     * int para poder compararlo con el año y de esta manera nos muestra si se
     * utilizara la letra 0 o A. Por ultimo se agrega el numero 1.
     * @param primerApellido Primer apellido que se ingreso de la persona.
     * @param segundoApellido Segundo apelldio que se ingreso de la persona.
     * @param nombre Nombre de la persona.
     * @param año Año en el que se registro el nacimiento de la persona.
     * @return 
     */
    public static String consonantes(String primerApellido, String segundoApellido, String nombre, String año){
        String resultadoConsonantes = "";
        String consonanteInternaPrimerApellido = "";
        String consonanteInternaSegundoApellido = "";
        String consonanteInternaNombre = "";
        int añoEntero = 0;
        String letraFecha = "";
        
        /* Creamos un arreglo tipo char cont al de poder segmentarlo y de esta manera
        en un ciclo poder compararlo y saber si se trata de una consonante, todo
        esto iniciando desde la posicion 1 por que especifica que debe ser interna.
        */
        char [] primerApellidoPorLetras = primerApellido.toUpperCase().trim().toCharArray();
        
        int contador = 1;
        for (char i : primerApellidoPorLetras) {
            if (String.valueOf(primerApellidoPorLetras[contador]).startsWith("A")) {
                contador++;
            }else if (String.valueOf(primerApellidoPorLetras[contador]).startsWith("E")) {
                contador++;
            }else if (String.valueOf(primerApellidoPorLetras[contador]).startsWith("I")) {
                contador++;
            }else if (String.valueOf(primerApellidoPorLetras[contador]).startsWith("O")) {
                contador++;
            }else if (String.valueOf(primerApellidoPorLetras[contador]).startsWith("U")) {
                contador++;
            }else{
                consonanteInternaPrimerApellido = String.valueOf(primerApellidoPorLetras[contador]);
            }
        }
        /* Aqui primero iniciamos con la comprobaciond e que exista un segundo apellido
        en caso de no haberlo automaticamente pasa a ser X el resultado. Por todo lo 
        demas es el mismo procedimiento del anterior paso. */
        if (segundoApellido.isBlank()) {
            consonanteInternaSegundoApellido = "X";
        }else{
           int segundoContador = 1;
           char [] segundoApellidoPorLetras = segundoApellido.trim().toUpperCase().toCharArray();
           
        for (char i : segundoApellidoPorLetras) {
            if (String.valueOf(segundoApellidoPorLetras[segundoContador]).startsWith("A")) {
                segundoContador++;
            }else if (String.valueOf(segundoApellidoPorLetras[segundoContador]).startsWith("E")) {
                segundoContador++;
            }else if (String.valueOf(segundoApellidoPorLetras[segundoContador]).startsWith("I")) {
                segundoContador++;
            }else if (String.valueOf(segundoApellidoPorLetras[segundoContador]).startsWith("O")) {
                segundoContador++;
            }else if (String.valueOf(segundoApellidoPorLetras[segundoContador]).startsWith("U")) {
                segundoContador++;
            }else{
                consonanteInternaSegundoApellido = String.valueOf(segundoApellidoPorLetras[segundoContador]);
            }
          } 
        }
        /* Mismo procedimiento que los anteriores 2 puntos solo que en este caso
        se realiza con la variable nombre para identificar la primera consonante
        interna del nombre */
        char [] nombreCompletoPorLetras = nombre.trim().toUpperCase().toCharArray();
        
        int contadorNombre = 1;
        for (char i : nombreCompletoPorLetras) {
            if (String.valueOf(nombreCompletoPorLetras[contadorNombre]).startsWith("A")) {
                contadorNombre++;
            }else if (String.valueOf(nombreCompletoPorLetras[contadorNombre]).startsWith("E")) {
                contadorNombre++;
            }else if (String.valueOf(nombreCompletoPorLetras[contadorNombre]).startsWith("I")) {
                contadorNombre++;
            }else if (String.valueOf(nombreCompletoPorLetras[contadorNombre]).startsWith("O")) {
                contadorNombre++;
            }else if (String.valueOf(nombreCompletoPorLetras[contadorNombre]).startsWith("U")) {
                contadorNombre++;
            }else{
                consonanteInternaNombre = String.valueOf(nombreCompletoPorLetras[contadorNombre]);
            }
          } 
        //en esta variable convertimos de string a int para poder hacer la comparativa
        añoEntero = Integer.parseInt(año);
        if (añoEntero >=2000) {
            letraFecha = "A";
        }else if (añoEntero < 2000) {
            letraFecha = "0";
        }
        
        resultadoConsonantes = consonanteInternaPrimerApellido + consonanteInternaSegundoApellido + consonanteInternaNombre + letraFecha + 1;
        return resultadoConsonantes;
    }
}
