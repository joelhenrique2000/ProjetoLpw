/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.blogy.entity.dao.impl;

import br.edu.ifpe.blogy.entity.HashTagEntity;
import java.util.List;

/**
 *
 * @author Joel
 */
public interface IHashTagDAO {
    public HashTagEntity create(HashTagEntity usuario);
    public List<HashTagEntity> read();
    public HashTagEntity update(HashTagEntity usuario);
    public HashTagEntity delete(HashTagEntity usuario);
}
