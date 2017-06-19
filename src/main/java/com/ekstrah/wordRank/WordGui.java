package com.ekstrah.wordRank;


import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class WordGui extends JFrame implements ActionListener{
    public WordProcessing obj = new WordProcessing();
    public int fileCount;
    fileStoreToText Storetxt= null;
    int state = 0;
    private ImageIcon Chartimg;
    private JTextField Fpath;
    private JTextField Ftype;
    private String path;
    private String type;
    private JScrollPane scrollPane;
    private BarChart Chart;
    private JButton clearButton;
    private JButton GoButton;
    //	private JButton appendButton;
    private JPanel WordRank;
    private ImageIcon backGround;
    private JPanel countPanel;
    private JLabel WordCounter;
    private JLabel Rank1;
    private JLabel Rank2;
    private JLabel Rank3;
    private JLabel Rank4;
    private JLabel Rank5;
    private JLabel Rank6;
    private JLabel Rank7;
    private JLabel Rank8;
    private JLabel Rank9;
    private JLabel Rank10;

    private Font font = new Font("SansSerif", Font.PLAIN, 24);
    private Font startFont = new Font("SansSerif", Font.PLAIN, 24);
    private Font clearFont = new Font("SansSerif", Font.PLAIN, 18);
    private Font appendFont = new Font("SansSerif", Font.PLAIN, 18);

    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();

        if(command.equals("Start"))  {
            try {
                initialize();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            JLabel ch = new JLabel();
            Chart = new BarChart(obj.topTen, obj.topTenNum);
            Chartimg = new ImageIcon("Barchart.jpeg");
            ch.setIcon(Chartimg);
            ch.setBounds(0, 0, 700, 550);
            WordRank.add(ch);

            Rank1.setText("  1. " + obj.topTen[0]);
            Rank2.setText("  2. " + obj.topTen[1]);
            Rank3.setText("  3. " + obj.topTen[2]);
            Rank4.setText("  4. " + obj.topTen[3]);
            Rank5.setText("  5. " + obj.topTen[4]);
            Rank6.setText("  6. " + obj.topTen[5]);
            Rank7.setText("  7. " + obj.topTen[6]);
            Rank8.setText("  8. " + obj.topTen[7]);
            Rank9.setText("  9. " + obj.topTen[8]);
            Rank10.setText("  10. "+ obj.topTen[9]);

            countPanel.add(Rank1);
            countPanel.add(Rank2);
            countPanel.add(Rank3);
            countPanel.add(Rank4);
            countPanel.add(Rank5);
            countPanel.add(Rank6);
            countPanel.add(Rank7);
            countPanel.add(Rank8);
            countPanel.add(Rank9);
            countPanel.add(Rank10);



            Fpath.setText(obj.dirPath + "\\");
            Ftype.setText("# of File " + String.valueOf(fileCount));
            String tempText = "Word Count " + String.valueOf(obj.wordCount);
            WordCounter.setText(tempText );
            repaint();
//			System.out.println(path);
        }
        if(command.equals("Clear"))
        {
            WordRank.removeAll();
            countPanel.removeAll();
            String tempText = "Word Count " + String.valueOf(obj.wordCount);
            WordCounter.setText(tempText );
            countPanel.add(WordCounter);
            repaint();
        }
    }

    public String getPath()
    {
        return path;
    }

    public String getfileType()
    {
        return type;
    }

    public void paint(Graphics g)
    {
        super.paint(g);
    }

//    public void aa() throws FileNotFoundException, IOException
//    {
//
//        Storetxt = new fileStoreToText(path, type);
//
//
//        if(Storetxt.getState() == 0)
//        {
//            //System.out.println(new PdfFileParser().PdfFileParser(filepath));
//            Storetxt.setText(new PdfFileParser().PdfFileParser(path));
//            Storetxt.StoreText();
//        }
//        else if(Storetxt.getState() == 1)
//        {
//            //System.out.println(new DocFileParser().DocFileContentParser(filepath));
//            Storetxt.setText(new DocFileParser().DocFileContentParser(path));
//            Storetxt.StoreText();
//        }
//        else if(Storetxt.getState() == 2)
//        {
//            //System.out.println(new DocxFileParser().docxFileContentParser(filepath));
//            Storetxt.setText(new DocxFileParser().docxFileContentParser(path));
//            Storetxt.StoreText();
//        }
//    }

    public WordGui() throws IOException {
        setTitle("Word Rank");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1024,750);
        setLayout(null);

        JPanel pathPanel = new JPanel();
        JPanel typePanel = new JPanel();
        pathPanel.setLayout(new BorderLayout());
        pathPanel.setBackground(Color.white);
        typePanel.setLayout(new BorderLayout());
        typePanel.setBackground(Color.white);

        Fpath = new JTextField("Enter Absolute File Path!", 50);
        Fpath.setFont(font);
        Fpath.setBackground(Color.white);
        pathPanel.setBounds(50, 50, 500, 35);
        pathPanel.add(Fpath);
        add(pathPanel);

        Ftype = new JTextField("File type?", 10);
        Ftype.setFont(font);
        Ftype.setBackground(Color.WHITE);
        typePanel.setBounds(560, 50, 190, 35);
        typePanel.add(Ftype);
        add(typePanel);



        GoButton = new JButton("Start");
        GoButton.setFont(startFont);
        GoButton.addActionListener(this);
        GoButton.setBounds(780, 50, 150, 38);
        add(GoButton);

        clearButton = new JButton("Clear");

        clearButton.addActionListener(this);
        clearButton.setFont(clearFont);
        clearButton.setBounds(780, 550, 150, 38);
        add(clearButton);

        WordRank = new JPanel();
        WordRank.setBackground(Color.white);
        WordRank.setBounds(50, 100, 700, 575);
        add(WordRank);

        countPanel = new JPanel();
        countPanel.setBackground(Color.white);
        countPanel.setLayout(new GridLayout(11,1));
        countPanel.setBounds(780, 100, 150, 440);

        WordCounter = new JLabel("     Word Count");
        WordCounter.setFont(appendFont);
        countPanel.add(WordCounter);

        Rank1 = new JLabel();
        countPanel.add(Rank1);
        Rank2 = new JLabel();
        countPanel.add(Rank2);
        Rank3 = new JLabel();
        countPanel.add(Rank3);
        Rank4 = new JLabel();
        countPanel.add(Rank4);
        Rank5 = new JLabel();
        countPanel.add(Rank5);
        Rank6 = new JLabel();
        countPanel.add(Rank6);
        Rank7 = new JLabel();
        countPanel.add(Rank7);
        Rank8 = new JLabel();
        countPanel.add(Rank8);
        Rank9 = new JLabel();
        countPanel.add(Rank9);
        Rank10 = new JLabel();
        countPanel.add(Rank10);

        add(countPanel);


        //����ȭ���� �ҷ����� ����.
        backGround = new ImageIcon("img/img1.png");

        JLabel im = new JLabel();
        im.setIcon(backGround);
        im.setBounds(0, 0, 1024, 750);
        add(im);

    }

    public void initialize () throws IOException {
        String fileAddress;
        String fileFormat;
        String content;
        String[] fileInDir = obj.getFileName();
        fileCount = 0;
        for(String names : fileInDir) {
            System.out.println(names);
            fileFormat = getFileExtension(names);
            System.out.println("Directory Path is " + obj.dirPath);
            fileAddress = obj.dirPath + "\\" + names;
            //System.out.println(fileFormat);
            if (new String(fileFormat).equals("txt") == true) {
                content = obj.readFile(fileAddress);
            }   else if(new String(fileFormat).equals("pdf") == true) {
                PdfFileParser a = new PdfFileParser();
                content = a.PdfFileParser(fileAddress);
            }   else {
                DocxFileParser test = new DocxFileParser();
                content = test.docxFileContentParser(fileAddress);
            }
            obj.getNoun(content);
            System.out.println("File has been ended Here");
            fileCount++;
        }
        System.out.println("All files have been inputed\n\n\n\n");
        obj.printDict();
        System.out.println("Sorted by the key value : \n\n\n\n\n");
        obj.sortDict();
    }
    private static String getFileExtension(String fileName) {
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".")+1);
        else
            return "";
    }

}


