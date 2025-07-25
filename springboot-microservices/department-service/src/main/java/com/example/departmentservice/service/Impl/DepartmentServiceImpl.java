package com.example.departmentservice.service.Impl;

import lombok.AllArgsConstructor;
import com.example.departmentservice.dto.DepartmentDto;
import com.example.departmentservice.entity.Department;
import com.example.departmentservice.repository.DepartmentRepository;
import com.example.departmentservice.service.DepartmentService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;


    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
 //convert departmentdto to department jpa entity
        Department department =new Department(
          departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()

        );
Department savedDepartment=departmentRepository.save(department);
DepartmentDto saveDepartmentDto = new DepartmentDto(
        savedDepartment.getId(),
        savedDepartment.getDepartmentName(),
        savedDepartment.getDepartmentDescription(),
        savedDepartment.getDepartmentCode()

        );
        return saveDepartmentDto;


    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentcode) {

        Department department = departmentRepository.findByDepartmentCode(departmentcode);
       DepartmentDto departmentDto = new DepartmentDto(
               department.getId(),
             department.getDepartmentName(),
             department.getDepartmentDescription(),
             department.getDepartmentCode()
       );
        return departmentDto;
    }
}
