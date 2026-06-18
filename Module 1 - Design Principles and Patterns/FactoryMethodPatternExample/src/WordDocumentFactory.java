class WordDocumentFactory extends DocumentFactory {

    @Override
    public Document createDocument() {
        return new WordDocumentImpl();
    }
}

class PdfDocumentFactory extends DocumentFactory {

    @Override
    public Document createDocument() {
        return new PdfDocumentImpl();
    }
}

class ExcelDocumentFactory extends DocumentFactory {

    @Override
    public Document createDocument() {
        return new ExcelDocumentImpl();
    }
}