package org.larma.model;

public class PostnrInfo {
    public String postnr;
    public String poststed;
    public String kommunenr;
    public String kommune;

    public PostnrInfo(
            final String postnr,
            final String poststed,
            final String kommunenr,
            final String kommune)
    {
        this.postnr = postnr;
        this.poststed = poststed;
        this.kommunenr = kommunenr;
        this.kommune = kommune;
    }

}
