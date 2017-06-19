package com.ekstrah.wordRank;


import java.io.FileInputStream;
import org.apache.poi.hslf.extractor.PowerPointExtractor;
import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/**
 * This class parses the microsoft word files except .docx,.pptx and
 * latest MSword files.
 *
 * @author Mubin Shrestha
 */
public class DocFileParser {
    public String DocFileContentParser(String fileName) {
        POIFSFileSystem fs = null;
        try {

            fs = new POIFSFileSystem(new FileInputStream(fileName));

            if(fileName.endsWith(".doc")) {
                HWPFDocument doc = new HWPFDocument(fs);
                WordExtractor we = new WordExtractor(doc);
                return we.getText();
            }else if(fileName.endsWith(".xls")) {
//              HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(fileName));
                ExcelExtractor ex = new ExcelExtractor(fs);
                ex.setFormulasNotResults(true);
                ex.setIncludeSheetNames(true);
                return ex.getText();
            } else if (fileName.endsWith(".ppt")) {
                PowerPointExtractor extractor = new PowerPointExtractor(fs);
                return extractor.getText();
            }

        } catch (Exception e) {
            System.out.println("document file cant be indexed");
        }
        return "";
    }
}

