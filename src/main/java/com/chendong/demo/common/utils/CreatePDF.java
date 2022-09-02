package com.chendong.demo.common.utils;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;

public class CreatePDF {

    /**
     * 获取中国字体
     *
     * @return
     */
    public static Font getChineseFont() {
        BaseFont bfChinese;  //确认支持中文
        Font fontChinese = null;  //字体的设置，如颜色，字体，大小等
        try {
            bfChinese = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            // fontChinese = new Font(bfChinese, 12, Font.NORMAL);
            fontChinese = new Font(bfChinese, 12, Font.NORMAL, BaseColor.BLUE);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fontChinese;
    }

    public static void test1() throws IOException, DocumentException {
        //new一个Document对象,设置纸张大小
        Document document = new Document(PageSize.A4);
        //解析器
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("D://pdfText.pdf"));
        //添加PDF属性
        document.addAuthor("作者");
        document.addTitle("标题");
        document.addSubject("主题");
        document.addKeywords("关键字");
        /*页边距*/
        document.setMargins(10, 20, 30, 40);

        //打开document
        document.open();

        //添加新段落
        document.add(new Paragraph("<p>Hello world</p>"));

        //添加新的空白页
        document.newPage();
        writer.setPageEmpty(true); //显示空白页

        /*Chunk:块对象,可配置字符间距、字符+背景色、背景色的矩形大小可任意调整*/
        document.newPage();
        document.add(new Chunk("中文输出： ", getChineseFont()));
        Chunk tChunk2 = new Chunk("输出的内容", getChineseFont());
        tChunk2.setBackground(BaseColor.CYAN, 1f, 0.5f, 1f, 1.5f); // 设置背景色
        tChunk2.setTextRise(6); // 上浮
        tChunk2.setUnderline(0.2f, -2f); // 下划线
        document.add(tChunk2);
        document.add(Chunk.NEWLINE); // 新建一行

        /*Phrase:短语可配置行间距、不会另起一行*/
        document.newPage();
        document.add(new Phrase("Phrase: "));
        Phrase tPhrase = new Phrase();
        Chunk name = new Chunk("Chunk1");
        name.setUnderline(0.2f, -2f);
        tPhrase.add(name);
        tPhrase.add(Chunk.NEWLINE);// 放在容器中好用
        tPhrase.add(new Chunk("换行Chunk: ", getChineseFont()));
        tPhrase.add(new Chunk("Chunk2"));
        tPhrase.setLeading(14f);// 行间距
        document.add(tPhrase);

        /*Paragraph:段落*/
        document.newPage();
        Paragraph info = new Paragraph("New page");
        info.setLeading(20f); //设置行距
        info.setSpacingBefore(5f);// 设置段落上空白
        info.setSpacingAfter(10f);// 设置段落下空白
        info.setFirstLineIndent(24);// 首行缩进
        info.setIndentationLeft(12);// 左缩进
        info.setIndentationRight(12);// 右缩进
        info.setAlignment(Element.ALIGN_CENTER);  //设置居中
        document.add(info);

        /*Image:图片,继承自Rectangle,scaleToFit设置大小,setAbsolutePosition设置绝对位置*/
        document.newPage();
        Image img = Image.getInstance("C:\\Users\\dong.chen\\Pictures\\790a6091-06e4-4435-b131-3c1146fbea76(1).jpg");
        img.setAlignment(Image.ALIGN_CENTER);  //对齐方式
        img.setBorder(Image.BOX);  //边框
        img.setBorderWidth(10);  //边框宽度
        img.setBorderColor(BaseColor.WHITE);  //边框颜色
        // img.scaleToFit(800, 600);// 大小
        // img.setRotationDegrees(-3);// 旋转
        document.add(img);

        /*Anchor:超链接和锚点对象*/
        document.newPage();
        Paragraph paragraph = new Paragraph();
        Anchor anchor = new Anchor("锚点文字", getChineseFont());
        anchor.setName("achorName"); // 设置锚点的名字
        anchor.setReference("http://www.baidu.com");// 连接
        paragraph.add(anchor);
        paragraph.add(String.format(": %d sites", 10000));
        document.add(paragraph);

        //关闭document
        document.close();
    }

    public static void test2() throws IOException, DocumentException {
        Document document = new Document(PageSize.A4.rotate());
        //解析器
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("D://pdftable.pdf"));
        /*页边距*/
        document.setMargins(10, 20, 30, 40);
        //打开document
        document.open();

        /*table:表格*/
        document.newPage();
        //中文字体
        BaseFont bfChinese = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        Font fontChinese = new Font(bfChinese, 12, Font.NORMAL);

        int colNumber = 6;
        // 创建有6列的表格
        PdfPTable datatable = new PdfPTable(colNumber);
        // 定义表格的宽度
        int[] cellsWidth = {1, 1, 1, 1, 1, 1};
        datatable.setWidths(cellsWidth);// 单元格宽度
        //datatable.setTotalWidth(300f);//表格的总宽度
        //datatable.setWidthPercentage(100);// 表格的宽度百分比
        datatable.getDefaultCell().setPadding(2);// 单元格的间隔
        datatable.getDefaultCell().setBorderWidth(2);// 边框宽度
        //设置表格的底色
        datatable.getDefaultCell().setBackgroundColor(BaseColor.GREEN);
        datatable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        //跨行跨列表格
        PdfPCell pdfPCell; // 单元格
        /*跨列*/
        pdfPCell = new PdfPCell(new Phrase("大标题--跨6列", getChineseFont()));
        pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);  //水平居中
        pdfPCell.setColspan(6);// 跨3列
        datatable.addCell(pdfPCell);
        /*跨行*/
        pdfPCell = new PdfPCell(new Phrase("标题一跨2行", getChineseFont()));
        pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);  //水平居中
        pdfPCell.setVerticalAlignment(Element.ALIGN_MIDDLE);  //垂直居中
        pdfPCell.setRowspan(2);// 跨2行
        datatable.addCell(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase("标题二跨2行", getChineseFont()));
        pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);  //水平居中
        pdfPCell.setVerticalAlignment(Element.ALIGN_MIDDLE);  //垂直居中
        pdfPCell.setRowspan(2);// 跨2行
        datatable.addCell(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase("标题三跨2行", getChineseFont()));
        pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);  //居中
        pdfPCell.setVerticalAlignment(Element.ALIGN_MIDDLE);  //垂直居中
        pdfPCell.setColspan(2);// 跨3列
        pdfPCell.setRowspan(1);// 跨2行
        datatable.addCell(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase("标题四跨2行", getChineseFont()));
        pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);  //居中
        pdfPCell.setVerticalAlignment(Element.ALIGN_MIDDLE);  //垂直居中
        pdfPCell.setRowspan(2);// 跨2行
        datatable.addCell(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase("标题五跨2行", getChineseFont()));
        pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);  //居中
        pdfPCell.setVerticalAlignment(Element.ALIGN_MIDDLE);  //垂直居中
        pdfPCell.setRowspan(2);// 跨2行
        datatable.addCell(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase("3子标题", getChineseFont()));
        pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);  //居中
        datatable.addCell(pdfPCell);
        datatable.addCell(pdfPCell);
        // 添加表头元素
        for (int i = 0; i < colNumber; i++) {
            datatable.addCell(new Paragraph("<p>中文内容</p>" + i, fontChinese));
        }
        // 添加表格的内容
        for (int i = 0; i < colNumber; i++) {
            datatable.addCell(new Paragraph("Content" + i, fontChinese));
        }
        // 空白表格
        for (int i = 0; i < colNumber; i++) {
            PdfPCell cell = new PdfPCell(new Paragraph(""));  //设置内容为空的表格
            cell.setFixedHeight(10);// 单元格高度
            datatable.addCell(cell);  //添加到表格
        }
        datatable.setSpacingAfter(40f);// 设置表格下面空白行
        document.add(datatable);// 把表格加入文档

        //关闭document
        document.close();
    }

    public static void main(String[] args) throws Exception {
        //new一个Document对象,设置纸张大小
        Document document = new Document(new RectangleReadOnly(1080,12320));
        //解析器
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("D://pdfText.pdf"));
        //添加PDF属性
        document.addAuthor("作者");
        document.addTitle("标题");
        document.addSubject("主题");
        document.addKeywords("关键字");
        /*页边距*/
        document.setMargins(10, 20, 30, 40);

        //打开document
        document.open();
        Image img = Image.getInstance("C:\\Users\\dong.chen\\Pictures\\790a6091-06e4-4435-b131-3c1146fbea76(1).jpg");
        img.setAlignment(Image.ORIGINAL_JPEG);  //对齐方式
        document.add(img);

        document.close();
    }
}