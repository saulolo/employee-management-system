package edu.ems.domain.model;

import edu.ems.domain.model.vob.Email;
import edu.ems.domain.model.vob.LastName;
import edu.ems.domain.model.vob.Name;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;


@Getter
@ToString
@AllArgsConstructor
@Builder(toBuilder = true)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public final class Employee {

    Long id;
    Name name;
    LastName lastname;
    Email email;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

}
