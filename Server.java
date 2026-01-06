import java.io.*;
import java.net.*;
public class Server{
    public void run() throws Exception {
        int port = 8010;
        ServerSocket socket = new ServerSocket(port);
        socket.setSoTimeout(10000);
        while (true) {
            try {
                System.out.println("Listening on Port:"+ port);
                Socket acceptedConnection = socket.accept();
                System.out.println("Connection Accepted from client " + acceptedConnection.getRemoteSocketAddress());
                PrintWriter toClient = new PrintWriter(acceptedConnection.getOutputStream(), true);
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(acceptedConnection.getInputStream()));
                toClient.println("Hello from server");     
                toClient.close();
                fromClient.close();
                acceptedConnection.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
          
        }
    }
    public static void main(String[] args)  {
        Server srv = new Server();
        try {
            srv.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}