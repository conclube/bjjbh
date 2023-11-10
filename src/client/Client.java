package client;

import common.Common;
import common.Credentials;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private final Socket socket;
    private boolean isLoggedIn = false;

    public Client(Socket socket) {
        this.socket = socket;
    }

    public void start() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextLine()) {
                if (!this.isLoggedIn) {
                    String username = scanner.nextLine();
                    try {
                        Credentials.of(username);
                        socket.connect(new InetSocketAddress("127.0.0.1", Common.STANDARD_PORT));
                    } catch (Exception e) {
                        System.out.println("Invalid username!");
                    }
                }
            }
        }
    }
}