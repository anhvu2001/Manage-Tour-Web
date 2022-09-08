/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ndav.repository;

import com.ndav.pojos.Image;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface ImageRepository {
    List<Image> getListImage(long id);
    Image getImageById(long id);
}
