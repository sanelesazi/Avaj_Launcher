package com.sazi.simulation;

// import java.io.BufferedWriter;
// import java.io.IOException;
// import java.io.Writer;
import java.io.*;

public class Logger
{
    private static Writer writer = null;

    public static void setOutputFile(String file) throws IOException
    {
        if (writer != null)
            writer.close();
        writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8"));
    }

    public static void logToFile (String msg)
    {
        try {
            writer.write(msg);
            writer.flush();
        }
        catch (IOException e) {
            System.out.println("Unable to write to file");
            System.exit(-1);
        }
    }
}