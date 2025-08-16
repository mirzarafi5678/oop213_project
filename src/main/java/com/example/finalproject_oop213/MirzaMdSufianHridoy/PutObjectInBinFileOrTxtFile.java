package com.example.finalproject_oop213.MirzaMdSufianHridoy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PutObjectInBinFileOrTxtFile {


    static class AppendableObjectOutputStream extends ObjectOutputStream {
        public AppendableObjectOutputStream(OutputStream out) throws IOException {
            super(out);
        }

        @Override
        protected void writeStreamHeader() throws IOException {
            reset();
        }
    }


    public static void writeObjInBinaryFile(String filePath, Object obj) {
        File file = new File(filePath);
        try (FileOutputStream fos = new FileOutputStream(file, true);
             ObjectOutputStream oos = file.exists() && file.length() > 0
                     ? new AppendableObjectOutputStream(fos)
                     : new ObjectOutputStream(fos)) {

            oos.writeObject(obj);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void overwriteBinaryFile(String filePath, Object obj) {
        File file = new File(filePath);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file, false))) {
            oos.writeObject(obj);
            System.out.println("Binary file overwritten with new object.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static String readObjFromBinaryFile(String filePath) {
        StringBuilder result = new StringBuilder();
        File file = new File(filePath);

        if (!file.exists()) {
            return "File not found: " + filePath;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    Object obj = ois.readObject();
                    result.append(obj.toString()).append("\n");
                } catch (EOFException eof) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return result.toString();
    }


    public static void writeObjectInTxtFile(String filePath, Object obj) {
        try (FileWriter fw = new FileWriter(filePath, true)) {
            fw.write(obj.toString() + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void overwriteTxtFile(String filePath, Object obj) {
        try (FileWriter fw = new FileWriter(filePath, false)) {
            fw.write(obj.toString() + System.lineSeparator());
            System.out.println("Text file overwritten successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    public static String readFromTxtFile(String filePath) {
        StringBuilder result = new StringBuilder();

        try (Scanner sc = new Scanner(new File(filePath))) {
            while (sc.hasNextLine()) {
                result.append(sc.nextLine()).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toString();
    }

    public static void appendLineToTxtFile(String filePath, String text) {
        try (FileWriter fw = new FileWriter(filePath, true)) {
            fw.write(text + System.lineSeparator());
            System.out.println("Line added successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Object getLastObjectFromBinaryFile(String filePath) {
        File file = new File(filePath);

        if (!file.exists() || file.length() == 0) {
            System.out.println("File is empty or does not exist.");
            return null;
        }

        Object lastObject = null;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    lastObject = ois.readObject();
                } catch (EOFException eof) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return lastObject;
    }

    public static void updateUser(alluserdata updatedUser) {
        // Step 1: Read all users
        List<alluserdata> allUsers = new ArrayList<>();
        File f = new File("User.bin");

        if (f.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
                while (true) {
                    try {
                        alluserdata user = (alluserdata) ois.readObject();
                        allUsers.add(user);
                    } catch (EOFException e) {
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        for (int i = 0; i < allUsers.size(); i++) {
            if (allUsers.get(i).getSetUsername().equals(updatedUser.getSetUsername())) {
                allUsers.set(i, updatedUser);
                break;
            }
        }


        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("User.bin"))) {
            for (alluserdata user : allUsers) {
                oos.writeObject(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static boolean removeATicketFromBin(int setid) {
        ArrayList<CreateTicket> cc1 = new ArrayList<>();
        File f = new File("CreatedByCounter.bin");
        boolean removed = false;

        if (f.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
                while (true) {
                    try {
                        CreateTicket obj = (CreateTicket) ois.readObject();
                        cc1.add(obj);
                    } catch (EOFException e) {
                        break;
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }


        for (int i = 0; i < cc1.size(); i++) {
            if (cc1.get(i).getSetid() == setid) {
                cc1.remove(i);
                removed = true;
                break;
            }
        }


        if (removed) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))) {
                for (CreateTicket ticket : cc1) {
                    oos.writeObject(ticket);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return removed;
    }

    public static boolean removeALaunchTripFromBin(String tripNumber) {
        ArrayList<LaunchTrip> trips = new ArrayList<>();
        File f = new File("LaunchInfo.bin");
        boolean removed = false;

        if (f.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
                while (true) {
                    try {
                        LaunchTrip obj = (LaunchTrip) ois.readObject();
                        trips.add(obj);
                    } catch (EOFException e) {
                        break;
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }


        for (int i = 0; i < trips.size(); i++) {
            if (trips.get(i).getTripnumber().equals(tripNumber)) {
                trips.remove(i);
                removed = true;
                break;
            }
        }


        if (removed) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))) {
                for (LaunchTrip trip : trips) {
                    oos.writeObject(trip);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return removed;
    }

    public static void writeStringToTxtFile1(String filename, String content) {
        File file = new File(filename);

        try {
            // Create file if it doesn't exist
            if (!file.exists()) {
                file.createNewFile();
            }

            // Write to file (overwrite mode)
            try (FileWriter writer = new FileWriter(file, false)) { // 'false' -> overwrite
                writer.write(content);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}





