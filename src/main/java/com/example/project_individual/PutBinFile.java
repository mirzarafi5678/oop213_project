package com.example.project_individual;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PutBinFile {

    public static void saveObject(File file, Object obj) throws IOException {
        boolean fileExists = file.exists();
        FileOutputStream fos = new FileOutputStream(file, true); // append = true

        ObjectOutputStream oos = fileExists
                ? new AppendableObjectOutputStream(fos) // Skip header
                : new ObjectOutputStream(fos);          // Write header

        oos.writeObject(obj);
        oos.close();
    }

    // Read all objects from the file
    public static <T> List<T> readAllObjects(File file) throws IOException, ClassNotFoundException {
        List<T> objects = new ArrayList<>();

        if (!file.exists()) return objects;

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        while (true) {
            try {
                @SuppressWarnings("unchecked")
                T obj = (T) ois.readObject();
                objects.add(obj);
            } catch (EOFException eof) {
                break; // End of file
            }
        }
        ois.close();

        return objects;
    }

    public static <T> void writeAllObjects(File file, List<T> objects) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        for (T obj : objects) {
            oos.writeObject(obj);
        }
        oos.close();
    }

    private static class AppendableObjectOutputStream extends ObjectOutputStream {
        public AppendableObjectOutputStream(OutputStream out) throws IOException {
            super(out);
        }

        @Override
        protected void writeStreamHeader() throws IOException {
            // Skip writing header to allow appending
        }
    }
}
