/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.pode.buscador.tag.formato;

/**
 *
 * @author Fernando Garcia
 *
 * Helper private class to store a String and a boolean value
 */
public class ItemStringBooleanVO {

             public String itemString;

             public boolean itemBoolean;

             public ItemStringBooleanVO(String _itemString, boolean _itemBoolean){
                 this.itemString = _itemString;
                 this.itemBoolean = _itemBoolean;
             }

             @Override
             public String toString() {
                return "ItemStringBoolean{" + "itemString=" + itemString + "itemBoolean=" + itemBoolean + '}';
             }
}

