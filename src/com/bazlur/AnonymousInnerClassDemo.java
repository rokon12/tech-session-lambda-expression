package com.bazlur;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;

public class AnonymousInnerClassDemo {
    public static void main(String[] args) {

        File file = new File("src/com/bazlur");
        String[] list = file.list((dir, name) -> name.endsWith(".java"));

        Thread thread = new Thread(() -> System.out.println("hello!"));
        thread.start();
    }
}
