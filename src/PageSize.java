public interface PageSize {

    Double ppi = Double.valueOf(72);
    ///**** UPDATED FROM OTHER SIDE

    Double width = Double.valueOf(8.268) * ppi;
    Double height = Double.valueOf(11.693) * ppi;

//    Double margin = Double.valueOf(0.8) * ppi;
//    Double leftMargin = margin;
//    Double rightMargin = margin;
//    Double topMargin = margin;
//    Double bottomMargin = margin;

    Double leftMargin = Double.valueOf(158);
    Double rightMargin = Double.valueOf(157);
    Double topMargin = Double.valueOf(0);
    Double bottomMargin = Double.valueOf(247);

    Double imageableWidth = width - (leftMargin + rightMargin);
    Double imageableHeight = height - (topMargin + bottomMargin);

    Boolean landscape = false;

}
