package com.company;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class Server {
    public static LinkedList<ServerEtc> serv = new LinkedList<>();
    ServerSocket serverSocket;

        public void server(){
            String tmp;
            try {
                serverSocket = new ServerSocket(25017);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Сервер запущен!");
            try{
            while (true) {
                Socket clientSocket = serverSocket.accept();
                serv.add(new ServerEtc(clientSocket));
                System.out.println("+1");
            }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
