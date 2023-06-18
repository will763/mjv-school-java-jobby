public enum DataFormato {
    YYYY_MM_DD("yyyy-MM-dd"),
    DD_MMM_YYYY("dd-MM-yyyy");

    private final String format;

    DataFormato(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }
}