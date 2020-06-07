import java.awt.print.*;

public class PrintingDemoMain {

    public static void main(String[] args) {
        String data[] = {"Salman", "Ali", "Safat", "Kareem"};

        Book book = new Book();
        Paper paper = new Paper();

        PageFormat pageFormat = Format.getPageFormat(paper);
        PrinterWork work = new PrinterWork(data);

        book.append(work, pageFormat);

        ///*** GO FOR PRINTING JOB
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        printerJob.setPageable(book);
        try{
            if(printerJob.printDialog())
                printerJob.print();
        }catch (PrinterException e){
            e.printStackTrace();
        }

    }
}
