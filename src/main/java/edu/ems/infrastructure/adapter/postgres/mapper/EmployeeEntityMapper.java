package edu.ems.infrastructure.adapter.postgres.mapper;

import edu.ems.domain.model.Employee;
import edu.ems.domain.model.vob.Email;
import edu.ems.domain.model.vob.LastName;
import edu.ems.domain.model.vob.Name;
import edu.ems.infrastructure.adapter.postgres.entity.EmployeeEntity;

/**
 * Clase utilitaria encargada de convertir entre la entidad de persistencia {@link EmployeeEntityMapper}
 * y el modelo de dominio {@link Employee}, manteniendo la separación entre capas.
 */
public class EmployeeEntityMapper {

    /**
     * Convierte un modelo de dominio {@link Employee} a su representación de persistencia {@link EmployeeEntity}.
     * @param employee El objeto de dominio con los datos del empleado a convertir.
     * @return Una instancia de {@link EmployeeEntity} lista para ser persistida.
     * */
    public static EmployeeEntity toEntity(Employee employee) {
        if (employee == null) throw new IllegalArgumentException("Cannot map null entity");

        return EmployeeEntity.builder()
                .id(employee.getId())
                .name(employee.getName().getValue())
                .lastname(employee.getLastname().value())
                .email(employee.getEmail().getValue())
                .createdAt(employee.getCreatedAt())
                .updatedAt(employee.getUpdatedAt())
                .build();
    }

    /**
     * Convierte una entidad de persistencia {@link EmployeeEntity} al modelo de dominio {@link Employee}.
     * Reconstruye los Value Objects correspondientes a cada campo.
     * @param entity La entidad JPA con los datos recuperados de la base de datos.
     * @return Una instancia del modelo de dominio {@link Employee} con sus Value Objects reconstituidos.
     * */
    public static Employee toDomain(EmployeeEntity entity) {
        if (entity == null) throw new IllegalArgumentException("Cannot map null entity");
        return Employee.builder()
                .id(entity.getId())
                .name(Name.of(entity.getName()))
                .lastname(LastName.of(entity.getLastname()))
                .email(Email.of(entity.getEmail()))
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

}
