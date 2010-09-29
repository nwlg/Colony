
package es.pode.auditoria.negocio.servicios;

/**
 * Class that contains every single line of the Site-Wide Activity Report
 * @author Fernando Garcia
 */
public class ReportSiteWideActivityVO implements java.io.Serializable
{


    private String reportLine;
    private String count;




    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getReportLine() {
        return reportLine;
    }

    public void setReportLine(String reportLine) {
        this.reportLine = reportLine;
    }

    public ReportSiteWideActivityVO(String reportLine, String count) {
        this.reportLine = reportLine;
        this.count = count;
    }

    public ReportSiteWideActivityVO() {
    }

    @Override
    public String toString() {
        return "ReportSiteWideActivityVO{" + "reportLine=" + reportLine + "count=" + count + '}';
    }

        


	

}
