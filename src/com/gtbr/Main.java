package com.gtbr;

import com.gtbr.controller.MenuController;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        MenuController menuController = new MenuController();

        menuController.exibeMenu();

    }
}
