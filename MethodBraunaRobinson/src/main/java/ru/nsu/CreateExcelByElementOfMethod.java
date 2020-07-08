//package ru.nsu;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.List;
//
//import org.apache.poi.hssf.usermodel.HSSFCellStyle;
//import org.apache.poi.hssf.usermodel.HSSFFont;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellType;
//import org.apache.poi.ss.usermodel.Row;
//
//
//public class CreateExcelByElementOfMethod {
//    private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
//        HSSFFont font = workbook.createFont();
//        font.setBold(true);
//        HSSFCellStyle style = workbook.createCellStyle();
//        style.setFont(font);
//        return style;
//    }
//    public static void main(String[] args) throws IOException {
//
//        HSSFWorkbook workbook = new HSSFWorkbook();
//        HSSFSheet sheet = workbook.createSheet("Result");
//        List<ElementOfMethod> list = ElementPackageExcel.listEmployees();
//        int rownum = 0;
//        Cell cell;
//        Row row;
//        //
//        HSSFCellStyle style = createStyleForTitle(workbook);
//
//        row = sheet.createRow(rownum);
//
//        // EmpNo
//        cell = row.createCell(0, CellType.STRING);
//        cell.setCellValue("k");
//        cell.setCellStyle(style);
//        // EmpName
//        cell = row.createCell(1, CellType.STRING);
//        cell.setCellValue("i");
//        cell.setCellStyle(style);
//        // Salary
//        for(int j =0;j<list.get(1).getUAI().length;j++){
//            cell = row.createCell(j+2, CellType.STRING);
//            cell.setCellValue(j+1);
//            cell.setCellStyle(style);
//        }
//        cell = row.createCell(list.get(0).getUAI().length+2, CellType.STRING);
//        cell.setCellValue("alpha");
//        cell.setCellStyle(style);
//        // Grade
//        cell = row.createCell(list.get(0).getUAI().length+3, CellType.STRING);
//        cell.setCellValue("j");
//        cell.setCellStyle(style);
//        // Bonus
//        for(int j =0;j<list.get(0).getUAI().length;j++){
//            cell = row.createCell(j+list.get(0).getUAI().length+4, CellType.STRING);
//            cell.setCellValue(j+1);
//            cell.setCellStyle(style);
//        }
//        cell = row.createCell(list.get(0).getUAI().length*2+4, CellType.STRING);
//        cell.setCellValue("beta");
//        cell.setCellStyle(style);
//
//        cell = row.createCell(list.get(0).getUAI().length*2+5, CellType.STRING);
//        cell.setCellValue("v");
//        cell.setCellStyle(style);
//
//        cell = row.createCell(list.get(0).getUAI().length*2+6, CellType.STRING);
//        cell.setCellValue("delta");
//        cell.setCellStyle(style);
//
//        cell = row.createCell(list.get(0).getUAI().length*2+7, CellType.STRING);
//        cell.setCellValue("epsilon");
//        cell.setCellStyle(style);
//
//        // Data
//        for (ElementOfMethod emp : list) {
//            rownum++;
//            row = sheet.createRow(rownum);
//
//            // EmpNo (A)
//            cell = row.createCell(0, CellType.NUMERIC);
//            cell.setCellValue(emp.getkOrder());
//            // EmpName (B)
//            cell = row.createCell(1, CellType.NUMERIC);
//            cell.setCellValue(emp.getiOrder());
//            // Salary (C)
//            for(int j =0;j<emp.getUAJ().length;j++){
//                cell = row.createCell(j+2, CellType.NUMERIC);
//                cell.setCellValue(emp.getUAJ()[j]);
//            }
//            cell = row.createCell(list.get(0).getUAJ().length+2, CellType.STRING);
//            cell.setCellValue(emp.getAlpha());
//            // Grade
//            cell = row.createCell(list.get(0).getUAJ().length+3, CellType.STRING);
//            cell.setCellValue(emp.getjOrder());
//            // Bonus
//            for(int j =0;j<list.get(0).getUAI().length;j++){
//                cell = row.createCell(j+list.get(0).getUAI().length+4, CellType.STRING);
//                cell.setCellValue(emp.getUAI()[j]);
//            }
//            cell = row.createCell(list.get(0).getUAI().length*2+4, CellType.STRING);
//            cell.setCellValue(emp.getBeta());
//
//            cell = row.createCell(list.get(0).getUAI().length*2+5, CellType.STRING);
//            cell.setCellValue(emp.getValue());
//
//            cell = row.createCell(list.get(0).getUAI().length*2+6, CellType.STRING);
//            cell.setCellValue(emp.getDelta());
//
//            cell = row.createCell(list.get(0).getUAI().length*2+7, CellType.STRING);
//            cell.setCellValue(emp.getEpsilon());
//
//        }
//        File file = new File("C:/Users/Mark/Maven project/MethodBraunaRobinson/result.xls");
//        file.getParentFile().mkdirs();
//
//        FileOutputStream outFile = new FileOutputStream(file);
//        workbook.write(outFile);
//        System.out.println("Created file: " + file.getAbsolutePath());
//
//    }
//}
