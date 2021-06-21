package com.company;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try{
            Socket socket = new Socket("localhost",5000);
            DataInputStream inFromServer = new DataInputStream(socket.getInputStream());
            DataOutputStream outFromClient = new DataOutputStream(socket.getOutputStream());
            BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

            String str="",str2;
            while(!str.equalsIgnoreCase("stop")){
                str=br.readLine();
                outFromClient.writeUTF(str);
                outFromClient.flush();
                str2=inFromServer.readUTF();
                System.out.println("Server says: "+str2);
            }

            outFromClient.close();
            socket.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
