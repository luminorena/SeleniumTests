package selenium.practice.helpers;

public enum LinksStatuses {
    STATUS_201("Link has responded with staus 201 and status text Created"),
    STATUS_204("Link has responded with staus 204 and status text No Content"),
    STATUS_301("Link has responded with staus 301 and status text Moved Permanently"),
    STATUS_400("Link has responded with staus 400 and status text Bad Request"),
    STATUS_401("Link has responded with staus 401 and status text Unauthorized"),
    STATUS_403("Link has responded with staus 403 and status text Forbidden"),
    STATUS_404("Link has responded with staus 404 and status text Not Found");

    public final String description;

    LinksStatuses(String description) {
        this.description = description;
    }
}
