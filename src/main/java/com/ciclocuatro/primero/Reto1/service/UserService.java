package com.ciclocuatro.primero.Reto1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciclocuatro.primero.Reto1.model.User;
import com.ciclocuatro.primero.Reto1.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAll() {
		return userRepository.getAll();
	}

	public Optional<User> getUser(int id) {
		return userRepository.getUser(id);
	}

	public User agregar(User user) {
		if (user.getId() != null) {
			if (existeEmail(user.getEmail()) == false) {
				return userRepository.save(user);
			} else {
				return user;
			}
		} else {
			return user;
		}
	}

	public boolean existeEmail(String email) {
		return userRepository.existeEmail(email);
	}

	public User autenticarUsuario(String email, String password) {
		Optional<User> usuario = userRepository.autenticarUsuario(email, password);

		if (usuario.isEmpty()) {
			return new User();
		} else {
			return usuario.get();
		}
	}
	
    public  User update(User user) {

        if (user.getId() != null) {
            Optional<User> userDb = userRepository.getUser(user.getId());
            if (!userDb.isEmpty()) {
                if (user.getIdentification() != null) {
                    userDb.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null) {
                    userDb.get().setName(user.getName());
                }
                if (user.getAddress() != null) {
                    userDb.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null) {
                    userDb.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null) {
                    userDb.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    userDb.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null) {
                    userDb.get().setZone(user.getZone());
                }

                userRepository.update(userDb.get());
                return userDb.get();
            } else {
                return user;
            }
        } else {
            return user;
        }
    }
    
    public boolean delete(int userId) {
        Boolean aBoolean = getUser(userId).map(user -> {
        	userRepository.delete(user);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
