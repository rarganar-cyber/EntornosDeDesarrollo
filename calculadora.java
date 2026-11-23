import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;

public class Calculadora {

    // Se usa long para evitar desbordamiento (99999 * 99999 no entra en int)
    static long sumar(int a, int b) { return (long) a + b; }
    static long restar(int a, int b) { return (long) a - b; }
    static long multiplicar(int a, int b) { return (long) a * b; }
    static double potencia(int a, int b) { return Math.pow(a, b); }

    // Procesa las peticiones del formulario
    static void procesar(HttpExchange ex) throws IOException {
        String html = Files.readString(Path.of("index.html"));

        if (ex.getRequestMethod().equals("POST")) {
            String cuerpo = new String(ex.getRequestBody().readAllBytes(), StandardCharsets.UTF_8);
            String n1 = "", n2 = "", op = "";

            for (String par : cuerpo.split("&")) {
                String[] kv = par.split("=", 2);
                if (kv.length == 2) {
                    String valor = URLDecoder.decode(kv[1], StandardCharsets.UTF_8);
                    if (kv[0].equals("n1")) n1 = valor;
                    if (kv[0].equals("n2")) n2 = valor;
                    if (kv[0].equals("op")) op = valor;
                }
            }

            String mensaje;
            // Solo se aceptan enteros de hasta 5 dígitos: -99999 ... 99999
            if (n1.matches("-?[0-9]{1,5}") && n2.matches("-?[0-9]{1,5}")) {
                int a = Integer.parseInt(n1);
                int b = Integer.parseInt(n2);
                Object r = null;
                if (op.equals("sum")) r = sumar(a, b);
                else if (op.equals("res")) r = restar(a, b);
                else if (op.equals("mul")) r = multiplicar(a, b);
                else if (op.equals("pot")) r = potencia(a, b);
                mensaje = (r == null) ? "Operación no válida." : "Resultado: " + r;
            } else {
                mensaje = "Introduce dos números enteros de hasta 5 cifras.";
            }
            html = html.replace("<!--RESULTADO-->", "<h2>" + mensaje + "</h2>");
        }

        byte[] bytes = html.getBytes(StandardCharsets.UTF_8);
        ex.getResponseHeaders().set("Content-Type", "text/html; charset=UTF-8");
        ex.sendResponseHeaders(200, bytes.length);
        OutputStream os = ex.getResponseBody();
        os.write(bytes);
        os.close();
    }

    // Inicia el servidor en el puerto 8080
    public static void main(String[] args) throws IOException {
        HttpServer servidor = HttpServer.create(new InetSocketAddress(8080), 0);
        servidor.createContext("/", ex -> procesar(ex));
        servidor.start();
        System.out.println("Calculadora iniciada en http://localhost:8080");
    }
}
