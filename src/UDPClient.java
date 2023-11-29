import java.net.*;
import java.util.Scanner;

public class UDPClient {
    private static final int SERVER_PORT = 9876;
    private static final String SERVER_IP = "127.0.0.1";

    public static void main(String[] args) {
        try {
            DatagramSocket clientSocket = new DatagramSocket();

            InetAddress serverAddress = InetAddress.getByName(SERVER_IP);

            Scanner scanner = new Scanner(System.in);
            System.out.println("Choose a request (READ, LIST, EXECUTE, WRITE, UPLOAD, BROWSE):");
            String requestType = scanner.nextLine().toUpperCase();

            String message;
            switch (requestType) {
                case "READ":
                case "EXECUTE":
                    System.out.println("Enter the file name or command:");
                    String fileNameOrCommand = scanner.nextLine();
                    message = requestType + " " + fileNameOrCommand;
                    break;
                case "LIST":
                    message = "LIST";
                    break;
                case "WRITE":
                    System.out.println("Enter the file name:");
                    String fileNameToWrite = scanner.nextLine();

                    System.out.println("Enter the content to write:");
                    String contentToWrite = scanner.nextLine();

                    message = requestType + " " + fileNameToWrite + " " + contentToWrite;
                    break;
                case "UPLOAD":
                    System.out.println("Enter the content for upload:");
                    String contentToUpload = scanner.nextLine();
                    message = requestType + " " + "readAllBytes" + " " + contentToUpload;
                    break;
                case "BROWSE":
                    System.out.println("Enter the directory path:");
                    String directoryPath = scanner.nextLine();
                    message = requestType + " " + directoryPath;
                    break;
                default:
                    System.out.println("Invalid request");
                    return;
            }
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