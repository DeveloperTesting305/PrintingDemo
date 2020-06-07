import java.awt.print.PageFormat;
import java.awt.print.Paper;

public class Format {

    public static PageFormat getPageFormat(Paper paper){
        PageFormat pageFormat = new PageFormat();

        paper.setSize(PageSize.width, PageSize.height);
        paper.setImageableArea(PageSize.leftMargin, PageSize.topMargin, PageSize.imageableWidth, PageSize.imageableHeight);

        pageFormat.setPaper(paper);
        pageFormat.setOrientation(PageFormat.PORTRAIT);

        return pageFormat;
    }
}
