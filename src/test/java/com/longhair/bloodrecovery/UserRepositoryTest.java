//package com.longhair.bloodrecovery;
//
//import com.longhair.bloodrecovery.repository.CardRepository;
//import org.assertj.core.api.Assertions;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.transaction.Transactional;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class UserRepositoryTest {
//
//    @Autowired
////    CardRepository cardRepository;
//
//    @Test
//    @Transactional
//    @Rollback(false)
//    public void testUser() {
//        User user = new User();
//        user.setUsername("userA");
//        Long savedId = userRepository.save(user);
//        User findUser = userRepository.find(savedId);
//        Assertions.assertThat(findUser.getId()).isEqualTo(user.getId());
//
//        Assertions.assertThat(findUser.getUsername()).isEqualTo(user.getUsername())
//        ;
//        Assertions.assertThat(findUser).isEqualTo(user); //JPA 엔티티 동일성 보장
//    }
//}