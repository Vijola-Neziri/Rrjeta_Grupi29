import java.net.*;
import java.util.Scanner;


    public class UDPClient1 {
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

                byte[] sendData = message.getBytes();

                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, SERVER_PORT);

                clientSocket.send(sendPacket);

                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                clientSocket.receive(receivePacket);

                String serverResponse = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Server response: " + serverResponse);

                clientSocket.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

