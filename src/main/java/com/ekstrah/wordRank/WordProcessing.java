package com.ekstrah.wordRank;

import javax.swing.*;
import java.io.*;
import java.util.*;


import com.twitter.penguin.korean.KoreanPosJava;
import com.twitter.penguin.korean.KoreanTokenJava;
import scala.collection.Seq;
import com.twitter.penguin.korean.TwitterKoreanProcessorJava;
import com.twitter.penguin.korean.tokenizer.KoreanTokenizer;

import static java.lang.System.out;

/**
 * Created by ekstr on 2017-06-18.
 */
public class WordProcessing {
    public int[] topTenNum = new int[10];
    public int numFile;
    public int wordCount;
    public JFileChooser chooser = new JFileChooser();
    public String dirPath;
    public ArrayList<String> nounDict = new ArrayList<String>();
    Map<String, Integer> map = new HashMap<String, Integer>();
    public String[] topTen = new String[10];

    public WordProcessing() {
        System.out.println("File Initialized");
        this.wordCount = 0;
    }

    public String[] getFileName() {
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("choosertitle");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            //System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
            System.out.println("Successfully opened " + chooser.getSelectedFile() + " directory :D");
            dirPath = new String(chooser.getSelectedFile().toString());
        } else {
            System.out.println("No Selection ");
        }

        File aDirectory = new File(dirPath);
        String[] fileInDir = aDirectory.list();
        dirPath = aDirectory.getPath();
        return fileInDir;
    }
    public void getNoun(String text) {
        // Normalize
        CharSequence normalized = TwitterKoreanProcessorJava.normalize(text);
        out.println(normalized);
        Seq<KoreanTokenizer.KoreanToken> tokens = TwitterKoreanProcessorJava.tokenize(normalized);
        List<KoreanTokenJava> javaKoreanTokenList = TwitterKoreanProcessorJava.tokensToJavaKoreanTokenList(tokens);
        for (KoreanTokenJava koreantokenjava : javaKoreanTokenList) {
            KoreanPosJava pos = koreantokenjava.getPos();
            if (pos.compareTo(KoreanPosJava.Noun) == 0 || pos.compareTo(KoreanPosJava.ProperNoun) == 0) {
                String keyword = koreantokenjava.getText();
                wordCount++;
                System.out.println(keyword + " " + koreantokenjava.getPos());
                if (map.get(keyword) == null)
                    map.put(keyword, 1);
                else
                    map.put(keyword, map.get(keyword)+1);
                nounDict.add(keyword);
            }
        }
    }
    public String readFile(String filePath) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        InputStreamReader isr = new InputStreamReader(fis, "MS949");
        String result = getStringFromInputStream(isr);
        return result;
    }
    public void contentPrint(String filePath) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        InputStreamReader isr = new InputStreamReader(fis, "MS949");
        String result = getStringFromInputStream(isr);
        System.out.println(result);
    }
    public void checkEncoding() {
        String originalStr = "Å×½ºÆ®"; // 테스트
        String[] charSet = {"utf-8", "euc-kr", "ksc5601", "iso-8859-1", "x-windows-949"};

        for (int i = 0; i < charSet.length; i++) {
            for (int j = 0; j < charSet.length; j++) {
                try {
                    System.out.println("[" + charSet[i] + "," + charSet[j] + "] = " + new String(originalStr.getBytes(charSet[i]), charSet[j]));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private static String getStringFromInputStream(InputStreamReader is) {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        String line;
        try {

            br = new BufferedReader(is);
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();

    }
    public void printDict() {
        for(Map.Entry entry : map.entrySet()) {
            System.out.println("Word >> " + entry.getKey() + " Value >> " + entry.getValue());
        }
    }
    public void sortDict() {
        Object[] a = map.entrySet().toArray();
        int check = 0;
        Arrays.sort(a, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Map.Entry<String, Integer>) o2).getValue().compareTo(((Map.Entry<String, Integer>) o1).getValue());
            }
        });
        for(Object e: a) {
            if(check < 10) {
                topTen[check] = ((Map.Entry<String, Integer>) e).getKey();
                topTenNum[check] = ((Map.Entry<String, Integer>) e).getValue();
                System.out.println(topTen[check]);
                check++;
            }
            else
                break;
        }
    }
}
