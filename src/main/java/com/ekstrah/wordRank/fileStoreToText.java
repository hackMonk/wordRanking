package com.ekstrah.wordRank;

/**
 * Created by ekstr on 2017-06-18.
 */

import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class fileStoreToText {
    private String text;
    private String fileType = null;
    private String filePath = null;
    private int state = 0;

    public fileStoreToText()
    {
        text = null;
    }

    public fileStoreToText(String absolutePath, String type)
    {
        filePath = absolutePath;
        fileType = type;

        if(fileType.equals(".pdf"))
            state = 0;
        else if(fileType.equals(".doc") || fileType.equals(".xls") || fileType.equals(".ppt"))
            state = 1;
        else if(fileType.equals(".docx") || fileType.equals(".xlsx") || fileType.equals(".pptx"))
            state = 2;
    }

    public void setText(String line)
    {
        text = line;
    }


    public int getState()
    {
        return state;
    }

    public void StoreText()
    {
        try
        {
            PrintWriter outputStream = new PrintWriter(new FileOutputStream("Word_Rank.txt"));
            outputStream.println(this.text);
            outputStream.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Problem opening files.");
        }


    }



}
