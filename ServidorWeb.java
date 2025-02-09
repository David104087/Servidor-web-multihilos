import java.net.* ;

public final class ServidorWeb {
    public static void main(String argv[]) throws Exception {
        int puerto = 6789;

        ServerSocket socketDeEscucha = new ServerSocket(puerto);

        while (true) {
            Socket socketDeConexion = socketDeEscucha.accept();

            SolicitudHttp solicitud = new SolicitudHttp(socketDeConexion);

            Thread hilo = new Thread(solicitud);

            hilo.start();
        }
    }
}

