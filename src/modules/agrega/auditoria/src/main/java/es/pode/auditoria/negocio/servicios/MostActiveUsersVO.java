/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.pode.auditoria.negocio.servicios;

/**
 *
 * @author build
 */
public class MostActiveUsersVO implements java.io.Serializable {


    private String category;
    private String userName;
    private String count;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public MostActiveUsersVO(String category, String userName, String count, String email) {
        this.category = category;
        this.userName = userName;
        this.count = count;
        this.email = email;

    }

    public MostActiveUsersVO() {
    }

    @Override
    public String toString() {
        return "MostActiveUsersVO{" + "category=" + category + "userName=" + userName + "count=" + count + "email=" + email + '}';
    }


    



}
