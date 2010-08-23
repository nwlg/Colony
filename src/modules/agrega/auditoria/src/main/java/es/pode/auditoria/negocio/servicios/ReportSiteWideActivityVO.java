/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.pode.auditoria.negocio.servicios;

/**
 *
 * @author build
 */
public class ReportSiteWideActivityVO implements java.io.Serializable
{


    private String numberOfResourcesTotal;
    private String numberOfResourcesPublished;
    private String numberOfResourcesSearched;
    private String numberOfResourcesPreviewed;
    private String numberOfResourcesDownloaded;
    private String numberOfResourcesSent;
    private String numberOfResourcesRated;
    private String numberOfComments;

    public ReportSiteWideActivityVO() {
    }




    public ReportSiteWideActivityVO(String numberOfResourcesTotal, String numberOfResourcesPublished, String numberOfResourcesSearched, String numberOfResourcesPreviewed, String numberOfResourcesDownloaded, String numberOfResourcesSent, String numberOfResourcesRated, String numberOfComments) {
        this.numberOfResourcesTotal = numberOfResourcesTotal;
        this.numberOfResourcesPublished = numberOfResourcesPublished;
        this.numberOfResourcesSearched = numberOfResourcesSearched;
        this.numberOfResourcesPreviewed = numberOfResourcesPreviewed;
        this.numberOfResourcesDownloaded = numberOfResourcesDownloaded;
        this.numberOfResourcesSent = numberOfResourcesSent;
        this.numberOfResourcesRated = numberOfResourcesRated;
        this.numberOfComments = numberOfComments;
    }




    public String getNumberOfComments() {
        return numberOfComments;
    }

    public void setNumberOfComments(String numberOfComments) {
        this.numberOfComments = numberOfComments;
    }

    public String getNumberOfResourcesDownloaded() {
        return numberOfResourcesDownloaded;
    }

    public void setNumberOfResourcesDownloaded(String numberOfResourcesDownloaded) {
        this.numberOfResourcesDownloaded = numberOfResourcesDownloaded;
    }

    public String getNumberOfResourcesPreviewed() {
        return numberOfResourcesPreviewed;
    }

    public void setNumberOfResourcesPreviewed(String numberOfResourcesPreviewed) {
        this.numberOfResourcesPreviewed = numberOfResourcesPreviewed;
    }

    public String getNumberOfResourcesPublished() {
        return numberOfResourcesPublished;
    }

    public void setNumberOfResourcesPublished(String numberOfResourcesPublished) {
        this.numberOfResourcesPublished = numberOfResourcesPublished;
    }

    public String getNumberOfResourcesRated() {
        return numberOfResourcesRated;
    }

    public void setNumberOfResourcesRated(String numberOfResourcesRated) {
        this.numberOfResourcesRated = numberOfResourcesRated;
    }

    public String getNumberOfResourcesSearched() {
        return numberOfResourcesSearched;
    }

    public void setNumberOfResourcesSearched(String numberOfResourcesSearched) {
        this.numberOfResourcesSearched = numberOfResourcesSearched;
    }

    public String getNumberOfResourcesSent() {
        return numberOfResourcesSent;
    }

    public void setNumberOfResourcesSent(String numberOfResourcesSent) {
        this.numberOfResourcesSent = numberOfResourcesSent;
    }

    public String getNumberOfResourcesTotal() {
        return numberOfResourcesTotal;
    }

    public void setNumberOfResourcesTotal(String numberOfResourcesTotal) {
        this.numberOfResourcesTotal = numberOfResourcesTotal;
    }






}
