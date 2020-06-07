import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

public class PrinterWork extends Component implements Printable {

    private String[] data;

    public PrinterWork(String[] data) {
        this.data = data;
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int i) throws PrinterException {

        Integer startX = 0;
        Integer startY = 0;

        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

        graphics.setColor(Color.BLACK);

        FontMetrics fontMetrics = graphics.getFontMetrics();

        Integer x = (int)pageFormat.getImageableX();
        Integer y = (int)pageFormat.getImageableY();

        x += 5;
        y += 5;

        int width = 0;

        ///*** SHOP NAME
        graphics.setFont(new Font("Open Sans", Font.BOLD, 16));
        String shopName = "SHOP Hello JAVA NAME";
        width = graphics.getFontMetrics().stringWidth(shopName);
        int shopNameX = (int)((PageSize.imageableWidth - width) / 2);
        graphics.drawString(shopName, shopNameX, 15);

        ///*** SHOP ADDRESS
        graphics.setFont(new Font("Open Sans", Font.PLAIN, 7));
        String address = "Shop No # 165, Street 58A, Market Road Hyderabad, Sindh";
        width = graphics.getFontMetrics().stringWidth(address);
        int addressX = (int)((PageSize.imageableWidth - width) / 2);
        graphics.drawString(address, addressX, 23);

        ///*** SHOP CONTACT NUMBER
        String contactNo = "022-2985485, 022-1511548, 0345-2651515";
        width = graphics.getFontMetrics().stringWidth(contactNo);
        int contactNoX = (int)((PageSize.imageableWidth - width) / 2);
        graphics.drawString(contactNo, contactNoX, 30);

        ///*** TID
        graphics.setFont(new Font("Open Sans", Font.PLAIN, 8));
        graphics.drawString("TID : 00000", 5, 43);

        ///*** CASH/CREDIT MEMO HEADIND
        graphics.setFont(new Font("Open Sans", Font.BOLD, 10));
        graphics.drawString("CREDIT MEMO", 112, 43);

        ///*** DATE
        graphics.setFont(new Font("Open Sans", Font.PLAIN, 8));
        graphics.drawString("Date : 02/08/2020", 206, 43);

        ///*** CLIENT NAME
        graphics.setFont(new Font("Open Sans", Font.PLAIN, 10));
        graphics.drawString("Client Name : asdfghjkdfghjkl", 5, 58);

        ///*** CITY
        graphics.drawString("City : asdfghjkdfghjkl", 5, 71);

        ///*** HEADING UPPER LINE
        graphics.drawLine(5, 91-8, 275, 91-8);

        ///*** HEADING
        graphics.setFont(new Font("Open Sans", Font.BOLD, 10));
        graphics.drawString("Qty", 6, 93);
        graphics.drawString("Perticulars", 40, 93);
        graphics.drawString("Unit", 139, 93);
        graphics.drawString("Price", 183, 93);
        graphics.drawString("Amount", 225, 93);

        ///*** HEADING LOWER LINE
        graphics.drawLine(5, 106-8, 275, 106-8);

        ///*** PRODUNT DETAIL
        graphics.setFont(new Font("Open Sans", Font.PLAIN, 10));
        y = 109;
        for(Byte row = 1; row <= 16; row++){
            graphics.setColor(Color.BLACK);
            graphics.drawString("400", 7, y);
            graphics.drawString("Sami Fabrics Cotton Mix", 40, y); y += 11;
            graphics.drawString("Meter", 139, y);
            graphics.drawString("1400", 183, y);
            graphics.drawString("560000", 224, y);  y += 12;
            ///*** SEPARATOR LINE
            graphics.setColor(Color.LIGHT_GRAY);
            graphics.drawLine(5, y-8, 275, y-8);    y += 2;
        }

        ///*** FOR BILL DETAIL STATUS|CONFIRMED BY|REMARKS
        Integer billDetailY = y;

        ///*** CHANGE COLOR
        graphics.setColor(Color.BLACK);

        ///*** NET TOTAL
        graphics.drawString("Net Total", 130, y);
        graphics.drawString("15000000", 209, y);    y += 12;

        ///*** DISCOUNT
        Float discount = Float.valueOf(150);
        if(discount > 0) {
            graphics.drawString("Discount -", 130, y);
            graphics.drawString("25000", 209, y);    y += 12;
        }

        ///*** EXPENCE
        Float expence = Float.valueOf(450);
        if(expence > 0) {
            graphics.drawString("Expence +", 130, y);
            graphics.drawString("1200", 209, y);    y += 12;
        }

        ///*** AMOUNT SEPARATOR LINE
        graphics.drawLine(127, y-7, 275, y-7);  y += 2;

        ///*** TOTAL AMOUNT
        graphics.setFont(new Font("Open Sans", Font.BOLD, 10));
        graphics.drawString("Total Amount", 130, y);
        graphics.setFont(new Font("Open Sans", Font.PLAIN, 10));
        graphics.drawString("1650000", 209, y);

        ///*** BILL DETAIL
        billDetailY += 25;
        graphics.setFont(new Font("Open Sans", Font.PLAIN, 8));
        ///*** STATUS
        graphics.drawString("Status : Clear", 6, billDetailY);              billDetailY += 8;

        ///*** CONFIRMED BY
        graphics.drawString("Confimed By : Name Here", 6, billDetailY);     billDetailY += 8;

        ///*** REMARKS
        graphics.drawString("Remarks :", 6, billDetailY);
        StringBuffer remarks = new StringBuffer("wertyuidsfgretuyfjydcjduyjdbkuevkuergkuerhgiuehriuheiurieurtikjfkjbnbkjfnkjdfjnbkjnbkjnbkjngkbjnfgjkllkdfjfnvkjbdbfkjvbkjdbvkjdbfkjvbdkjbvkjdbvkjdbfvkjbdfkjvbkdjbvkjbdfkvjbdfkjvbkdjfvkjbdfkjvbkjbdfkjbkdfjbvkjdbfkvjbkdfjvbkjdbvkjdbfvkjbdfkvjbdfnkjfngkjfnkjfnbkjiueyriuteiurtuieyru");
        System.out.println(remarks.length());

        for(int line = 60; line <= remarks.length(); line += 60){
            remarks.insert(line, "\n");
        }
        drawString(graphics, remarks.toString(), 13, billDetailY);

        return this.PAGE_EXISTS;
    }

    private void drawString(Graphics g, String text, int x, int y) {
        for (String line : text.split("\n"))
            g.drawString(line, x, y += 8);
    }
}
