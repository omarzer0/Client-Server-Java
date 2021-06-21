package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            Socket connectionSocket = serverSocket.accept();

            DataInputStream inFromClient = new DataInputStream(new BufferedInputStream(connectionSocket.getInputStream()));
            DataOutputStream outFromServer = new DataOutputStream(connectionSocket.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String str = "", str2;
            while (!str.equalsIgnoreCase("stop")) {
                str = inFromClient.readUTF();
                System.out.println("Client says: " + str);
                str2 = br.readLine();
                outFromServer.writeUTF(str2);
                outFromServer.flush();
            }

            inFromClient.close();
            connectionSocket.close();
            serverSocket.close();

        } catch (IOException e) {
            System.out.println("error: " + e.getMessage());
        }

    }
}
