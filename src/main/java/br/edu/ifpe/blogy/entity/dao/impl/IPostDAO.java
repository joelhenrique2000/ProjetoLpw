/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.blogy.entity.dao.impl;

import br.edu.ifpe.blogy.entity.PostEntity;
import java.util.List;

/**
 *
 * @author Joel
 */
public interface IPostDAO {
    public PostEntity create(PostEntity usuario);
    public List<PostEntity> read();
    public PostEntity update(PostEntity usuario);
    public PostEntity delete(PostEntity usuario);
}
