public class FactoryMethodTest {

    public static void main(String[] args) {

        DocumentFactory factory;

        System.out.println("--- Word Document ---");
        factory = new WordDocumentFactory();
        factory.handleDocument();
        WordDocument wd = (WordDocument) factory.createDocument();
        wd.enableTrackChanges();

        System.out.println();

        System.out.println("--- PDF Document ---");
        factory = new PdfDocumentFactory();
        factory.handleDocument();
        PdfDocument pd = (PdfDocument) factory.createDocument();
        pd.addPasswordProtection();

        System.out.println();

        System.out.println("--- Excel Document ---");
        factory = new ExcelDocumentFactory();
        factory.handleDocument();
        ExcelDocument ed = (ExcelDocument) factory.createDocument();
        ed.addFormula();
    }
}