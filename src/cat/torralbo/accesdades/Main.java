package cat.torralbo.accesdades;


import java.io.*;

public class Main {

    public static void main(String[] args) {
        /*
	if(!comparaFitxers()){
        System.out.println("Són diferents!");
    } else {
        System.out.println("Són iguals.");
    }*/

        /*System.out.println(damReader());*/

        try {
            System.out.println(stringWriter());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean comparaFitxers() {

        boolean comprovant = true;

        BufferedReader reader1 = null;
        try {
            reader1 = new BufferedReader(new FileReader("src/primer.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        BufferedReader reader2 = null;
        try {
            reader2 = new BufferedReader(new FileReader("src/segon.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int char1, char2;
        try {
            while ((char1 = reader1.read()) != -1 && (char2 = reader2.read()) != -1) {
                // converteix a minúscules
                char lowerCase1 = Character.toLowerCase((char) char1);
                char lowerCase2 = Character.toLowerCase((char) char2);

                if (lowerCase1 != lowerCase2) {
                    //són diferents;
                    comprovant = false;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return comprovant;

    }

    private static int damReader() {
        BufferedReader reader = null;
        int charCount = 0;
        int wordCount = 0;

        try
        {
            reader = new BufferedReader(new FileReader("src/primer.txt"));

            String currentLine = reader.readLine();
            while (currentLine != null)
            {

                String[] words = currentLine.split(" ");

                wordCount = wordCount + words.length;

                //Iterem paraules
                for (String word : words)
                {
                    charCount = charCount + word.length();
                }
                //Llegim següent línia
                currentLine = reader.readLine();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return charCount;
    }

    private static String stringWriter() throws IOException {

        char[] buff = new char[1024];
        Writer stringWriter = new StringWriter();
        FileInputStream fStream = null;
        Reader bReader = null;

        try {
            fStream = new FileInputStream("src/primer.txt");
            bReader = new BufferedReader(new InputStreamReader(fStream, "UTF-8"));
            int n;
            while ((n = bReader.read(buff)) != -1) {
                stringWriter.write(buff, 0, n);
            }
        } finally {
            bReader.close();
            stringWriter.close();
            fStream.close();
        }
        return stringWriter.toString();
    }
}
