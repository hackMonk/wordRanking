package com.ekstrah.wordRank;

/**
 * Created by ekstr on 2017-06-18.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

/**
 * This class parses the pdf file.
 * i.e this class returns the text from the pdf file.
 * @author Mubin Shrestha
 */
public class PdfFileParser {

    public String PdfFileParser(String pdffilePath) throws FileNotFoundException, IOException  {
        String content;
        FileInputStream fi = new FileInputStream(new File(pdffilePath));
        PDFParser parser = new PDFParser(fi);
        parser.parse();
        COSDocument cd = parser.getDocument();
        PDFTextStripper stripper = new PDFTextStripper();
        content = stripper.getText(new PDDocument(cd));
        cd.close();
        return content;
    }
}
