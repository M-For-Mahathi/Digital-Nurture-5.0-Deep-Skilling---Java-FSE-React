class WordDocumentImpl implements WordDocument {

    @Override
    public void open() {
        System.out.println("Word document opened.");
    }

    @Override
    public void save() {
        System.out.println("Word document saved.");
    }

    @Override
    public void close() {
        System.out.println("Word document closed.");
    }

    @Override
    public void enableTrackChanges() {
        System.out.println("Track Changes enabled for Word document.");
    }
}

class PdfDocumentImpl implements PdfDocument {

    @Override
    public void open() {
        System.out.println("PDF document opened.");
    }

    @Override
    public void save() {
        System.out.println("PDF document saved.");
    }

    @Override
    public void close() {
        System.out.println("PDF document closed.");
    }

    @Override
    public void addPasswordProtection() {
        System.out.println("Password protection added to PDF document.");
    }
}

class ExcelDocumentImpl implements ExcelDocument {

    @Override
    public void open() {
        System.out.println("Excel document opened.");
    }

    @Override
    public void save() {
        System.out.println("Excel document saved.");
    }

    @Override
    public void close() {
        System.out.println("Excel document closed.");
    }

    @Override
    public void addFormula() {
        System.out.println("Formula added to Excel document.");
    }
}