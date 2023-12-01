import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient2 {
    private static final int SERVER_PORT = 9876;
    private static final String SERVER_IP = "192.168.1.9"; //visari

    public static void main(String[] args) {
        try {
            DatagramSocket clientSocket = new DatagramSocket();

            InetAddress serverAddress = InetAddress.getByName(SERVER_IP);

            String requestType = "READ";

            System.out.println("You can only choose the READ option.");

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the file name:");
            String fileName = scanner.nextLine();

            String message = requestType.toUpperCase() + " " + fileName.toUpperCase();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



