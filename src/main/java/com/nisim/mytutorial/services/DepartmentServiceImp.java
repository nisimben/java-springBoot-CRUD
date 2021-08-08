package com.nisim.mytutorial.services;

import com.nisim.mytutorial.entity.Department;
import com.nisim.mytutorial.error.DepartmentNotFoundException;
import com.nisim.mytutorial.repository.DepartmetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImp implements DepartmentService{

    @Autowired
    private DepartmetRepository departmetRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmetRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmetRepository.findAll();
    }


    @Override
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department = departmetRepository.findById(departmentId);

        if (!department.isPresent()){
            throw new DepartmentNotFoundException("Department Not Available");
        }
        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmetRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department depDB = departmetRepository.findById(departmentId).get() ;

        if (Objects.nonNull(department.getDepartmentName())&&
        !"".equalsIgnoreCase(department.getDepartmentName())){
            depDB.setDepartmentName(department.getDepartmentName());
        }
        if (Objects.nonNull(department.getDepartmentCode())&&
        !"".equalsIgnoreCase(department.getDepartmentCode())){
            depDB.setDepartmentCode(department.getDepartmentCode());
        }
        if (Objects.nonNull(department.getDepartmentAddress())&&
        !"".equalsIgnoreCase(department.getDepartmentAddress())){
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }
        return departmetRepository.save(depDB);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmetRepository.findByDepartmentNameIgnoreCase(departmentName);
    }
}
