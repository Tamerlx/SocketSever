package com.company;

import socketserver.ChatServer;

public class Main {

    public static void main(String[] args) {
        ChatServer socketSever = ChatServer.shareChatServer();
        socketSever.connectServer();
    }
}
