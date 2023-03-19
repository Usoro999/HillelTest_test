package APItests.APIdata;

public class Info {
        private Integer count;
        private Integer pages;
        private String next;
        private Object prev;

    public Info() {
    }

    public Info(Integer count, Integer pages, String next, Object prev) {
        this.count = count;
        this.pages = pages;
        this.next = next;
        this.prev = prev;
    }

    public Integer getCount() {
        return count;
    }

    public Integer getPages() {
        return pages;
    }

    public String getNext() {
        return next;
    }

    public Object getPrev() {
        return prev;
    }
}

