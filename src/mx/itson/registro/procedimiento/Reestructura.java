
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
        if (segundoApellido == "") {
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
     * 
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
        String fecha = añoUltimosDigitos + mes + dia;
        return fecha;
    }
    
    public static String datosPersonales(String sexo, String entidadFederativa){
        String datosPersonales = "S";
        String estado = "";

        switch(entidadFederativa){
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
         datosPersonales = "M" + estado;   
        }else if (sexo == "Hombre") {
         datosPersonales = "H" + estado;   
        }
        
        return datosPersonales;
    }
    
}
