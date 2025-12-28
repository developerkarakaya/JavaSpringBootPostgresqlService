package com.springboot.start.lectureapi.service.impl;
import com.springboot.start.lectureapi.common.GeneralException;
import com.springboot.start.lectureapi.entity.User;
import com.springboot.start.lectureapi.entity.enums.Role;
import com.springboot.start.lectureapi.repository.IUserRepository;
import com.springboot.start.lectureapi.service.IUserService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    private IUserRepository userRepository;

    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsersByRole(Role role) {
        return userRepository.findAllByRole(role);
    }

    @Override
    public List<User> getPotentialUsers(List<Integer> idList) {
        if (idList.isEmpty()) {
            return getUsersByRole(Role.STUDENT);
        }
        return userRepository.findAllByRoleAndIdIsNotIn(Role.STUDENT,idList);
    }

    @Override
    public User Save(User user) {
        if (user.getId() == null) {
            // new entity
            if (user.getIdentityNo() == null || user.getIdentityNo().length()!=11) {
                throw new GeneralException("Kimlik bilgisi boş veya 11 haneden farklı olamaz!");
            }
            if(userRepository.existsByIdentityNo(user.getIdentityNo())) {
                throw new GeneralException("Geçerli kimlik no giriniz !");
            }
        }


        return userRepository.save(user);
    }

    @Override
    public User getById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new GeneralException("Bilgisi getiriecek bir kullanıcı bulunamadı");
        }

        return user.get();
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        if (!userRepository.existsById(id)) {
            throw new GeneralException("Silinecek kullaıcı kaydı bulunamadı.");
        }
        userRepository.deleteById(id);
    }
}
