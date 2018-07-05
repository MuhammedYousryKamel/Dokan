/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.susport.contact;

import java.util.ArrayList;

/**
 *
 * @author gami
 */
public interface IModel {

    /**
     * Get Table name
     *
     * @return Table name
     */
    String getTable();

    /**
     * Get All Attribute name
     *
     * @return
     */
    ArrayList getAttributes();
}
