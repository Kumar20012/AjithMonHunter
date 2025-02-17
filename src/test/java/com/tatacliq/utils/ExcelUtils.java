package com.tatacliq.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {

    public static void writeDataToExcel(List<List<String>> data, String filePath) {
        if (data.isEmpty()) {
            System.out.println("No data found");
            return;
        }
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Product Details");
        Row headerRow = sheet.createRow(0);
        List<String> firstRow = data.get(0);
        for (int i = 0; i < firstRow.size(); i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue("Column " + (i + 1));
        }
        for (int i = 0; i < data.size(); i++) {
            Row row = sheet.createRow(i + 1);
            List<String> dataRow = data.get(i);
            for (int j = 0; j < dataRow.size(); j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(dataRow.get(j));
            }
        }
        try (FileOutputStream fileOut = new FileOutputStream(new File("src/test/resources/data/"+filePath))) {
            workbook.write(fileOut);
            System.out.println("Data wrote successfully");
        } catch (IOException e) {
            System.out.println("Error writing to Excel file: " + e.getMessage());
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void addProductData(List<List<String>> data, String... values) {
        List<String> row = new ArrayList<>();
        for (String value : values) {
            row.add(value);
        }
        data.add(row);
    }

}
