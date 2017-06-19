package com.ekstrah.wordRank;

import java.io.IOException;



public class wordRank {
    public static void main(String[] args) throws IOException {
//        String fileAddress;
//        String fileFormat;
//        WordProcessing obj = new WordProcessing();
//        String content;
//        String[] fileInDir = obj.getFileName();
//        for(String names : fileInDir) {
//            System.out.println(names);
//            fileFormat = getFileExtension(names);
//            System.out.println("Directory Path is " + obj.dirPath);
//            fileAddress = obj.dirPath + "\\" + names;
//            //System.out.println(fileFormat);
//            if (new String(fileFormat).equals("txt") == true) {
//                content = obj.readFile(fileAddress);
//            }   else if(new String(fileFormat).equals("pdf") == true) {
//                    PdfFileParser a = new PdfFileParser();
//                    content = a.PdfFileParser(fileAddress);
//            }   else {
//                DocxFileParser test = new DocxFileParser();
//                content = test.docxFileContentParser(fileAddress);
//            }
//            obj.getNoun(content);
//            System.out.println("File has been ended Here");
//        }
//        System.out.println("All files have been inputed\n\n\n\n");
//        obj.printDict();
//        System.out.println("Sorted by the key value : \n\n\n\n\n");
//        obj.sortDict();
        WordGui window = new WordGui();
        window.setVisible(true);
    }
//    private static String getFileExtension(String fileName) {
//        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
//            return fileName.substring(fileName.lastIndexOf(".")+1);
//        else
//            return "";
//    }
}
