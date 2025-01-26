package br.com.contato12.service;

import java.util.List;
import java.util.UUID;

import br.com.contato12.entity.UserEntity;
import br.com.contato12.exception.UserNotFoundException;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Service {

    public UserEntity createUser(UserEntity userEntity){
        UserEntity.persist(userEntity);
        return userEntity;
    }
    
    public List<UserEntity> findAll(Integer page, Integer pageSize){
        return UserEntity.findAll().page(page, pageSize).list();
    }

    public UserEntity findById(UUID id){
        return (UserEntity) UserEntity.findByIdOptional(id).orElseThrow(UserNotFoundException::new);
    }

    public UserEntity updateUser(UUID id, UserEntity userEntity) {
        var user = findById(id);
        user.name = userEntity.name;
        UserEntity.persist(user);
        return user;
    }

    public void deleteById(UUID id) {
        var user = findById(id);
        UserEntity.deleteById(user.id);
    }
}
