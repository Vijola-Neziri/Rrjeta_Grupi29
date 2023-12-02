import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
import java.net.*;

public class UDPClient3 {
    private static final int SERVER_PORT = 9876;
    private static final String SERVER_IP = "192.168.1.9"; //visari

    public static void main(String[] args) {
        try {
            DatagramSocket clientSocket = new DatagramSocket();

            InetAddress serverAddress = InetAddress.getByName(SERVER_IP);

            String requestType = "READ";

            System.out.println("You can only choose the READ option.");
        }
    }
}
