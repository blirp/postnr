package org.larma.model;

import org.larma.validation.Numeric;

public class PostnrInfo {
    @Numeric
    public String postnr;
    public String poststed;
    @Numeric
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
