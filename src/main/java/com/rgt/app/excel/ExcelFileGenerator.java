package com.rgt.app.excel;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.rgt.app.models.Product;

public class ExcelFileGenerator{  
	
	public static ByteArrayInputStream ProductToExcel(List<Product> product)throws IOException{
		
        String[] columns= {"id","name","category","price","weight","description","imageName"};
        try(
                Workbook workbook=new XSSFWorkbook();
                ByteArrayOutputStream out=new ByteArrayOutputStream();
                ){
            Sheet sheet=workbook.createSheet("Product");
            Font headerFont=workbook.createFont();
            headerFont.setBold(true);
            headerFont.setColor(IndexedColors.BLUE.getIndex());
            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFont(headerFont);
             
            //Row  for Header
            Row headerRow=sheet.createRow(0);
            //header
            
            for(int col=0;col<columns.length; col++) {
                
                Cell cell=headerRow.createCell(col);
                cell.setCellValue(columns[col]);
                cell.setCellStyle(headerCellStyle);
            }
                
                int rowIdx=1;
                for(Product prod: product) {
                    Row row=sheet.createRow(rowIdx++);
                    row.createCell(0).setCellValue(prod.getId());
                    row.createCell(1).setCellValue(prod.getName());
                    row.createCell(2).setCellValue(prod.getCategory().getId());
                    row.createCell(3).setCellValue(prod.getPrice());
                    row.createCell(4).setCellValue(prod.getWeight());
                    row.createCell(5).setCellValue(prod.getDescription());
                    row.createCell(6).setCellValue(prod.getImageName());
                }
                workbook.write(out);
                return new ByteArrayInputStream(out.toByteArray());
                
            }
        }

}






