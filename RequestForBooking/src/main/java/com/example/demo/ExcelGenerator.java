package com.example.demo;

import java.util.List;
import java.io.IOException;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;


public class ExcelGenerator {

    private List < Client > getAllClient;
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    public ExcelGenerator(List < Client > client) {
        this.getAllClient = client;
        workbook = new XSSFWorkbook();
    }
    private void writeHeader() {
        sheet = workbook.createSheet("Client");
        Row row = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
       
        createCell(row, 0, "ID", style);
        createCell(row, 1, "First Name", style);
        createCell(row, 2, "Last Name", style);
        createCell(row, 3, "Email", style);
        createCell(row, 4, "Working Days", style);
        createCell(row, 5, "Employee Leave", style);
        createCell(row, 6, "Mobile Number", style);
        createCell(row, 7, "Reporting", style);
        createCell(row, 8, "Remark", style);
    }
    private void createCell(Row row, int columnCount, Object valueOfCell, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (valueOfCell instanceof Integer) {
            cell.setCellValue((Integer) valueOfCell);
        } else if (valueOfCell instanceof Long) {
            cell.setCellValue((Long) valueOfCell);
        } else if (valueOfCell instanceof String) {
            cell.setCellValue((String) valueOfCell);
        } else {
            cell.setCellValue((Boolean) valueOfCell);
        }
        cell.setCellStyle(style);
    }
    private void write() {
        int rowCount = 1;
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
        for (Client record: getAllClient) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, record.getId(), style);
            createCell(row, columnCount++, record.getFirst_name(),style );
            createCell(row, columnCount++, record.getLast_Name(), style);
            createCell(row, columnCount++, record.getMobile_number(), style);
            createCell(row, columnCount++, record.getSource(), style);
            createCell(row, columnCount++, record.getDestination(), style);
            createCell(row, columnCount++, record.getDateOfJourney(), style);
            createCell(row, columnCount++, record.getSeat(), style);
            createCell(row, columnCount++, record.getMeal(), style);
            createCell(row, columnCount++, record.getBaggage(), style);
        }
    }
    public void generateExcelFile(HttpServletResponse response) throws IOException {
        writeHeader();
        write();
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}