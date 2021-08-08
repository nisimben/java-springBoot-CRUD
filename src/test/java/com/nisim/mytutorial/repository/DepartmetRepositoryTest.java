package com.nisim.mytutorial.repository;
import static org.junit.jupiter.api.Assertions.*;
import com.nisim.mytutorial.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
@DataJpaTest
class DepartmetRepositoryTest {

    @Autowired
    private DepartmetRepository departmetRepository;
    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp(){
        Department department =
                Department.builder()
                        .departmentName("Mechanical Engineering")
                        .departmentAddress("delhi")
                        .departmentCode("Me-011")
                        .build();
                entityManager.persist(department);

    }

    @Test
    public void whenFindById_thenReturnDepartment(){
        Department department = departmetRepository.findById(1L).get();
        assertEquals(department.getDepartmentName(),"Mechanical Engineering");


    }

}