public abstract class DocumentFactory {

    public abstract Document createDocument();

    public void handleDocument() {
        Document doc = createDocument();
        doc.open();
        doc.save();
        doc.close();
    }
}