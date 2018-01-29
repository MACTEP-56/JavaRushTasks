package com.javarush.task.task32.task3209;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by PBunegin on 19.10.2017.
 */
public class HTMLFileFilter extends FileFilter {
    @Override
    public boolean accept(File f) {
        String name = f.getName();
        if (f.isDirectory() || name.toLowerCase().endsWith(".html") ||
                name.toLowerCase().endsWith(".htm"))
            return true;
        return false;
    }

    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
