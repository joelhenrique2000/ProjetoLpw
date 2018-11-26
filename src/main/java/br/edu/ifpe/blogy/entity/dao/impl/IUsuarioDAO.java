/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.blogy.entity.dao.impl;

import br.edu.ifpe.blogy.entity.UsuarioEntity;
import java.util.List;

/**
 *
 * @author Joel
 */
public interface IUsuarioDAO {
    public UsuarioEntity create(UsuarioEntity usuario);
    public List<UsuarioEntity> read();
    public UsuarioEntity update(UsuarioEntity usuario);
    public UsuarioEntity delete(UsuarioEntity usuario);
}
