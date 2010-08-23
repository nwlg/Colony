/*
 * 20/09/2010 Fernando Garcia
 */

package es.pode.auditoria.negocio.servicios;

/**
 *
 * @author build
 */
public class InformeOdeUsuarioPLUSVO {



    private String group;

    private String item;

    private String count;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public InformeOdeUsuarioPLUSVO() {
    }

    public InformeOdeUsuarioPLUSVO(String group, String item, String count) {
        this.group = group;
        this.item = item;
        this.count = count;
    }

    @Override
    public String toString() {
        return "InformeOdeUsuarioPLUSVO{" + "group=" + group + "item=" + item + "count=" + count + '}';
    }


    



}
